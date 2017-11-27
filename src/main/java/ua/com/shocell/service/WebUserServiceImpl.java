package ua.com.shocell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.shocell.models.Role;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.repository.RoleRepository;
import ua.com.shocell.repository.WebUsersJPARepository;

import java.util.*;

@Service("webUsersJPAService")
public class WebUserServiceImpl implements WebUserService, UserDetailsService {

    @Autowired
    private WebUsersJPARepository webUsersJPARepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public WebUsers findWebUserByLogin(String login) {
        return webUsersJPARepository.findByLogin(login);
    }

    @Override
    public void saveUser(WebUsers webUsers) {
        webUsers.setPassword(bCryptPasswordEncoder.encode(webUsers.getPassword()));
        webUsers.setEnabled(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        webUsers.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        webUsersJPARepository.save(webUsers);
    }

    @Override
    public boolean deleteByLogin(String login) {
        webUsersJPARepository.deleteByLogin(login);
        return true;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        WebUsers webUsers = webUsersJPARepository.findByLogin(login);
        List<GrantedAuthority> authorities = getUserAuthority(webUsers.getRoles());
        return buildUserForAuthentication(webUsers, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(WebUsers user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }


}

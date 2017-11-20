package ua.com.shocell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.repository.WebUsersRepository;

@Service()
public class WebUsersService {

    @Autowired
    private WebUsersRepository webUsersRepository;

    public void saveUser(WebUsers webUsers) {
        webUsersRepository.save(webUsers);
    }

    public WebUsers findByLogin(String webUserLogin) {
        return webUsersRepository.findByLogin(webUserLogin);
    }

    public WebUsers findByPassword(String webUserPassword) {
        return webUsersRepository.findByPassword(webUserPassword);
    }

}

package ua.com.shocell.models;

import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Entity
@Cacheable
@Table(
        name = "Web_users"
)
public class WebUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private int userID;
    @Column(
            name = "Login",
            unique = true,
            nullable = false
    )
    private String login;
    @Column(
            name = "Password",
            nullable = false
    )
    private String password;
    @Column(
            name = "Email",
            nullable = false
    )
    private String email;
    @Column(
            name = "Enabled",
            nullable = false
    )
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(
            mappedBy = "webUserID",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<Abonents> owners = new ArrayList();

    public WebUsers() {
    }

    public WebUsers(String login, String password, String userRole, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Abonents> getOwners() {
        return this.owners;
    }

    public void setOwners(List<Abonents> owners) {
        this.owners = owners;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "WebUsers{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", owners=" + owners +
                '}';
    }
}

package ua.com.shocell.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Cacheable
@Table(
        name = "Web_users"
)
public class WebUsers {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "User_ID"
    )
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
            name = "WebUser_Role",
            nullable = false
    )
    private String webUserRole;
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
        this.webUserRole = userRole;
    }

    public int getUserID() {
        return this.userID;
    }

//    public void setUserID(int userID) {
//        this.userID = userID;
//    }

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

    public String webUserRole() {
        return this.webUserRole;
    }

    public void setWebUserRole(String userRole) {
        this.webUserRole = userRole;
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

    @Override
    public String toString() {
        return "WebUsers{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", webUserRole='" + webUserRole + '\'' +
                '}';
    }
}

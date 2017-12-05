package ua.com.shocell.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "webServiceUsers")
public class WebServUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "webServUserId")
    private Long webServUserID;

    @Column(
            name = "webServUserLogin",
            unique = true,
            nullable = false
    )
    private String login;

    @Column(
            name = "webServUserPassword",
            nullable = false
    )
    private String password;

    @Column(
            name = "Enabled",
            nullable = false
    )
    private boolean enabled;

    public WebServUsers() {
        System.out.println("WebServUser Constructor");
    }

    public Long getWebServUserID() {
        return webServUserID;
    }

    public void setWebServUserID(Long webServUserID) {
        this.webServUserID = webServUserID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "WebServUsers{" +
                "webServUserID=" + webServUserID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}


package ua.com.shocell.service;

import ua.com.shocell.models.WebUsers;

public interface WebUserService {

    public void saveUser(WebUsers webUsers);

    public boolean deleteByLogin(String login);

    public WebUsers findWebUserByLogin(String login);
}

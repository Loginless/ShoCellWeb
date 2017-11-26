package ua.com.shocell.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUserServiceImpl;

@Component
public class WebUserLoginValidator implements Validator{

    @Autowired
    WebUserServiceImpl webUserServiceImpl;

    @Override
    public boolean supports(Class<?> aClass) {
        return WebUsers.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        WebUsers webUsers = (WebUsers) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
//        if (!webUsersService.findByLogin(webUsers.getLogin()).getLogin().equals(webUsers.getLogin())) {
//            errors.rejectValue("login", "Wrong.loginForm.login");
//        }

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//        if (!webUserServiceImpl.findByPassword(webUsers.getPassword()).getPassword().equals(webUsers.getPassword())) {
//            errors.rejectValue("login", "Wrong.loginForm.password");
//        }
    }
}

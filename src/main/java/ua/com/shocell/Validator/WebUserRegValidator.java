package ua.com.shocell.Validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUserServiceImpl;

@Component
public class WebUserRegValidator implements Validator {

    @Autowired
    WebUserServiceImpl webUserServiceImpl;

    @Override
    public boolean supports(Class<?> aClass) {
        return WebUsers.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        WebUsers regUsers = (WebUsers) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (regUsers.getLogin().length() < 3 || regUsers.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.userForm.login");
        }
        if (webUserServiceImpl.findWebUserByLogin(regUsers.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (regUsers.getPassword().length() < 3 || regUsers.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

    }
}

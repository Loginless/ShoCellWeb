package ua.com.shocell.controllers;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUsersService;

public class WebUserRegValidator implements Validator{

    WebUsersService webUsersService;

    @Override
    public boolean supports(Class<?> aClass) {
        return WebUsers.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");

//        WebUsers webUsers = (WebUsers) o;
//        if(webUsersService.findByLogin(webUsers.getLogin()) != null) {
//            errors.rejectValue("login", "User already exists");
//        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
    }
}

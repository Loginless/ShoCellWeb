package ua.com.shocell.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUsersService;

@Controller
public class UserLoginController {

    @Autowired
    WebUsersService webUsersService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView modelAndView = new ModelAndView("login", "loginForm", new WebUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView checkLoginForm(@ModelAttribute("loginForm") WebUsers loginForm) {
        if(webUsersService.findByLogin(loginForm.getLogin()) != null &&
                webUsersService.findByLogin(loginForm.getLogin()).getPassword()
                        .equals(loginForm.getPassword())){
            return new ModelAndView("/protected/loginConfirmation","loginForm",loginForm);
        }
        return new ModelAndView("login");
    }

}

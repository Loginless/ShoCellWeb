package ua.com.shocell.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUserServiceImpl;

@Controller
public class UserLoginController {

    @Autowired
    WebUserServiceImpl webUserServiceImpl;


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView modelAndView = new ModelAndView("login", "loginForm", new WebUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView checkLoginForm(@ModelAttribute("loginForm") WebUsers loginForm) {
        System.out.println("Login " + loginForm.getLogin());
        System.out.println("Login by repository " + webUserServiceImpl.findWebUserByLogin(loginForm.getLogin()));


        if (webUserServiceImpl.findWebUserByLogin(loginForm.getLogin()) != null &&
                (webUserServiceImpl.findWebUserByLogin(loginForm.getLogin()).getPassword().equals(loginForm.getPassword()))) {
            System.out.println("checked");
            return new ModelAndView("/confidential/getUserInf", "loginForm", loginForm);
        } else {
            System.out.println("No user");
            return new ModelAndView("login");
        }

    }

}

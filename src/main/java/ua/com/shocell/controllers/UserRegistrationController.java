package ua.com.shocell.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.shocell.Validator.WebUserLoginValidator;
import ua.com.shocell.Validator.WebUserRegValidator;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUsersService;

@Controller
public class UserRegistrationController {

    @Autowired
    WebUsersService webUsersService;

    @Autowired
    WebUserRegValidator webUserRegValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(Model model) {
        WebUsers user = new WebUsers();
        model.addAttribute("registerForm", user);
        return "registration";
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView doRegistration(@ModelAttribute("registerForm") WebUsers registerForm,
                                       BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        webUserRegValidator.validate(registerForm, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        modelAndView.addObject(registerForm);
        webUsersService.saveUser(registerForm);
        modelAndView.setViewName("regConfirmation");
        return modelAndView;
    }

    @RequestMapping(value = "/regConfirmation", method = RequestMethod.POST)
    public String getConfirmation(@ModelAttribute("registerForm") WebUsers registerForm) {
        // we have to clear data after registrations and provide new one to login
        return "index";
    }
}

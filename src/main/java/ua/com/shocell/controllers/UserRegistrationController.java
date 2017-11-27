package ua.com.shocell.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.shocell.Validator.WebUserRegValidator;
import ua.com.shocell.models.WebUsers;
import ua.com.shocell.service.WebUserServiceImpl;

@Controller
@RequestMapping
public class UserRegistrationController {

    @Autowired
    WebUserServiceImpl webUserServiceImpl;

    @Autowired
    WebUserRegValidator webUserRegValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationForm() {
        return new ModelAndView("registration", "command", new WebUsers());
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")WebUsers webUsers,
                             ModelMap model) {
        model.addAttribute("login", webUsers.getLogin());
        model.addAttribute("password", webUsers.getPassword());
        model.addAttribute("email", webUsers.getEmail());

        return "registrationConfirmation";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String getRegistrationForm() {
//        ModelAndView modelAndView = new ModelAndView();
//        WebUsers user = new WebUsers();
//        modelAndView.addObject(user);
//        modelAndView.setViewName("registration");
//        return "registration";
//    }
//
//    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
//    public ModelAndView doRegistration(@ModelAttribute("registerForm") WebUsers registerForm) {
//        System.out.println("Check");
//        ModelAndView modelAndView = new ModelAndView();
//        WebUsers userExists = webUserServiceImpl.findWebUserByLogin(registerForm.getLogin());
//        if (userExists != null) {
//            modelAndView.setViewName("registration");
//            return modelAndView;
//        }
//        modelAndView.addObject(registerForm);
//        webUserServiceImpl.saveUser(registerForm);
//        modelAndView.setViewName("regConfirmation");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/regConfirmation", method = RequestMethod.POST)
//    public String getConfirmation(@ModelAttribute("registerForm") WebUsers registerForm) {
//        return "login";
//    }


}

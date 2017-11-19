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
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    WebUsersService webUsersService;

    @Autowired
    HttpSession session;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(Model model) {
        WebUsers user = new WebUsers();
        model.addAttribute("registeredUser", user);
        return "registration";
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView doRegistration(@ModelAttribute("registeredUser") WebUsers registeredUser) {
        ModelAndView mod = new ModelAndView();
        mod.addObject(registeredUser);
        webUsersService.saveUser(registeredUser);
        mod.setViewName("confirmation");
        return mod;
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String getConfirmation(@ModelAttribute("registeredUser") WebUsers registeredUser) {
        // we have to clear data after registrations and provide new one to login
        return "index";
    }
    

}

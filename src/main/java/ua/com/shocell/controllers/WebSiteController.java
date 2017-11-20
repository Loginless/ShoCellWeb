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
public class WebSiteController {

    @Autowired
    WebUsersService webUsersService;

    @Autowired
    WebUserRegValidator webUserRegValidator;

    @Autowired
    WebUserLoginValidator webUserLoginValidator;





//    @RequestMapping(value = {"/user**"}, method = {RequestMethod.GET})
//    public ModelAndView welcomePage() {
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security - user page");
//        model.addObject("message", "User Page !");
//        model.setViewName("user");
//        return model;
//    }


}

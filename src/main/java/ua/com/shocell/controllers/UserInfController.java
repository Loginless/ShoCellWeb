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
public class UserInfController {

    @Autowired
    WebUserServiceImpl webUserServiceImpl;

    @RequestMapping(value = {"/getUserInf"}, method = RequestMethod.GET)
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView("userInfForm", "getUserForm", new WebUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/getUserInformationProcess", method = RequestMethod.POST)
    public ModelAndView checkLoginForm(@ModelAttribute("userInfForm") WebUsers getUserForm) {
//        if(webUsersService.findByLogin(getUserForm.getLogin()) != null &&
//                webUsersService.findByLogin(getUserForm.getLogin()).getPassword()
//                        .equals(getUserForm.getPassword())){
//            getUserForm = webUsersService.getByLogin(getUserForm.getLogin());
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("/confidential/userInformation");
//            modelAndView.addObject(getUserForm);
//            return new ModelAndView("/confidential/userInformation","getUserForm",getUserForm);
//        }
//        return new ModelAndView("userInformation");

            getUserForm = webUserServiceImpl.findWebUserByLogin(getUserForm.getLogin());
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/confidential/userInformation");
            modelAndView.addObject(getUserForm);
            return modelAndView;
    }


}

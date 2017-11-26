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
public class UserRemoveController {

    @Autowired
    WebUserServiceImpl webUserServiceImpl;

    @RequestMapping(value = {"/removeWebUser"}, method = RequestMethod.GET)
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView("deleteUserForm", "deleteUserForm", new WebUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteUserProcess", method = RequestMethod.POST)
    public ModelAndView checkLoginForm(@ModelAttribute("removeWebUser") WebUsers deleteUserForm) {
        deleteUserForm = webUserServiceImpl.findWebUserByLogin(deleteUserForm.getLogin());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/removeConfirmation");
        modelAndView.addObject(deleteUserForm);
        webUserServiceImpl.deleteByLogin(deleteUserForm.getLogin());
        return modelAndView;
    }


}

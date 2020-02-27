package com.example.controller;

import com.example.model.User;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final CustomerService userService;

    @Autowired
    public LoginController(CustomerService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView loginProcess(HttpServletRequest req) {
//        String username = req.getParameter("username");
//        ModelAndView mav = new ModelAndView("login");
//        User user = (User) userService.getUserByUsername(username);
//
//        if (null != user) {
//            mav.addObject("username", user.getUsername());
//            mav.setViewName("redirect:/welcome");
//
//        } else {
//            mav.addObject("message", "Username or Password is wrong!!");
//            mav.setViewName("redirect:/login");
//        }
//        return mav;
//    }
}

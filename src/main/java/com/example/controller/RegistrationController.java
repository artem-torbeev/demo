package com.example.controller;

import com.example.model.User;
import com.example.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    private final CustomerService userService;

    public RegistrationController(CustomerService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest req) {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userService.creatUser(new User(username, email, password));
        return new ModelAndView("welcome", "username", username);
    }
}

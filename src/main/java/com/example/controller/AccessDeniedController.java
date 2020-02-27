package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        return new ModelAndView("access_denied");
    }
}

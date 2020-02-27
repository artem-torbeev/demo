package com.example.controller;

import com.example.model.User;
import com.example.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    private final CustomerService userService;

    public AdminController(CustomerService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public ModelAndView getAllUsers() {
        List<User> users = userService.selectAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("listUser", users);
        return modelAndView;
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView getUserToEdit(@PathVariable Long id) {
        User user = (User) userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/admin/edit/{id}")
    public ModelAndView editUser(@PathVariable Long id, HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        userService.updateUser(id, name, email);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/admin/create")
    public ModelAndView getFormForCreateUser() {
        return new ModelAndView("create");
    }

    @PostMapping("/admin/create")
    public ModelAndView createUser(HttpServletRequest req) {
        String username = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userService.creatUser(new User(username, email, password));
        return new ModelAndView( "redirect:/admin");
    }
}


package com.kilopo.kwitter.controller;

import com.kilopo.kwitter.domain.User;
import com.kilopo.kwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {


    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registeruser(User user, Model model) {


        if (!userService.addUser(user)) {
            model.addAttribute("message", "User already exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActive = userService.activateUser(code);

        if (isActive) {
            model.addAttribute("message", "User successfully activated!");
        } else {
            model.addAttribute("message", "Activation Code is not found!");
        }
        return "login";
    }
}

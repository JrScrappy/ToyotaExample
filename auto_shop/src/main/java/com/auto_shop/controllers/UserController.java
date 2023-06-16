package com.auto_shop.controllers;

import com.auto_shop.beans.HttpSession;
import com.auto_shop.models.entities.User;
import com.auto_shop.models.enums.UserRole;
import com.auto_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class UserController {
    private final UserService service;
    private final HttpSession session;

    @Autowired
    public UserController(UserService service, HttpSession session) {
        this.service = service;
        this.session = session;
    }

    @GetMapping("/account")
    public ModelAndView getUser(ModelAndView modelAndView) {
        if (!session.isPresent()) {
            return new ModelAndView("redirect:/login");
        }
        modelAndView.addObject("user", session.getUser());
        modelAndView.setViewName("account.html");
        return modelAndView;
    }

    @PostMapping("/account")
    public ModelAndView exit(ModelAndView modelAndView) {
        session.clear();
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/signin")
    public ModelAndView signIn(ModelAndView modelAndView) {
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signin.html");
        return modelAndView;
    }

    @PostMapping("/signin")
    public ModelAndView createUser(@ModelAttribute User user, ModelAndView modelAndView) {
        user.setRole(UserRole.CLIENT);
        try {
            service.save(user);
            session.setUser(user);
        } catch (Exception ex) {
            return signIn(modelAndView);
        }
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public ModelAndView logIn(ModelAndView modelAndView) {
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login.html");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView getUser(@RequestParam String phone, @RequestParam String password, ModelAndView modelAndView) {
        session.setUser(service.getUserByPhoneAndPassword(phone, password));
        return (session.isPresent()) ? new ModelAndView("redirect:/") : logIn(modelAndView);
    }
}

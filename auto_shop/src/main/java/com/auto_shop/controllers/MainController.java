package com.auto_shop.controllers;

import com.auto_shop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class MainController {
    private final CarService service;

    @Autowired
    public MainController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getCatalog(ModelAndView modelAndView){
        modelAndView.addObject("cars", service.findAll());
        modelAndView.setViewName("toyota.html");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getCar(@PathVariable String id, ModelAndView modelAndView){
        modelAndView.addObject("car", service.getById(id));
        modelAndView.setViewName("auto.html");
        return modelAndView;
    }
}

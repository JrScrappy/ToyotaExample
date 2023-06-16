package com.auto_shop.controllers;

import com.auto_shop.beans.HttpSession;
import com.auto_shop.models.entities.Order;
import com.auto_shop.models.entities.User;
import com.auto_shop.models.enums.UserRole;
import com.auto_shop.services.CarService;
import com.auto_shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final CarService carService;
    private HttpSession session;

    @Autowired
    public OrderController(OrderService orderService, CarService carService, HttpSession session) {
        this.orderService = orderService;
        this.carService = carService;
        this.session = session;
    }

    @GetMapping
    public ModelAndView getOrders(ModelAndView modelAndView) {
        if (!session.isPresent()) {
            return new ModelAndView("redirect:/login");
        }
        User currentUser = session.getUser();
        List<Order> orders;
        if (currentUser.getRole() == UserRole.MANAGER) {
            orders = orderService.getForManager();
        } else {
            orders = orderService.getByClientId(currentUser.getId());
        }
        modelAndView.addObject("user", session.getUser());
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders.html");
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView createOrder(@PathVariable("id") String idCar, ModelAndView modelAndView) {
        if (!session.isPresent()) {
            return new ModelAndView("redirect:/login");
        }
        Order order = new Order(session.getUser(), carService.getById(idCar));
        orderService.save(order);
        return new ModelAndView("redirect:/orders");
    }

    @PostMapping("/accept/manager/{id}")
    public ModelAndView acceptManagerOrder(@PathVariable("id") String idOrder, ModelAndView modelAndView) {
        if (!session.isPresent()) {
            return new ModelAndView("redirect:/login");
        }
        Order order = orderService.getById(idOrder);
        order.setEndDateManager(Date.valueOf(LocalDate.now()));
        order.setManager(session.getUser());
        orderService.save(order);
        return new ModelAndView("redirect:/orders");
    }

    @PostMapping("/cancel/{id}")
    public ModelAndView cancelOrder(@PathVariable("id") String idOrder, ModelAndView modelAndView) {
        if (!session.isPresent()) {
            return new ModelAndView("redirect:/login");
        }
        Order order = orderService.getById(idOrder);
        order.setCanceled(true);
        orderService.save(order);
        return new ModelAndView("redirect:/orders");
    }
}

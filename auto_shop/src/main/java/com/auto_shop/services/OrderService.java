package com.auto_shop.services;

import com.auto_shop.models.entities.Order;
import com.auto_shop.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository repository;

    public void save(Order order){
        repository.save(order);
    }

    public void save(Iterable<Order> orders){
        repository.saveAll(orders);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order getById(String id) {
        return repository.getReferenceById(id);
    }

    public List<Order> getByClientId(String id) {
        return repository.getByClientId(id);
    }

    public List<Order> getForManager() {
        return repository.getForManager();
    }
}

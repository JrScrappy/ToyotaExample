package com.auto_shop.services;

import com.auto_shop.models.entities.Car;
import com.auto_shop.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository repository;


    public void save(Car car) {
        repository.save(car);
    }

    public void save(Iterable<Car> cars) {
        repository.saveAll(cars);
    }

    public List<Car> findAll() {
        return repository.findAll();
    }


    public Car getById(String id) {
        return repository.getReferenceById(id);
    }

}

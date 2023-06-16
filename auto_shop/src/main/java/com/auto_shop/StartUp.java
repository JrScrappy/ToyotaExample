package com.auto_shop;

import com.auto_shop.models.entities.Car;
import com.auto_shop.models.entities.User;
import com.auto_shop.models.enums.CarEngineType;
import com.auto_shop.models.enums.UserRole;
import com.auto_shop.services.CarService;
import com.auto_shop.services.OrderService;
import com.auto_shop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class StartUp implements CommandLineRunner {
    private final UserService userService;
    private final CarService carService;
    private final OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        makeUsers();
        makeCars();
    }

    private void makeCars() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Highlander", "https://toyotaassets.scene7.com/is/image/toyota/HLD_MY23_0003_V001_desktop-1?fmt=jpeg&fit=crop&qlt=90&wid=500", "Go above and beyond the ordinary.", 2023, 265, 36420, 22, 29, CarEngineType.ENGINE));
        cars.add(new Car("bZ4X", "https://toyotaassets.scene7.com/is/image/toyota/BZ4_MY23_0035_V001-2?fmt=jpeg&fit=crop&qlt=90&wid=500", "Refreshingly intuitive. Remarkably designed.", 2023, 42000, 201, 24, 25, CarEngineType.ELECTRIC));
        cars.add(new Car("Highlander Hybrid", "https://toyotaassets.scene7.com/is/image/toyota/HLH_MY23_0002_V001_desktop-2?fmt=jpeg&fit=crop&qlt=90&wid=500", "Designed to go the extra miles.", 2023, 265, 40220, 36, 35, CarEngineType.ENGINE));
        cars.add(new Car("RAV4", "https://toyotaassets.scene7.com/is/image/toyota/RAV_MY22_0051_V001-4?fmt=jpeg&fit=crop&qlt=90&wid=500", "Adventure is what you make of it.", 2023, 203, 27975, 27, 35, CarEngineType.ENGINE));
        cars.add(new Car("RAV4 Hybrid", "https://toyotaassets.scene7.com/is/image/toyota/RHV_MY23_0003_V001_mobile-1?fmt=jpeg&fit=crop&qlt=90&wid=500", "Get ready to expand your territory.", 2023, 203, 30725, 41, 38, CarEngineType.ENGINE));
        cars.add(new Car("RAV4 Prime", "https://toyotaassets.scene7.com/is/image/toyota/RPV_MY22_0002_V001_mobile?fmt=jpeg&fit=crop&qlt=90&wid=500", "Power up your drive.", 2023, 302, 42340, 38, 94, CarEngineType.ENGINE));
        cars.add(new Car("Corolla Cross", "https://toyotaassets.scene7.com/is/image/toyota/COC_MY22_0042_V001-2?fmt=jpeg&fit=crop&qlt=90&wid=500", "For the life that requires a little bit of everything.", 2023, 196, 23060, 31, 33, CarEngineType.ENGINE));
        cars.add(new Car("Corolla Cross Hybrid", "https://toyotaassets.scene7.com/is/image/toyota/CCH_MY23_0002_V002_mobile?fmt=jpeg&fit=crop&qlt=90&wid=500", "A move in the bold direction.", 2023, 196, 27970, 45, 38, CarEngineType.ENGINE));
        cars.add(new Car("4Runner", "https://toyotaassets.scene7.com/is/image/toyota/FRN_MY23_0014_V001_mobile?fmt=jpeg&fit=crop&qlt=90&wid=500", "The legend continues.", 2023, 270, 39555, 16, 19, CarEngineType.GAS_ENGINE));
        cars.add(new Car("Venza", "https://toyotaassets.scene7.com/is/image/toyota/VEN_MY23_0001_V002_mobile_sc5kChoi77?fmt=jpeg&fit=crop&qlt=90&wid=500", "Designed for the daring.", 2023, 219, 34120, 40, 37, CarEngineType.ENGINE));
        cars.add(new Car("Sequoia", "https://toyotaassets.scene7.com/is/image/toyota/SEQ_MY23_0041_V001_912x680?fmt=jpeg&fit=crop&qlt=90&wid=500", "Take your family adventures above and beyond.", 2023, 437, 58365, 21, 24, CarEngineType.ENGINE));
        carService.save(cars);
    }

    private void makeUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Alex", "Petrov", "alexpetrov@example.com", "+380991234567", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Elena", "Ivanova", "elenivanova@example.com", "+380982345678", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Sergey", "Kuznetsov", "sergeykuznetsov@example.com", "+380973456789", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Olga", "Sidorova", "olgasidorova@example.com", "+380964567890", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Ivan", "Fedorov", "ivanfedorov@example.com", "+380955678901", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Maria", "Smirnova", "mariasmirnova@example.com", "+380946789012", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Dmitry", "Kovalev", "dmitrykovalev@example.com", "+380937890123", "password", Date.valueOf(LocalDate.now()), UserRole.CLIENT));
        users.add(new User("Anastasia", "Popova", "anastasiapopova@example.com", "+380928901234", "password", Date.valueOf(LocalDate.now()), UserRole.MANAGER));
        users.add(new User("Pavel", "Sokolov", "pavelsokolov@example.com", "+380919012345", "password", Date.valueOf(LocalDate.now()), UserRole.MANAGER));
        users.add(new User("Natalia", "Morozova", "nataliamorozova@example.com", "+380901123456", "password", Date.valueOf(LocalDate.now()), UserRole.MANAGER));
        userService.save(users);
    }
}

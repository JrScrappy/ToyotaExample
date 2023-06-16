package com.auto_shop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "car_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    private final String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    @NotNull
    private Date startDate = Date.valueOf(LocalDate.now());

    @Column
    private Date endDateManager;

    @Column
    private Boolean canceled = false;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private User client;

    @ManyToOne
    @JoinColumn
    private User manager;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Car car;

    public Order(User client, Car car) {
        this.client = client;
        this.car = car;
    }

    public String getStatus() {
        if (canceled) {
            return "CANCELED";
        }
        if (endDateManager != null) {
            return "ACCEPTED";
        } else {
            return "ON REVISION";
        }
    }
}

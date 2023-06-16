package com.auto_shop.models.entities;

import com.auto_shop.models.enums.CarEngineType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car{
    @Id
    private final String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String pictureUrl;

    @Column(nullable = false)
    private String description;
    /**
     * Manufacturer's Suggested Retail Price
     * */
    @Column(nullable = false)
    private Integer msrp;


    /**
     * Horse Power
     */
    @Column(nullable = false)
    private Integer hp;

    /**
     * Miles Per Gallon
     * */
    @Column(nullable = false)
    private Integer mpgStarts;

    @Column(nullable = false)
    private Integer mpgEnds;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarEngineType engineType;

    public Car(String name, String pictureUrl, String description, Integer year,  Integer hp, Integer msrp, Integer mpgStarts, Integer mpgEnds, CarEngineType engineType) {
        if(mpgStarts > mpgEnds){
            int tmp = mpgStarts;
            mpgStarts = mpgEnds;
            mpgEnds = tmp;
        }

        this.name = name;
        this.year = year;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.msrp = msrp;
        this.hp = hp;
        this.mpgStarts = mpgStarts;
        this.mpgEnds = mpgEnds;
        this.engineType = engineType;
    }
}

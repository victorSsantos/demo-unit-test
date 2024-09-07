package com.curso.java.demo.rental.api.entities;

import com.curso.java.demo.rental.api.entities.enums.CarStatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_car_status")
public class CarStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CarStatusType type;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private final List<Car> cars = new ArrayList<>();

    public CarStatus() {
    }

    public CarStatus(Long id, CarStatusType type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarStatusType getType() {
        return type;
    }

    public void setType(CarStatusType type) {
        this.type = type;
    }

    public List<Car> getCars() {
        return cars;
    }
}


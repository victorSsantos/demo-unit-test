package com.curso.java.demo.rental.api.entities;

import com.curso.java.demo.rental.api.entities.enums.RentalStatusType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_rental_status")
public class RentalStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RentalStatusType type;

    @OneToMany(mappedBy = "status")
    private final List<Rental> rentals = new ArrayList<>();

    public RentalStatus() {
    }

    public RentalStatus(Long id, RentalStatusType type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentalStatusType getType() {
        return type;
    }

    public void setType(RentalStatusType type) {
        this.type = type;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}


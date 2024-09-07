package com.curso.java.demo.rental.api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private RentalStatus status;

    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Double totalValue;

    public Rental() {
    }

    public Rental(Long id, Client client, Car car, RentalStatus status, LocalDate rentalDate, LocalDate returnDate) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.status = status;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalValue =
                ChronoUnit.DAYS.between(returnDate,rentalDate) * car.getPricePerDay();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }
}

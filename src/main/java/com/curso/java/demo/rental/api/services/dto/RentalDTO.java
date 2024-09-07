package com.curso.java.demo.rental.api.services.dto;

import com.curso.java.demo.rental.api.entities.Car;
import com.curso.java.demo.rental.api.entities.Client;
import com.curso.java.demo.rental.api.entities.Rental;
import com.curso.java.demo.rental.api.entities.enums.RentalStatusType;
import com.curso.java.demo.rental.api.repositories.RentalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;

public class RentalDTO implements Serializable {

    @Autowired
    private RentalStatusRepository statusRepo;

    private Long id;
    private Client client;
    private Car car;
    private RentalStatusType status;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Double totalValue;

    public RentalDTO() {
    }

    public RentalDTO(Long id, Client client, Car car, RentalStatusType statusType, LocalDate rentalDate, LocalDate returnDate, Double totalValue) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.status = statusType;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalValue = totalValue;
    }

    public RentalDTO(Rental rental) {
        this.id = rental.getId();
        this.client = rental.getClient();
        this.car = rental.getCar();
        this.status = rental.getStatus().getType();
        this.rentalDate = rental.getRentalDate();
        this.returnDate = rental.getReturnDate();
        this.totalValue = rental.getTotalValue();
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

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public RentalStatusType getStatus() {
        return status;
    }

    public void setStatus(RentalStatusType status) {
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

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Rental toEntity(){
        var status = statusRepo.findByType(this.status);
        return new Rental(id, client, car, status, rentalDate, returnDate);
    }
}

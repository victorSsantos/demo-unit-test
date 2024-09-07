package com.curso.java.demo.rental.api.config;

import com.curso.java.demo.rental.api.entities.*;
import com.curso.java.demo.rental.api.entities.enums.CarStatusType;
import com.curso.java.demo.rental.api.entities.enums.CategoryType;
import com.curso.java.demo.rental.api.entities.enums.RentalStatusType;
import com.curso.java.demo.rental.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class InitConfig implements CommandLineRunner {

    @Autowired
    private CarStatusRepository carStatusRepo;

    @Autowired
    private RentalStatusRepository rentalStatusRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private CarRepository carRepo;

    @Override
    public void run(String... args) throws Exception {

        CarStatus cs1 = new CarStatus(null, CarStatusType.AVAILABLE);
        CarStatus cs2 = new CarStatus(null, CarStatusType.RENTED);
        CarStatus cs3 = new CarStatus(null, CarStatusType.OUT_OF_SERVICE);
        carStatusRepo.saveAll(Arrays.asList(cs1, cs2, cs3));

        RentalStatus rs1 = new RentalStatus(null, RentalStatusType.OPEN);
        RentalStatus rs2 = new RentalStatus(null, RentalStatusType.CLOSED);
        rentalStatusRepo.saveAll(Arrays.asList(rs1, rs2));

        Category c1 = new Category(null, CategoryType.HATCH);
        Category c2 = new Category(null, CategoryType.SEDAN);
        Category c3 = new Category(null, CategoryType.SUV);
        categoryRepo.saveAll(Arrays.asList(c1, c2, c3));

        Client cli1 = new Client(null, "John Green", "john.green@gmail.com","985873945784");
        Client cli2 = new Client(null, "Rosie White", "rosie.white@gmail.com","754739000788");
        clientRepo.saveAll(Arrays.asList(cli1, cli2));

        Car car01 = new Car(null,"Hyundai - Hb20", c1, 2018, 150.0, cs1);
        Car car02 = new Car(null, "Fiat - Argo", c1, 2021, 150.00, cs1);
        Car car03 = new Car(null, "Chevrolet - Onix", c1, 2020, 140.00, cs1);
        Car car04 = new Car(null, "Toyota - Corolla", c2, 2022, 200.00, cs1);
        Car car05 = new Car(null, "Honda - Civic", c2, 2021, 210.00, cs1);
        Car car06 = new Car(null, "Nissan - Sentra", c2, 2020, 220.00, cs1);
        Car car07 = new Car(null, "Jeep - Compass", c3, 2022, 300.00, cs1);
        Car car08 = new Car(null, "Hyundai - Creta", c3, 2021, 280.00, cs1);
        Car car09 = new Car(null, "Volkswagen - TCross", c3, 2020, 270.00, cs1);
        Car car10 = new Car(null, "Renault - Duster", c3, 2019, 260.00, cs1);
        carRepo.saveAll(Arrays.asList(car01, car02, car03, car04, car05, car06, car07, car08, car09, car10));

    }
}

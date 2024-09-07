package com.curso.java.demo.rental.api.entities;

import com.curso.java.demo.rental.api.entities.enums.CategoryType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CategoryType type;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private final List<Car> cars = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, CategoryType type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public List<Car> getCars() {
        return cars;
    }
}

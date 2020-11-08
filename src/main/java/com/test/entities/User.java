package com.test.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 255)
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holderCar", fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    public User(){}

    public User(String fullName){
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addCar(Car car){
        if (car != null){
            this.cars.add(car);
            car.setHolderCar(this);
        }
    }
}

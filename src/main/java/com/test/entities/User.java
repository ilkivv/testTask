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
    private String full_name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holder_car", fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    public User(){}

    public User(String full_name){
        this.full_name = full_name;
    }

    public Long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        if (car != null){
            this.cars.add(car);
            car.setHolder_car(this);
        }
    }

    public void removeCar(Car car){
        if (car != null){
            this.cars.remove(car);
            car.setHolder_car(null);
        }
    }
}

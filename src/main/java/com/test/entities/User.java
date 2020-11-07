package com.test.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;

    @OneToMany(mappedBy = "holder_car", fetch = FetchType.EAGER)
    private Collection<Car> cars;

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

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }
}

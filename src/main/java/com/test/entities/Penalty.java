package com.test.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "penalties")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_penalty", length = 255)
    private String type_penalty;

    @Column(name = "tarrif")
    private Float tarrif;

    @ManyToMany(mappedBy = "penalties", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Car> cars = new ArrayList<>();

    public Penalty(){}

    public Penalty(String type_penalty, Float tarrif){
        this.type_penalty = type_penalty;
        this.tarrif = tarrif;
    }

    public Long getId() {
        return id;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    public String getType_penalty() {
        return type_penalty;
    }

    public void setType_penalty(String type_penalty) {
        this.type_penalty = type_penalty;
    }

    public Float getTarrif() {
        return tarrif;
    }

    public void setTarrif(Float tarrif) {
        this.tarrif = tarrif;
    }

    public void addCar(Car car){
        if (car != null){
            this.cars.add(car);
        }
    }

    public void removeCar(Car car){
        if (car != null){
            this.cars.remove(car);
        }
    }

    public void removePCarAll(){
        for (Car car : cars){
            removeCar(car);
        }
    }
}

package com.test.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state_number", length = 255)
    private String state_number;

    @Column(name = "brand_car", length = 255)
    private String brand_car;

    @Column(name = "model_car", length = 255)
    private String model_car;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User holder_car;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "car_penalties",
            joinColumns = @JoinColumn(
                    name = "car_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "penalty_id",
                    referencedColumnName = "id"
            )
    )
    private Collection<Penalty> penalties = new ArrayList<>();

    public Car() {
    }

    public Car(String state_number, String brand_car, String model_car) {
        this.state_number = state_number;
        this.brand_car = brand_car;
        this.model_car = model_car;
    }

    public Car(String state_number, String brand_car, String model_car, User holder_car) {
        this.state_number = state_number;
        this.brand_car = brand_car;
        this.model_car = model_car;
        this.holder_car = holder_car;
    }

    public Long getId() {
        return id;
    }

    public String getState_number() {
        return state_number;
    }

    public void setState_number(String state_number) {
        this.state_number = state_number;
    }

    public String getBrand_car() {
        return brand_car;
    }

    public void setBrand_car(String brand_car) {
        this.brand_car = brand_car;
    }

    public String getModel_car() {
        return model_car;
    }

    public void setModel_car(String model_car) {
        this.model_car = model_car;
    }

    public User getHolder_car() {
        return holder_car;
    }

    public void setHolder_car(User holder_car) {
        this.holder_car = holder_car;
    }

    public Collection<Penalty> getPenalties() {
        return penalties;
    }

    public void setPenalties(Collection<Penalty> penalties) {
        this.penalties = penalties;
    }

    public void addPenalty(Penalty penalty){
        if (penalty != null){
            this.penalties.add(penalty);
        }
    }

    public void removePenalty(Penalty penalty) {
        if (penalty != null){
            this.penalties.remove(penalty);
        }
    }

    public void removePenaltyAll(){
        for (Penalty penalty : penalties){
            removePenalty(penalty);
        }
    }

//    public void isEmpty(){
//        return assert
//    }
}

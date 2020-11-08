package com.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String stateNumber;

    @Column(name = "brand_car", length = 255)
    private String brandCar;

    @Column(name = "model_car", length = 255)
    private String modelCar;

    @JsonIgnoreProperties("cars")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User holderCar;

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

    public Car(String stateNumber, String brand_car, String model_car) {
        this.stateNumber = stateNumber;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
    }

    public Long getId() {
        return id;
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

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public User getHolderCar() {
        return holderCar;
    }

    public void setHolderCar(User holderCar) {
        this.holderCar = holderCar;
    }
}

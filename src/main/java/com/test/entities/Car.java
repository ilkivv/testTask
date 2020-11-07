package com.test.entities;

import com.sun.org.glassfish.gmbal.NameValue;
import com.test.intarfaces.CarRepository;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

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
}

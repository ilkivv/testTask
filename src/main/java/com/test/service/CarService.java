package com.test.service;

import com.test.entities.Car;
import com.test.entities.Penalty;
import com.test.intarfaces.CarRepository;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service("carService")
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List getPenalties(String stateNumber, String fullName) {

        List<Car> cars = new ArrayList<>();

        if (!fullName.isEmpty() && !stateNumber.isEmpty() ) {
            cars = carRepository.findDistinctByStateNumberAndHolderCar_FullNameContaining(stateNumber, fullName);
        }else if (!fullName.isEmpty() && stateNumber.isEmpty()){
            cars = carRepository.findDistinctByHolderCar_FullNameContaining(fullName);
        }else if (fullName.isEmpty() && !stateNumber.isEmpty()){
            cars = carRepository.findDistinctByStateNumber(stateNumber);
        }

        List penaltiesByCar = getAllPenaltiesByAllCars(cars);

        return penaltiesByCar;
    }

    public List<?> getAllPenaltiesByAllCars(List<Car> cars){
        List<String> penalties = new ArrayList();
        for (Car car : cars) {
            for ( Penalty penalty: car.getPenalties()) {
                penalties.add("Штраф: " + penalty.getTypePenalty()
                                + " тариф: " + penalty.getTarrif() + " руб."
                                + " гос. номер: " + car.getStateNumber()
                                + " Автомобиль: " + car.getBrandCar() + " " + car.getModelCar()
                                + " Владелец: " + car.getHolderCar().getFullName()
                );
            }
        }
        return penalties;
    }
}

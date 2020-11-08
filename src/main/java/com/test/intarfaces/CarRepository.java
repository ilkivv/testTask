package com.test.intarfaces;

import com.test.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List <Car> findDistinctByStateNumberOrHolderCar_FullNameContaining(String stateNumber, String fullName);

    List <Car> findDistinctByStateNumber(String stateNumber);

    List <Car> findDistinctByHolderCar_FullNameContaining(String fullName);

    List <Car> findAll();

}

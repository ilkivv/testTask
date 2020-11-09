package com.test.intarfaces;

import com.test.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List <Car> findDistinctByStateNumberOrHolderCar_FullNameContaining(String stateNumber, String fullName);

    List <Car> findDistinctByStateNumber(String stateNumber);

    List <Car> findDistinctByHolderCar_FullNameContaining(String fullName);

}

package com.test.intarfaces;

import com.test.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarRepository extends JpaRepository <Car, Long> {
}

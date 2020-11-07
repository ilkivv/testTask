package com.test.data;

import com.test.entities.Car;
import com.test.entities.Penalty;
import com.test.entities.User;
import com.test.intarfaces.CarRepository;
import com.test.intarfaces.PenaltyRepository;
import com.test.intarfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class DataLoader implements ApplicationRunner {

    @Autowired
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final PenaltyRepository penaltyRepository;

    public DataLoader(
            UserRepository userRepository,
            CarRepository carRepository, PenaltyRepository penaltyRepository){

        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.penaltyRepository = penaltyRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Penalty penalty1 = new Penalty("превышение скорости", (float) 500);
        Penalty penalty2 = new Penalty("сбил человека", (float) 100);
        Penalty penalty3 = new Penalty("сбил человека на зебре", (float) 200);
        Penalty penalty4 = new Penalty("сбил хрустика", (float) 50);
        Penalty penalty5 = new Penalty("Проезд на красный", (float) 5000);

        Car car1 = new Car();
        car1.setBrand_car("Toyota");
        car1.setModel_car("Spacio");
        car1.setState_number("с317нн70");
        car1.addPenalty(penalty1);
        car1.addPenalty(penalty2);

        Car car2 = new Car();
        car2.setBrand_car("Toyota");
        car2.setModel_car("Corolla");
        car2.setState_number("с214мм70");
        car2.addPenalty(penalty3);
        car2.addPenalty(penalty4);
        car2.addPenalty(penalty5);

        User user1 = new User();
        user1.setFull_name("Илькив Алексей Витальевич");
        user1.addCar(car1);
        user1.addCar(car2);
        userRepository.save(user1);

    }
}

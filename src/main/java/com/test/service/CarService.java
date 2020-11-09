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
            cars = carRepository.findDistinctByStateNumberOrHolderCar_FullNameContaining(stateNumber, fullName);
        }else if (!fullName.isEmpty() && stateNumber.isEmpty()){
            cars = carRepository.findDistinctByHolderCar_FullNameContaining(fullName);
        }else if (fullName.isEmpty() && !stateNumber.isEmpty()){
            cars = carRepository.findDistinctByStateNumber(stateNumber);
        }

        List qwe = carRepository.findAll();
        generateReport(qwe);

        return cars;
    }

    private void generateReport(List<Car> cars) {
        Map<Long, Integer> rating = new HashMap<>();
        for (Car car: cars) {
            for (Penalty penalty : car.getPenalties()){
                rating.put(
                        penalty.getId(),
                        rating.containsKey(penalty.getId())
                                ? rating.get(penalty.getId()) + 1
                                : 1
                );
            }
        }
        Map<Long, Integer> sortedRating = rating.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e2,
                                LinkedHashMap::new
                        )
                );

//        List<Car> cars1 = new ArrayList<>();
//        for (Map item : sortedRating) {
//
//        }

        String qwewqrq = "dfasd";
    }

    public Boolean isStateNumber(String stateNumber){
        String regexp = "/^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$/ui";
        return stateNumber.matches(regexp);
    }

    public Boolean isFullName(String fullName){
        String regexp = "/^[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{0,}\\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,}(\\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,})?$/";
        return fullName.matches(regexp);
    }

    public List getPenaltiesByCar(List<Car> cars){
        List penalties = new ArrayList<>();
//        for (Car car : cars){
//            penalties.add();
//        }
        return penalties;
    }
}

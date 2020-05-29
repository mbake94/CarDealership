package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception{

        Categories sedan = new Categories();
        sedan.setCarType("Sedan");
        categoryRepository.save(sedan);

        Categories truck = new Categories();
        truck.setCarType("Truck");
        categoryRepository.save(truck);

        Categories electric = new Categories();
        electric.setCarType("Electric");
        categoryRepository.save(electric);

        Car impala = new Car();
        impala.setMake("Chevorlet");
        impala.setCarModel("Impala");
        impala.setYear(2014);
        impala.setPrice(8500);
        impala.setMpg(35);
        impala.setCondition("Used");
        carRepository.save(impala);

        Car tesla = new Car();
        tesla.setMake("Tesla");
        tesla.setCarModel("Model 3");
        tesla.setYear(2020);
        tesla.setPrice(35200);
        tesla.setMpg(75);
        tesla.setCondition("New");
        carRepository.save(tesla);

        Car ford = new Car();
        ford.setMake("Ford");
        ford.setCarModel("F150");
        ford.setYear(2017);
        ford.setPrice(9420);
        ford.setMpg(29);
        ford.setCondition("Used");
        carRepository.save(ford);

        Set<Car> cars = new HashSet<Car>();
        cars.add(impala);
        cars.add(tesla);
        cars.add(ford);

        ford.setCategory(truck);
        tesla.setCategory(electric);
        impala.setCategory(sedan);


    }

}

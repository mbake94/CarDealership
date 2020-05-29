package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception{

        Category category = new Category();
        category.setCarType("Sedan");
        categoryRepository.save(category);

        category = new Category();
        category.setCarType("Truck");
        categoryRepository.save(category);

        category = new Category();
        category.setCarType("Sports Car");
        categoryRepository.save(category);

        category = new Category();
        category.setCarType("Electric");
        categoryRepository.save(category);

        Car car = new Car();
        car.setMake("Chevorlet");
        car.setCarModel("Impala");
        car.setYear(2014);
        car.setPrice(8700);
        car.setMpg(32);
        car.setCondition("Used");
        category.setCarType("Sedan");
        carRepository.save(car);

        car = new Car();
        car.setMake("Ford");
        car.setCarModel("F150");
        car.setYear(2017);
        car.setPrice(11200);
        car.setMpg(29);
        car.setCondition("Used");
        category.setCarType("Truck");
        carRepository.save(car);

        car = new Car();
        car.setMake("Tesla");
        car.setCarModel("Model 3");
        car.setYear(2020);
        car.setPrice(38000);
        car.setMpg(75);
        car.setCondition("New");
        category.setCarType("Electric");
        carRepository.save(car);



    }
}

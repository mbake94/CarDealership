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

        Categories category = new Categories();
        category.setCarType("Sedan");
        categoryRepository.save(category);

        category = new Categories();
        category.setCarType("Truck");
        categoryRepository.save(category);

        category = new Categories();
        category.setCarType("Sports Car");
        categoryRepository.save(category);

        category = new Categories();
        category.setCarType("Electric");
        categoryRepository.save(category);
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;
    // list objects
    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("allcategory", categoryRepository.findAll());
        return "list";
    }
    // add a new category page
    @RequestMapping("/newcategory")
    public String newCategory(Model model){
        model.addAttribute("category", new Category());
        return "newcategory";
    }
    // add a new car page
    @RequestMapping("/newcar")
    public String newCar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("allcategory", categoryRepository.findAll());
        return "newcar";
    }
    // process and save added objects
    @PostMapping("processcar")
    public String procressCar(@ModelAttribute("car") Car car){
        carRepository.save(car);
        return "redirect:/list";
    }
    @PostMapping("processcategory")
    public String procressCategory(@ModelAttribute("category") Category category){
        categoryRepository.save(category);
        return "redirect:/list";
    }
    // update car
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "newcar";
    }
    // delete category
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        return "redirect:/list";
    }
    // detail of car
    @RequestMapping("/details/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        model.addAttribute("course", carRepository.findById(id).get());
        Car car = carRepository.findById(id).get();

        return "detailCar";
    }

}
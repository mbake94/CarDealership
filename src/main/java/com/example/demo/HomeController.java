package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;
    // list objects
    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "list";
    }
    // add a new category page
    @RequestMapping("/newcategory")
    public String newCategory(Model model){
        model.addAttribute("category", new Categories());
        return "newcategory";
    }
    // add a new car page
    @RequestMapping("/newcar")
    public String newCar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "newcar";
    }
    // process and save added objects
    @PostMapping("processcar")
    public String procressCar(@ModelAttribute("car") Car car){
        carRepository.save(car);
        return "redirect:/";
    }
    @PostMapping("processcategory")
    public String procressCategory(@ModelAttribute("category") Categories category){
        categoryRepository.save(category);
        return "redirect:/";
    }

    // detail of car
    @RequestMapping("/details/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        model.addAttribute("cardetails", carRepository.findById(id).get());
        System.out.println("<<<<-------------DETAILS-------------->>>>");

        return "details";
    }
    // update car
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        System.out.println("<<<<-------------UPDATING-------------->>>>");
        return "newcar";
    }

    // delete category
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model, Car car){
       model.addAttribute("cars", carRepository.findById(id).get());
       Car cars = carRepository.findById(id).get();
       System.out.println("<<<<-------------DELETING-------------->>>>");
       carRepository.delete(car);
       return "redirect:/";

    }

}

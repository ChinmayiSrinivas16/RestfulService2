package com.example.controller;

import com.example.model.Laptop;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/laptop1")
public class LaptopController1 {
    List<Laptop> laptopList = new ArrayList<>();

    @GetMapping("/listLaptops")
    public List<Laptop> list() {
        return laptopList;
    }

    @GetMapping("/findById/{id}")
    public Laptop findById(@PathVariable int id) {
        return laptopList.stream()
                .filter(laptop -> laptop.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/findByName/{name}")
    public Laptop findByName(@PathVariable String name) {
        return laptopList.stream()
                .filter(laptop -> laptop.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/addLaptop")
    public void add(@RequestBody Laptop laptop) {
        laptopList.add(laptop);
    }

    @PutMapping("/updateLaptop/{id}")
    public String update(@PathVariable int id, @RequestBody Laptop updatedLaptop) {
        for (int i = 0; i < laptopList.size(); i++) {
            if (laptopList.get(i).getId() == id) {
                laptopList.set(i, updatedLaptop);
                return "Laptop updated successfully";
            }
        }
        return "Laptop not found";
    }

    @DeleteMapping("/deleteLaptop/{id}")
    public void delete(@PathVariable int id) {
        laptopList.removeIf(laptop -> laptop.getId() == id);
    }
}

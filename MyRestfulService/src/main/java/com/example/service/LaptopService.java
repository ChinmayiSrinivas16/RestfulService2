package com.example.service;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    // Add a new laptop
    public void addLaptop(Laptop lp) {
        laptopRepository.save(lp);
    }

    // Get a list of all laptops
    public List<Laptop> listLaptop() {
        return laptopRepository.findAll();
    }

    // Find a laptop by ID
    public Optional<Laptop> findOneLaptop(int index) {
        return laptopRepository.findById(index);
    }

    // Update a laptop by ID
    public Optional<Laptop> updateLaptop(int index, Laptop newLaptop) {
        Optional<Laptop> oldLaptop = laptopRepository.findById(index);
        if (oldLaptop.isPresent()) {
            oldLaptop.get().setName(newLaptop.getName());
            oldLaptop.get().setBrand(newLaptop.getBrand());
            oldLaptop.get().setPrice(newLaptop.getPrice());
            oldLaptop.get().setRAM(newLaptop.getRAM());
            laptopRepository.save(oldLaptop.get());  // Save the updated laptop
            return oldLaptop;  // Return the updated laptop
        }
        return Optional.empty();  // Return empty if laptop is not found
    }

    // Delete a laptop by ID
    public void deleteLaptop(int index) {
        Optional<Laptop> laptop = laptopRepository.findById(index);
        if (laptop.isPresent()) {
            laptopRepository.delete(laptop.get()); // Delete the laptop
        } else {
            throw new RuntimeException("Laptop id not found: " + index); // Handle case where laptop is not found
        }
    }

    // Find laptops by brand
    public List<Laptop> findByBrand(String brand) {
        return laptopRepository.findByBrand(brand);
    }
}


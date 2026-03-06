package com.example.controller;

import com.example.model.Laptop;
import com.example.service.LaptopService;
import com.example.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
@CrossOrigin("*")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    // Add a new laptop
    @PostMapping("/add")
    public void add(@RequestBody Laptop lp) {
        laptopService.addLaptop(lp);
    }

    // Get list of laptops
    @GetMapping("/list")
    public List<Laptop> list() {
        return laptopService.listLaptop();
    }

    // Get a single laptop by ID
    @GetMapping("/findOne/{index}")
    public ResponseEntity<Laptop> findOne(@PathVariable int index) {
        Laptop lt = laptopService.findOneLaptop(index)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop id not found: " + index));
        return ResponseEntity.ok().body(lt);
    }

    // Update a laptop by ID
    @PutMapping("/update/{index}")
    public ResponseEntity<Laptop> update(@PathVariable int index, @RequestBody Laptop newLaptop) {
        Laptop lt = laptopService.updateLaptop(index, newLaptop)
                .orElseThrow(() -> new ResourceNotFoundException("Laptop id not found: " + index));
        return ResponseEntity.ok().body(lt);
    }

    // Delete a laptop by ID
    @DeleteMapping("/delete/{index}")
    public ResponseEntity<Void> delete(@PathVariable int index) {
        laptopService.deleteLaptop(index);
        return ResponseEntity.noContent().build(); // Return 204 No Content status
    }

    // Find laptops by brand
    @GetMapping("/findByBrand/{brand}")
    public List<Laptop> findByBrandName(@PathVariable String brand) {
        return laptopService.findByBrand(brand);
    }
}
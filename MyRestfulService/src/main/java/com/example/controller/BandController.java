package com.example.controller;

import com.example.model.Band;
import com.example.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/band")
public class BandController {

    @Autowired
    BandRepository br;

    @PostMapping("/add")
    public void add(@RequestBody Band band) {
        br.save(band);
    }

    @GetMapping("/list")
    public List<Band> list() {
        return br.findAll();
    }

    @GetMapping("/findOne/{id}")
    public Optional<Band> findOne(@PathVariable int id) {
        return br.findById(id);
    }

    @PutMapping("/update/{id}")
    public Band update(@PathVariable int id, @RequestBody Band newBand) {
        Optional<Band> oldBand = br.findById(id);

        oldBand.get().setName(newBand.getName());
        oldBand.get().setMusicians(newBand.getMusicians());

        br.save(oldBand.get());
        return oldBand.get();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        br.deleteById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<Band> findByName(@PathVariable String name) {
        return br.findByName(name);
    }
}

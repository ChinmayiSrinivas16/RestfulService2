package com.example.controller;

import com.example.model.Musician;
import com.example.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musician")  // This is the base path for all Musician-related requests
public class MusicianController {

    @Autowired
    private MusicianRepository musicianRepository;

    // Add a new musician
    @PostMapping("/add")
    public void add(@RequestBody Musician musician) {
        musicianRepository.save(musician);  // Save the musician to the database
    }

    // Get all musicians
    @GetMapping("/list")
    public List<Musician> list() {
        return musicianRepository.findAll();  // Return all musicians
    }

    // Get a specific musician by ID
    @GetMapping("/findOne/{id}")
    public Optional<Musician> findOne(@PathVariable Integer id) {
        return musicianRepository.findById(id);  // Return the musician with the given ID
    }

    // Update a musician's information
    @PutMapping("/update/{id}")
    public Musician update(@PathVariable Integer id, @RequestBody Musician newMusician) {
        Optional<Musician> oldMusician = musicianRepository.findById(id);

        if (oldMusician.isPresent()) {
            Musician musician = oldMusician.get();
            musician.setName(newMusician.getName());
            musician.setStrings(newMusician.getStrings());
            musician.setType(newMusician.getType());
            musician.setBand(newMusician.getBand());  // Update the band reference

            return musicianRepository.save(musician);  // Save the updated musician to the database
        }

        return null;  // Return null if the musician is not found
    }

    // Delete a musician by ID
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        musicianRepository.deleteById(id);  // Delete the musician with the given ID
    }

    // Get all musicians from a specific band by band ID
    @GetMapping("/findByBand/{bandId}")
    public List<Musician> findByBand(@PathVariable Integer bandId) {
        return musicianRepository.findByBandId(bandId);  // Get musicians associated with a specific band
    }
}

package com.example.repository;

import com.example.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicianRepository extends JpaRepository<Musician, Integer> {
    // Find musicians by band ID
    List<Musician> findByBandId(Integer bandId);
}

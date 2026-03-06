package com.example.repository;

import com.example.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Integer> {

    @Query(value = "select b from Band b where b.name = ?1")
    public List<Band> findByName(String name);
}

package com.example.repository;

import com.example.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
//    @Query(value="select * from laptop l where l.brand=?1", nativeQuery = true)
//    public void findByBrand(String brand);

    @Query(value = "select l from Laptop l where l.brand=?1")
    public List<Laptop> findByBrand(String brand);
}

package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //public List<Product> findByCategoryIgnoreCaseAndRegionIgnoreCase(String category, String region);
    //@Query("Select c from Registration c where c.place like %:place%")
    public List<Product> findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(String category, String region);
}

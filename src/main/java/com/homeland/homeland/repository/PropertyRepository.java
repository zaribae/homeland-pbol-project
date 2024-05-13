package com.homeland.homeland.repository;

import com.homeland.homeland.model.Property;
import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    
    List<Property> findTop3ByOrderByIdDesc();
}

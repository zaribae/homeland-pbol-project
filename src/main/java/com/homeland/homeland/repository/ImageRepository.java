package com.homeland.homeland.repository;

import com.homeland.homeland.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByPropertyId(Long propertyId);
}

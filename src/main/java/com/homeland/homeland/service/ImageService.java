package com.homeland.homeland.service;

import com.homeland.homeland.model.Property;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    void init();

    void save(MultipartFile file, Property property);

    Resource load(String fileName);

    List<String> findByPropertyId(Long propertyId);
}

package com.homeland.homeland.service;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.model.Property;

import java.util.List;

public interface PropertyService {
    Property findById(Long id);
    List<PropertyDto> findAllProperties();
    void addProperty(PropertyRequest propertyRequest);
    PropertyDto findPropertyById(Long id);
    List<PropertyDto> findLatestProperties();
}

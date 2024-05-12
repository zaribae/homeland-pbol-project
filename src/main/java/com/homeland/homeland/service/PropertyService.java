package com.homeland.homeland.service;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;

import java.util.List;

public interface PropertyService {
    List<PropertyDto> findAllProperties();
    void addProperty(PropertyRequest propertyRequest);
    PropertyDto findPropertyById(Long id);
    List<PropertyDto> findLatestProperties();
}

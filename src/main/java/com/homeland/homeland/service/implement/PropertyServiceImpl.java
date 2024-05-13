package com.homeland.homeland.service.implement;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.repository.PropertyRepository;
import com.homeland.homeland.service.ImageService;
import com.homeland.homeland.service.PropertyService;
import com.homeland.homeland.utilities.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final ImageService imageService;

    @Override
    public Property findById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Property not found with id: " + id));
    }

    @Override
    public List<PropertyDto> findAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream().map(this::mapPropertyToDto).collect(Collectors.toList());
    }

    @Override
    public void addProperty(PropertyRequest request) {
        var property = propertyRepository.save(Mapper.mapToPropertyFromRequest(request));

        Arrays.stream(request.getImages()).forEach(image -> {
            imageService.save(image, property);
        });

        mapPropertyToDto(propertyRepository.save(property));
    }

    @Override
    public PropertyDto findPropertyById(Long id) {
        return mapPropertyToDto(propertyRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PropertyDto> findLatestProperties() {
        return propertyRepository.findTop3ByOrderByIdDesc().stream().map(this::mapPropertyToDto).toList();
    }

    private PropertyDto mapPropertyToDto(Property property) {
        List<String> images = imageService.findByPropertyId(property.getId());
        return Mapper.mapToPropertyDto(property, images);
    }
}

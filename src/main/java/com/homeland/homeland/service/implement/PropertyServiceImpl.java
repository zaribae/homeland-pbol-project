package com.homeland.homeland.service.implement;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.repository.PropertyRepository;
import com.homeland.homeland.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<PropertyDto> findAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream().map((property) -> mapPropertyToDto(property)).collect(Collectors.toList());
    }

    private PropertyDto mapPropertyToDto(Property property) {

        return PropertyDto.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(property.getPrice())
                .image(property.getImage())
                .beds(property.getBeds())
                .baths(property.getBaths())
                .areas(property.getAreas())
                .homeType(property.getHomeType())
                .yearBuilt(property.getYearBuilt())
                .pricePerSqft(property.getPricePerSqft())
                .description(property.getDescription())
                .location(property.getLocation())
                .agentName(property.getAgentName())
                .propertiesStatusType(property.getPropertiesStatusType())
                .createdAt(property.getCreatedAt())
                .updatedAt(property.getUpdatedAt())
                .build();
    }
}

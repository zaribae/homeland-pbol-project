package com.homeland.homeland.service.implement;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.model.Image;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.model.PropertyStatus;
import com.homeland.homeland.repository.ImageRepository;
import com.homeland.homeland.repository.PropertyRepository;
import com.homeland.homeland.service.ImageService;
import com.homeland.homeland.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final ImageService imageService;
    private final ImageRepository imageRepository;

    @Override
    public List<PropertyDto> findAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream().map(this::mapPropertyToDto).collect(Collectors.toList());
    }

    @Override
    public PropertyDto addProperty(PropertyRequest request) {
        var property = propertyRepository.save(Property.builder()
                .title(request.getTitle())
                .price(request.getPrice())
                .beds(request.getBeds())
                .baths(request.getBaths())
                .areas(request.getAreas())
                .homeType(request.getType())
                .yearBuilt(request.getYearBuilt())
                .pricePerSqft(request.getPricePerSqft())
                .description(request.getDescription())
                .location(request.getLocation())
                .agentName(request.getAgent())
                .status(PropertyStatus.NOT_SOLD)
                .build());

        Arrays.stream(request.getImages()).forEach(image -> {
            imageService.save(image, property);
        });

        return mapPropertyToDto(propertyRepository.save(property));
    }

    private PropertyDto mapPropertyToDto(Property property) {

        return PropertyDto.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(property.getPrice())
                .images(imageService.findByPropertyId(property.getId()))
                .beds(property.getBeds())
                .baths(property.getBaths())
                .areas(property.getAreas())
                .homeType(property.getHomeType().toString())
                .yearBuilt(property.getYearBuilt())
                .pricePerSqft(property.getPricePerSqft())
                .description(property.getDescription())
                .location(property.getLocation())
                .agentName(property.getAgentName())
                .status(property.getStatus().toString())
                .createdAt(property.getCreatedAt())
                .updatedAt(property.getUpdatedAt())
                .build();
    }
}

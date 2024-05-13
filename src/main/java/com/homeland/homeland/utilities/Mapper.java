package com.homeland.homeland.utilities;

import com.homeland.homeland.controller.ImageController;
import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.model.PropertyStatus;
import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;

@UtilityClass
public class Mapper {

    public PropertyDto mapToPropertyDto(Property property, List<String> images) {

        return PropertyDto.builder()
                .id(property.getId())
                .title(property.getTitle())
                .price(NumberFormatter.numberToStringRupiah(property.getPrice()))
                .images(images.stream().map(Mapper::getImageUrl).toList())
                .beds(property.getBeds())
                .baths(property.getBaths())
                .areas(property.getAreas())
                .homeType(property.getHomeType().getDisplayValue())
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

    public Property mapToPropertyFromRequest(PropertyRequest request) {
        return Property.builder()
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
                .build();
    }

    public String getImageUrl(String imageName) {
        return MvcUriComponentsBuilder
                .fromMethodName(ImageController.class, "getImage", imageName)
                .build().toString();
    }
}

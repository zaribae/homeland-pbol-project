package com.homeland.homeland.dto;

import com.homeland.homeland.model.Image;
import com.homeland.homeland.model.PropertyStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class PropertyDto {
    private Long id;
    private String title;
    private String price;
    private List<String> images;
    private String beds;
    private String baths;
    private String areas;
    private String homeType;
    private String yearBuilt;
    private String pricePerSqft;
    private String description;
    private String location;
    private String agentName;
    private String status;
    private String createdAt;
    private String updatedAt;
}

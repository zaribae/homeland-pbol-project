package com.homeland.homeland.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PropertyDto {
    private Long id;
    private String title;
    private String price;
    private String image;
    private String beds;
    private String baths;
    private String areas;
    private String homeType;
    private String yearBuilt;
    private String pricePerSqft;
    private String description;
    private String location;
    private String agentName;
    private String propertiesStatusType;
    private String createdAt;
    private String updatedAt;

}

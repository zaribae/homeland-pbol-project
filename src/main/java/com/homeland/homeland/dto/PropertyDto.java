package com.homeland.homeland.dto;

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
    private Integer beds;
    private Integer baths;
    private Integer areas;
    private String homeType;
    private Integer yearBuilt;
    private Integer pricePerSqft;
    private String description;
    private String location;
    private String agentName;
    private String status;
    private String createdAt;
    private String updatedAt;
}

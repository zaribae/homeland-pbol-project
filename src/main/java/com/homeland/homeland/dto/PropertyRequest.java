package com.homeland.homeland.dto;

import com.homeland.homeland.model.PropertyType;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRequest {

    @NonNull
    private String title;

    @NonNull
    private Integer price;

    @NonNull
    private Integer beds;

    @NonNull
    private Integer baths;

    @NonNull
    private Integer areas;

    @NonNull
    private PropertyType type;

    @NonNull
    private Integer yearBuilt;

    @NonNull
    private Integer pricePerSqft;

    @NonNull
    private String location;

    @NonNull
    private String agent;

    @NonNull
    private String description;

    @NonNull
    private MultipartFile[] images;
}

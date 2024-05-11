package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;
}

package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;

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

    private String beds;

    private String baths;

    private String areas;

    private String homeType;

    private String yearBuilt;

    private String pricePerSqft;

    private String description;

    private String location;

    private String agentName;

    private PropertyStatus status;

    @OneToMany(mappedBy = "property")
    private List<Image> images;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;
}

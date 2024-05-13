package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;

    private Integer beds;

    private Integer baths;

    private Integer areas;

    @Enumerated(EnumType.STRING)
    private PropertyType homeType;

    private Integer yearBuilt;

    private Integer pricePerSqft;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    private String agentName;

    @Enumerated(EnumType.STRING)
    private PropertyStatus status;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;
}

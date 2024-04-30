package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
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

    private String home_type;

    private String year_built;

    private String price_per_sqft;

    private String description;

    private String location;

    private String agent_name;

    private String properties_status_type;

    @CreationTimestamp
    private String created_at;

    @UpdateTimestamp
    private String updated_at;
}

package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
}

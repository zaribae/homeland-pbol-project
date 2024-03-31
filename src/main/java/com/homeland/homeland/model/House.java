package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "house")
    List<Image> images;
}

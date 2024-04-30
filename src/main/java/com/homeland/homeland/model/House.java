package com.homeland.homeland.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

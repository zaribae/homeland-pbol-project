package com.homeland.homeland.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PropertyType {

    HOUSE("House"),
    APARTMENT("Apartment");

    private final String displayValue;
}

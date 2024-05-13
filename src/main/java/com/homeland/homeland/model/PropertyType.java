package com.homeland.homeland.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PropertyType {

    CONDO("Condo"),
    COMMERCIAL_BUILDING("Commercial Building"),
    LAND_PROPERTY("Land Property");

    private final String displayValue;
}

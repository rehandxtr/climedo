package com.climedo.test.model;

import lombok.Data;

@Data
public class DataPoint {
    private String dataType;
    private String label;
    private String description;
    private String[] options;
    private String placeholder;
}
package com.climedo.test.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "tabs")
public class Tabs {
    @Id
    String id;
    private String name;
    private String description;
    private List<DataPoint> dataPoints;
}

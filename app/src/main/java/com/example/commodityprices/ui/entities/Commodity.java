package com.example.commodityprices.ui.entities;

public class Commodity {

    private String name;
    private String description;

    public Commodity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}

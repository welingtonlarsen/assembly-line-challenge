package com.neogrid.model;

public class ProductionStep {

    private String description;
    private int necessaryTime;

    public ProductionStep(String description, int necessaryTime) {
        this.description = description;
        this.necessaryTime = necessaryTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNecessaryTime() {
        return necessaryTime;
    }

    public void setNecessaryTime(int necessaryTime) {
        this.necessaryTime = necessaryTime;
    }
}

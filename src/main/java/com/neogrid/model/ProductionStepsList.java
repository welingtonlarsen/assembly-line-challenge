package com.neogrid.model;

import java.util.ArrayList;
import java.util.List;

public class ProductionStepsList {

    private List<ProductionStep> productionStepsList = new ArrayList<>();

    public List<ProductionStep> getProductionStepsList() {
        return productionStepsList;
    }

    public void addProductionStepInList(ProductionStep newProductionStep) {
        productionStepsList.add(newProductionStep);
    }

    public void orderTheProductionStepsList() {
        productionStepsList.sort((a, b) -> ((Integer) b.getNecessaryTime()).compareTo(((Integer) a.getNecessaryTime())));

    }

}

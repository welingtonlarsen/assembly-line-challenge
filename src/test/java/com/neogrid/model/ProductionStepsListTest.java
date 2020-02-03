package com.neogrid.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductionStepsListTest {

    ProductionStepsList productionStepsList;
    ProductionStep productionStepA;
    ProductionStep productionStepB;
    ProductionStep productionStepC ;

    @Before
    public void setup(){
        productionStepsList = new ProductionStepsList();

        productionStepA = new ProductionStep("Description Test 1", 45);
        productionStepB = new ProductionStep("Description Test 2", 30);
        productionStepC = new ProductionStep("Description Test 2", 60);

        productionStepsList.addProductionStepInList(productionStepA);
        productionStepsList.addProductionStepInList(productionStepB);
        productionStepsList.addProductionStepInList(productionStepC);
    }

    @Test
    public void testNewInstanceOfProductionStepsList() {
        Assert.assertTrue(productionStepsList instanceof ProductionStepsList);
        Assert.assertTrue(!productionStepsList.getProductionStepsList().isEmpty());
    }

    @Test
    public void testOrderTheListFromProductionStepsListByDescendingOrder(){
        productionStepsList.orderTheProductionStepsList();

        List<ProductionStep> expetedListForTheTest = new ArrayList<>();
        expetedListForTheTest.add(productionStepC);
        expetedListForTheTest.add(productionStepA);
        expetedListForTheTest.add(productionStepB);

        Assert.assertEquals(expetedListForTheTest, productionStepsList.getProductionStepsList());
    }

}

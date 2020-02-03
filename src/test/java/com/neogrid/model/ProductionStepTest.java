package com.neogrid.model;

import org.junit.Assert;
import org.junit.Test;

public class ProductionStepTest {

    @Test
    public void testNewInstanceOfProductionStep() {
        ProductionStep productionStep = new ProductionStep("Production Step Test", 60);
        String descriptionFromNewProductionStep = productionStep.getDescription();
        int necessaryTimeFromNewProductionStep = productionStep.getNecessaryTime();

        Assert.assertEquals("Production Step Test", descriptionFromNewProductionStep);
        Assert.assertEquals(60, necessaryTimeFromNewProductionStep);
    }
}

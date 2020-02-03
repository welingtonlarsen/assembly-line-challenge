package com.neogrid.service.impl;

import com.neogrid.model.ProductionStep;
import com.neogrid.model.ProductionStepsList;
import com.neogrid.service.DocumentTxtEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DocumentTxtEntryImpl implements DocumentTxtEntry {

    ProductionStepsList productionStepsEntryList = new ProductionStepsList();

    public ProductionStepsList getProductionStepsEntryList() {
        return productionStepsEntryList;
    }

    public void setProductionStepsEntryList(ProductionStepsList productionStepsEntryList) {
        this.productionStepsEntryList = productionStepsEntryList;
    }

    @Override
    public BufferedReader createBufferedReader(String documentTxtPath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(documentTxtPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return bufferedReader;
    }

    @Override
    public void readAllDocumentAndAddProductionStepsToAList(BufferedReader bufferedReader) throws IOException {
        String currentLine = bufferedReader.readLine();

        String description = "";
        int necessaryTime = 0;
        ProductionStep productionStep = new ProductionStep(description, necessaryTime);

        this.createInstancesOfProductionSteps(currentLine, description, necessaryTime, productionStep, bufferedReader);
    }

    @Override
    public void createInstancesOfProductionSteps(String currentLine, String description, int necessaryTime, ProductionStep productionStep, BufferedReader bufferedReader) throws IOException {
        while (currentLine != null) {
            description = currentLine.substring(0, currentLine.length() - 6);

            if (currentLine.contains("30")) {
                necessaryTime = 30;
                productionStep = new ProductionStep(description, necessaryTime);
                productionStepsEntryList.addProductionStepInList(productionStep);
            }

            if (currentLine.contains("45")) {
                necessaryTime = 45;
                productionStep = new ProductionStep(description, necessaryTime);
                productionStepsEntryList.addProductionStepInList(productionStep);
            }

            if (currentLine.contains("60")) {
                necessaryTime = 60;
                productionStep = new ProductionStep(description, necessaryTime);
                productionStepsEntryList.addProductionStepInList(productionStep);
            }

            if (currentLine.contains("maintenance")) {
                necessaryTime = 5;
                productionStep = new ProductionStep(description, necessaryTime);
                productionStepsEntryList.addProductionStepInList(productionStep);
            }

            currentLine = bufferedReader.readLine();
        }
    }
}

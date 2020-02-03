package com.neogrid.service;

import com.neogrid.model.ProductionStep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DocumentTxtEntry {

    public BufferedReader createBufferedReader(String documentTxtPath) throws FileNotFoundException;

    public void readAllDocumentAndAddProductionStepsToAList(BufferedReader bufferedReader) throws IOException;

    public void createInstancesOfProductionSteps(String currentLine, String description, int necessaryTime, ProductionStep productionStep, BufferedReader bufferedReader) throws IOException;


}

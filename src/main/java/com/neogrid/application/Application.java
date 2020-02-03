package com.neogrid.application;

import com.neogrid.model.ProductionStep;
import com.neogrid.service.impl.DocumentTxtEntryImpl;
import com.neogrid.utils.ApplicationUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        String documentTxtPath = "c:\\dev\\projects\\arquivo.txt";

        DocumentTxtEntryImpl documentTxtEntry = new DocumentTxtEntryImpl();
        try {
            BufferedReader reader = documentTxtEntry.createBufferedReader(documentTxtPath);
            documentTxtEntry.readAllDocumentAndAddProductionStepsToAList(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        documentTxtEntry.getProductionStepsEntryList().orderTheProductionStepsList();
        List<ProductionStep> productionStepsListOrdened = documentTxtEntry.getProductionStepsEntryList().getProductionStepsList();

        if (productionStepsListOrdened.size() != 0) {
            ApplicationUtils.createOrganizedAssemblyLines(productionStepsListOrdened);
        }else {
            System.out.println("The txt document is empty!");
        }

    }

}

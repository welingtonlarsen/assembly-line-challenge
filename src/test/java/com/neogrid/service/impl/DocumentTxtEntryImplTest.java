package com.neogrid.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DocumentTxtEntryImplTest {

    DocumentTxtEntryImpl documentTxtEntry;
    BufferedReader reader;
    String documentTxtPath;

    @Before
    public void setup() throws FileNotFoundException {
        documentTxtEntry = new DocumentTxtEntryImpl();
        documentTxtPath = "c:\\dev\\projects\\arquivo.txt";
        reader = documentTxtEntry.createBufferedReader(documentTxtPath);
    }

    @Test
    public void testBufferedReaderCreation() {
        Assert.assertEquals(reader.getClass(), BufferedReader.class);
    }

    @Test
    public void testAddTheProductionStepsEntryToTheListEntity() throws IOException {
        documentTxtEntry.readAllDocumentAndAddProductionStepsToAList(reader);

        Assert.assertNotNull(documentTxtEntry.getProductionStepsEntryList().getProductionStepsList());
    }

    @Test(expected = FileNotFoundException.class)
    public void testShoudNotCreateBufferedReaderWithWrongOrEmptyPath() throws FileNotFoundException {
        reader = documentTxtEntry.createBufferedReader("c:\\invalidPath.txt");
    }
}

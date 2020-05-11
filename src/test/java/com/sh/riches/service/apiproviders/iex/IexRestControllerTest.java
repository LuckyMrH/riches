/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.service.apiproviders.iex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.riches.service.apiproviders.iex.business_objects.IexEarningsToday;
import com.sh.riches.service.apiproviders.iex.business_objects.IexEarningsTodayList;
import com.sh.riches.util.TestUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Steve
 */
@SpringBootTest
public class IexRestControllerTest {

    @Autowired
    ResourceLoader resourceLoader;

    public IexRestControllerTest() {
        System.out.println(TestUtil.createTestTitle("IexRestControllerTest()"));
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of list method, of class IexRestController.
     */
    /**
     * Test of fetchIexEarningsToday method, of class IexRestController.
     */
    @Test
    public void testFetchIexEarningsToday() throws JsonProcessingException {
        System.out.println(TestUtil.createTestTitle("IexRestControllerTest.testFetchIexEarningsToday()"));
        IexRestController instance = new IexRestController();

        File resourceFile = null;
        String jsonFile = null;

        try {
            resourceFile = resourceLoader.getResource(
                    "classpath:iex_api_earnings_today.json").getFile();
            jsonFile = new String(Files.readAllBytes(resourceFile.toPath()));
        }
        catch (IOException ex) {
            Logger.getLogger(IexRestControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(resourceFile);
        assertNotNull(jsonFile);
        System.out.println("EarningsToday JSON file=" + jsonFile);

        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        IexEarningsTodayList earningsToday = null;
        JsonNode node = mapper.readTree(jsonFile);
        System.out.println("JsonNode.getNodeTpe()=" + node.getNodeType()); // prints OBJECT
        System.out.println("JsonNode.isContainerNode()=" + node.isContainerNode()); // prints true
        Iterator<String> fieldNames = node.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            System.out.println(fieldName);// prints title, message, errors,
            // total,
            // total_pages, page, limit, dataset
        }
        JsonNode dataset = node.get("bto");
        System.out.println("bto dataNodeType=" + dataset.getNodeType()); // Prints ARRAY
        Iterator<JsonNode> datasetElements = dataset.iterator();
        while (datasetElements.hasNext()) {
            JsonNode datasetElement = datasetElements.next();
            // what is its type
            System.out.println("    bto datasetElementType()=" + datasetElement.getNodeType());// Prints Object
        }
        // what is its type?
        dataset = node.get("amc");
        System.out.println("amc dataNodeType=" + dataset.getNodeType()); // Prints ARRAY
        datasetElements = dataset.iterator();
        while (datasetElements.hasNext()) {
            JsonNode datasetElement = datasetElements.next();
            // what is its type
            System.out.println("     amc datasetElementType()=" + datasetElement.getNodeType());// Prints Object
        }
        // what is its type?
        dataset = node.get("other");
        System.out.println("other dataNodeType=" + dataset.getNodeType()); // Prints ARRAY
        datasetElements = dataset.iterator();
        while (datasetElements.hasNext()) {
            JsonNode datasetElement = datasetElements.next();
            // what is its type
            System.out.println("     other datasetElementType()=" + datasetElement.getNodeType());// Prints Object
            ObjectMapper datasetElementMapper = new ObjectMapper();
            datasetElementMapper.disable(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES);
            System.out.println("JSON STRING================");
            System.out.println(datasetElement.toString());
            IexEarningsToday earnings = datasetElementMapper.readValue(datasetElement.toString(), IexEarningsToday.class);
            System.out.println("EARNINGS===================");
            System.out.println(earnings.toString());

        }
    }
    // what is its type?

//    /**
//     * Test of fetchIexExchangeListing method, of class IexRestController.
//     */
//    @Test
//    public void testFetchIexExchangeListing() {
//        System.out.println("fetchIexExchangeListing");
//        IexRestController instance = new IexRestController();
//        String expResult = "";
//        String result = instance.fetchIexExchangeListing();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

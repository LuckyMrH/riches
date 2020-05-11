/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.api_providers.iex;

import com.sh.riches.service.apiproviders.iex.business_objects.IexExchangeXferObject;
import com.sh.riches.service.impl.entity.IexExchange;
import com.sh.riches.service.impl.repository.IexExchangeRepository;
import com.sh.riches.util.TestUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Steve
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class IexExchangeRepositoryTest {

    @Autowired
    private IexExchangeRepository iexRepo;

    public IexExchangeRepositoryTest() {
        System.out.println(TestUtil.createTestTitle("IexExchangeRepositoryTest()"));
    }

    @BeforeAll
    public void setUpClass() {
        IexExchangeXferObject xfer1 = new IexExchangeXferObject("NYS1",
                "US",
                "New York Stock Exchange",
                "XNYS",
                "");

        IexExchangeXferObject xfer2 = new IexExchangeXferObject("MEX1",
                "MX",
                "Mexican Stock Exchange",
                "XMEX",
                "-MM");

        IexExchangeXferObject xfer3 = new IexExchangeXferObject("ASE1",
                "US",
                "NYSE American",
                "XASE",
                "");
        IexExchangeXferObject xfer4 = new IexExchangeXferObject("BATS1",
                "US",
                "Cboe BZX US Equities Exchange",
                "BATS",
                "");

        //save eompany, verify has ID value after save
        IexExchange ex1 = new IexExchange(xfer1);
        IexExchange ex2 = new IexExchange(xfer2);
        IexExchange ex3 = new IexExchange(xfer3);
        IexExchange ex4 = new IexExchange(xfer4);
        assertNull(ex1.getId());
        assertNull(ex2.getId());//null before save
        assertNull(ex3.getId());
        assertNull(ex4.getId());//null before save
        iexRepo.save(ex1);
        iexRepo.save(ex2);
        iexRepo.save(ex3);
        iexRepo.save(ex4);
        assertNotNull(ex1.getId());
        assertNotNull(ex2.getId());
        assertNotNull(ex3.getId());
        assertNotNull(ex4.getId());

    }

    @AfterAll
    public void tearDownClass() {
        IexExchange ex1 = iexRepo.findByExchange("NYS1");
        IexExchange ex2 = iexRepo.findByExchange("MEX1");
        IexExchange ex3 = iexRepo.findByExchange("ASE1");
        IexExchange ex4 = iexRepo.findByExchange("BATS1");

        iexRepo.delete(ex1);
        iexRepo.delete(ex2);
        iexRepo.delete(ex3);
        iexRepo.delete(ex4);

        IexExchange ex5 = iexRepo.findByExchange("NYS1");
        IexExchange ex6 = iexRepo.findByExchange("MEX1");
        IexExchange ex7 = iexRepo.findByExchange("ASE1");
        IexExchange ex8 = iexRepo.findByExchange("BATS1");

        assertNull(ex5);
        assertNull(ex6);
        assertNull(ex7);
        assertNull(ex8);

    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetData() {
        System.out.println(TestUtil.createTestTitle("IexExchangeRepositoryTest.testGetData()"));

        /*Test data retrieval*/
//        exchange = xfer.getExchange();
//        region = xfer.getRegion();
//        description = xfer.getDescription();
//        marketId = xfer.getDescription();
//        exchangeSuffix = xfer.getExchangeSuffix();
        Iterable<IexExchange> exchanges = iexRepo.findAll();
        int count = 0;
        for (IexExchange ex : exchanges) {
            count++;
        }
        assertEquals(4, count);
        Iterable<IexExchange> exchangesUS = iexRepo.findByRegion("US");
        count = 0;
        for (IexExchange ex : exchanges) {
            count++;
        }
        assertEquals(4, count);
        IexExchange ex = iexRepo.findByExchange("ASE1");
        assertEquals("NYSE American", ex.getDescription());

    }

}

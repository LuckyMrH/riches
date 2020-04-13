/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.api_providers.dumbstock;

import com.sh.riches.apiproviders.dumbstock.business_objects.DsCompanyXferObject;
import com.sh.riches.entities.DsCompany;
import com.sh.riches.repository.DsCompanyRepository;
import com.sh.riches.util.TestUtil;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Steve
 */
//@RunWith(SpringRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DsCompanyRepositoryTest {

    private static final Logger LOG = Logger.getLogger(DsCompanyRepositoryTest.class.getName());

    @Autowired
    private DsCompanyRepository companyRepository;

    public DsCompanyRepositoryTest() {
        System.out.println(TestUtil.createTestTitle("DsCompanyRepositoryIT()"));

    }

    @BeforeAll
    public void setUpClass() {
        System.out.println(TestUtil.createTestTitle("DsCompanyRepositoryIT.setUpClass()"));
        DsCompanyXferObject company1 = new DsCompanyXferObject("IBM1", "International Business Machines", "true", "NASDAQ");
        DsCompanyXferObject company2 = new DsCompanyXferObject("DELL1", "Dell Technologies Inc.", "false", "NYSE");
        //save eompany, verify has ID value after save
        DsCompany dsc1 = new DsCompany(company1);
        DsCompany dsc2 = new DsCompany(company2);
        assertNull(dsc1.getId());
        assertNull(dsc2.getId());//null before save
        this.companyRepository.save(dsc1);
        this.companyRepository.save(dsc2);
        assertNotNull(dsc1.getId());
        assertNotNull(dsc2.getId());
    }

    @AfterAll
    public void tearDownClass() {
        DsCompany dsc1 = companyRepository.findByTickerSymbol("IBM1");
        DsCompany dsc2 = companyRepository.findByTickerSymbol("DELL1");
        assertNotNull(dsc1);
        assertNotNull(dsc2);
        companyRepository.delete(dsc1);
        companyRepository.delete(dsc2);
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testDataRetrieval() {
        /*Test data retrieval*/
        System.out.println(TestUtil.createTestTitle("DsCompanyRepositoryIT.testDataRetrieval()"));
        DsCompany companyA = companyRepository.findByName("International Business Machines");
        assertNotNull(companyA);
        assertTrue(companyA.isEtf());
        assertEquals(companyA.getTickerSymbol(), "IBM1");
        DsCompany companyB = companyRepository.findByTickerSymbol("DELL1");
        assertNotNull(companyB);
        assertEquals(companyB.getName(), "Dell Technologies Inc.");
        assertFalse(companyB.isEtf());
        /*Get all products, list should only have two*/
        Iterable<DsCompany> companies = companyRepository.findAll();
        int count = 0;
        for (DsCompany p : companies) {
            count++;
        }
        assertEquals(count, 2);
    }
}

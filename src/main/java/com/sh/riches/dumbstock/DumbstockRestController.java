/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.dumbstock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.riches.dumbstock.entiities.dumbstock.DsCompanyXferObject;
import com.sh.riches.entities.DsCompany;
import com.sh.riches.repositories.DsCompanyRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Steve
 */
@RestController
@RequestMapping("/ds")
public class DumbstockRestController {

    @Autowired
    DsCompanyRepository coRepo;

    @GetMapping()
    public List<DsCompanyXferObject> list() {
        return null;
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

    @GetMapping(value = "/fetch", produces = MediaType.TEXT_PLAIN_VALUE)
    public String fetchDsListing() {
        String url = "https://dumbstockapi.com/stock/";
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        List<DsCompanyXferObject> companies = null;
        try {
            companies = Arrays.asList(mapper.readValue(resp, DsCompanyXferObject[].class));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(DumbstockRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("==================================================================================================================");
        System.out.println("Items retrieved from DumbStock=" + companies.size());
        System.out.println("==================================================================================================================");
        //coRepo.saveAll(companies);
        //companies.forEach(x -> System.out.println(x));
        List<DsCompany> cos = new ArrayList<>(companies.size());
        for (DsCompanyXferObject xfer : companies) {
            DsCompany co = new DsCompany(xfer);
            cos.add(co);
        }
        coRepo.saveAll(cos);
        return "DumbStock fetch completed successfully";

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.apiproviders.dumbstock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.riches.apiproviders.dumbstock.business_objects.DsCompanyXferObject;
import com.sh.riches.entities.DsCompany;
import com.sh.riches.repository.DsCompanyRepository;
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
@RequestMapping("/api/ds")
public class DumbstockRestController {

    @Autowired
    private RestTemplate restTemplate;

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
        String resp = restTemplate.getForObject(url, String.class);
        //coRepo.saveAll(companies);
        //companies.forEach(x -> System.out.println(x));
        List<DsCompany> cos = getCompaniesFromResponse(resp);
        coRepo.saveAll(cos);
        StringBuilder sb = new StringBuilder("==================================================================================================================\n");
        sb.append("Items retrieved from DumbStock=").append(cos.size()).append("\n");
        sb.append("==================================================================================================================\n");
        return sb.toString();

    }

    public List<DsCompany> getCompaniesFromResponse(String resp) {
        ObjectMapper mapper = new ObjectMapper();
        List<DsCompanyXferObject> companies = null;
        try {
            companies = Arrays.asList(mapper.readValue(resp, DsCompanyXferObject[].class));
        }
        catch (JsonProcessingException ex) {
            Logger.getLogger(DumbstockRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<DsCompany> cos = new ArrayList<>(companies.size());
        for (DsCompanyXferObject xfer : companies) {
            DsCompany co = new DsCompany(xfer);
            cos.add(co);
        }
        return cos;
    }

//    private void saveAll(List<DsCompany> cos) {
//        for (DsCompany co : cos) {
//            try {
//                coRepo.save(co);
//            }
//            catch (ConstraintViolationException cve) {
//                StringBuilder sb = new StringBuilder("==================================================================================================================\n");
//                sb.append("Dumstock ConstraintViolationException caught!\n");
//                sb.append("DsCompany=").append(co.toString()).append("\n");
//                sb.append("==================================================================================================================\n");
//
//            }
//        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.service.apiproviders.iex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.riches.service.apiproviders.iex.business_objects.IexEarningsTodayList;
import com.sh.riches.service.apiproviders.iex.business_objects.IexExchangeXferObject;
import com.sh.riches.service.impl.entity.IexExchange;
import com.sh.riches.service.impl.repository.IexExchangeRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.INFO;
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
@RequestMapping("/api/iex")
public class IexRestController {

    private static final Logger LOG = Logger.getLogger(IexRestController.class.getName());
//  before the open bto, after market close amc and during the trading day other
    static final String IEX = "https://cloud.iexapis.com/";
    static final String IEX_TOKEN = "?token=";
    static final String IEX_MY_TOKEN = "pk_bc51e28277ce4fc0b3c0b1a261a98730";
    static final String IEX_EARNINGS_TODAY_URI = "stable/stock/market/today-earnings";
    static final String IEX_EXCHANGES_URI = "stable/ref-data/exchanges";

    @Autowired
    IexExchangeRepository ieExchangeRepo;

    @GetMapping(value = "/list", produces = {"application/json"})
    public List<IexExchange> list() {
        return ieExchangeRepo.findAll();
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

    @GetMapping(value = "fetch_earnings_today", produces = MediaType.TEXT_PLAIN_VALUE)
    public String fetchIexEarningsToday() {
        String res = null;
        String url = IEX + IEX_EARNINGS_TODAY_URI + IEX_TOKEN + IEX_MY_TOKEN;
        LOG.log(INFO, "Fetching Iex Earnings Today from-" + url);
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        LOG.log(INFO, resp);
        IexEarningsTodayList earningsToday = null;
        try {
            earningsToday = mapper.readValue(resp, IexEarningsTodayList.class);
        }
        catch (JsonProcessingException ex) {
            Logger.getLogger(IexRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        res = "==================================================================================================================";
        res += "Items retrieved from Iex Earnings Today =" + earningsToday.toString();
        res += "==================================================================================================================";
        LOG.log(INFO, resp);
        LOG.log(INFO, "Fetched Earning Today:" + earningsToday.toString());
        return res;
    }

    @GetMapping(value = "/fetch_exchanges", produces = MediaType.TEXT_PLAIN_VALUE)
    public String fetchIexExchangeListing() {
        String res = null;
        String url = IEX + IEX_EXCHANGES_URI + IEX_TOKEN + IEX_MY_TOKEN;
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        List<IexExchangeXferObject> exchanges = null;
        try {
            exchanges = Arrays.asList(mapper.readValue(resp, IexExchangeXferObject[].class));
        }
        catch (JsonProcessingException ex) {
            Logger.getLogger(IexRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        res = "==================================================================================================================";
        res += "Items retrieved from Iex Exchanges=" + exchanges.size();
        res += "==================================================================================================================";
        System.out.println(res);
        //coRepo.saveAll(companies);
        //companies.forEach(x -> System.out.println(x));
        List<IexExchange> iexExchanges = new ArrayList<>(exchanges.size());
        for (IexExchangeXferObject xfer : exchanges) {
            IexExchange ex = new IexExchange(xfer);
            iexExchanges.add(ex);
        }
        ieExchangeRepo.saveAll(iexExchanges);
        return res;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.controller;

import com.sh.riches.service.impl.entity.DsExchange;
import com.sh.riches.service.impl.repository.DsExchangeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Steve
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/dsexchange")
public class DsExchangeRestController {

    @Autowired
    DsExchangeRepository exchangeRepo;

    @GetMapping(value = "/list_us", produces = {"application/json"})
    public List<DsExchange> getDsExchangesUS() {
        return exchangeRepo.findByCountry("US");
    }

    @GetMapping(value = "/list", produces = {"application/json"})
    public List<DsExchange> getDsExchanges() {
        return exchangeRepo.findAll();
    }

    @GetMapping(value = "/list_as_hal", produces = {"application/hal+json"})
    public CollectionModel<DsExchange> getAllDsCompaniesAsHAL() {
        Iterable<DsExchange> allExchanges = exchangeRepo.findAll();

        for (DsExchange exchange : allExchanges) {
            String exchangeId = exchange.getId().toString();
            Link selfLink = linkTo(DsExchangeRestController.class).slash(exchangeId).withSelfRel();
            exchange.add(selfLink);
//            if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
//                Link ordersLink = linkTo(methodOn(CustomerController.class)
//                        .getOrdersForCustomer(customerId)).withRel("allOrders");
//                customer.add(ordersLink);
//            }
        }

        Link link = linkTo(DsExchangeRestController.class).withSelfRel();
        CollectionModel<DsExchange> result = new CollectionModel<>(allExchanges, link);
        return result;
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

}

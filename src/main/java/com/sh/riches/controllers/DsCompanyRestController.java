/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.controllers;

import com.sh.riches.entities.DsCompany;
import com.sh.riches.repositories.DsCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/company")
public class DsCompanyRestController {

    @Autowired
    DsCompanyRepository coRepo;

//    @GetMapping("/list")
//    public Resources<Resource<DsCompany>> list() {
//        List<Resource<DsCompany>> companies = coRepo.findAll().stream()
//                .map(company -> new Resource<>(company,
//                linkTo(methodOn(DsCompanyRestController.class).one(company.getId())).withSelfRel(),
//                linkTo(methodOn(DsCompanyRestController.class).all()).withRel("companies")))
//                .collect(Collectors.toList());
//
//        return new Resources<>(companies,
//                linkTo(methodOn(DsCompanyRestController.class).all()).withSelfRel());
//    }
    @GetMapping(value = "/list", produces = {"application/hal+json"})
    public CollectionModel<DsCompany> getAllDsCompany() {
        Iterable<DsCompany> allCompanies = coRepo.findAll();

        for (DsCompany company : allCompanies) {
            String companyId = company.getId().toString();
            Link selfLink = linkTo(DsCompanyRestController.class).slash(companyId).withSelfRel();
            company.add(selfLink);
//            if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
//                Link ordersLink = linkTo(methodOn(CustomerController.class)
//                        .getOrdersForCustomer(customerId)).withRel("allOrders");
//                customer.add(ordersLink);
//            }
        }

        Link link = linkTo(DsCompanyRestController.class).withSelfRel();
        CollectionModel<DsCompany> result = new CollectionModel<>(allCompanies, link);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.entities;

import com.sh.riches.apiproviders.dumbstock.business_objects.DsCompanyXferObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Steve
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "api_ds_company")
@Entity
public class DsCompany extends RepresentationModel<DsCompany> implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    String tickerSymbol;
    String name;
    boolean etf;
    String exchange;

    public DsCompany(DsCompanyXferObject xfer) {
        tickerSymbol = xfer.getTicker();
        name = xfer.getName();
        etf = xfer.getEtf() == null ? false : xfer.getEtf().contains("true");
        exchange = xfer.getExchange();
    }

}

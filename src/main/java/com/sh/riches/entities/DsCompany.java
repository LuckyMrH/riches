/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.entities;

import com.sh.riches.dumbstock.entiities.dumbstock.DsCompanyXferObject;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Steve
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DsCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

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

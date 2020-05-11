/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.service.impl.entity;

import com.sh.riches.service.impl.entity.DsCompany;
import com.sh.riches.service.apiproviders.iex.business_objects.IexExchangeXferObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Steve
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_iex_exchange")
@Entity
public class IexExchange extends RepresentationModel<DsCompany> implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    String exchange; //"exchange": "ADS",
    String region; //"region": "AE",
    String description; //"description": "Abu Dhabi Securities Exchange",
    String marketId; // Market Identifier Cod"mic": "XADS"
    String exchangeSuffix;

    public IexExchange(IexExchangeXferObject xfer) {
        exchange = xfer.getExchange();
        region = xfer.getRegion();
        description = xfer.getDescription();
        marketId = xfer.getDescription();
        exchangeSuffix = xfer.getExchangeSuffix();
    }
}

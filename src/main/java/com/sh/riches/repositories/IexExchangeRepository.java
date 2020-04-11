/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.repositories;

import com.sh.riches.entities.IexExchange;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Steve
 */
public interface IexExchangeRepository extends JpaRepository<IexExchange, Integer> {
//        exchange = xfer.getExchange();
//        region = xfer.getRegion();
//        description = xfer.getDescription();
//        marketId = xfer.getDescription();
//        exchangeSuffix = xfer.getExchangeSuffix();

    IexExchange findByExchange(String exchangeName);

    Iterable<IexExchange> findByRegion(String region);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.service.impl.repository;

import com.sh.riches.service.impl.entity.DsExchange;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Steve
 */
public interface DsExchangeRepository extends JpaRepository<DsExchange, Integer> {

    DsExchange findByName(String name);

    List<DsExchange> findByCountry(String country);

}

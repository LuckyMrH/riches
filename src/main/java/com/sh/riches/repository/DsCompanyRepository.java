/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.repository;

import com.sh.riches.entities.DsCompany;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Steve
 */
public interface DsCompanyRepository extends JpaRepository<DsCompany, Integer> {

    DsCompany findByName(String name);

    DsCompany findByTickerSymbol(String tickerSymbol);

}

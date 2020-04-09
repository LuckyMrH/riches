/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.repositories;

import com.sh.riches.entities.DsCompany;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steve
 */
public interface DsCompanyRepository extends CrudRepository<DsCompany, Integer> {

    DsCompany findByName(String name);

    DsCompany findByTickerSymbol(String tickerSymbol);

}

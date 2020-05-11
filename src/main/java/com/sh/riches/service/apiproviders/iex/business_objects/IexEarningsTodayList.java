/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.service.apiproviders.iex.business_objects;

import java.util.List;
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
public class IexEarningsTodayList {

    IexEarningsToday[] bto;
    List<IexEarningsToday> amc;
    List<IexEarningsToday> other;

}

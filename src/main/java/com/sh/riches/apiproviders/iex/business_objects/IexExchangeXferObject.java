package com.sh.riches.apiproviders.iex.business_objects;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Steve
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IexExchangeXferObject {

    String exchange; //"exchange": "ADS",
    String region; //"region": "AE",
    String description; //"description": "Abu Dhabi Securities Exchange",
    String marketId; // Market Identifier Cod"mic": "XADS"
    String exchangeSuffix; //    "exchangeSuffix": "-DH"
}

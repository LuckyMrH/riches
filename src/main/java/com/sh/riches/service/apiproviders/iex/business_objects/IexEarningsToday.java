/*
 * Earnings Today
 * Returns earnings that will be reported today as three arrays:
 *  before the open bto,
 *  after market close amc
 *  during the trading day other. Each array contains an object with all keys from earnings, a quote object, and a headline key.
 *
 * actualEPS                number	Actual earnings per share for the period
 * consensusEPS             number	Consensus EPS estimate trend for the period
 * announceTime             string	Time of earnings announcement. BTO (Before open), DMT (During trading or if the time is unknown), AMC (After close)
 * numberOfEstimates        number	Number of estimates for the period
 * EPSSurpriseDollar        number	Dollar amount of EPS surprise for the period
 * EPSReportDate            string	Expected earnings report date YYYY-MM-DD
 * fiscalPeriod             string	The fiscal quarter the earnings data applies to Q# YYYY
 * fiscalEndDate            string	Date representing the company fiscal quarter end YYYY-MM-DD
 * yearAgo                  number	Represents the EPS of the quarter a year ago
 * yearAgoChangePercent     number	Represents the percent difference between the quarter a year ago actualEPS and current period actualEPS
 * estimatedChangePercent   number	Represents the percent difference between the quarter a year ago actualEPS and current period consensusEPS
 * symbol                   string	The symbol the earning relates to
 * quote                    object	See quote
 */
package com.sh.riches.service.apiproviders.iex.business_objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
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
public class IexEarningsToday {

    @JsonProperty("actualEPS")
    BigDecimal actualEPS;                           // actualEPS                number	Actual earnings per share for the period
    @JsonProperty("consensusEPS")
    BigDecimal consensusEPS;                        // consensusEPS             number	Consensus EPS estimate trend for the period
    @JsonProperty("announceTime")
    String announceTime;                            // announceTime             string	Time of earnings announcement. BTO (Before open), DMT (During trading or if the time is unknown), AMC (After close)
    @JsonProperty("numberOfEstimates")
    Integer numberOfEstimates;                      // numberOfEstimates        number	Number of estimates for the period
    @JsonProperty("EPSSurpriseDollar")
    BigDecimal EPSSurpriseDollar;                   // EPSSurpriseDollar        number	Dollar amount of EPS surprise for the period
    @JsonProperty("EPSReportDate")
    String EPSReportDate;                           // EPSReportDate            string	Expected earnings report date YYYY-MM-DD
    @JsonProperty("fiscalPeriod")
    String fiscalPeriod;                            // fiscalPeriod             string	The fiscal quarter the earnings data applies to Q# YYYY
    @JsonProperty("fiscalEndDate")
    String fiscalEndDate;                           // fiscalEndDate            string	Date representing the company fiscal quarter end YYYY-MM-DD
    @JsonProperty("yearAgo")
    BigDecimal yearAgo;                             // yearAgo                  number	Represents the EPS of the quarter a year ago
    @JsonProperty("yearAgoChangePercent")
    Float yearAgoChangePercent;                     // yearAgoChangePercent     number	Represents the percent difference between the quarter a year ago actualEPS and current period actualEPS
    @JsonProperty("estimatedChangePercent")
    Float estimatedChangePercent;                   // estimatedChangePercent   number	Represents the percent difference between the quarter a year ago actualEPS and current period consensusEPS
    @JsonProperty("symbol")
    String symbol;                                  // symbol                   string	The symbol the earning relates to
    @JsonProperty("reportDate")
    String reportDate;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("quote")
    IexQuote quote;                                 // quote                    quote
}

/**
 * Provides the classes necessary to work with the IEX API.
 * <p>
 * International Exchanges Returns an array of exchanges. HTTP REQUEST
 *
 * GET /ref-data/exchanges JSON RESPONSE
 *
 * [
 * {
 * "exchange": "ADS", "region": "AE", "description": "Abu Dhabi Securities
 * Exchange", "mic": "XADS", "exchangeSuffix": "-DH" } ] Data Weighting 1 per
 * call
 *
 * Data Timing End of day
 *
 * Data Schedule 8am, 9am, 12pm, 1pm UTC daily
 *
 * Data Source(s) Investors Exchange
 *
 * Available Methods GET /ref-data/exchanges
 *
 * Examples
 * https://sandbox.iexapis.com/stable/ref-data/exchanges?token=Tsk_8289a6b023dd40d7af8e7535816fe5d6
 * Query String Parameters OPTION	DETAILS format	• Parameter is optional • Value
 * can only be csv • When parameter is not present, format defaults to JSON
 * Response Attributes KEY	TYPE	DESCRIPTION exchange	string	Exchange
 * abbreviation region	string	2 letter case insensitive string of country codes
 * using ISO 3166-1 alpha-2 description	string	Full name of the exchange. mic
 * string	Market Identifier Code using ISO 10383 exchangeSuffix	string	Exchange
 * Suffix to be added for symbols on that exchange I *
 */
package com.sh.riches.service.apiproviders.iex;

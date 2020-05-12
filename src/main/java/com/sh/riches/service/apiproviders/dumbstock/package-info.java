/**
 * Provides the classes necessary to work with the dumbstock API.
 * <p>
 * Directly download up to date CSV files for tickers in popular exchanges.
 *
 * Combined All American (NYSE, NASDAQ, AMEX)
 *
 * NYSE
 *
 * NASDAQ
 *
 * AMEX
 *
 * Documentation Rate Limit All calls are rate limited to something reasonable.
 * I'm not sure what the exact limits are b/c still work in progress
 *
 * Example get all stocks on the NYSE
 * https://dumbstockapi.com/stock?exchanges=NYSE
 *
 * [
 * {
 * "ticker": "A", "name": "Agilent Technologies, Inc.", "is_etf": null,
 * "exchange": "NYSE" }, { "ticker": "AA", "name": "Alcoa Corporation",
 * "is_etf": null, "exchange": "NYSE" }, ... ] JSON values & caveats ticker -
 * some exchanges use numbers instead of letters
 *
 * name - may be blank for certain asian exchanges whose names have no english
 * equivalent
 *
 * is_etf - if null, then no information was available
 *
 * exchange - self explanatory
 *
 * Query Parameters filters countries (csv) - list of countries codes (and EU).
 * ie countries=US,CA,EU. Mutually exclusive with exchanges filter
 *
 * exchanges (csv) - list of exchanges' abbreviations. ie exchanges=NASDAQ,NYSE.
 * Mutually exclusive with countries filter
 *
 * is_etf (boolean) - only return stock that are reported as etfs.
 *
 * name_search (string) - like search over the full names of companies
 *
 * ticker_search (string) - like search over ticker symbols
 *
 * Example- find all stocks in North America where the ticker contains "AA"
 * https://dumbstockapi.com/stock?countries=CA,US&ticker_search=AA
 *
 * [
 * {
 * "ticker": "AA", "name": "Alcoa Corporation Common Stock ", "is_etf": false,
 * "exchange": "NASDAQ" }, { "ticker": "AAB", "name": "Aberdeen International
 * Inc.", "is_etf": false, "exchange": "TSX" } ... ] formats format (enum) - can
 * be one of json, csv, tickers-only. default json.
 *
 * ⚠ If using tickers-only, duplicate tickers will be squashed into one. IE, the
 * stock CAE exists in three different stock exchanges; twice as Canadian
 * company CAE Inc and once as Australian company Cannindah Resources Ltd, but
 * it will only appear in the array once. It may make sense to use tickers-only
 * with a set exchange in mind, or a country where symbols tend not to clash.
 *
 * https://dumbstockapi.com/stock?format=tickers-only&exchange=NYSE
 *
 * [
 * "A", "AA", "AAC", "AAN", ... ]
 * https://dumbstockapi.com/stock?format=csv&exchanges=NYSE
 *
 * ticker,name,is_etf,exchange A,Agilent Technologies, Inc.,,NYSE AA,Alcoa
 * Corporation,,NYSE AAC,AAC Holdings, Inc.,,NYSE ...
 *
 * Supported Exchanges: ==================== Abbreviation Name Country AMEX NYSE
 * American US ASX Australian Securities Exchange	AU BSE Bombay Stock Exchange
 * IN JPX Japan Exchange Group JP NASDAQ NASDAQ US NSE National Stock Exchange
 * of India	IN NYSE New York Stock Exchange US SWX Six Swiss Exchange CH SZSE
 * Shenzhen Stock Exchange CN TSX Toronto Stock Exchange CA TWSE Taiwan Stock
 * Exchange Corporation TW
 *
 */
package com.sh.riches.service.apiproviders.dumbstock;

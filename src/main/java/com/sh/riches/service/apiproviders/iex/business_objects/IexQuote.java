/*
 * latestPrice              number      Use this to get the latest price
 *                                             Refers to the latest relevant price of the security which is derived from multiple sources.
 *                                             We first look for an IEX real time price. If an IEX real time price is older than 15 minutes,
 *                                             15 minute delayed market price is used. If a 15 minute delayed price is not available, we will use the current day close price.
 *                                             If a current day close price is not available, we will use the last available closing price (listed below as previousClose)
 *                                             IEX real time price represents trades on IEX only. Trades occur across over a dozen exchanges, so the last IEX price can be used to indicate the overall market price.
 *                                             15 minute delayed prices are from all markets using the Consolidated Tape.
 *                                             This will not included pre or post market prices.
 * latestVolume             number	Use this to get the latest volume
 *                                      Refers to the latest total market volume of the stock across all markets.
                                        This will be the most recent volume of the stock during trading hours, or it will be the total volume of the last available trading day.
 * latestUpdate             number	Refers to the machine readable epoch timestamp of when latestPrice was last updated. Represented in milliseconds since midnight Jan 1, 1970.
 * latestTime               string	Refers to a human readable time/date of when latestPrice was last updated. The format will vary based on latestSource is inteded to be displayed to a user. Use latestUpdate for machine readable timestamp.
 * calculationPrice         string	Refers to the source of the latest price.
 *                                      Possible values are "tops", "sip", "previousclose" or "close"
 * latestSource             string	This will represent a human readable description of the source of latestPrice.
 *                                      Possible values are "IEX real time price", "15 minute delayed price", "Close" or "Previous close"
 * change                   number	Refers to the change in price between latestPrice and previousClose
 * changePercent            number	Refers to the percent change in price between latestPrice and previousClose. For example, a 5% change would be represented as 0.05. You can use the query string parameter displayPercent to return this field multiplied by 100. So, 5% change would be represented as 5.
 * volume                   number	Total volume for the stock, but only updated after market open. To get premarket volume, use latestVolume
 * open                     number	Refers to the official open price from the SIP. 15 minute delayed (can be null after 00:00 ET, before 9:45 and weekends)
 * openTime                 number	Refers to the official listing exchange time for the open from the SIP. 15 minute delayed
 * close                    number	Refers to the official close price from the SIP. 15 minute delayed
 * closeTime                number	Refers to the official listing exchange time for the close from the SIP. 15 minute delayed
 * previousClose            number	Refers to the previous trading day closing price.
 * previousVolume           number	Refers to the previous trading day volume.
 * high                     number	Refers to the market-wide highest price from the SIP. 15 minute delayed during normal market hours 9:30 - 16:00 (null before 9:45 and weekends).
 * low                      number	Refers to the market-wide lowest price from the SIP. 15 minute delayed during normal market hours 9:30 - 16:00 (null before 9:45 and weekends).
 * extendedPrice            number	Refers to the 15 minute delayed price outside normal market hours 0400 - 0930 ET and 1600 - 2000 ET. This provides pre market and post market price. This is purposefully separate from latestPrice so users can display the two prices separately.
 * extendedChange           number	Refers to the price change between extendedPrice and latestPrice.
 * extendedChangePercent    number	Refers to the price change percent between extendedPrice and latestPrice.
 * extendedPriceTime        number	Refers to the last update time of extendedPrice
 * delayedPrice             number	Refers to the 15 minute delayed market price from the SIP during normal market hours 9:30 - 16:00 ET.
 * delayedPriceTime         number	Refers to the last update time of the delayed market price during normal market hours 9:30 - 16:00 ET.
 * oddLotDelayedPrice       number	Refers to the 15 minute delayed odd Lot trade price from the SIP during normal market hours 9:30 - 16:00 ET.
 * oddLotDelayedPriceTime   number	Refers to the last update time of the odd Lot trade price during normal market hours 9:30 - 16:00 ET.
 * marketCap                number	is calculated in real time using latestPrice.
 * avgTotalVolume           number	Refers to the 30 day average volume.
 * week52High               number	Refers to the adjusted 52 week high.
 * week52Low                number	Refers to the adjusted 52 week low.
 * ytdChange                number	Refers to the price change percentage from start of year to previous close.
 * iexRealtimePrice         number	Refers to the price of the last trade on IEX.
 * iexRealtimeSize          number	Refers to the size of the last trade on IEX.
 * iexLastUpdated           number	Refers to the last update time of iexRealtimePrice in milliseconds since midnight Jan 1, 1970 UTC or -1 or 0. If the value is -1 or 0, IEX has not quoted the symbol in the trading day.
 * iexMarketPercent         number	Refers to IEX’s percentage of the market in the stock.
 * iexVolume                number	Refers to shares traded in the stock on IEX.
 * iexBidPrice              number	Refers to the best bid price on IEX.
 * iexBidSize               number	Refers to amount of shares on the bid on IEX.
 * iexAskPrice              number	Refers to the best ask price on IEX.
 * iexAskSize               number	Refers to amount of shares on the ask on IEX.
 * symbol                   string	Refers to the stock ticker.
 * companyName              string	Refers to the company name.
 * primaryExchange          string	Refers to the primary listing exchange for the symbol.
 * peRatio                  number	Refers to the price-to-earnings ratio for the company.
 * lastTradeTime            number	Epoch timestamp in milliseconds of the last market hours trade excluding the closing auction trade.
 * isUSMarketOpen           boolean	For US stocks, indicates if the market is in normal market hours. Will be false during extended hours trading.
 */
package com.sh.riches.service.apiproviders.iex.business_objects;

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
public class IexQuote {

    String symbol;                  // "symbol": "AAPL",
    String companyName;             // "companyName": "Apple Inc.",
    String calculationPrice;        // "calculationPrice": "tops",
    BigDecimal open;                // "open": 154,
    Long openTime;                  // "openTime": 1506605400394,
    String openSource;
    BigDecimal close;               // "close": 153.28,
    Long closeTime;                 // "closeTime": 1506605400394,
    String closeSource;
    BigDecimal high;                // "high": 154.80,
    Long highTime;
    String highSource;
    BigDecimal low;                 // "low": 153.25,
    Long lowTime;
    String lowSource;
    BigDecimal latestPrice;         // "latestPrice": 158.73,
    String latestSource;            // "latestSource": "Previous close",
    String latestTime;              // "latestTime": "September 19, 2017",
    Long latestUpdate;              // "latestUpdate": 1505779200000,
    Long latestVolume;              // "latestVolume": 20567140,
    Long volume;                    // "volume": 20567140,
    BigDecimal iexRealtimePrice;    // "iexRealtimePrice": 158.71,
    Long iexRealtimeSize;           // "iexRealtimeSize": 100,
    Long iexLastUpdated;             // "iexLastUpdated": 1505851198059,
    BigDecimal delayedPrice;        // "delayedPrice": 158.71,
    Long delayedPriceTime;            // "delayedPriceTime": 1505854782437,
    BigDecimal oddLotDelayedPrice;  // "oddLotDelayedPrice": 158.70,
    Long oddLotDelayedPriceTime;    // "oddLotDelayedPriceTime": 1505854782436,
    BigDecimal extendedPrice;       // "extendedPrice": 159.21,
    BigDecimal extendedChange;      // "extendedChange": -1.68,
    Double extendedChangePercent;   // "extendedChangePercent": -0.0125,
    Long extendedPriceTime;         // "extendedPriceTime": 1527082200361,
    BigDecimal previousClose;       // "previousClose": 158.73,
    Long previousVolume;            // "previousVolume": 22268140,
    BigDecimal change;              // "change": -1.67,
    Double changePercent;           // "changePercent": -0.01158,
    Double iexMarketPercent;        // "iexMarketPercent": 0.00948,
    Long iexVolume;                 // "iexVolume": 82451,
    Long avgTotalVolume;            // "avgTotalVolume": 29623234,
    BigDecimal iexBidPrice;         // "iexBidPrice": 153.01,
    Long iexBidSize;                // "iexBidSize": 100,
    BigDecimal iexAskPrice;         // "iexAskPrice": 158.66,
    Long iexAskSize;                // "iexAskSize": 100,
    Double marketCap;               // "marketCap": 751627174400,
    BigDecimal week52High;          // "week52High": 159.65,
    BigDecimal week52Low;           // "week52Low": 93.63,
    BigDecimal ytdChange;           // "ytdChange": 0.3665,
    String primaryExchange;
    BigDecimal peRatio;             // "peRatio": 17.18,
    Long lastTradeTime;             // "lastTradeTime": 1505779200000,
    Boolean isUSMarketOpen;           // "isUSMarketOpen": false
    BigDecimal iexOpen;
    Long iexOpenTime;
    BigDecimal iexClose;
    Long iexCloseTime;

}

/*
 * The stock exchanges used by DumbStock.
 * The list is extracted from https://dumbstockapi.com/
 * This list is

 * Supported Exchanges
 * Abbreviation     Name                                Country
 * AMEX             NYSE American                       US
 * ASX              Australian Securities Exchange	AU
 * BSE              Bombay Stock Exchange               IN
 * JPX              Japan Exchange Group                JP
 * NASDAQ           NASDAQ                              US
 * NSE              National Stock Exchange of India	IN
 * NYSE             New York Stock Exchange             US
 * SWX              Six Swiss Exchange                  CH
 * SZSE             Shenzhen Stock Exchange             CN
 * TSX              Toronto Stock Exchange              CA
 * TWSE             Taiwan Stock Exchange Corporation   TW
 */
package com.sh.riches.service.impl.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Steve
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_ds_exchange",
        uniqueConstraints = @UniqueConstraint(name = "exchange_contraint", columnNames = {"abbreviation", "country"})
)
@Entity
public class DsExchange extends RepresentationModel<DsExchange> implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String abbreviation;
    String name;
    String country;

}

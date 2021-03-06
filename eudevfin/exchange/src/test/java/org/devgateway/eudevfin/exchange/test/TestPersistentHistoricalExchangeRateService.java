/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/

package org.devgateway.eudevfin.exchange.test;

import java.math.BigDecimal;

import org.devgateway.eudevfin.exchange.common.domain.HistoricalExchangeRate;
import org.devgateway.eudevfin.exchange.common.service.HistoricalExchangeRateService;
import org.joda.money.CurrencyUnit;
import org.joda.money.ExchangeRate;
import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/financialContext.xml",
		"classpath:META-INF/commonExchangeContext.xml",
		"classpath:META-INF/exchangeContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
public class TestPersistentHistoricalExchangeRateService {

	@Autowired
	HistoricalExchangeRateService service;

	
	/**
	 * Tests the exchange rate service to remotely save/retrieve an exchange rate
	 */
	@Test
	public void testCreateReadHistoricalExchangeRate() {
		HistoricalExchangeRate her=new HistoricalExchangeRate();
		her.setDate(LocalDateTime.now());
		her.setRate(ExchangeRate.of(CurrencyUnit.USD, CurrencyUnit.EUR, BigDecimal.valueOf(1.33d)));
		service.save(her);
		
		Assert.assertNotNull(her.getId());
		
		Long id = her.getId();
		
		HistoricalExchangeRate one = service.findOne(id).getEntity();
		
		Assert.assertEquals(her.getId(), one.getId());
		Assert.assertEquals(her.getDate(), one.getDate());
		Assert.assertEquals(her.getRate(), one.getRate());
	}
}

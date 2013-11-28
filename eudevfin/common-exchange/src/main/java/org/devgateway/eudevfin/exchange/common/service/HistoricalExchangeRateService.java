/*
  * Copyright (c) 2013 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 *    mpostelnicu
 */

/**
 * 
 */
package org.devgateway.eudevfin.exchange.common.service;

import org.devgateway.eudevfin.exchange.common.domain.HistoricalExchangeRate;

/**
 * @author mihai
 *
 */
public interface HistoricalExchangeRateService {
	HistoricalExchangeRate save(HistoricalExchangeRate t);

	HistoricalExchangeRate findById(Long id);
}

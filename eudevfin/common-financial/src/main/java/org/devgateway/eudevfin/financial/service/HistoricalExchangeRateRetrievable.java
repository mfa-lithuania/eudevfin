/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/

package org.devgateway.eudevfin.financial.service;

import org.joda.time.LocalDateTime;
import org.springframework.integration.annotation.Payload;

import java.util.Collection;

public interface HistoricalExchangeRateRetrievable {


    @Payload("new java.util.Date()")
    public Collection<LocalDateTime> getHistoricalExchangeRates();

}

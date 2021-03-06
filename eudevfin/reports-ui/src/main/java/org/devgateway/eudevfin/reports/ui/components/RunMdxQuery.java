/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/
package org.devgateway.eudevfin.reports.ui.components;

import org.apache.log4j.Logger;
import org.devgateway.eudevfin.reports.core.domain.QueryResult;
import org.devgateway.eudevfin.reports.core.service.QueryService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author idobre
 * @since 3/11/14
 */
public class RunMdxQuery implements Serializable {
    private static final Logger logger = Logger.getLogger(RunMdxQuery.class);

    QueryService CdaService;

    Map<String, String> params;

    public RunMdxQuery (QueryService CdaService) {
        this.CdaService = CdaService;
        params = new HashMap<>();
    }

    public QueryResult runQuery () {
        return CdaService.doQuery(params);
    }

    public void setParam (String key, String value) {
        params.put(key, value);
    }
}

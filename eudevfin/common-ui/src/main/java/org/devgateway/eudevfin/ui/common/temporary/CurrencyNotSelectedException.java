/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/

package org.devgateway.eudevfin.ui.common.temporary;

/**
 * @author aartimon
 * @since 03/12/13
 */
public class CurrencyNotSelectedException extends AssertionError {
    public CurrencyNotSelectedException() {
        super("Currency not selected in the form");
    }
}

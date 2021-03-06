/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/
/**
 *
 */
package org.devgateway.eudevfin.sheetexp.iati.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author alexandru-m-g
 *
 */
@XStreamAlias("location")
public class Location {
	private StringWithLanguage name;

	public Location(final StringWithLanguage name) {
		super();
		this.name = name;
	}

	public StringWithLanguage getName() {
		return this.name;
	}

	public void setName(final StringWithLanguage name) {
		this.name = name;
	}




}

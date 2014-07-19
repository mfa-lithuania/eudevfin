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
package org.devgateway.eudevfin.sheetexp.dto;

import java.util.Map;

/**
 * @author Alex
 *
 */
public interface MetadataInterface {
	
	
	public Map<String, String> getMetadata() ;

	boolean isHeader();
	
	public boolean isValueTrue(String key);
	
}

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
package org.devgateway.eudevfin.sheetexp.transformer;

import org.devgateway.eudevfin.sheetexp.dto.MetadataCell;

/**
 * @author Alex
 *
 */
public interface CellTransformerInterface<SrcType,ReturnType> {
	public MetadataCell<ReturnType> transform(SrcType src);
}

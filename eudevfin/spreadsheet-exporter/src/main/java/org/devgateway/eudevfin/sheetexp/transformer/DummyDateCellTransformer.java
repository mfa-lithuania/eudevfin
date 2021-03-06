/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/
package org.devgateway.eudevfin.sheetexp.transformer;

import org.devgateway.eudevfin.sheetexp.dto.MetadataCell;
import org.devgateway.eudevfin.sheetexp.util.MetadataConstants;
import org.joda.time.LocalDateTime;

public class DummyDateCellTransformer<SrcType> implements CellTransformerInterface<SrcType, LocalDateTime>{

	@Override
	public MetadataCell<LocalDateTime> transform(final SrcType src) {
		final LocalDateTime date	= LocalDateTime.now();
		final MetadataCell<LocalDateTime> cell	= new MetadataCell<LocalDateTime>( date );
		cell.getMetadata().put(MetadataConstants.DATA_TYPE, MetadataConstants.DATA_TYPES.DATE.getType());
		return cell;
	}

}

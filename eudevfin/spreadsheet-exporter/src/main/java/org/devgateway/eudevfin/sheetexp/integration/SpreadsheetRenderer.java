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
package org.devgateway.eudevfin.sheetexp.integration;

import java.io.OutputStream;
import java.util.List;

import org.devgateway.eudevfin.sheetexp.dto.MetadataRow;
import org.devgateway.eudevfin.sheetexp.exception.PoiCreationException;
import org.devgateway.eudevfin.sheetexp.poi.PoiExporter;
import org.springframework.context.annotation.Lazy;
import org.springframework.integration.annotation.Header;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * @author Alex
 * 
 */
@Component
@Lazy(value = false)
public class SpreadsheetRenderer {

	@ServiceActivator(inputChannel = "spreadsheetCreatorChannel")
	public Boolean renderSpreadsheet(final List<MetadataRow> list, @Header("outputStream") final OutputStream out, 
			@Header("exportName")final String exportName) {
//		for (final MetadataRow metadataRow : list) {
//			System.out.println("Row: " + metadataRow.toString());
//		}
		OutputStream usedOutStream	= null;
		if (out == null) {
//			final File f = new File("/home/alex/test.xls");
//			try {
//				usedOutStream = new FileOutputStream(f);
//			} catch (final FileNotFoundException e) {
//				throw new PoiCreationException(e);
//			}
			throw new PoiCreationException("OutputStream is null !!");
		} else {
			usedOutStream = out;
		}

		
		final PoiExporter exporter = new PoiExporter(usedOutStream, list, exportName);
		exporter.export();

		return true;
	}
}

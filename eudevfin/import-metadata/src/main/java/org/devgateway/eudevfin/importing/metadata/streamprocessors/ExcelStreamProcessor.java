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
package org.devgateway.eudevfin.importing.metadata.streamprocessors;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.devgateway.eudevfin.importing.metadata.exception.EntityMapperGenerationException;
import org.devgateway.eudevfin.importing.metadata.exception.InvalidDataException;
import org.devgateway.eudevfin.importing.metadata.mapping.MapperInterface;

/**
 * @author Alex
 *
 */
public class ExcelStreamProcessor implements IMetadataStreamProcessor {

	private static final int METADATA_INFO_ROW_NUM = 1;

	private static final int MAPPER_CLASS_COL_NUM = 1;

	private static final int MAPPER_CLASS_ROW_NUM = 0;

	private static final int ACTUAL_DATA_START_ROW_NUM = 3;

	public final static Integer OFFSET 	= 1;

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;

	private List<String> metadataInfoList;
	private String mapperClassName;

	private int currentRowNum = ACTUAL_DATA_START_ROW_NUM;

	private int endRowNum;

	private final InputStream inputStream;

	public ExcelStreamProcessor(final InputStream is) {
		this.inputStream	= is;
		try {
			this.workbook 	= new HSSFWorkbook(is);
			this.sheet		= this.workbook.getSheetAt(0);
			this.endRowNum	= this.sheet.getLastRowNum();

			this.generateMetadataInfoList();
			this.findMapperClassName();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object generateNextObject() {
		if ( this.currentRowNum <= this.endRowNum ) {
			final HSSFRow row 	= this.sheet.getRow(this.currentRowNum);
			try {
				final MapperInterface mapper			= this.instantiateMapper();
				final Object entity	= this.generateObject(mapper, row);
				return entity;
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {

				e.printStackTrace();

				throw new EntityMapperGenerationException("Problems generating object",e);
			}
			finally{
				this.currentRowNum++;
			}
		}
		return null;

	}

	@Override
	public boolean hasNextObject() {
		if ( this.currentRowNum <= this.endRowNum ) {
			return true;
		}
		return false;

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object generateObject(final MapperInterface<?> mapper, final HSSFRow row)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		boolean allCellsAreNull	= true;
		final List<String> values	= new ArrayList<String>();
		for ( int j=OFFSET; j<this.metadataInfoList.size()+OFFSET; j++) {
			final HSSFCell cell	= row.getCell(j);
			if (cell != null) {
				allCellsAreNull = false;
				String val		= null;
				if ( HSSFCell.CELL_TYPE_STRING == cell.getCellType() ) {
					val	= cell.getStringCellValue() ;
				}
				else if ( HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType() ) {
//					HSSFDataFormatter dataFormatter	= new HSSFDataFormatter();
//					val	= dataFormatter.formatCellValue(cell);
					val	=  new BigDecimal(cell.getNumericCellValue()).toString() ;
				}
				if ( val != null && val.trim().length() > 0 ) {
					values.add(val.trim());
				} else {
					values.add(null);
				}

			} else {
				values.add( null );
			}

		}
		if ( allCellsAreNull ) {
			return null;
		}
		final Object result	=  mapper.createEntity(values);
		return result;
	}

	/**
	 *
	 * @param mapperClassName the name of the mapper class that needs to be instantiated
	 * @param metadataInfoList the metainformation needed for each field of the mapping
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("rawtypes")
	private MapperInterface<?> instantiateMapper() {
		try {
			final Class clazz = Class.forName(this.mapperClassName);
			final MapperInterface<?> mapper =
					(MapperInterface<?>) clazz.newInstance();
			mapper.setMetainfos(this.metadataInfoList);

			return mapper;
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
			throw new EntityMapperGenerationException(
					"Problems generating objects", e);
		}
	}

	private void findMapperClassName() {
		final HSSFRow row 	= this.sheet.getRow(MAPPER_CLASS_ROW_NUM);
		final HSSFCell cell	= row.getCell(MAPPER_CLASS_COL_NUM);
		if ( HSSFCell.CELL_TYPE_STRING == cell.getCellType() ) {
			this.mapperClassName = cell.getStringCellValue();
		} else {
			throw new InvalidDataException("Expecting mapper name in cell B1");
		}
	}

	private void generateMetadataInfoList () {
		this.metadataInfoList	= new ArrayList<String>();
		final HSSFRow row 			= this.sheet.getRow(METADATA_INFO_ROW_NUM);
		final short end				= row.getLastCellNum();
		for (short i=1; i<end; i++ ) {
			final HSSFCell cell	= row.getCell((int)i);
			if ( cell != null ) {
				if ( HSSFCell.CELL_TYPE_STRING == cell.getCellType() ) {
					final String value	=  cell.getStringCellValue();
					this.metadataInfoList.add(value);
				} else {
					throw new InvalidDataException("Expecting mapper name in cell B1");
				}
			} else {
				break;
			}
		}

	}

	@Override
	public void close() {
		try {
			this.inputStream.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> getMetadataInfoList() {
		return this.metadataInfoList;
	}

	public void setMetadataInfoList(final List<String> metadataInfoList) {
		this.metadataInfoList = metadataInfoList;
	}

	@Override
	public String getMapperClassName() {
		return this.mapperClassName;
	}

	public void setMapperClassName(final String mapperClassName) {
		this.mapperClassName = mapperClassName;
	}





}

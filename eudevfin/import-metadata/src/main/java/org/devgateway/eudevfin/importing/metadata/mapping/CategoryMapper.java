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
package org.devgateway.eudevfin.importing.metadata.mapping;

import java.util.HashSet;
import java.util.Set;

import liquibase.exception.SetupException;

import org.devgateway.eudevfin.financial.dao.CategoryDaoImpl;
import org.devgateway.eudevfin.importing.metadata.exception.InvalidDataException;
import org.devgateway.eudevfin.metadata.common.domain.Category;
import org.devgateway.eudevfin.metadata.common.domain.SectorCategory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Alex
 *
 */
public class CategoryMapper extends AbstractMapper<Category> {
	
	private static final String SECTOR = "sector";
	@Autowired
	CategoryDaoImpl categDao;

	
	
	public CategoryMapper() {
		super();
		try {
			this.setUp();
		} catch (final SetupException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Category instantiate() {
		return new Category();
	}
	
	public Category __factory(final String type){
		if (SECTOR.equals(type)) {
			return new SectorCategory();
		} else {
			return new Category();
		}
	}
	
	public void __insertParent(final Category newCateg, final String parentCode) {
		if (parentCode != null && parentCode.length() > 0) {
			final Category parent	= this.categDao.findByCodeAndClass(parentCode, newCateg.getClass(), true).getEntity();
			if (parent != null) {
				final Set<Category> children	= parent.getChildren();
				children.add(newCateg);
				newCateg.setParentCategory(parent);
			}
			else {
				throw new InvalidDataException(
						String.format("Found null parent category for code %s for category with code %s", 
								parentCode, newCateg.getCode() )
				);
			}
		}
	}
	
	public void __insertTag(final Category newCateg, final String tagCode) {
		if ( tagCode != null && tagCode.length() > 0 ) {
			final Category tag	= this.categDao.findByCodeAndClass(tagCode, Category.class, true).getEntity();
			if (tag != null) {
				if ( newCateg.getTags() == null ) {
					newCateg.setTags(new HashSet<Category>());
				}
				newCateg.getTags().add(tag);
			}
			else {
				throw new InvalidDataException(
						String.format("Found null tag category for code %s for category with code %s", 
								tagCode, newCateg.getCode() )
				);
			}
		}
	}

}

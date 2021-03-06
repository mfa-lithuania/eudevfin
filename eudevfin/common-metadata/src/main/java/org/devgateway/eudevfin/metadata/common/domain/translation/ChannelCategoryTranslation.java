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
package org.devgateway.eudevfin.metadata.common.domain.translation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.envers.Audited;

/**
 * @author Alex
 *
 */
@Entity @Audited
@DiscriminatorValue("ChannelCategoryTrn")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ChannelCategoryTranslation extends CategoryTranslation implements ChannelCategoryTrnInterface {
	
	@Index(name="channel_category_acronym_idx")
	private String acronym;
	@Override
	public String getAcronym() {
		return acronym;
	}

	@Override
	public void setAcronym(String acronym) {
		this.acronym	= acronym;
		
	}

	
}

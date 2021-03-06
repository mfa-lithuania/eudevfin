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
package org.devgateway.eudevfin.auth.dao;

import org.devgateway.eudevfin.auth.common.domain.PersistedUserGroup;
import org.devgateway.eudevfin.auth.common.service.PersistedUserGroupService;
import org.devgateway.eudevfin.auth.repository.PersistedUserGroupRepository;
import org.devgateway.eudevfin.common.dao.AbstractDaoImpl;
import org.devgateway.eudevfin.common.spring.integration.NullableWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.integration.annotation.Header;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * @author mihai
 * 
 */
@Component
@Lazy(value = false)
public class PersistedUserGroupDaoImplEndpoint extends
		AbstractDaoImpl<PersistedUserGroup, Long, PersistedUserGroupRepository> {

	@Autowired
	protected PersistedUserGroupRepository persistedUserGroupRepository;

	/**
	 * 
	 */
	public PersistedUserGroupDaoImplEndpoint() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.devgateway.eudevfin.financial.dao.AbstractDaoImpl#getRepo()
	 */
	@Override
	protected PersistedUserGroupRepository getRepo() {
		return persistedUserGroupRepository;
	}

	/**
	 * @see PersistedUserGroupService#findByName(String)
	 * @param name
	 * @return
	 */
	@ServiceActivator(inputChannel = "findByNameUserGroupChannel")
	public NullableWrapper<PersistedUserGroup> findByName(String name) {
		return newWrapper(persistedUserGroupRepository.findByName(name));
	}

	/**
	 * @see PersistedUserGroupService#findAll()
	 */
	@ServiceActivator(inputChannel = "findAllUserGroupChannel")
	@Override
	public Iterable<PersistedUserGroup> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	/**
	 * @see PersistedUserGroupService#save(PersistedUserGroup)
	 */
	@ServiceActivator(inputChannel = "saveUserGroupChannel")
	@Override
	public NullableWrapper<PersistedUserGroup> save(PersistedUserGroup e) {
		return super.save(e);
	}

	/**
	 * @see PersistedUserGroupService#findOne(Long)
	 */
	@ServiceActivator(inputChannel = "findOneUserGroupChannel")
	@Override
	public NullableWrapper<PersistedUserGroup> findOne(Long id) {
		// TODO Auto-generated method stub
		return super.findOne(id);
	}

	/**
	 * @see PersistedUserGroupService#findByGeneralSearchPageable(String, int,
	 *      int)
	 */
	@Override
	@ServiceActivator(inputChannel = "findByGeneralSearchUserGroupChannel")
	public Page<PersistedUserGroup> findByGeneralSearch(String searchString,
			@Header(value="locale",required=false) String locale, @Header("pageable") Pageable pageable) {
		return super.findByGeneralSearch(searchString, locale, pageable);
	}

}

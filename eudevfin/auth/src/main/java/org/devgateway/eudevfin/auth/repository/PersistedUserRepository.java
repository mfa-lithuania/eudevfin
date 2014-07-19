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
package org.devgateway.eudevfin.auth.repository;

import org.devgateway.eudevfin.auth.common.domain.PersistedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mihai
 *
 */
@Component
public interface PersistedUserRepository extends
		JpaRepository<PersistedUser, Long> {

	PersistedUser findByUsername(String username);

    @Query("SELECT distinct user FROM PersistedUser user INNER JOIN user.persistedAuthorities persistedAuthority " +
            "WHERE persistedAuthority.authority = :authority")
    public List<PersistedUser> findUsersWithPersistedAuthority(@Param("authority") String persistedAuthority);
}

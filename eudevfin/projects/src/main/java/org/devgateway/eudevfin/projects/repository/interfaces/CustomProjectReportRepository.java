/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.devgateway.eudevfin.projects.repository.interfaces;

import org.devgateway.eudevfin.projects.common.entities.ProjectReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomProjectReportRepository {
    Page<ProjectReport> findReportsByProjectID(Long id, Pageable pageable);
}

/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/
package org.devgateway.eudevfin.reports.ui.pages;

import org.devgateway.eudevfin.metadata.common.domain.Area;
import org.devgateway.eudevfin.metadata.common.domain.Category;
import org.devgateway.eudevfin.metadata.common.domain.ChannelCategory;
import org.devgateway.eudevfin.metadata.common.domain.Organization;

import java.io.Serializable;

/**
 * @author idobre
 * @since 4/2/14
 */
public class CustomReportsModel implements Serializable {
    private Area recipient;
    private Category geography;
    private Organization nationalInstitution;
    private ChannelCategory multilateralAgency;
    private Category typeOfFlowbiMulti;
    private Category sector;
    private String typeOfExpenditure;
    private String valueOfActivity;
    private Integer year;
    private Integer startingYear;
    private Integer completitionYear;
    private Boolean coFinancingTransactionsOnly;
    private Boolean CPAOnly;
    private Boolean humanitarianAid;
    private Boolean showRelatedBudgetCodes;
    private String pricesCurrency;

    public Area getRecipient() {
        return recipient;
    }

    public void setRecipient(Area recipient) {
        this.recipient = recipient;
    }

    public Category getGeography() {
        return geography;
    }

    public void setGeography(Category geography) {
        this.geography = geography;
    }

    public Organization getNationalInstitution() {
        return nationalInstitution;
    }

    public void setNationalInstitution(Organization nationalInstitution) {
        this.nationalInstitution = nationalInstitution;
    }

    public ChannelCategory getMultilateralAgency() {
        return multilateralAgency;
    }

    public void setMultilateralAgency(ChannelCategory multilateralAgency) {
        this.multilateralAgency = multilateralAgency;
    }

    public Category getTypeOfFlowbiMulti() {
        return typeOfFlowbiMulti;
    }

    public void setTypeOfFlowbiMulti(Category typeOfFlowbiMulti) {
        this.typeOfFlowbiMulti = typeOfFlowbiMulti;
    }

    public Category getSector() {
        return sector;
    }

    public void setSector(Category sector) {
        this.sector = sector;
    }

    public String getTypeOfExpenditure() {
        return typeOfExpenditure;
    }

    public void setTypeOfExpenditure(String typeOfExpenditure) {
        this.typeOfExpenditure = typeOfExpenditure;
    }

    public String getValueOfActivity() {
        return valueOfActivity;
    }

    public void setValueOfActivity(String valueOfActivity) {
        this.valueOfActivity = valueOfActivity;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(Integer startingYear) {
        this.startingYear = startingYear;
    }

    public Integer getCompletitionYear() {
        return completitionYear;
    }

    public void setCompletitionYear(Integer completitionYear) {
        this.completitionYear = completitionYear;
    }

    public Boolean getCoFinancingTransactionsOnly() {
        return coFinancingTransactionsOnly;
    }

    public void setCoFinancingTransactionsOnly(Boolean coFinancingTransactionsOnly) {
        this.coFinancingTransactionsOnly = coFinancingTransactionsOnly;
    }

    public Boolean getCPAOnly() {
        return CPAOnly;
    }

    public void setCPAOnly(Boolean CPAOnly) {
        this.CPAOnly = CPAOnly;
    }

    public Boolean getHumanitarianAid() {
        return humanitarianAid;
    }

    public void setHumanitarianAid(Boolean humanitarianAid) {
        this.humanitarianAid = humanitarianAid;
    }

    public Boolean getShowRelatedBudgetCodes() {
        return showRelatedBudgetCodes;
    }

    public void setShowRelatedBudgetCodes(Boolean showRelatedBudgetCodes) {
        this.showRelatedBudgetCodes = showRelatedBudgetCodes;
    }

    public String getPricesCurrency() {
        return pricesCurrency;
    }

    public void setPricesCurrency(String pricesCurrency) {
        this.pricesCurrency = pricesCurrency;
    }
}

/*
 * Copyright (c) 2013 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 */

package org.devgateway.eudevfin.dim.pages.transaction.crs;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;
import org.devgateway.eudevfin.ui.common.providers.CategoryProviderFactory;
import org.devgateway.eudevfin.metadata.common.domain.Category;
import org.devgateway.eudevfin.metadata.common.util.CategoryConstants;
import org.devgateway.eudevfin.ui.common.RWComponentPropertyModel;
import org.devgateway.eudevfin.ui.common.components.DateInputField;
import org.devgateway.eudevfin.ui.common.components.DropDownField;
import org.devgateway.eudevfin.ui.common.components.TextAreaInputField;
import org.devgateway.eudevfin.ui.common.components.TextInputField;
import org.devgateway.eudevfin.ui.common.models.DateToLocalDateTimeModel;
import org.devgateway.eudevfin.ui.common.permissions.PermissionAwareComponent;
import org.devgateway.eudevfin.ui.common.temporary.SB;
import org.devgateway.eudevfin.ui.common.validators.MarkersValidator;
import org.joda.time.LocalDateTime;

/**
 * @author aartimon@developmentgateway.org
 * @since 01 November 2013
 */
public class SupplementaryDataTab extends Panel implements PermissionAwareComponent {

	private static final long serialVersionUID = 7166734776330580011L;
	public static final String KEY = "tabs.supplementary";
    protected PageParameters parameters;
    
    public static final String VALIDATIONKEY_MARKER_DESERTIFICATION = "validation.markerDesertification";
    
    @SpringBean
    protected CategoryProviderFactory categoryFactory;

    public SupplementaryDataTab(String id,PageParameters parameters) {
        super(id);
        this.parameters=parameters;
        addComponents();
    }
    
	public class MarkersValidatorWithLocalError extends MarkersValidator {
		private static final long serialVersionUID = -6215764438353685692L;

		public MarkersValidatorWithLocalError(boolean desertification) {
			super(desertification);
		}
		
		public MarkersValidatorWithLocalError() {
			super();
		}
		
		@Override
		protected ValidationError decorate(ValidationError error, IValidatable<Category> validatable) {
			error.addKey(VALIDATIONKEY_MARKER_DESERTIFICATION);
			return super.decorate(error, validatable);
		}
	}

    private void addComponents() {
        TextInputField<String> geographicalTargetArea = new TextInputField<>("16geographicalTargetArea", new RWComponentPropertyModel<String>("geoTargetArea"));
        geographicalTargetArea.typeString();
        add(geographicalTargetArea);

        DateInputField startingDate = new DateInputField("17startingDate", new DateToLocalDateTimeModel(new RWComponentPropertyModel<LocalDateTime>("expectedStartDate")));
        add(startingDate);

        DateInputField completionDate = new DateInputField("18completionDate", new DateToLocalDateTimeModel(new RWComponentPropertyModel<LocalDateTime>("expectedCompletionDate")));
        add(completionDate);

        TextAreaInputField description = new TextAreaInputField("19description", new RWComponentPropertyModel<String>("description"));
        add(description);

        DropDownField<Category> genderEquality = new DropDownField<>("20genderEquality",
                new RWComponentPropertyModel<Category>("genderEquality"), categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        genderEquality.getField().add(new MarkersValidatorWithLocalError());
        
        add(genderEquality);

        DropDownField<Category> aidToEnvironment = new DropDownField<>("21aidToEnvironment",
                new RWComponentPropertyModel<Category>("aidToEnvironment"), categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        aidToEnvironment.getField().add(new MarkersValidatorWithLocalError());
        
        add(aidToEnvironment);

        DropDownField<Category> pdGg = new DropDownField<>("22pdGg",
                new RWComponentPropertyModel<Category>("pdgg"), categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        pdGg.getField().add(new MarkersValidatorWithLocalError());
        
        add(pdGg);

        DropDownField<Category> tradeDevelopment = new DropDownField<>("23tradeDevelopment",
                new RWComponentPropertyModel<Category>("tradeDevelopment"), categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        tradeDevelopment.getField().add(new MarkersValidatorWithLocalError());
        
        add(tradeDevelopment);

        DropDownField<Boolean> freestandingTechnicalCooperation = new DropDownField<>("24freestandingTechnicalCooperation",
                new RWComponentPropertyModel<Boolean>("freestandingTechnicalCooperation"), SB.boolProvider);
        add(freestandingTechnicalCooperation);

        DropDownField<Boolean> programmeBasedApproach = new DropDownField<>("25programmeBasedApproach",
                new RWComponentPropertyModel<Boolean>("programmeBasedApproach"), SB.boolProvider);
        add(programmeBasedApproach);

        DropDownField<Boolean> investmentProject = new DropDownField<>("26investmentProject",
                new RWComponentPropertyModel<Boolean>("investment"), SB.boolProvider);
        add(investmentProject);


        DropDownField<Boolean> associatedFinancing = new DropDownField<>("27associatedFinancing",
                new RWComponentPropertyModel<Boolean>("associatedFinancing"), SB.boolProvider);
        add(associatedFinancing);

        DropDownField<Category> biodiversity = new DropDownField<>("28biodiversity", new RWComponentPropertyModel<Category>("biodiversity"),
        		categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        biodiversity.getField().add(new MarkersValidatorWithLocalError());
        add(biodiversity);

        DropDownField<Category> ccMitigation = new DropDownField<>("29ccMitigation", new RWComponentPropertyModel<Category>("climateChangeMitigation"),
        		categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        ccMitigation.getField().add(new MarkersValidatorWithLocalError());
        
        add(ccMitigation);

        DropDownField<Category> ccAdaptation = new DropDownField<>("30ccAdaptation", new RWComponentPropertyModel<Category>("climateChangeAdaptation"),
        		categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        ccAdaptation.getField().add(new MarkersValidatorWithLocalError());
        
        add(ccAdaptation);

        DropDownField<Category> desertification = new DropDownField<>("31desertification", new RWComponentPropertyModel<Category>("desertification"),
        		categoryFactory.get(CategoryConstants.MARKER_TAG));
        
        desertification.getField().add(new MarkersValidatorWithLocalError(true));
        
        add(desertification);
    }

    @Override
    public String getPermissionKey() {
        return KEY;
    }

    @Override
    public void enableRequired() {
    }
}

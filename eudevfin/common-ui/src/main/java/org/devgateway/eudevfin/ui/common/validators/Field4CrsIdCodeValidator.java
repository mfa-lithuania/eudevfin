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
package org.devgateway.eudevfin.ui.common.validators;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.devgateway.eudevfin.financial.service.FinancialTransactionService;
import org.devgateway.eudevfin.metadata.common.domain.Category;
import org.devgateway.eudevfin.metadata.common.util.CategoryConstants;
import org.devgateway.eudevfin.ui.common.components.DropDownField;

/**
 * @author mihai
 * 
 *         Code validator for CRS Id if nature of submission is 1 or 8 we need
 *         to error check if there are existing CRS IDs and donor id in the
 *         database
 * @see https://jira.dgfoundation.org/browse/ODAEU-180
 */
public class Field4CrsIdCodeValidator extends Behavior implements IValidator<Integer> {

	private static final long serialVersionUID = 7283770086223927921L;
	private transient FinancialTransactionService financialTransactionService;
	private DropDownField<Category> natureOfSubmission;

	public Field4CrsIdCodeValidator(FinancialTransactionService financialTransactionService,
			DropDownField<Category> natureOfSubmission) {
		this.financialTransactionService = financialTransactionService;
		this.natureOfSubmission = natureOfSubmission;
	}

	@Override
	public void validate(IValidatable<Integer> validatable) {
		if (natureOfSubmission.getField().getModelObject() != null
				&& validatable != null
				&& validatable.getValue() != null
				&& (CategoryConstants.NatureOfSubmission.NEW_ACTIVITY_REPORTED.equals(natureOfSubmission.getField()
						.getModelObject().getCode()) || CategoryConstants.NatureOfSubmission.COMMITMENT_EQ_DISBURSEMENT
						.equals(natureOfSubmission.getField().getModelObject().getCode()))
				&& !financialTransactionService.findByCrsIdentificationNumber(validatable.getValue().toString())
						.isEmpty()) {
			ValidationError error = new ValidationError(this);
			validatable.error(decorate(error, validatable));
		}

	}

	/**
	 * Allows subclasses to decorate reported errors
	 * 
	 * @param error
	 * @param validatable
	 * @return decorated error
	 */
	protected ValidationError decorate(ValidationError error, IValidatable<Integer> validatable) {
		return error;
	}

}

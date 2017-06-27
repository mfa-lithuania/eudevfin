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
package org.devgateway.eudevfin.sheetexp.iati.transformer;

import java.util.Date;
import java.util.Map;

import org.devgateway.eudevfin.financial.CustomFinancialTransaction;
import org.devgateway.eudevfin.metadata.common.domain.Category;
import org.devgateway.eudevfin.sheetexp.iati.domain.AmountValue;
import org.devgateway.eudevfin.sheetexp.iati.domain.CodeEntityWithLanguage;
import org.devgateway.eudevfin.sheetexp.iati.domain.IatiActivity;
import org.devgateway.eudevfin.sheetexp.iati.domain.Transaction;
import org.devgateway.eudevfin.sheetexp.iati.domain.TransactionDate;
import org.joda.money.BigMoney;

/**
 * @author alexandru-m-g
 *
 */
public abstract class AbstractTransactionTransformer extends AbstractElementTransformer {

	public AbstractTransactionTransformer(final CustomFinancialTransaction ctx,
			final IatiActivity iatiActivity, final Map<String, Object> paramsMap) {
		super(ctx, iatiActivity, paramsMap);
	}

	/* (non-Javadoc)
	 * @see org.devgateway.eudevfin.sheetexp.iati.transformer.AbstractElementTransformer#process()
	 */
	@Override
	public void process() {
		final BigMoney money = this.findTxMoney();
		if (money != null) {
			final Transaction transaction = this.createTransaction(money);
			this.saveTransaction(transaction);
		}


	}

	protected Transaction createTransaction(final BigMoney money) {
		final Transaction tx = new Transaction();

		tx.setDescription(this.getCtx().getDescription());
		tx.setTransactionDate( new TransactionDate(this.findTxDate()) );

		tx.setAmountValue(new AmountValue(this.findTxDate(),
				money.getCurrencyUnit().getCurrencyCode(), money.getAmount()));

		final Category typeOfAid = this.getCtx().getTypeOfAid();
		if (typeOfAid != null) {
			tx.setAidType( new CodeEntityWithLanguage(typeOfAid.getDisplayableCode(), typeOfAid.getName()) );
		}

		final Category typeOfFinance = this.getCtx().getTypeOfFinance();
		if (typeOfFinance != null) {
			tx.setFinanceType( new CodeEntityWithLanguage(typeOfFinance.getDisplayableCode(), typeOfFinance.getName()) );
		}

		final Category typeOfFlow = this.getCtx().getTypeOfFlow();
		if (typeOfFlow != null) {
			tx.setFlowType( new CodeEntityWithLanguage(typeOfFlow.getDisplayableCode(), typeOfFlow.getName()) );
		}


		return tx;

	}

	protected abstract Date findTxDate();

	protected abstract BigMoney findTxMoney() ;

	protected abstract void saveTransaction(Transaction transaction);

}

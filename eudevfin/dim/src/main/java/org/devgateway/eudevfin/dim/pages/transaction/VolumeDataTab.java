/*******************************************************************************
 * Copyright (c) 2013 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 *    aartimon
 ******************************************************************************/

package org.devgateway.eudevfin.dim.pages.transaction;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.StringResourceModel;
import org.devgateway.eudevfin.dim.core.RWComponentPropertyModel;
import org.devgateway.eudevfin.dim.core.StaticBinds;
import org.devgateway.eudevfin.dim.core.components.DropDownField;
import org.devgateway.eudevfin.dim.core.components.TextInputField;

/**
 * @author aartimon@developmentgateway.org
 * @since 01 November 2013
 */
public class VolumeDataTab extends Panel{

    public VolumeDataTab(String id) {
        super(id);
        addComponents();
    }

    private void addComponents() {

        DropDownField<String> currency = new DropDownField<>("32currency", new RWComponentPropertyModel<String>("currency"),
                "32currency", StaticBinds.yesNoProvider);
        add(currency);

        TextInputField<Integer> commitments = new TextInputField<>("33commitments", new RWComponentPropertyModel<Integer>("commitments"));
        commitments.typeInteger();
        add(commitments);

        TextInputField<Integer> amountsExtended = new TextInputField<>("34amountsExtended", new RWComponentPropertyModel<Integer>("amountsExtended"));
        amountsExtended.typeInteger();
        add(amountsExtended);

        TextInputField<Integer> amountsReceived = new TextInputField<>("35amountsReceived", new RWComponentPropertyModel<Integer>("amountsReceived"));
        amountsReceived.typeInteger();
        add(amountsReceived);

        TextInputField<Integer> amountUntied = new TextInputField<>("36amountUntied", new RWComponentPropertyModel<Integer>("amountUntied"));
        amountUntied.typeInteger();
        add(amountUntied);

        TextInputField<Integer> amountPartiallyUntied = new TextInputField<>("37amountPartiallyUntied", new RWComponentPropertyModel<Integer>("amountPartiallyUntied"));
        amountPartiallyUntied.typeInteger();
        add(amountPartiallyUntied);

        TextInputField<Integer> amountTied = new TextInputField<>("38amountTied", new RWComponentPropertyModel<Integer>("amountTied"));
        amountTied.typeInteger();
        add(amountTied);

        TextInputField<Integer> amountOfIRTC = new TextInputField<>("39amountOfIRTC", new RWComponentPropertyModel<Integer>("amountOfIRTC"));
        amountOfIRTC.typeInteger();
        add(amountOfIRTC);

        TextInputField<Integer> amountOfExpertsCommitments = new TextInputField<>("40amountOfExpertsCommitments", new RWComponentPropertyModel<Integer>("amountOfExpertsCommitments"));
        amountOfExpertsCommitments.typeInteger();
        add(amountOfExpertsCommitments);

        TextInputField<Integer> amountOfExpertsExtended = new TextInputField<>("41amountOfExpertsExtended", new RWComponentPropertyModel<Integer>("amountOfExpertsExtended"));
        amountOfExpertsExtended.typeInteger();
        add(amountOfExpertsExtended);

        TextInputField<Integer> amountOfExportCredit = new TextInputField<>("42amountOfExportCredit", new RWComponentPropertyModel<Integer>("amountOfExportCredit"));
        amountOfExportCredit.typeInteger();
        add(amountOfExportCredit);
    }

    public static ITab newTab(Component askingComponent){
        return new AbstractTab(new StringResourceModel("tabs.volume", askingComponent, null)){
            private static final long serialVersionUID = -724508987522388955L;

            @Override
            public WebMarkupContainer getPanel(String panelId) {
                return new VolumeDataTab(panelId);
            }
        };
    }
}
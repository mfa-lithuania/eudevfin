/*******************************************************************************
 * Copyright (c) 2013 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    mpostelnicu
 ******************************************************************************/
package org.devgateway.eudevfin.dim;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.devgateway.eudevfin.domain.Person;
import org.devgateway.eudevfin.persistence.service.PersonService;

@AuthorizeInstantiation("ROLE_SUPERVISOR")
public class ItemsPage extends WebPage {
	
	@SpringBean
	private PersonService personService;

	public ItemsPage() {	
		
		
		add(new PropertyListView<Person>("items",personService.findPeople()) {

			@Override
			protected void populateItem(ListItem<Person> item) {
				item.add(new Label("name"));
				item.add(new Label("id"));
			}
		});
	}
}

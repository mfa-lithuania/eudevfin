package org.devgateway.eudevfin.forms.pages;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.repeater.Item;

@AuthorizeInstantiation("ROLE_SUPERVISOR")
public class ItemsPage extends WebPage {

	//@SpringBean
//	private ItemDao itemDao;
//
//	public ItemsPage() {
//
//		add(new PropertyListView<Item>("items", itemDao.findItems()) {
//
//			@Override
//			protected void populateItem(ListItem<Item> item) {
//				item.add(new Label("product"));
//				item.add(new Label("quantity"));
//			}
//		});
//	}
}
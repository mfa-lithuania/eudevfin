package org.devgateway.eudevfin.dim.desktop.components;

import java.util.List;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.devgateway.eudevfin.financial.util.PagingItem;

public class PagingPanel extends Panel {

	private ListView<PagingItem> paginationListView;

	public PagingPanel(String id, IModel<List<PagingItem>> model) {
		super(id, model) ;
		
		
		List<PagingItem> items			= model.getObject();
		
		this.paginationListView			= new ListView<PagingItem>("page-number-list", items ) {

			@Override
			protected void populateItem(ListItem<PagingItem> item) {
				PagingItem pagingItem					= item.getModelObject();
				Pageable parent	= (Pageable) PagingPanel.this.getParent();
				
				AjaxLink<PagingItem> link	= parent.createLink(pagingItem);
				Label label				= new Label("page-number-label", pagingItem.getLabel());
				link.add(label);
				item.add(link);
				if ( pagingItem.isDisabled() )
					item.add(new AttributeAppender("class", "active"));
			}
			
		};
		
		this.add(this.paginationListView);
	}


}
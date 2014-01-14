/**
 * 
 */
package org.devgateway.eudevfin.dim.desktop.components;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.devgateway.eudevfin.auth.common.domain.PersistedUserGroup;
import org.devgateway.eudevfin.dim.pages.admin.EditPersistedUserPage;
import org.devgateway.eudevfin.ui.common.components.TableListPanel;
import org.devgateway.eudevfin.ui.common.components.util.ListGeneratorInterface;

/**
 * @author mihai
 * 
 */
public class PersistedUserGroupTableListPanel extends TableListPanel<PersistedUserGroup> {

	private static final long serialVersionUID = 7403189032489301520L;

	public PersistedUserGroupTableListPanel(String id,
			ListGeneratorInterface<PersistedUserGroup> listGenerator) {
		super(id, listGenerator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void populateTable() {
		this.itemsListView = new ListView<PersistedUserGroup>("groupList", items) {

			private static final long sermiialVersionUID = -8758662617501215830L;

			@Override
			protected void populateItem(ListItem<PersistedUserGroup> listItem) {
				final PersistedUserGroup group = listItem.getModelObject();
				
				Link linkToEditUserGroup=new Link("linkToEditUserGroup") {
					@Override
					public void onClick() {
						PageParameters pageParameters = new PageParameters(); 
				
						pageParameters.add("groupId", group.getId());

						setResponsePage(EditPersistedUserPage.class, pageParameters);
						
					}
				};
				
				linkToEditUserGroup.setBody(Model.of(group.getName()));

//				Label groupsLabel = new Label("groups",
//						user.getGroups() != null ? user.getGroups().toString()
//								: "");


//				listItem.add(groupsLabel);
				listItem.add(linkToEditUserGroup);

			}

		};

		this.add(itemsListView);

	}
}
/*
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 */

package org.devgateway.eudevfin.dim.pages;

import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipConfig;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.IconBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.IconType;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.devgateway.eudevfin.auth.common.domain.PersistedUser;
import org.devgateway.eudevfin.dim.desktop.components.MessageNavbarButton;
import org.devgateway.eudevfin.financial.FileWrapper;
import org.devgateway.eudevfin.financial.Message;
import org.devgateway.eudevfin.financial.service.MessageService;
import org.devgateway.eudevfin.ui.common.components.TableListPanel;
import org.devgateway.eudevfin.ui.common.components.util.DownloadLink;
import org.devgateway.eudevfin.ui.common.components.util.ListGeneratorInterface;
import org.devgateway.eudevfin.ui.common.providers.PersistedUserChoiceProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Alexandru Artimon
 * @since 16/08/14
 */
public class MessagesListTable extends TableListPanel<Message> {
    @SpringBean
    private MessageService mxService;

    public MessagesListTable(String id, ListGeneratorInterface<Message> listGenerator) {
        super(id, listGenerator, null);
    }

    public void reloadMessageList(AjaxRequestTarget target) {
        reloadTable();
        for (Component c : getPage().visitChildren(MessageNavbarButton.class))
            target.add(c);
        target.add(itemsListView.getParent());
    }


    @Override
    protected void populateTable() {
        this.itemsListView = new ListView<Message>("messagesList", items) {
            @Override
            protected void populateItem(final ListItem<Message> item) {
                final Message msg = item.getModelObject();
                String from = "";
                if (msg.getFrom() != null)
                    from = PersistedUserChoiceProvider.userToString(msg.getFrom());
                else
                    from = "[SYSTEM]";

                String to = "";
                Iterator<PersistedUser> it = msg.getTo().iterator();
                while (it.hasNext()) {
                    PersistedUser u = it.next();
                    to += PersistedUserChoiceProvider.userToString(u) + (it.hasNext() ? ", " : "");
                }

                item.add(new Label("from", Model.of(from)));
                item.add(new Label("to", Model.of(to)));

                final Label messageLabel = new Label("message", new PropertyModel(item.getModel(), "message"));
                messageLabel.setRenderBodyOnly(true);
                messageLabel.setEscapeModelStrings(false);
                item.add(messageLabel);

                AbstractReadOnlyModel<List<FileWrapper>> roList = new AbstractReadOnlyModel<List<FileWrapper>>() {
                    @Override
                    public List<FileWrapper> getObject() {
                        final PropertyModel<Set<FileWrapper>> attachments = new PropertyModel<>(item.getModel(), "attachments");
                        ArrayList<FileWrapper> ret = new ArrayList<FileWrapper>();
                        if (attachments.getObject() != null)
                            for (FileWrapper fw : attachments.getObject())
                                ret.add(fw);
                        return ret;
                    }
                };

                WebMarkupContainer attachments = new WebMarkupContainer("attachments");
                item.add(attachments);

                attachments.setVisibilityAllowed(false);
                if (roList.getObject() != null && roList.getObject().size() > 0)
                    attachments.setVisibilityAllowed(true);

                ListView<FileWrapper> list = new ListView<FileWrapper>("list", roList) {
                    @Override
                    protected void populateItem(final ListItem<FileWrapper> item) {
                        Label label = new Label("label", item.getModelObject().getName());
                        item.add(label);

                        Link<FileWrapper> download = new DownloadLink("download", item.getModel());
                        item.add(download);
                    }
                };
                attachments.add(list);

                final Label subjectModel = new Label("subject", new PropertyModel(item.getModel(), "subject"));
                subjectModel.setRenderBodyOnly(true);
                subjectModel.setEscapeModelStrings(false);
                item.add(subjectModel);
                item.add(new Label("date", Model.of(msg.getSendDate().toString("EEEEEE, dd MMMMM yyyy HH:mm"))));

                TooltipConfig tooltipConfig = new TooltipConfig().withPlacement(TooltipConfig.Placement.left);

                AjaxLink delete = new AjaxLink("delete") {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        mxService.delete(msg);
                        reloadMessageList(target);
                    }

                    @Override
                    protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                        super.updateAjaxAttributes(attributes);
                        AjaxCallListener ajaxCallListener = new AjaxCallListener();
                        ajaxCallListener.onPrecondition("return confirm(' "
                                + new StringResourceModel("modal.delete", this.getPage(), null, null).getObject() + " ');");
                        attributes.getAjaxCallListeners().add(ajaxCallListener);
                    }
                };
                delete.add(new TooltipBehavior(new StringResourceModel("delete.tooltip", this, null, null), tooltipConfig));
                item.add(delete);

                AjaxLink reply = new AjaxLink("reply") {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        Messages messages = this.findParent(Messages.class);
                        messages.reply(msg.getFrom(), msg.getTo(), msg.getSubject(), target);
                    }
                };
                reply.add(new TooltipBehavior(new StringResourceModel("reply.tooltip", this, null, null), tooltipConfig));
                item.add(reply);


                AjaxLink readToggle = new AjaxLink("readStatus") {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        msg.setReadStatus(!msg.getReadStatus());
                        mxService.save(msg);
                        reloadMessageList(target);
                    }
                };
                WebMarkupContainer readToggleIcon = new WebMarkupContainer("readStatusIcon");
                if (msg.getReadStatus() != null && msg.getReadStatus()) {
                    readToggle.add(new TooltipBehavior(new StringResourceModel("markUnread.tooltip", this, null, null), tooltipConfig));
                    readToggleIcon.add(new IconBehavior(IconType.cog));
                } else {
                    readToggle.add(new TooltipBehavior(new StringResourceModel("markRead.tooltip", this, null, null), tooltipConfig));
                    readToggleIcon.add(new IconBehavior(IconType.asterisk));
                }
                readToggle.add(readToggleIcon);
                item.add(readToggle);

            }
        };
        itemsListView.setReuseItems(false);
        this.add(this.itemsListView);
    }

    @Override
    protected void populateHeader() {
//        this.add( ComponentsUtil.generateLabel("from", "fromLabel", this) );
//        this.add( ComponentsUtil.generateLabel("message", "messageLabel", this) );
//        this.add( ComponentsUtil.generateLabel("actions", "actionsLabel", this) );
    }
}

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

package org.devgateway.eudevfin.dim.core.components;

import de.agilecoders.wicket.core.markup.html.bootstrap.form.InputBehavior;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;


public abstract class AbstractInputField<T> extends AbstractField {
    private IModel<String> placeholderText;

    public AbstractInputField(String id, IModel<T> model, String messageKeyGroup){
        super(id, model, messageKeyGroup);

        placeholderText = new StringResourceModel(messageKeyGroup + ".placeholder", this, null, "");
        addComponents(model);
    }

    private void addComponents(IModel<T> model){
        addFormComponent(newField("field", model));
        field.setOutputMarkupId(true);

        field.add(new InputBehavior(InputBehavior.Size.Large));
    }

    @Override
    protected void onBeforeRender() {
        if (!hasBeenRendered())
            field.add(new AttributeModifier("placeholder", placeholderText));

        super.onBeforeRender();
    }

    @Override
    @SuppressWarnings("unchecked")
    public AbstractInputField<T> required() {
        return (AbstractInputField<T>) super.required();
    }

    public void setPlaceholderText(IModel<String> placeholderText) {
        this.placeholderText = placeholderText;
    }

    protected abstract FormComponent<T> newField(String id, IModel<T> model);
}

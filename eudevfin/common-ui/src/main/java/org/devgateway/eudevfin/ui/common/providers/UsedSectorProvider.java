/*******************************************************************************
 * Copyright (c) 2014 Development Gateway.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *******************************************************************************/
package org.devgateway.eudevfin.ui.common.providers;

import com.vaynberg.wicket.select2.Response;
import org.apache.wicket.Session;
import org.devgateway.eudevfin.metadata.common.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author idobre
 * @since 4/7/14
 */
public class UsedSectorProvider extends AbstractCategoryProvider {

    protected UsedSectorProvider() {

    }

    @Override
    protected Page<Category> getItemsByTerm(String term, int page) {
        Page<Category> categories = categoryService.findUsedSectorPaginated(Session.get().getLocale()
                .getLanguage(), term, new PageRequest(page, pageSize, sort), false);
        return categories;
    }

    @Override
    public void query(String term, int page, Response<Category> response) {
        Page<Category> itemsByTerm = getItemsByTerm(term, page);
        response.setHasMore(itemsByTerm.hasNextPage());
        List<Category> responseItems = new ArrayList<>();
        if (itemsByTerm.getNumberOfElements() > 0) {
            for (Category category : itemsByTerm) {
                responseItems.add(category);
            }
        }
        response.addAll(responseItems);
    }
}
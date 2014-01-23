/**
 * 
 */
package org.devgateway.eudevfin.financial.repository;

import java.util.List;

import org.devgateway.eudevfin.financial.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Alex
 *
 */
public interface CategoryRepository extends
		PagingAndSortingRepository<Category, Long> {
	
	List<Category> findByTagsCode(String tagsCode);
	

	@Query("select distinct categ from CategoryTranslation trn join trn.parent categ join categ.tags tag where lower(trn.name) like %?1% and tag.code=?2")
	Page<Category> findByTranslationsNameIgnoreCaseContainsAndTagsCode(String term, String tagsCode,Pageable page);		
	
	//@Query("select categ from Category categ where lower(categ.translations[?1]).name like %?2%")
	@Query("select distinct categ from CategoryTranslation trn join trn.parent categ join categ.tags tag "
			+ " where trn.locale=?1 and lower(trn.name) like %?2% and tag.code=?3 ")
	List<Category> findByTranslationsLocaleAndTranslationsNameIgnoreCaseContainsAndTagsCode(String locale, String term, String tagsCode);
	
	Page<Category> findByTagsCode(String code,Pageable page);
	
	List<Category> findByCode(String code);

}

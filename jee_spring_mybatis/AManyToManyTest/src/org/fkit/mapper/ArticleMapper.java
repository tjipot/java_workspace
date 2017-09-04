package org.fkit.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Article;


/**
 * Article 才是多对多的关系;
 * @author UNIVESRE
 *
 */
public interface ArticleMapper {

	@Select("SELECT * FROM tb_article WHERE id IN (SELECT article_id FROM tb_item WHERE order_id = #{id} ) ")
	List<Article> selectByOrderId(Integer order_id);
	
}

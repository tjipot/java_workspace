package com.univesre.onlineshop.dao;

import java.util.List;

import com.univesre.onlineshop.domain.SalesItem;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface SalesItemDao {
	
	// 全选sales_item表格的数据;
	@Select("select * from sales_item")
	@Results({@Result(id=true, column="item_id", property="item_id"),
			@Result(column="item_name", property="item_name"),
			@Result(column="item_category", property="item_category"),
			@Result(column="item_description", property="item_description"),
			@Result(column="item_price", property="item_price"),
			@Result(column="item_amount", property="item_amount"),
			@Result(column="item_weight", property="item_weight")})	// 结果的映射, 删除不需要映射;
	List<SalesItem> selectAll();
	
	// 这里没有用到动态SQL, 否则就用@SelectProvider注解了;
	
}

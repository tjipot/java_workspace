package com.univesre.onlineshop.service;

import java.util.List;

import com.univesre.onlineshop.domain.SalesItem;

/**
 * @author UNIVESRE
 * @Description Onlineshop服务层接口: 业务逻辑;
 */

public interface OnlineshopService {

	/**
	 * 
	 * @return List<SalesItem>对象
	 */
	List<SalesItem> showItems();

}

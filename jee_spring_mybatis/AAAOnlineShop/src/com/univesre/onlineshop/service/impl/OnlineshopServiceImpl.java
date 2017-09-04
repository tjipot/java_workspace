package com.univesre.onlineshop.service.impl;

import java.util.List;

import com.univesre.onlineshop.dao.SalesItemDao;
import com.univesre.onlineshop.domain.SalesItem;
import com.univesre.onlineshop.service.OnlineshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 
 * @author UNIVESRE
 * @Description Onlineshop服务层接口的实现: 业务逻辑;
 */
@Service("onlineshopService")	// springframework框架;
public class OnlineshopServiceImpl implements OnlineshopService{

	/** 注入持久层对象 */
	@Autowired
	private SalesItemDao salesItemDao;
	
	
	
	/** _____SalesItem服务接口实现_____ */
	@Override
	public List<SalesItem> showItems() {
		return salesItemDao.selectAll();
	}
	
}

package org.fkit.mapper;

import org.fkit.domain.Person;

public interface PersonMapper {
	
	/**
	 * 根据id查询Person,
	 * 方法名和参数必须和xml文件中的<select.../>元素的属性id和属性parameterType一致;
	 * @param id
	 * @return Person对象
	 * 
	 * 方法的实现应该是在xml的select元素中了: 返回的person数据被包装成了Person对象;
	 * */
	Person selectPersonById(Integer id);
	
}

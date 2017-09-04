package org.fkit.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.User;

/**
 * UserMapper接口
 * */
public interface UserMapper {
	
	/**
	 * 根据登录名和密码查询用户
	 * @param String loginname
	 * @param String password
	 * @return 找到返回User对象，没有找到返回null
	 * */
	// 此处数据库条件查询是大小写不敏感的, 所以如果输入用户名'jack'和'Jack'是一样的;
	@Select("select * from tb_user_fkbookapp where loginname = #{loginname} and password = #{password}")
	User findWithLoginnameAndPassword(@Param("loginname")String loginname, @Param("password") String password);

}
 
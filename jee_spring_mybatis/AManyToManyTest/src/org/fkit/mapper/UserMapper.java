package org.fkit.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.domain.User;

public interface UserMapper {

	@Select("SELECT * FROM TB_USER_1 WHERE ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="loginname",property="loginname"),
		@Result(column="PASSWORD",property="password"),
		@Result(column="phone",property="phone"),
		@Result(column="address",property="address"),
//		@Result(column="user_id",property="user",one=@One(select="org.fkit.mapper.UserMapper.selectById",fetchType=FetchType.EAGER)),				// 返回一个user;
//		@Result(column="order",property="articles",many=@Many(select="org.fkit.mapper.ArticleMapper.selectByOrderId",fetchType=FetchType.LAZY))
		})		// 返回多个article(商品);
	User selectById(Integer id);
	
}

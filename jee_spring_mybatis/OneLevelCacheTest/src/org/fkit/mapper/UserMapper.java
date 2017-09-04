package org.fkit.mapper;

import org.fkit.domain.User;
import java.util.List;

public interface UserMapper {
	
	// 对应UserMapper.xml中的id;
	User selectUserById(Integer id);	// 根据id查询User;
	List<User> selectAllUser();			// 查询所有User;
	void deleteUserById(Integer id);	// 根据id删除User;

}

package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.UserDynaSqlProvider;
import org.fkit.hrm.domain.User;
import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;

/** Data Access Object, DAO层;
 *  @Description: UserMapper接口;
 *  所谓Mapper的意思就是MyBatis将User对象和数据库(table)映射(map)了起来; */
public interface UserDao {

	/** 通过@select注解, MyBatis框架将Java方法(可带参数)和指定的SQL语句关联了起来,
	 *  每个方法对应了一条SQL语句, 关键还得看SQL语句干了什么; */
	// 根据登录名和密码查询员工;
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);
	
	// 根据id查询用户;
	@Select("select * from "+USERTABLE+" where ID = #{id}")
	User selectById(Integer id);
	
	// 根据id删除用户;
	@Delete("delete from "+USERTABLE+" where id = #{id} ")
	void deleteById(Integer id);

	
	/** 另一种注解 */
	// 动态修改用户;
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(User user);

	// 动态查询;
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
	List<User> selectByPage(Map<String, Object> params);

	// 根据参数查询用户总数;
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	// 动态插入用户;
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);

}

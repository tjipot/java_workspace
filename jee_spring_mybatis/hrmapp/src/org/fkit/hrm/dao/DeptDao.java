package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.DeptDynaSqlProvider;
import org.fkit.hrm.domain.Dept;
import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;

/** 使用到动态SQL(将这个代码放在DeptDynaSqlProvider中以便于管理 */
public interface DeptDao {
	
	@Select("select * from "+DEPTTABLE+" ")
	List<Dept> selectAllDept();

	@Select("select * from "+DEPTTABLE+" where ID = #{id}")
	Dept selectById(int id);

	// 根据id删除部门;
	@Delete(" delete from "+DEPTTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	/** 动态SQL */
	// 动态查询;
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
	List<Dept> selectByPage(Map<String, Object> params);

	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	// 动态插入部门;
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	void save(Dept dept);

	// 动态修改用户;
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	void update(Dept dept);

}

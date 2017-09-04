package org.fkit.hrm.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Dept;
import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;

public class DeptDynaSqlProvider {

	// 分页动态查询: 一条select from where语句;
	public String selectWhitParam(Map<String, Object> params){
		
		String sql = new SQL(){{
			SELECT("*");
			FROM(DEPTTABLE);
			if(params.get("dept") != null){
				Dept dept = (Dept) params.get("dept");
				if(dept.getName() != null && !dept.getName().equals("")){
					WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
				}
			}
		}}.toString();

		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
			
		return sql;
	}	

	// 动态查询总数量: 一条select from where语句;
	public String count(Map<String, Object> params){

		return new SQL(){{
			SELECT("count(*)");
			FROM(DEPTTABLE);
			if(params.get("dept") != null){
				Dept dept = (Dept) params.get("dept");
				if(dept.getName() != null && !dept.getName().equals("")){
					WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
				}
			}
		}}.toString();
	}

	// 动态插入: 一条insert_into语句;
	public String insertDept(Dept dept){

		return new SQL(){{
			INSERT_INTO(DEPTTABLE);
			if(dept.getName() != null && !dept.getName().equals("")){
				VALUES("name", "#{name}");
			}
			if(dept.getRemark() != null && !dept.getRemark().equals("")){
				VALUES("remark", "#{remark}");
			}
		}}.toString();
	}

	// 动态更新: 一条update where语句;
	public String updateDept(Dept dept){

		return new SQL(){{
			UPDATE(DEPTTABLE);
			if(dept.getName() != null){
				SET(" name = #{name} ");
			}
			if(dept.getRemark() != null){
				SET(" remark = #{remark} ");
			}
			WHERE(" id = #{id} ");
		}}.toString();
	}

}

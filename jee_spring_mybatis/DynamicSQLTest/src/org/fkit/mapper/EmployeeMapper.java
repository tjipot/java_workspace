package org.fkit.mapper;

import org.fkit.domain.Employee;
import java.util.HashMap;
import java.util.List;

/* mapper接口代理对象:EmployeeMapper */
public interface EmployeeMapper {

	// 一大波接口: 从方法名看sql语句的功能;
	List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);
	
	List<Employee> selectEmployeeByLoginLike(HashMap<String, Object> params);
	
	List<Employee> selectEmployeeChoose(HashMap<String, Object> params);
	
	List<Employee> findEmployeeLike(HashMap<String, Object> params);
	
	List<Employee> selectEmployeeLike(HashMap<String, Object> params);
	
	Employee 	   selectEmployeeWithId(Integer id);
	
	void 		   updateEmployeeIfNecessary(Employee employee);
	
	List<Employee> selectEmployeeIn(List<Integer> ids);
	
	List<Employee> selectEmployeeLikeName(Employee employee);
	
}

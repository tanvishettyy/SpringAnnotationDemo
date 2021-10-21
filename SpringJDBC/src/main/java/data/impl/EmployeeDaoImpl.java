package data.impl;

import org.impelsys.data.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Employee;
import model.EmployeeMapper;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}


		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

	public int saveEmp(Employee e)
	 {
		 String sql="insert into Employee(empName,age) values(:name :age)";
		return 1; 
	 }
	
	public Employee getEmployee(int id)
	 {
		 String sql="select * from employee where empId =?";
		 
		 Employee emp = jdbcTemplate.queryForObject(sql, new Object[]{id} , new EmployeeMapper());
		 return emp;
	 }


	


	
	
}



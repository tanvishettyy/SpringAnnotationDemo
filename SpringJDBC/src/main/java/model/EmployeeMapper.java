package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>
{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Employee emp = new Employee();
		emp.setEmpName(rs.getString("empName"));
		emp.setAge(rs.getInt("age"));
		return emp;
		
	}
}

package data;


import java.util.List;

import org.springframework.stereotype.Repository;

import model.Employee;

public interface EmployeeDao{
	public int addEmployee(Employee emp);
	
	public default boolean delete(Employee emp)
	{
		return false;
	}
	
	public default Employee getEmployees(int id)
	{
		return null;
	}
	
	public default List<Employee> getAllEmployees()
	{
		return null;
	}
	
	public default List<Integer> getDistinctSalary()
	{
		return null;
	}
	
	public default List<Employee> getEmployeeList()
	{
		return null;
	}
	
	 int update(Employee emp);
	 Long getEmployeesCount();

	List<Employee> getEmployeesList(int from, int noOfRows);

	public int updateEmployeeDept(Employee emp);

	public void assignEmployeeProjects();

	List<Employee> getAllEmployeesList();
	
	
	
}


/*@Repository("employeeDao")
public class EmployeeDao {
	public boolean addEmployee(Employee emp){
		System.out.println("Adding employee (in data/dao)");
		boolean flag=true;
		//perform database operations here
		System.out.println(emp.getEmpName()+emp.getEmpPhoneNum());
		
		return flag;
	}
	public default boolean delete(Employee emp){return false;};
	public List<Employee> getEmployees() {
		return null;
	}

}
*/
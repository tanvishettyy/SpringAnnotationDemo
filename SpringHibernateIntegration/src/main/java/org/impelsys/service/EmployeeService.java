package org.impelsys.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.impelsys.data.EmployeeDao;
import org.impelsys.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
//@Service
public class EmployeeService {
	@Autowired
	@Qualifier("hibernateDao")
	EmployeeDao employeeDao;
	@PostConstruct
	public void setup(){
	
	}
	
	public int updateEmployeeDept(Employee emp)
	{
		return employeeDao.updateEmployeeDept(emp);
	}
	public Employee displayEmployees(int empId){
		return employeeDao.getEmployees(empId);
	}
	
	public List<Employee> displayAllEmployees(){
		return employeeDao.getEmployeeList();
	}
	
	public List<Integer> displayDistinctSalary(){
		return employeeDao.getDistinctSalary();
	}
	
	public int addEmployeeDetails(Employee emp)
	{
		int empId;
		System.out.println("Adding employee (in service)");
		empId = employeeDao.addEmployee(emp);
		return empId;
	}
	public Long EmployeeCount()
	{
		return employeeDao.getEmployeesCount();
	}
	public int updateEmployee(Employee emp)
	{
		return employeeDao.update(emp);		
	}
	
	public List<Employee> displayAllEmployees(int rowFrom, int noOfRecords)
	{
		return employeeDao.getEmployeesList(rowFrom,noOfRecords);
	}
	
	public void assignEmployeeProjects()
	{
		 employeeDao.assignEmployeeProjects();
	}
}

/*HibernateEmployeeDaoImpl dao;
public int addEmployeeDetails(Employee emp){
	System.out.println("Adding employee (in service)");
	//perform business logic here
	boolean flag=false;
		flag=dao.addEmployee(emp);
	return 0;*/
package service;


import org.springframework.stereotype.Component;

import model.Employee;

@Component
public class EmployeeService {
	
	public boolean addEmployeeDetails(Employee emp)
	{
	
		System.out.println("Employee Added");
	
		boolean flag=true;
		if(emp!=null)
		 return flag;
		else
		 return false;
	}

}

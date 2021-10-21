package org.impelsys.data;

import model.Employee;

public interface EmployeeDao{

	int saveEmp(model.Employee e);

	Employee getEmployee(int id);
	
}

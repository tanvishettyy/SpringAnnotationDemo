package model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import customannotation.Exist;
@Component
public class Employee {
	
	@NotNull(message="Name is required")
	@Exist
	String empName;
	
	@NotNull(message="Id is required")
	String empId;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + "]";
	}
	
}

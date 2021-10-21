package model;

import java.util.Date;
import java.util.List;


public class Employee {
	
	
	int empId;
	String empName;
	String empPhoneNum;
	String experience;
	String gender;	
	int age;
	int salary;
	

	public Employee(String empName, String empPhoneNum, String gender) {
		super();
		this.empName = empName;
		this.empPhoneNum = empPhoneNum;
		this.gender = gender;
	}
	
	public Employee(){
		
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhoneNum() {
		return empPhoneNum;
	}
	public void setEmpPhoneNum(String empPhoneNum) {
		this.empPhoneNum = empPhoneNum;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", experience="
				+ experience + ", gender=" + gender + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}

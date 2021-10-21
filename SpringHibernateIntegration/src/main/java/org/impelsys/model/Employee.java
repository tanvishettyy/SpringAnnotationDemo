package org.impelsys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	int empId;
	
	String empName;
	String empPhoneNum;
	String experience;
	String gender;	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Date dob;
	int age;
	int salary;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)        //many emp to 1 dept
	@JoinColumn(name="deptId", referencedColumnName="dept_id")  //emp table deptId is FK to dept_id of dept table
	Department department;
	
	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)  //emp has one-to-one association         //use annotation or xml
	@JoinColumn(name="emp_acc_id", referencedColumnName="accountId" )  //cascade type=ALL,DELETE action in parent triggers other table
	BankAccount bankAccount;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="EMP_PROJECTS", 
	joinColumns = {@JoinColumn(name="EMPLOYEE_id",referencedColumnName="empId")}, inverseJoinColumns={@JoinColumn(name="PROJECT_ID",referencedColumnName="PR_ID")}
	)
	private List<Project> projectsList;
	
	
	public List<Project> getProjectsList() {
		return projectsList;
	}
	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}
	public Employee(String empName, String empPhoneNum, String gender) {
		super();
		this.empName = empName;
		this.empPhoneNum = empPhoneNum;
		this.gender = gender;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Employee(){
		
	}

	public static class EmployeeFactory{
	public static Employee create(){
		return  new Employee();
	}
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", experience="
				+ experience + ", gender=" + gender + ", dob=" + dob + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
	
}

package model;

import java.util.Date;

import javax.print.attribute.standard.Severity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import customannotations.Year;


@Component

public class Employee {

	@NotNull(message="Id is required")
	String empID;
	
	@NotNull
	@Size(min=3,max=30,message="Employee name should be more than 3 characters and less than 20 characters")
	@Pattern(regexp="[^0-9]*")
	String empName;
	
	@NotNull(message="Phone number is required")
	String empPhoneNum;
	
	@Range(min=2,max=5, message="Experience should be betweeen 2 and 5 years")
	int empExperience;
	
	//@NotNull
	@Past(message="DOB cannot be empty")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Year(value=2001,message="please make sure year of birth is 2001", payload = Severity.Error.class)                            //user defined annotation defined in package validators. for message define it inside year class
	Date dateOfBirth;
	
	/*@NotNull
    @Min(20)
	int age;*/
	

	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
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
	public int getEmpExperience() {
		return empExperience;
	}
	public void setEmpExperience(int empExperience) {
		this.empExperience = empExperience;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		System.out.println(dateOfBirth);
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", empExperience="
				+ empExperience + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}

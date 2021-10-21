package model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee 
{
private String name;
private String EmpId;
private Device laptopDevice;  //has a relationship



public Employee() //if not created error created because 
{
	
}

public Employee(String ename, Device laptopDevice)  //constructor injection
{
	System.out.println("In contructor");
	name=ename;
	this.laptopDevice=laptopDevice;
}


public Device getLaptopDevice() {
	return laptopDevice;
}

public void setLaptopDevice(Device laptopDevice)
{
	System.out.println("In setter: setlaptopDevice");
	this.laptopDevice = laptopDevice;
}



public String getEmpId() {
	return EmpId;
}
public void setEmpId(String empId) {
	EmpId = empId;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
	System.out.println("Emp name: "+ name);
}
//intit method
//@PostConstruct
	 public void intit()
	 {
		 System.out.println("Intialising of the Employee");
	 }

	//@PreDestroy
	 public void destroy()
	 {
		 //shutdown activities
		 System.out.println("Doing cleaning activities before destroying employee");
	 }
}

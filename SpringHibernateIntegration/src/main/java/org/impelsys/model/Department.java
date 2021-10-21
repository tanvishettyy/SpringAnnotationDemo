package org.impelsys.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity           //pojo
@Table(name="Department")         //if its not there hibernate will automatically create
public class Department {
	@Id
	@Column(name="dept_id")       //column specific name. not required
	@GeneratedValue(strategy=GenerationType.IDENTITY)           
	int deptId;
	
	@Column(name="dept_name")  //table cloumn name
	String  deptName;
	
	@Column(name="hod_Name") 
	String hodName;            
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY)   //property name  //all emp from one dept
	@JoinColumn(name="deptId")
	private Set<Employee> employees;        
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	
}

package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PR_ID", unique=true, nullable=false)
	int projectId;
	
	@Column(name="project_name")
	String projectName;
	
	@Column(name="project_lead")
	String projectLead;
	
	

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	@JoinColumn(name="prjtLeadId",referencedColumnName="empId")
	private Employee projectEmployee;
	
	@ManyToMany(mappedBy="projectsList")
	List<Employee> employeeList;
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectLead() {
		return projectLead;
	}

	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getProjectEmployee() {
		return projectEmployee;
	}

	public void setProjectEmployee(Employee projectEmployee) {
		this.projectEmployee = projectEmployee;
	}

	
	
	

}

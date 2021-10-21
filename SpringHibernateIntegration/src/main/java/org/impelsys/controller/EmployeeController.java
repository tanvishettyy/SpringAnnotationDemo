package org.impelsys.controller;

import java.util.List;

import org.impelsys.model.BankAccount;
import org.impelsys.model.Department;
import org.impelsys.model.Employee;
import org.impelsys.model.Employee.EmployeeFactory;
import org.impelsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Component
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	/* localhost:8080/HibernateDemo/employee/update/tanvi/12545215/mangalore -> RESTful url
	 * localhost:8080/HibernateDemo/employee/update?ename==tanvi&phone=25525&city=mangalore  
	 * 
	 */
	@RequestMapping("/updateDept/{empId}/{deptId}")
	public void updateDept(@PathVariable int empId , @PathVariable int deptId, Model model)
	{
		Employee emp= new Employee();
		emp.setEmpId(empId);
		Department d = new Department();
		d.setDeptId(deptId);
		emp.setDepartment(d);
		service.updateEmployeeDept(emp);
	}
	
	@RequestMapping("/update/{ename}/{phone}/{city}")   //utility url
	public String update(@PathVariable String ename, @PathVariable String phone , @PathVariable String city, Model model )
	{
		Employee e= new Employee();
		e.setEmpName(ename);
		e.setEmpPhoneNum(phone);
		//update operation
		int count = service.updateEmployee(e);
		if(count>=1){
			model.addAttribute("emp",e);
			return "home";           //display
		}
		else
		{
			return "error";
		}
		
	}

	@RequestMapping("/create/{count}")
	//localhost:8080/HibernateDemo/employee/create/100
	public void createEmpInBulk(@PathVariable int count)
	{
		Employee e = new Employee();
		for(int i=0;i<count;i++)
		{
			e.setEmpName("emp:"+i);
			e.setEmpPhoneNum("452646"+i);
			Department d=new Department();
			d.setDeptName("IT");
			//populate all fields
			service.addEmployeeDetails(e);
		}
		System.out.println("Processing Complete");
	}
	
	@RequestMapping("/getPage/{pageNum}")
	public String page(@PathVariable String pageNum, Model model)
	{
		int pageNo = Integer.parseInt(pageNum);
		int numOfRecords=10;
		int rowFrom =1;
		rowFrom =( (pageNo-1) * numOfRecords) + 1;
		List<Employee> listEmp =service.displayAllEmployees(rowFrom, numOfRecords);
		model.addAttribute("empList",listEmp);
		return "home";
	}
	@RequestMapping("/")
	public String home(Model model)
	{
		/*System.out.println("In home");
		
		Employee emp = new Employee();
		emp.setEmpName("John");
		emp.setEmpPhoneNum("246810");
		emp.setExperience("4");
		emp.setGender("M");
		emp.setAge(30);
		emp.setSalary(2300);
		//emp.setAge(10);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date dob =sdf.parse("01/01/2000");
			emp.setDob(dob);
		}
		catch(ParseException e1)
		{
			e1.printStackTrace();
		}
			
		int empId = service.addEmployeeDetails(emp);
		
	 List<Employee> list = service.displayAllEmployees();
		 for(Employee e: list)
			 System.out.println(e);
		 
		 model.addAttribute("empList",list);
		  List<Integer> list1 = service.displayDistinctSalary();
		 for(Integer e1: list1)
			 System.out.println(e1);
			 model.addAttribute("empList1",list1);
			 //	service.addEmployeeDetails(emp);
		//model.addAttribute("employee",EmployeeFactory.create());*/
			  	
		System.out.println("In /employee/");
		Employee emp=new Employee();
		emp.setEmpName("Atul");
		Department dept= new Department();
		dept.setDeptName("Admin2");
		emp.setDepartment(dept);
		
		
		//System.out.println("dept added");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountType("Savings Account");
		bankAccount.setBankName("AXIS Bank");
		bankAccount.setIfsc("AXIS004240");
		System.out.println("Bank details added");
		
		emp.setBankAccount(bankAccount);
		service.addEmployeeDetails(emp);
		service.assignEmployeeProjects();
		
		Long empCount = service.EmployeeCount();
		model.addAttribute("employee",emp);
		model.addAttribute("empCount",empCount);
		model.addAttribute("firstCall",true);
		
		return "home";
	}
	
	@ModelAttribute
	public void commStuff(Model model){
		model.addAttribute("HeaderStatus", "Welcome to Impelsys!!");
		model.addAttribute("emp", new Employee());
	}
	@RequestMapping("/index")
	public String addemp(){
		return "add";
	}
	@RequestMapping("/tryAgain")
	public String tryAgain(){
		return "add";
	}
	@RequestMapping("showLogin")
	public String showLogin(){
		return "login";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
	}

	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp)
	{
		System.out.println("Adding employee (in controller)");
		 int flag = 1;
		
		 flag=service.addEmployeeDetails(emp);
		 if(true)
			 return "success";
		 return "error";
	}
	
}

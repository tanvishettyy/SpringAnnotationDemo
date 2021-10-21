package controller;


import java.util.Set;

import javax.print.attribute.standard.Severity;
import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;


import service.EmployeeService;


@Component
@Controller  //inherits from @component
public class EmployeeController {


	/*public void addEmp(HttpServletRequest request , HttpServletResponse response) {
		//public String addEmployee (@RequestParam String ename, @RequestParam String empPhone){
		Employee emp=null;
		String empName =  request.getParameter("ename");
		String empPhone =  request.getParameter("empPhone");
		String empId =  request.getParameter("eid");
		emp.setEmpID(empName);
		emp.setEmpName(empPhone);
		emp.setEmpPhoneNum(empId);
		System.out.println("employee created");
		}*/
		
		//System.out.println("In Create Employee");
	@Autowired
	EmployeeService employeeService;
	/*@RequestMapping("/")
	 public String home(Model model)
	 {
		System.out.println("In home");
		model.addAttribute("employee", new Employee());
		
		return "add";
	 }*/
	
	@ModelAttribute         //called even before request mapping
	public void commonStuff(Model model)
	{
		model.addAttribute("HeaderStatus", "Employee details");
		model.addAttribute("employee", new Employee());         //create a employee obj and later it is overwritten
	}
	
	@RequestMapping("/add")
		public String addEmployee(@ModelAttribute("employee") @Valid Employee emp,BindingResult bindingresult)
		{
		
		boolean flag= false;
		System.out.println("Employee:"+emp);
		if(bindingresult.hasErrors())
		{
			StringBuffer sb=new StringBuffer();
			System.out.println("No of errors found in forms: "+ bindingresult.getErrorCount());
			for(Object object: bindingresult.getAllErrors())
			{
				if(object instanceof FieldError)
				{
					FieldError fieldError =(FieldError) object;
					System.out.println(fieldError.getCode());
					//fieldError.
					sb.append(fieldError.getDefaultMessage());
					sb.append("\n");
				}
			}
			System.out.println("Errors: "+sb);
			
			
			boolean isSevereError;
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Employee employee;
			Set<ConstraintViolation<Employee>> constraintViolation=validator.validate(employee);
			if(constraintViolation.size()>0)
			{
				for(ConstraintViolation<Employee>violation : constraintViolation)  //looping through the set
				{
					Set<Class<? extends Payload>> payloads = violation.getConstraintDescriptor().getPayload();
					for(Class<? extends Payload>payload: payloads)
					{
						if(payload==Severity.Error.class)
						{
							isSevereError=true;
							Severity.sendEmail(violation);
						}
					}
				}
				if(isSevereError)
				{
					bindingresult.reject("dob","Mail sent to Hr for year violation in Date of Birth field. Request");
				}
			}
			
			bindingresult.reject("errors",sb.toString());
			return "add";
		}
		
	 flag= employeeService.addEmployeeDetails(emp);

		if(flag)
			return "success";
		return "error";
	
	}
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee emp)  //searches for employee object and overwrites it
	{
		ModelAndView modelandview = new ModelAndView("success");
		return modelandview;
	}

}

	/*	ModelAndView mv= new ModelAndView();
		mv.addObject("empname",ename);
		mv.addObject("phone",empPhone);*/
		/*Employee emp=new Employee();
		emp.setEmpName(ename);
		emp.setEmpPhoneNum(empPhone);*/
		

		
		/*if(flag.equalsIgnoreCase("success"))
		{
			mv.setViewName("success.jsp");
		}
		else
		{
		mv.setViewName("error.jsp");
		}*/
	
		//return mv;



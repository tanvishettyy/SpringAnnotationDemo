package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;



@Component
@Controller
public class EmployeeController {
	
	@ModelAttribute         //called even before request mapping
	public void commonStuff(Model model)
	{
		model.addAttribute("HeaderStatus", "Employee details");
		model.addAttribute("employee", new Employee());         //create a employee obj and later it is overwritten
	}
	
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("in home");
		return "login";
	}
	
	@RequestMapping("/login")
	public String addEmployee(@ModelAttribute("employee") @Valid Employee emp,BindingResult bindingresult)
	{
	
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
		bindingresult.reject("errors",sb.toString());
		return "login";
	}
	return "success";
}
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee emp)  //searches for employee object and overwrites it
	{
		ModelAndView modelandview = new ModelAndView("success");
		return modelandview;
	}
	
}

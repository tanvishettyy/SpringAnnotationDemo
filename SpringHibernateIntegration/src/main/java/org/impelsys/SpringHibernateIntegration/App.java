package org.impelsys.SpringHibernateIntegration;

import java.util.List;

import org.impelsys.config.SpringHibernateXMLConf;
import org.impelsys.data.impl.HibernateEmployeeDaoImpl;
import org.impelsys.model.Department;
import org.impelsys.model.Employee;
import org.impelsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



/**
 * Hello world!
 *
 */

public class App 
{
	@Autowired
	@Qualifier("hibernateDao")
	static HibernateEmployeeDaoImpl hibernateDao;
	
	@Autowired
	static EmployeeService service;
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SpringHibernateXMLConf.class);
    	List<Employee> list;
    	System.out.println("In App");
    	hibernateDao = (HibernateEmployeeDaoImpl) context.getBean("hibernateDao");
    	
    	
    	Employee emp = new Employee();
    	emp.setEmpName("Tanvi");
    	emp.setEmpPhoneNum("8463156230");
    	Department dept = new Department();
    	dept.setDeptId(10);
    	hibernateDao.addEmployee(emp);
    	list = hibernateDao.getEmployeeList();
        for(Employee emp1:list)
        {
        	System.out.println(emp1.toString());
        }
    	
    }
}

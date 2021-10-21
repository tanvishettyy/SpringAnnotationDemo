package org.impelsys.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import data.impl.EmployeeDaoImpl;
import model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDaoImpl employeeDao = (EmployeeDaoImpl) context.getBean("employeeDao");
        Employee emp = employeeDao.getEmployee(2);
        System.out.println("emp: "+emp);
    }
}

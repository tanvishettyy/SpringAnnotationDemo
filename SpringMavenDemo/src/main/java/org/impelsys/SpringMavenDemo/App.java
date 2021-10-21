package org.impelsys.SpringMavenDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import model.Employee;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml"); //beans are instantiated in this path
    	System.out.println( "Hello World!" );
    	
    	Employee bean1 =(Employee) context.getBean("empbean");
    	/*System.out.println("Emp name: "+ bean1.getName() +" has been allocated "+ (bean1.getLaptopDevice()!=null? ( bean1.getLaptopDevice().getModelNum()+" "):"No device is Found!!!"));*/
    }
}

//bean.setName("Miss Tanvi");
//Employee bean1 =(Employee) context.getBean("empbean");
//System.out.println("Emp name: "+ bean.getName());
//here empbean is the id ,its like a name of object .it searches bean with id name empbean
// employee bean , here bean should be the attribute name in applicationcontext    
//attribute is<>
//System.out.println("Name:"+bean.getName()+"has been allocated: "+bean.getLaptopDevice().getModelNum());

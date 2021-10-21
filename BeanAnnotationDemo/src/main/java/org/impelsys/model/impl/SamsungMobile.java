package org.impelsys.model.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.impelsys.model.Mobile;
import org.impelsys.model.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//@Component("samsungGalaxy")

public class SamsungMobile implements Mobile {
	public SamsungMobile()
	{
		System.out.println("In constructor");
	}
	
	@Autowired
	@Qualifier("createOctaCoreProcessor")   //follow camelcasing. used instead of primary 
	//@Qualifier("coreProcessor8")   // custom name
	Processor processor;
	public void config() 
	{
	System.out.println("Octa Core , 12MP camera, 8GB Ram");
	processor.config();
	}
	
	@PostConstruct
	//init method
	 public void intit()
	 {
		 System.out.println("Intialising of the SamsungMobile");
	 }

	@PreDestroy
	 public void destroy()
	 {
		 //shutdown activities
		 System.out.println("Doing cleaning activities before destroying SamsungMobile");
	 }
}

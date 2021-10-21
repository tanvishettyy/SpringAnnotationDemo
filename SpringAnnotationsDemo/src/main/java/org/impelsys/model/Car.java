package org.impelsys.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.*;

@Component
@PropertySource("classpath:car.properties")
public class Car {
	@Value("${type1}")  //instead of us giving value it picks from properties file
	String type;
	
	@Value("${model1}")
	String model;
	
	
	private Engine mustangEngine;
	Car(){
		
	}
	
	//@Autowired  //constructor injection 
	public Car(Engine e){
		System.out.println("In constructor: ");
		mustangEngine = e;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	
	@Required
	public void setModel(String model) {
		this.model = model;
	}

	public Engine getMustangEngine() {
		return mustangEngine;
	}

	
	
	
	/*@Autowired  //constructor injection 
	@Qualifier("mustangEngine")*/
	//@Autowired //setter injection
	@Resource 
	public void setMustangEngine(Engine mustangEngine) {
		this.mustangEngine = mustangEngine;
	}

}

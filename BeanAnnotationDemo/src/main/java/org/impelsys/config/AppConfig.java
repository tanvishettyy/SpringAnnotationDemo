package org.impelsys.config;

import org.impelsys.model.Processor;
import org.impelsys.model.impl.OctaCoreProcessor;
import org.impelsys.model.impl.QuadraCoreProcessor;
import org.impelsys.model.impl.SamsungMobile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
@Lazy
@Configuration
//@ComponentScan("org.impelsys.model.impl")
public class AppConfig {//this class is src of beans  either use componentscan and automativally scans else crete inside like @bean
	//factory method

	@Bean
	public SamsungMobile createSamsungMobile()
	{
		return new SamsungMobile();
		
	}
	
	@Bean
	public Processor createOctaCoreProcessor()
	{
		return new OctaCoreProcessor();
		
	}
	
	@Bean
	public Processor createQuadraCoreProcessor()
	{
		return new QuadraCoreProcessor();
		
	}

}

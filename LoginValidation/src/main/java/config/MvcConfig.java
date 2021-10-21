package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"controller","model"})
public class MvcConfig {
	
	@Bean
	public ViewResolver ConfigureViewResolver()
	{
	System.out.println("In Configure View resolver");
	InternalResourceViewResolver viewResolve =new InternalResourceViewResolver();
	viewResolve.setPrefix("/WEB-INF/jsp/");
	viewResolve.setSuffix(".jsp");
	return viewResolve;
	}

}

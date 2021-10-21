package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//replacement for dispatcher servlet.xml
//where to go 
@EnableWebMvc           //<mvc:annotation-driven/> used to enable spring mvc
@ImportResource("classpath:dispatcherServlet-servlet.xml")
@Configuration
@ComponentScan({"controller","model","service"})
public class MvcConfig {
	@Bean
		public ViewResolver ConfigureViewResolver()
		{
		System.out.println("In configure view resolver");
		InternalResourceViewResolver viewResolve =new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/jsp/");
		viewResolve.setSuffix(".jsp");
		return viewResolve;
		}
}

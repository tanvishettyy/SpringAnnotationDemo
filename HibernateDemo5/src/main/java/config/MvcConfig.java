package config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import util.HibernateUtil;
//replacement for dispatch servlet xml
@EnableWebMvc
//@ImportResource("classpath:hibernate.cfg.xml")
@Configuration
@ComponentScan({"controller","model","data","service","data.impl","util"})
public class MvcConfig {
	@Bean
	public ViewResolver ConfigureViewResolver(){
		System.out.println("in view Resolver");
		InternalResourceViewResolver view= new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/jsp/");
		view.setSuffix(".jsp");
		return view;
	}
	@Bean
	public SessionFactory sessionFactory(){
		return HibernateUtil.getSessionFactory();
		
	}

}

package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebIniti extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		System.out.println("inside webmvc");
		return new Class[]{MvcConfig.class};
	} 
	
	@Override	
	protected String[] getServletMappings()
	{
		//url pattern mapping
		// for all url
			return new String[]{"/"};
	}	
}


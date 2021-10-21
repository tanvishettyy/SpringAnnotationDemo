package org.impelsys.BeanAnnotationDemo;

import org.impelsys.config.AppConfig;
import org.impelsys.model.impl.SamsungMobile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);  //class
        context.registerShutdownHook();
     //  SamsungMobile s8 = context.getBean(SamsungMobile.class); //retrieve bean from Spring context
      // SamsungMobile s8 = (SamsungMobile)context.getBean("samsungMobile"); //retrieve bean from Spring context
      //  System.out.println("Lazily loading the samsung mobile");
        SamsungMobile s8 = (SamsungMobile)context.getBean("createSamsungMobile");
        s8.config();
    }
}

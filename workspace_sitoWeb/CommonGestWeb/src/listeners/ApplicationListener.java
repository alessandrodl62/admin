package listeners;
 
import java.util.Date;
import java.util.Locale;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.beanutils.ConvertUtils; 

 
import converters.*; 

public class ApplicationListener implements  ServletContextListener{
	
	
	public void contextInitialized(ServletContextEvent event) {
	   
	    configureBeans();
	    

	
	}
	
	private void configureBeans(){
		ConvertUtils.register(new DateLocaleConverterCustom( Locale.ITALY,"dd.MM.yyyy"),Date.class );
		ConvertUtils.register(new DoubleLocalConverterCustom( Locale.ITALY),Double.class );
		ConvertUtils.register(new IntegerLocalConverterCustom( Locale.ITALY),Integer.class );
		
	}
	 
  
	 
	public void contextDestroyed(ServletContextEvent event){

		
	}
}    
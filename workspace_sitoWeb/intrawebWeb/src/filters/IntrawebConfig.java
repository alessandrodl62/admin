package filters;
import java.io.*;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*; 
 
 
public class IntrawebConfig implements Filter {
  private Object persistence;  
  
  
  public void doFilter(ServletRequest req,
                       ServletResponse res,
                       FilterChain chain)
                       throws IOException,
                              ServletException {
	  
	  
	  HttpServletRequest request = (HttpServletRequest)req; 
	  
	  persistence =  request.getSession().getAttribute("app.persistence");
	  if(persistence==null) {
		  
		  	Context initContext;
			try {
				initContext = new InitialContext();
				
				
//Object pippo = initContext.lookup( "alert/PersistenceAlertFacadeBean/local");
//System.out.println("PersistenceAlertFacade.class.getClassLoader() ["+PersistenceAlertFacade.class.getClassLoader()+"]");
//System.out.println("pippo.getClass().getClassLoader() ["+pippo.getClass().getInterfaces()[0].getClassLoader()+"]");
//Thread.currentThread().setContextClassLoader(PersistenceAlertFacade.class.getClassLoader());

				
				persistence  =   initContext.lookup( "intraweb/IntrawebPersistenceFacadeBean/local");
//System.out.println("-- new Persistence " + persistence);
				request.getSession().setAttribute("app.persistence",persistence);
				
				// memorizza anno di sistema
				GregorianCalendar calendar = new GregorianCalendar();
				Integer annosys = calendar.get(GregorianCalendar.YEAR);
				request.getSession().setAttribute("annosys",annosys);
				
				//JSONRPCBridge bridge = new JSONRPCBridge();
				//bridge.registerObject("persistence", persistence);
				
			} catch (NamingException e) { 
				e.printStackTrace();
				throw new ServletException(e);
			}  
 
	  }
		  
	  
	  chain.doFilter(req, res);
  }
  public void init(FilterConfig filterConfig) {
 
  }
  
  public void destroy() {
	     
  }
}
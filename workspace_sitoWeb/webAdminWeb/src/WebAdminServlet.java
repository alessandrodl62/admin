import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import commonBean.OrganiDO;
import commonSession.PersistWebadminFacade;
import commonSession.PersistWebadminFacadeBean;
import commons.DateJsonValueProcessor;
import commons.TimeJsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;


/**
 * @author alessandrodl ottobre 2013
 *
 */



public class WebAdminServlet extends HttpServlet implements Servlet {

	private JsonConfig JsConf = new JsonConfig();
	
	public WebAdminServlet() {
		super();
		JsConf.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor());
		JsConf.registerJsonValueProcessor(Time.class, new TimeJsonValueProcessor());
		
	}
	
	private PersistWebadminFacade getPersistence(HttpServletRequest  request) throws NullPointerException {
	      
	      return (PersistWebadminFacade) request.getSession().getServletContext().getAttribute("app.persistence");
	      
	    }
	
	
	private void elaboraRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("sono nella servlet");
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	      
		String    command = request.getPathInfo();
	      
	      if(command == null) command = request.getServletPath();
	      
	      if(command.equals("/listaorgani")) organiAllList(request, response); 
	       
	        
	      
	      
	      System.out.println("comando della servlet:  "+command);
	      
	}
	
	private void organiAllList(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		

		try {

			PersistWebadminFacade persistence = getPersistence(request);
/*			
			List<OrganiDO> organiLista =  null;
			
			organiLista =  persistence.listOrgani();

				
			
			for (Iterator iter = organiLista.iterator(); iter.hasNext();) {
				 OrganiDO  element = (OrganiDO) iter.next();
				
				System.out.println("Elemento lista:  "+element.getTor_denom());
			}
			
			
			
			response.getWriter().write(JSONArray.fromObject(organiLista).toString());
*/
			
			response.getWriter().write(persistence.jsonArrayListOrgani());

		}  catch (Exception e) {

			throw new ServletException(e);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			elaboraRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			elaboraRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	    	
}
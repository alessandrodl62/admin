/*
 * Created on 07/lug/08 by alessandrodl
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

package filtri;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import commonSession.PersistWebadminFacade;






/**
 * Filter class
 *
 * @web.filter              name="GetContesto"
 *                          display-name="Name for GetContesto"
 *                          description="Description for GetContesto"
 * @web.filter-mapping      url-pattern="/GetContesto"
 * @web.filter-init-param   name="A parameter"
 *                          value="A value"
 */
public class GetContesto implements Filter {

  private PersistWebadminFacade  persistence;
  
  public GetContesto() {
    // TODO Auto-generated constructor stub
  }

  public void destroy() {
    // TODO Auto-generated method stub

  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException,
    ServletException {
    
	  
      System.out.println("CI SONO PASSATO DI QUI - FILTRO");
      
    HttpServletRequest request = (HttpServletRequest) req;
//    AppAttivitaFacInterface application = (AppAttivitaFacInterface) request.getSession().getAttribute("application");
  
    persistence = (PersistWebadminFacade)request.getSession().getServletContext().getAttribute("app.persistence");
    
    if(persistence==null) {
      Context context;
      
      try {
        context = new InitialContext();
        System.out.println("name in namespace: "+context.getNameInNamespace());
        System.out.println("environment: "+context.getEnvironment().toString());
                                                                       
        persistence = (PersistWebadminFacade) context.lookup("webAdminEAR/PersistWebadminFacadeBean/local");
        
        request.getSession().getServletContext().setAttribute("app.persistence", persistence);
        
//        application =  new AppAttivitaFacImpl((PersistAttivitaFacade) request.getSession().getServletContext().getAttribute("persistence"));
//        request.getSession().setAttribute("application", application);
//        application.setRequest(request);

        System.out.println("persistence - getcontesto:  "+persistence);
        
        //memorizzo anno di sistema
        GregorianCalendar calendar = new GregorianCalendar();
        Integer annosys = calendar.get(GregorianCalendar.YEAR);
        request.getSession().setAttribute("annosys", annosys);
        
      } catch (Exception e) {
        
        e.printStackTrace();
        throw new ServletException(e);
      }  
   
    }
    
    chain.doFilter(req, res);

  }

  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub

  }

}

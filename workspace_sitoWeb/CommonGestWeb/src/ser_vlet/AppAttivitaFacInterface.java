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

package ser_vlet;

import javax.servlet.http.HttpServletRequest;

public interface AppAttivitaFacInterface {

  public Object get(Object prototype)throws Exception; 
  
  public void  set(Object object)throws Exception;
  public void setPersist(Object object)throws Exception;
  
  public void setRequest(HttpServletRequest request) throws Exception; 
  public HttpServletRequest getRequest() throws Exception;
  
  public Object getById(long id)throws Exception;
  
}

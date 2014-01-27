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

package commonSession;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.persistence.Query;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import commonBean.EcoAttAutRumore;


@Local
public interface PersistAttivitaFacade {

    public Object find(Object id, Class clazz, String   unit) throws Exception;
    
    public Boolean savePersist(Object obj)  throws Exception;
    public Boolean saveMerge(Object obj)  throws Exception;
    
    public Boolean savePersistGest(Object obj)  throws Exception;
    public Boolean saveMergeGest(Object obj)  throws Exception;
    public Boolean saveMergeTerr(Object obj)  throws Exception;
    public Boolean saveMergeAutRumore(String json) throws Exception;
    
    public void delete(Object id, Class clazz, String unit) throws Exception;
    
//    public Query namedQuery(String namedQuery) throws Exception;
//    public Query namedQueryGest(String namedQuery) throws Exception;
    
    public List resultQuery(Map<String, Object> parametri, String entityName, String unit) throws Exception;
    
    public List resultListQuery(String nomeQuery, Map<String, Object>  parametri, String unit) throws Exception;
    
    public String jsonArrayQuery(String nomeQuery, Map<String, Object>  parametri, String unit) throws Exception;
    public String jsonArrayCreateQuery(Map<String, Object> parametri, String entityName, String unit) throws Exception;
    public String jsonArrayCreateNativeQuery(String sql, Class clazz,Map<String, Object> parametri, String unit) throws Exception;
    
    public String jsonArrayCreateQueryEJBQL(String sql, Map<String, Object> parametri, String orderBy, String unit)  throws Exception;
    public String jsonArrayCreateQueryAttivita(Map<String, Object> parametri, String entityName, String unit) throws Exception;
    public String jsonArrayCreateQueryAutRumoreEJBQL(String sql, Map<String, Object> parametri, String orderBy) throws Exception;
    
    public Object getReference(Integer id,  Class clazz, String unit) throws Exception;
    public Object getReference(String id,  Class clazz, String unit) throws Exception;
}

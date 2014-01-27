/**
 * @author alessandrodl ottobre 2013
 */

package commonSession;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface PersistWebadminFacade {
	
	public List listOrgani() throws Exception;
	
	public String jsonArrayListOrgani() throws Exception;

}

package intrawebPK;

import java.io.Serializable;

import javax.persistence.Id;

public class AutxtipopubProxyiPK implements Serializable {

	
	private Integer tat_iduser;
	private Integer tat_idtipopub;
    

	public AutxtipopubProxyiPK() {};
	public AutxtipopubProxyiPK(Integer idtipo,Integer iduser) {
		
		this.tat_idtipopub = idtipo;
		this.tat_iduser = iduser;
		
	};
    

    
	
	public Integer getTat_idtipopub() {
		return tat_idtipopub;
	}
	public void setTat_idtipopub(Integer tat_idtipopub) {
		this.tat_idtipopub = tat_idtipopub;
	}
	public Integer getTat_iduser() {
		return tat_iduser;
	}
	public void setTat_iduser(Integer tat_iduser) {
		this.tat_iduser = tat_iduser;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((tat_idtipopub == null) ? 0 : tat_idtipopub.hashCode());
		result = result + ((tat_iduser == null) ? 0 : tat_iduser.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		final AutxtipopubProxyiPK other = (AutxtipopubProxyiPK) obj;

        if (!tat_idtipopub.equals(other.tat_idtipopub) || !tat_iduser.equals(other.tat_iduser))
			 return false;
   
		return true;
	}
	
	
}

package intraweb;

import intrawebPK.AutxtipopubProxyiPK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_autxtipopub")
@IdClass(AutxtipopubProxyiPK.class)
@NamedQuery(name="AutxtipopubiProxy.selectByUser",query="select autx from AutxtipopubiProxy autx where autx.tat_iduser = :id")
public class AutxtipopubiProxy {
	
	@Id
	private Integer tat_iduser;
	
	@Id
	private Integer tat_idtipopub;
	
	
	@Transient
	private String descrtpubbl;

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

	public String getDescrtpubbl() {
		return descrtpubbl;
	}

	public void setDescrtpubbl(String descrtpubbl) {
		this.descrtpubbl = descrtpubbl;
	}
	
}

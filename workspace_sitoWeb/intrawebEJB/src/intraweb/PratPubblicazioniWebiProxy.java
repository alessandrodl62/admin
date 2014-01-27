package intraweb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_pratpubblicazioni")
@NamedQueries({@NamedQuery(name="PratPubblicazioniWebiProxy.selectByPratica",query="select prpweb from PratPubblicazioniWebiProxy prpweb where prpweb.prp_praid = :id"),
	           @NamedQuery(name="PratPubblicazioniWebiProxy.selectByNotPratica",query="select prpweb from PratPubblicazioniWebiProxy prpweb where prpweb.prp_praid <> :id")
		      }) 
public class PratPubblicazioniWebiProxy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer prp_id;
	
	private Integer prp_praid;
	private Integer prp_pubblid;
	
	public Integer getPrp_id() {
		return prp_id;
	}
	public void setPrp_id(Integer prp_id) {
		this.prp_id = prp_id;
	}
	public Integer getPrp_praid() {
		return prp_praid;
	}
	public void setPrp_praid(Integer prp_praid) {
		this.prp_praid = prp_praid;
	}
	public Integer getPrp_pubblid() {
		return prp_pubblid;
	}
	public void setPrp_pubblid(Integer prp_pubblid) {
		this.prp_pubblid = prp_pubblid;
	}
	
}

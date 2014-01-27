package intraweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_ariprat")
@NamedQuery(name="Ariprati.selectByPrat",query="select arip from Ariprati arip where  arip.idprat = :id")
public class Ariprati {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idprat;
	private Integer tari_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdprat() {
		return idprat;
	}
	public void setIdprat(Integer idprat) {
		this.idprat = idprat;
	}
	public Integer getTari_id() {
		return tari_id;
	}
	public void setTari_id(Integer tari_id) {
		this.tari_id = tari_id;
	}
	
}

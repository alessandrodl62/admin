package intraweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_arsprat")
@NamedQuery(name="Arsprati.selectByPrat",query="select arsp from Arsprati arsp where  arsp.idprat = :id")
public class Arsprati {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idprat;
	private Integer tars_id;
	
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
	public Integer getTars_id() {
		return tars_id;
	}
	public void setTars_id(Integer tars_id) {
		this.tars_id = tars_id;
	}
	
}

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
@Table(name="t_modassegnazione")
@NamedQuery(name="Modassegnazione.selectAll",query="select mas from Modassegnazione mas order by mas.descrizione")
public class Modassegnazione implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private Integer idmoda;

    private String descrizione;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getIdmoda() {
		return idmoda;
	}

	public void setIdmoda(Integer idmoda) {
		this.idmoda = idmoda;
	}
    
    
}

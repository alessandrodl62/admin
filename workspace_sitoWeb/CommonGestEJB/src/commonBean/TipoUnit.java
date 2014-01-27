package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_unit")
public class TipoUnit implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tipunit; 
	
	private Integer id_ente;
	private String descrizione;

	public Integer getId_ente() {
		return id_ente;
	}
	public void setId_ente(Integer id_ente) {
		this.id_ente = id_ente;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getId_tipunit() {
		return id_tipunit;
	}
	public void setId_tipunit(Integer id_tipunit) {
		this.id_tipunit = id_tipunit;
	}
	
	
	

}

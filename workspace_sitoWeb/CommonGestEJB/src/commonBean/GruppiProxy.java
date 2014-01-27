package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gruppi_gen")
public class GruppiProxy implements Serializable {
	
	@Id
	private Integer id_grugen;
	
	private Integer id_ente;
	
    private String desc_grugen;

	public String getDesc_grugen() {
		return desc_grugen;
	}

	public void setDesc_grugen(String desc_grugen) {
		this.desc_grugen = desc_grugen;
	}

	public Integer getId_ente() {
		return id_ente;
	}

	public void setId_ente(Integer id_ente) {
		this.id_ente = id_ente;
	}

	public Integer getId_grugen() {
		return id_grugen;
	}

	public void setId_grugen(Integer id_grugen) {
		this.id_grugen = id_grugen;
	}

}

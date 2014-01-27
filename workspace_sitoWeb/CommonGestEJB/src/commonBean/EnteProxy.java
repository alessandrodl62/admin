package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab_enti")
public class EnteProxy implements Serializable {
	
	private int id_ente;
	private String descr_ente;
	private String pathbase;

	@Id
	public int getId_ente() {
		return id_ente;
	}
	public void setId_ente(int id_ente) {
		this.id_ente = id_ente;
	}
	
	public String getDescr_ente() {
		return descr_ente;
	}
	public void setDescr_ente(String descr_ente) {
		this.descr_ente = descr_ente;
	}
	public String getPathbase() {
		return pathbase;
	}
	public void setPathbase(String pathbase) {
		this.pathbase = pathbase;
	}
	
	

}

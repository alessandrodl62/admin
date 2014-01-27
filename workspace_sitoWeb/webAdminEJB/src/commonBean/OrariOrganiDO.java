package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_orariorgani")
public class OrariOrganiDO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer too_id;
	
	private Integer too_idorgtipo;
	private Integer too_idsede;
	private String  too_giorno;
	private String	too_orario;
	private String	too_flappunt;
	private Integer too_numordgg;
	
	
	public Integer getToo_id() {
		return too_id;
	}
	
	public String getToo_flappunt() {
		return too_flappunt;
	}
	public void setToo_flappunt(String too_flappunt) {
		this.too_flappunt = too_flappunt;
	}
	public String getToo_giorno() {
		return too_giorno;
	}
	public void setToo_giorno(String too_giorno) {
		this.too_giorno = too_giorno;
	}
	public Integer getToo_idorgtipo() {
		return too_idorgtipo;
	}
	public void setToo_idorgtipo(Integer too_idorgtipo) {
		this.too_idorgtipo = too_idorgtipo;
	}
	public Integer getToo_idsede() {
		return too_idsede;
	}
	public void setToo_idsede(Integer too_idsede) {
		this.too_idsede = too_idsede;
	}
	public Integer getToo_numordgg() {
		return too_numordgg;
	}
	public void setToo_numordgg(Integer too_numordgg) {
		this.too_numordgg = too_numordgg;
	}
	public String getToo_orario() {
		return too_orario;
	}
	public void setToo_orario(String too_orario) {
		this.too_orario = too_orario;
	}
	
	
	
	
}

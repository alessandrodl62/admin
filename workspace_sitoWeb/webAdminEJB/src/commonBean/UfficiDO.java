package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_uffici")
public class UfficiDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tuf_id;
	private String	tuf_descr;
	private Integer tuf_idsett;
	private Integer tuf_idsede;
	private String	tuf_tel1;
	private String	tuf_tel2;
	private String	tuf_fax;
	private String	tuf_email;
	private String	tuf_flpubbl;
	private String	tuf_dirigente;
	private String	tuf_orario;
	private Integer	tuf_lunghorario;
	private String	tuf_responsabile;
	
	
	public Integer getTuf_id() {
		return tuf_id;
	}
	
	public String getTuf_descr() {
		return tuf_descr;
	}
	public void setTuf_descr(String tuf_descr) {
		this.tuf_descr = tuf_descr;
	}
	public String getTuf_dirigente() {
		return tuf_dirigente;
	}
	public void setTuf_dirigente(String tuf_dirigente) {
		this.tuf_dirigente = tuf_dirigente;
	}
	public String getTuf_email() {
		return tuf_email;
	}
	public void setTuf_email(String tuf_email) {
		this.tuf_email = tuf_email;
	}
	public String getTuf_fax() {
		return tuf_fax;
	}
	public void setTuf_fax(String tuf_fax) {
		this.tuf_fax = tuf_fax;
	}
	public String getTuf_flpubbl() {
		return tuf_flpubbl;
	}
	public void setTuf_flpubbl(String tuf_flpubbl) {
		this.tuf_flpubbl = tuf_flpubbl;
	}
	public Integer getTuf_idsede() {
		return tuf_idsede;
	}
	public void setTuf_idsede(Integer tuf_idsede) {
		this.tuf_idsede = tuf_idsede;
	}
	public Integer getTuf_idsett() {
		return tuf_idsett;
	}
	public void setTuf_idsett(Integer tuf_idsett) {
		this.tuf_idsett = tuf_idsett;
	}
	public Integer getTuf_lunghorario() {
		return tuf_lunghorario;
	}
	public void setTuf_lunghorario(Integer tuf_lunghorario) {
		this.tuf_lunghorario = tuf_lunghorario;
	}
	public String getTuf_orario() {
		return tuf_orario;
	}
	public void setTuf_orario(String tuf_orario) {
		this.tuf_orario = tuf_orario;
	}
	public String getTuf_responsabile() {
		return tuf_responsabile;
	}
	public void setTuf_responsabile(String tuf_responsabile) {
		this.tuf_responsabile = tuf_responsabile;
	}
	public String getTuf_tel1() {
		return tuf_tel1;
	}
	public void setTuf_tel1(String tuf_tel1) {
		this.tuf_tel1 = tuf_tel1;
	}
	public String getTuf_tel2() {
		return tuf_tel2;
	}
	public void setTuf_tel2(String tuf_tel2) {
		this.tuf_tel2 = tuf_tel2;
	}
	
	
	

}

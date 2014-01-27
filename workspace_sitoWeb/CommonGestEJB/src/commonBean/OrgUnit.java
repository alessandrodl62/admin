package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="org_unit")
public class OrgUnit implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_unit; 
	
	private Integer id_ente;
	private Integer id_user;
	
	private Integer id_tipunit;
	private Integer id_sede;
	
	private String descr_titolo;
	private String tel1;
	private String tel2;
	private String tel3;
	private String fax;
	private String email;
	
	private String orario;
	private String codest;
	
	private Boolean f_olda;
	private Boolean f_primary;
	
	
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
	public Integer getId_unit() {
		return id_unit;
	}
	public void setId_unit(Integer id_unit) {
		this.id_unit = id_unit;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getId_tipunit() {
		return id_tipunit;
	}
	public void setId_tipunit(Integer id_tipunit) {
		this.id_tipunit = id_tipunit;
	}
	public Integer getId_sede() {
		return id_sede;
	}
	public void setId_sede(Integer id_sede) {
		this.id_sede = id_sede;
	}
	public String getCodest() {
		return codest;
	}
	public void setCodest(String codest) {
		this.codest = codest;
	}
	public String getDescr_titolo() {
		return descr_titolo;
	}
	public void setDescr_titolo(String descr_titolo) {
		this.descr_titolo = descr_titolo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getOrario() {
		return orario;
	}
	public void setOrario(String orario) {
		this.orario = orario;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public Boolean getF_olda() {
		return f_olda;
	}
	public void setF_olda(Boolean f_olda) {
		this.f_olda = f_olda;
	}
	public Boolean getF_primary() {
		return f_primary;
	}
	public void setF_primary(Boolean f_primary) {
		this.f_primary = f_primary;
	}

}

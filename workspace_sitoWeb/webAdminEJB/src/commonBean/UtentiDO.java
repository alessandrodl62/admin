package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_utenti")
public class UtentiDO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer	tus_id;
	
	private String	tus_nome;
	private Integer	tus_idsettore;
	private	String	tus_utente;
	private String	tus_psw;
	private	String	tus_flvalid;
	private	String	tus_adm;
	private	String	tus_tuttisettori;
	private	Integer	tus_userid;
	private Integer	tus_idufficio;
	
	
	public Integer getTus_id() {
		return tus_id;
	}
	
	
	
	public String getTus_adm() {
		return tus_adm;
	}
	public void setTus_adm(String tus_adm) {
		this.tus_adm = tus_adm;
	}
	public String getTus_flvalid() {
		return tus_flvalid;
	}
	public void setTus_flvalid(String tus_flvalid) {
		this.tus_flvalid = tus_flvalid;
	}
	public Integer getTus_idsettore() {
		return tus_idsettore;
	}
	public void setTus_idsettore(Integer tus_idsettore) {
		this.tus_idsettore = tus_idsettore;
	}
	public Integer getTus_idufficio() {
		return tus_idufficio;
	}
	public void setTus_idufficio(Integer tus_idufficio) {
		this.tus_idufficio = tus_idufficio;
	}
	public String getTus_nome() {
		return tus_nome;
	}
	public void setTus_nome(String tus_nome) {
		this.tus_nome = tus_nome;
	}
	public String getTus_psw() {
		return tus_psw;
	}
	public void setTus_psw(String tus_psw) {
		this.tus_psw = tus_psw;
	}
	public String getTus_tuttisettori() {
		return tus_tuttisettori;
	}
	public void setTus_tuttisettori(String tus_tuttisettori) {
		this.tus_tuttisettori = tus_tuttisettori;
	}
	public Integer getTus_userid() {
		return tus_userid;
	}
	public void setTus_userid(Integer tus_userid) {
		this.tus_userid = tus_userid;
	}
	public String getTus_utente() {
		return tus_utente;
	}
	public void setTus_utente(String tus_utente) {
		this.tus_utente = tus_utente;
	}
	
	
	
	
	
}

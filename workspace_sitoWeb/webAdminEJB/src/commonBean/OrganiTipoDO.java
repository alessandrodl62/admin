package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_organixtipo")
public class OrganiTipoDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer txo_id;

	private Integer txo_idorgano;
	private Integer txo_tipoorg;
	private Integer txo_numord;
	private String	txo_ruolo;
	private String	telappunt;
	private Integer txo_idsubgroup;
	private Integer txo_idsupplente;
	private Integer txo_nummembri;
	private String	txo_url_simbolo;
	
	
	public Integer getTxo_id() {
		return txo_id;
	}
	
	public String getTelappunt() {
		return telappunt;
	}
	public void setTelappunt(String telappunt) {
		this.telappunt = telappunt;
	}
	public Integer getTxo_idorgano() {
		return txo_idorgano;
	}
	public void setTxo_idorgano(Integer txo_idorgano) {
		this.txo_idorgano = txo_idorgano;
	}
	public Integer getTxo_idsubgroup() {
		return txo_idsubgroup;
	}
	public void setTxo_idsubgroup(Integer txo_idsubgroup) {
		this.txo_idsubgroup = txo_idsubgroup;
	}
	public Integer getTxo_idsupplente() {
		return txo_idsupplente;
	}
	public void setTxo_idsupplente(Integer txo_idsupplente) {
		this.txo_idsupplente = txo_idsupplente;
	}
	public Integer getTxo_nummembri() {
		return txo_nummembri;
	}
	public void setTxo_nummembri(Integer txo_nummembri) {
		this.txo_nummembri = txo_nummembri;
	}
	public Integer getTxo_numord() {
		return txo_numord;
	}
	public void setTxo_numord(Integer txo_numord) {
		this.txo_numord = txo_numord;
	}
	public String getTxo_ruolo() {
		return txo_ruolo;
	}
	public void setTxo_ruolo(String txo_ruolo) {
		this.txo_ruolo = txo_ruolo;
	}
	public Integer getTxo_tipoorg() {
		return txo_tipoorg;
	}
	public void setTxo_tipoorg(Integer txo_tipoorg) {
		this.txo_tipoorg = txo_tipoorg;
	}
	public String getTxo_url_simbolo() {
		return txo_url_simbolo;
	}
	public void setTxo_url_simbolo(String txo_url_simbolo) {
		this.txo_url_simbolo = txo_url_simbolo;
	}
	
}

/*
 * Created on 15/apr/08 by alessandrodl
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
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
@Table(name="t_tipopubbl")
@NamedQueries({@NamedQuery(name="TipoPubbliProxy.selectAll",query="select tpub from TipoPubbliProxy tpub order by tpub.ttp_descr"),
	           @NamedQuery(name="TipoPubbliProxy.selectByDescr",query="select tpub from TipoPubbliProxy tpub WHERE UPPER(tpub.ttp_descr) LIKE :desc  order by tpub.ttp_descr")	
})
public class TipoPubbliProxy implements Serializable {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ttp_id;
    
    private String ttp_descr;
    
    private String ttp_pathdestinazione;
    
    private String ttp_tipo;
    
    private String  ttp_flnews;
    private Integer ttp_numord;
    private String  ttp_flattiv;
    private String  ttp_fldatascad;
    private String  ttp_suser;
    private String  ttp_user;
    private String  ttp_fllotus;
    private String  ttp_camponatto;
    private String  ttp_campodatto;
    private String  ttp_tipoattolotus;
    private Integer ttp_idini;
    private String  ttp_flalbo; 
    private Integer ttp_ggalbo;

    private String  ttp_testo; 
    
	public String getTtp_descr() {
		return ttp_descr;
	}

	public void setTtp_descr(String ttp_descr) {
		this.ttp_descr = ttp_descr;
	}

	public Integer getTtp_id() {
		return ttp_id;
	}

	public void setTtp_id(Integer ttp_id) {
		this.ttp_id = ttp_id;
	}

	public String getTtp_pathdestinazione() {
		return ttp_pathdestinazione;
	}

	public void setTtp_pathdestinazione(String ttp_pathdestinazione) {
		this.ttp_pathdestinazione = ttp_pathdestinazione;
	}

	public String getTtp_tipo() {
		return ttp_tipo;
	}

	public void setTtp_tipo(String ttp_tipo) {
		this.ttp_tipo = ttp_tipo;
	}

	public String getTtp_campodatto() {
		return ttp_campodatto;
	}

	public void setTtp_campodatto(String ttp_campodatto) {
		this.ttp_campodatto = ttp_campodatto;
	}

	public String getTtp_camponatto() {
		return ttp_camponatto;
	}

	public void setTtp_camponatto(String ttp_camponatto) {
		this.ttp_camponatto = ttp_camponatto;
	}

	public String getTtp_flalbo() {
		return ttp_flalbo;
	}

	public void setTtp_flalbo(String ttp_flalbo) {
		this.ttp_flalbo = ttp_flalbo;
	}

	public String getTtp_flattiv() {
		return ttp_flattiv;
	}

	public void setTtp_flattiv(String ttp_flattiv) {
		this.ttp_flattiv = ttp_flattiv;
	}

	public String getTtp_fldatascad() {
		return ttp_fldatascad;
	}

	public void setTtp_fldatascad(String ttp_fldatascad) {
		this.ttp_fldatascad = ttp_fldatascad;
	}

	public String getTtp_fllotus() {
		return ttp_fllotus;
	}

	public void setTtp_fllotus(String ttp_fllotus) {
		this.ttp_fllotus = ttp_fllotus;
	}

	public String getTtp_flnews() {
		return ttp_flnews;
	}

	public void setTtp_flnews(String ttp_flnews) {
		this.ttp_flnews = ttp_flnews;
	}

	public Integer getTtp_ggalbo() {
		return ttp_ggalbo;
	}

	public void setTtp_ggalbo(Integer ttp_ggalbo) {
		this.ttp_ggalbo = ttp_ggalbo;
	}

	public Integer getTtp_idini() {
		return ttp_idini;
	}

	public void setTtp_idini(Integer ttp_idini) {
		this.ttp_idini = ttp_idini;
	}

	public Integer getTtp_numord() {
		return ttp_numord;
	}

	public void setTtp_numord(Integer ttp_numord) {
		this.ttp_numord = ttp_numord;
	}

	public String getTtp_suser() {
		return ttp_suser;
	}

	public void setTtp_suser(String ttp_suser) {
		this.ttp_suser = ttp_suser;
	}

	public String getTtp_tipoattolotus() {
		return ttp_tipoattolotus;
	}

	public void setTtp_tipoattolotus(String ttp_tipoattolotus) {
		this.ttp_tipoattolotus = ttp_tipoattolotus;
	}

	public String getTtp_user() {
		return ttp_user;
	}

	public void setTtp_user(String ttp_user) {
		this.ttp_user = ttp_user;
	}

	public String getTtp_testo() {
		return ttp_testo;
	}

	public void setTtp_testo(String ttp_testo) {
		this.ttp_testo = ttp_testo;
	}

    
  
    
}

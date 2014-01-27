package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_sedi")
public class SediDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tsd_id;
	private String	tsd_descr;
	private Integer	tsd_idvia;
	private Integer	tsd_civico;
	private String	tsd_subciv;
	private String	tsd_linkcarto;
	private	String	tsd_urlimm;
	private String	tsd_urlimmdett;
	private String	tsd_tuttocitt;
	
	
	public Integer getTsd_id() {
		return tsd_id;
	}
	
	public Integer getTsd_civico() {
		return tsd_civico;
	}
	public void setTsd_civico(Integer tsd_civico) {
		this.tsd_civico = tsd_civico;
	}
	public String getTsd_descr() {
		return tsd_descr;
	}
	public void setTsd_descr(String tsd_descr) {
		this.tsd_descr = tsd_descr;
	}
	public Integer getTsd_idvia() {
		return tsd_idvia;
	}
	public void setTsd_idvia(Integer tsd_idvia) {
		this.tsd_idvia = tsd_idvia;
	}
	public String getTsd_linkcarto() {
		return tsd_linkcarto;
	}
	public void setTsd_linkcarto(String tsd_linkcarto) {
		this.tsd_linkcarto = tsd_linkcarto;
	}
	public String getTsd_subciv() {
		return tsd_subciv;
	}
	public void setTsd_subciv(String tsd_subciv) {
		this.tsd_subciv = tsd_subciv;
	}
	public String getTsd_tuttocitt() {
		return tsd_tuttocitt;
	}
	public void setTsd_tuttocitt(String tsd_tuttocitt) {
		this.tsd_tuttocitt = tsd_tuttocitt;
	}
	public String getTsd_urlimm() {
		return tsd_urlimm;
	}
	public void setTsd_urlimm(String tsd_urlimm) {
		this.tsd_urlimm = tsd_urlimm;
	}
	public String getTsd_urlimmdett() {
		return tsd_urlimmdett;
	}
	public void setTsd_urlimmdett(String tsd_urlimmdett) {
		this.tsd_urlimmdett = tsd_urlimmdett;
	}
	
	
	
	

}

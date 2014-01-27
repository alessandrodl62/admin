package intraweb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_linkpubblicazioni")
@NamedQueries({@NamedQuery(name="LinkPubblicazioniWebiProxy.selectByPubbl",query="select lnpw from LinkPubblicazioniWebiProxy lnpw where lnpw.tlp_idpubbl = :id  order by lnpw.tlp_titolo"),
	           @NamedQuery(name="LinkPubblicazioniWebiProxy.selectByVisto",query="select lnpw from LinkPubblicazioniWebiProxy lnpw where lnpw.tlp_flone = 'Y' and lnpw.tlp_idpubbl = :id  order by lnpw.tlp_titolo")
              })
public class LinkPubblicazioniWebiProxy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tlp_id;
	
	private Integer tlp_idpubbl;
	
	private String  tlp_url;
	
	private String  tlp_titolo;
	private String  tlp_nomefile;
	
	private String  tlp_flone;
	
	@Transient
	private Integer tlp_user;
	
	public Integer getTlp_id() {
		return tlp_id;
	}
	public void setTlp_id(Integer tlp_id) {
		this.tlp_id = tlp_id;
	}
	public Integer getTlp_idpubbl() {
		return tlp_idpubbl;
	}
	public void setTlp_idpubbl(Integer tlp_idpubbl) {
		this.tlp_idpubbl = tlp_idpubbl;
	}
	public String getTlp_nomefile() {
		return tlp_nomefile;
	}
	public void setTlp_nomefile(String tlp_nomefile) {
		this.tlp_nomefile = tlp_nomefile;
	}
	public String getTlp_titolo() {
		return tlp_titolo;
	}
	public void setTlp_titolo(String tlp_titolo) {
		this.tlp_titolo = tlp_titolo;
	}
	public String getTlp_url() {
		return tlp_url;
	}
	public void setTlp_url(String tlp_url) {
		this.tlp_url = tlp_url;
	}
	public Integer getTlp_user() {
		return tlp_user;
	}
	public void setTlp_user(Integer tlp_user) {
		this.tlp_user = tlp_user;
	}
	public String getTlp_flone() {
		return tlp_flone;
	}
	public void setTlp_flone(String tlp_flone) {
		this.tlp_flone = tlp_flone;
	}
	
	
	
	
	
}

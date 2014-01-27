package intraweb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_linkpratiche")
@NamedQuery(name="LinkPraticheWebiProxy.selectAll",query="select lnkw from LinkPraticheWebiProxy lnkw order by lnkw.prl_titolo")
public class LinkPraticheWebiProxy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer prl_id;
	
	private String  prl_url;
	
	private String  prl_nomefile;
	private String  prl_titolo;
	
	
	@Transient
	private Integer prp_id;
	
	public Integer getPrl_id() {
		return prl_id;
	}
	public void setPrl_id(Integer prl_id) {
		this.prl_id = prl_id;
	}
	public String getPrl_nomefile() {
		return prl_nomefile;
	}
	public void setPrl_nomefile(String prl_nomefile) {
		this.prl_nomefile = prl_nomefile;
	}
	public String getPrl_titolo() {
		return prl_titolo;
	}
	public void setPrl_titolo(String prl_titolo) {
		this.prl_titolo = prl_titolo;
	}
	public String getPrl_url() {
		return prl_url;
	}
	public void setPrl_url(String prl_url) {
		this.prl_url = prl_url;
	}
	public Integer getPrp_id() {
		return prp_id;
	}
	public void setPrp_id(Integer prp_id) {
		this.prp_id = prp_id;
	}
	
	
	
	
}

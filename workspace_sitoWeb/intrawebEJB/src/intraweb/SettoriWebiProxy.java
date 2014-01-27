package intraweb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_settori")
@NamedQueries({@NamedQuery(name="SettoriWebiProxy.selectById",query="select setweb from SettoriWebiProxy setweb where setweb.tse_id = :id"),
		       @NamedQuery(name="SettoriWebiProxy.selectAll",query="select setweb from SettoriWebiProxy setweb order by tse_descr")
		      }) 
public class SettoriWebiProxy implements Serializable {

	@Id
	private Integer tse_id;
	
	private String tse_descr;


	public Integer getTse_id() {
		return tse_id;
	}

	public void setTse_id(Integer tse_id) {
		this.tse_id = tse_id;
	}

	public String getTse_descr() {
		return tse_descr;
	}

	public void setTse_descr(String tse_descr) {
		this.tse_descr = tse_descr;
	}
	
}

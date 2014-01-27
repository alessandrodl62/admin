package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_settori")
public class SettoriDO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tse_id;
	private String	tse_descr;
	
	public Integer getTse_id() {
		return tse_id;
	}
		
	public String getTse_descr() {
		return tse_descr;
	}
	public void setTse_descr(String tse_descr) {
		this.tse_descr = tse_descr;
	}
	
	
	
	
}

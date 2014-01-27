package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_tipoorg")
public class TipoOrgDO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tto_id;
	private String 	tto_descr;
	
	
	public Integer getTto_id() {
		return tto_id;
	}
	
	public String getTto_descr() {
		return tto_descr;
	}
	public void setTto_descr(String tto_descr) {
		this.tto_descr = tto_descr;
	}
	
}

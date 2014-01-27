package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_referati")
public class ReferatiDO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tre_id;
	
	private Integer tre_idorgxtipo;
	private String	tre_descr;
	private Integer tre_numord;
	
	
	public Integer getTre_id() {
		return tre_id;
	}
	
	public String getTre_descr() {
		return tre_descr;
	}
	public void setTre_descr(String tre_descr) {
		this.tre_descr = tre_descr;
	}
	public Integer getTre_idorgxtipo() {
		return tre_idorgxtipo;
	}
	public void setTre_idorgxtipo(Integer tre_idorgxtipo) {
		this.tre_idorgxtipo = tre_idorgxtipo;
	}
	public Integer getTre_numord() {
		return tre_numord;
	}
	public void setTre_numord(Integer tre_numord) {
		this.tre_numord = tre_numord;
	}
	
	
	
}

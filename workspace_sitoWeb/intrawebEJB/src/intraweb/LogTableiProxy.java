package intraweb;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="log_table")
@NamedQuery(name="LogTableiProxy.selectByPubbl",query="select logt from LogTableiProxy logt where logt.id_pubbl = :id")
public class LogTableiProxy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_log;
	
	private Integer id_pubbl;
	private Integer id_user;
	
	//private Timestamp  date_modify; 
	
	private String  desc_event;
	
	@Transient
	private String desc_user;



/*	public Timestamp getDate_modify() {
		return date_modify;
	}
 
	public void setDate_modify(Timestamp date_modify) {
		this.date_modify = date_modify;
	} */



	public String getDesc_event() {
		return desc_event;
	}



	public void setDesc_event(String desc_event) {
		this.desc_event = desc_event;
	}



	public String getDesc_user() {
		return desc_user;
	}



	public void setDesc_user(String desc_user) {
		this.desc_user = desc_user;
	}



	public Integer getId_log() {
		return id_log;
	}



	public void setId_log(Integer id_log) {
		this.id_log = id_log;
	}



	public Integer getId_pubbl() {
		return id_pubbl;
	}



	public void setId_pubbl(Integer id_pubbl) {
		this.id_pubbl = id_pubbl;
	}



	public Integer getId_user() {
		return id_user;
	}



	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	
	
	
	
	
}

package intraweb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_masterurl")
@NamedQuery(name="MasterUrlWebiProxy.selectByOnline",query="select murweb from MasterUrlWebiProxy murweb where murweb.tmu_online = 'Y'")
public class MasterUrlWebiProxy implements Serializable {

	@Id
	private Integer tmu_id;
	
	private String tmu_user;
	private String tmu_psw;
	private String tmu_host;
	private Integer tmu_porta;
	private String tmu_online;
	
	private String tmu_homepage;
	private String tmu_pathftp;
	private String tmu_pathpratiche;
	
	public String getTmu_homepage() {
		return tmu_homepage;
	}
	public void setTmu_homepage(String tmu_homepage) {
		this.tmu_homepage = tmu_homepage;
	}
	public String getTmu_host() {
		return tmu_host;
	}
	public void setTmu_host(String tmu_host) {
		this.tmu_host = tmu_host;
	}
	public Integer getTmu_id() {
		return tmu_id;
	}
	public void setTmu_id(Integer tmu_id) {
		this.tmu_id = tmu_id;
	}
	public String getTmu_pathftp() {
		return tmu_pathftp;
	}
	public void setTmu_pathftp(String tmu_pathftp) {
		this.tmu_pathftp = tmu_pathftp;
	}
	public String getTmu_pathpratiche() {
		return tmu_pathpratiche;
	}
	public void setTmu_pathpratiche(String tmu_pathpratiche) {
		this.tmu_pathpratiche = tmu_pathpratiche;
	}
	public Integer getTmu_porta() {
		return tmu_porta;
	}
	public void setTmu_porta(Integer tmu_porta) {
		this.tmu_porta = tmu_porta;
	}
	public String getTmu_psw() {
		return tmu_psw;
	}
	public void setTmu_psw(String tmu_psw) {
		this.tmu_psw = tmu_psw;
	}
	public String getTmu_user() {
		return tmu_user;
	}
	public void setTmu_user(String tmu_user) {
		this.tmu_user = tmu_user;
	}
	public String getTmu_online() {
		return tmu_online;
	}
	public void setTmu_online(String tmu_online) {
		this.tmu_online = tmu_online;
	}
	
	
	
}

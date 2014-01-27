/*
 * Created on 28/ott/2013 by alessandrodl
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.annotation.*;
import javax.persistence.*;

@Entity
@Table(name="t_organi")
@NamedQuery(name="OrganiDO.selectAll", query="SELECT org FROM OrganiDO org ORDER BY org.tor_denom")
public class OrganiDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer	tor_id;
	
	private String tor_denom;
	private String tor_mail;
	private String tor_urlfoto;
	private String tor_suppl;
	private String tor_schedapers;
	
	
	public Integer getTor_id() {
		return tor_id;
	}
	
	public String getTor_denom() {
		return tor_denom;
	}
	public void setTor_denom(String tor_denom) {
		this.tor_denom = tor_denom;
	}
	public String getTor_mail() {
		return tor_mail;
	}
	public void setTor_mail(String tor_mail) {
		this.tor_mail = tor_mail;
	}
	public String getTor_schedapers() {
		return tor_schedapers;
	}
	public void setTor_schedapers(String tor_schedapers) {
		this.tor_schedapers = tor_schedapers;
	}
	public String getTor_suppl() {
		return tor_suppl;
	}
	public void setTor_suppl(String tor_suppl) {
		this.tor_suppl = tor_suppl;
	}
	public String getTor_urlfoto() {
		return tor_urlfoto;
	}
	public void setTor_urlfoto(String tor_urlfoto) {
		this.tor_urlfoto = tor_urlfoto;
	}
	
	

}

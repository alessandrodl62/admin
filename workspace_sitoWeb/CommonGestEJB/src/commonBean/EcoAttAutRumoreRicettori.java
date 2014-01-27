/*
 * Created on 28/lug/08 by alessandrodl
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
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="EcoAttAutRumoreRicettori.selectByDescrizione", query="SELECT autr FROM EcoAttAutRumoreRicettori autr WHERE autr.descrizione = :descrizione AND autr.distanza = :distanza")
//@Table(name="ecoattautrumorericettori")
public class EcoAttAutRumoreRicettori implements Serializable {
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idricettore;
    
    
    @ManyToOne
    @JoinColumn(name="idautorizza")
    private EcoAttAutRumore autrumore;
    
    
    private String	descrizione;
    
    private String	distanza;
    
    private String	classe;

//    public EcoAttAutRumoreRicettori(String descrizione, String distanza, String classe){
//    	
//    	this.descrizione = descrizione;
//    	this.distanza = distanza;
//    	this.classe = classe;
//    	
//    }

     

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDistanza() {
		return distanza;
	}

	public void setDistanza(String distanza) {
		this.distanza = distanza;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}


	public EcoAttAutRumore getAutrumore() {
		return autrumore;
	}


	public void setAutrumore(EcoAttAutRumore autrumore) {
		this.autrumore = autrumore;
	}



	public Integer getIdricettore() {
		return idricettore;
	}



	public void setIdricettore(Integer idricettore) {
		this.idricettore = idricettore;
	}
    
  
  

}

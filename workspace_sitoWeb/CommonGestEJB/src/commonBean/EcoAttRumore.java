/*
 * Created on 06/mag/08 by alessandrodl
 *
 * * This program is free software; you can redistribute it and/or modify
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
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */


package commonBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class EcoAttRumore implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer       idrumore;
  
  @ManyToOne
  @JoinColumn(name="idattivita")
  private Attivita  attivita;

  private Integer       idprocedure;
  private Date          datainizio;
  private Integer       iddocproc;
  private boolean       emissione;
  private boolean       valutazione;
  private String        contromisure;
  
  
//  @OneToMany(mappedBy="rumore")
//  private Collection<Eco_att_rumore_sto>        rumoreSto;        
  
  
  
  public Integer getIdrumore() {
    return idrumore;
  }
  public void setIdrumore(Integer idrumore) {
    this.idrumore = idrumore;
  }
  
  
//  public Collection<Eco_att_rumore_sto> getRumoreSto() {
//    return rumoreSto;
//  }
//  public void setRumoreSto(Collection<Eco_att_rumore_sto> rumoreSto) {
//    this.rumoreSto = rumoreSto;
//  }

  
  public String getContromisure() {
    return contromisure;
  }
  public void setContromisure(String contromisure) {
    this.contromisure = contromisure;
  }
  public Date getDatainizio() {
    return datainizio;
  }
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  public boolean isEmissione() {
    return emissione;
  }
  public void setEmissione(boolean emissione) {
    this.emissione = emissione;
  }

  
  public Attivita getAttivita() {
    return attivita;
  }
  public void setAttivita(Attivita attivita) {
    this.attivita = attivita;
  }
  
  
  public Integer getIddocproc() {
    return iddocproc;
  }
  public void setIddocproc(Integer iddocproc) {
    this.iddocproc = iddocproc;
  }
  public Integer getIdprocedure() {
    return idprocedure;
  }
  public void setIdprocedure(Integer idprocedure) {
    this.idprocedure = idprocedure;
  }
  public boolean isValutazione() {
    return valutazione;
  }
  public void setValutazione(boolean valutazione) {
    this.valutazione = valutazione;
  }
  
  
}

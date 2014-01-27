/*
 * Created on 29/lug/08 by alessandrodl
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="anagprofessioni")
@NamedQuery(name="AnagProfBasicProxy.selectByIdAdresse", query="SELECT ap FROM AnagProfBasicProxy ap WHERE ap.idAdresse = :idAdresse ORDER BY titolo")
public class AnagProfBasicProxy {

  
  @Id
  private Integer     idAnagProf;
  
  private Integer       idAdresse;
  
  //numero iscrizione Ordine/collegio
  private String      numOrdine;  
  
  //titolo professionale
  private String      titolo;  
  
  //campo contenente informazioni personalizzate in base alla verticalizzazione implementata
  @Column(length=3200)
  private String      ext_data;

  
  
  public String getExt_data() {
    return ext_data;
  }

  public void setExt_data(String ext_data) {
    this.ext_data = ext_data;
  }

  public Integer getIdAnagProf() {
    return idAnagProf;
  }

  public void setIdAnagProf(Integer idAnagProf) {
    this.idAnagProf = idAnagProf;
  }

  public String getNumOrdine() {
    return numOrdine;
  }

  public void setNumOrdine(String numOrdine) {
    this.numOrdine = numOrdine;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public Integer getIdAdresse() {
    return idAdresse;
  }

  public void setIdadresse(Integer idAdresse) {
    this.idAdresse = idAdresse;
  }  
 
  
  
  
  
}

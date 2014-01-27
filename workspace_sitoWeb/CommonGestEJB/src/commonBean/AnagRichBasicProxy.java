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
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="anag_rich")
@NamedQuery(name="AnagRichBasicProxy.selectByEnte", query="SELECT ar FROM AnagRichBasicProxy ar WHERE ar.id_ente = :idente ORDER BY ragsoc")

public class AnagRichBasicProxy implements Serializable {
  
    @Id
    private Integer idAdresse;
    
    private String  ragsoc;
    private String  ragric;
    private String  note;
    private String  indir;
    private String  nciv;
    private String  localita;
    private String  cap;
    private String  nazione;
    private String  prov; 
    private String  email;
    private String  codfisc;
    private Integer id_anagrafe;
    private String  partiva;
    private Date    datanasc;
    private String  sesso;
    private String  tipo_tela;   
    private String  tipo_telb;   
    private String  telefonoa;  
    private String  telefonob;  
    
    private Integer id_ente;

    
    public String getCap() {
      return cap;
    }

    public void setCap(String cap) {
      this.cap = cap;
    }

    public String getCodfisc() {
      return codfisc;
    }

    public void setCodfisc(String codfisc) {
      this.codfisc = codfisc;
    }

    public Date getDatanasc() {
      return datanasc;
    }

    public void setDatanasc(Date datanasc) {
      this.datanasc = datanasc;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public Integer getId_anagrafe() {
      return id_anagrafe;
    }

    public void setId_anagrafe(Integer id_anagrafe) {
      this.id_anagrafe = id_anagrafe;
    }

    public Integer getId_ente() {
      return id_ente;
    }

    public void setId_ente(Integer id_ente) {
      this.id_ente = id_ente;
    }

    public Integer getIdAdresse() {
      return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
      this.idAdresse = idAdresse;
    }

    public String getIndir() {
      return indir;
    }

    public void setIndir(String indir) {
      this.indir = indir;
    }

    public String getLocalita() {
      return localita;
    }

    public void setLocalita(String localita) {
      this.localita = localita;
    }

    public String getNazione() {
      return nazione;
    }

    public void setNazione(String nazione) {
      this.nazione = nazione;
    }

    public String getNciv() {
      return nciv;
    }

    public void setNciv(String nciv) {
      this.nciv = nciv;
    }

    public String getNote() {
      return note;
    }

    public void setNote(String note) {
      this.note = note;
    }

    public String getPartiva() {
      return partiva;
    }

    public void setPartiva(String partiva) {
      this.partiva = partiva;
    }

    public String getProv() {
      return prov;
    }

    public void setProv(String prov) {
      this.prov = prov;
    }

    public String getRagric() {
      return ragric;
    }

    public void setRagric(String ragric) {
      this.ragric = ragric;
    }

    public String getRagsoc() {
      return ragsoc;
    }

    public void setRagsoc(String ragsoc) {
      this.ragsoc = ragsoc;
      this.setRagric(StringRoutine.compatta(ragsoc));
      
    }

    public String getSesso() {
      return sesso;
    }

    public void setSesso(String sesso) {
      this.sesso = sesso;
    }

    public String getTelefonoa() {
      return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
      this.telefonoa = telefonoa;
    }

    public String getTelefonob() {
      return telefonob;
    }

    public void setTelefonob(String telefonob) {
      this.telefonob = telefonob;
    }

    public String getTipo_tela() {
      return tipo_tela;
    }

    public void setTipo_tela(String tipo_tela) {
      this.tipo_tela = tipo_tela;
    }

    public String getTipo_telb() {
      return tipo_telb;
    }

    public void setTipo_telb(String tipo_telb) {
      this.tipo_telb = tipo_telb;
    }
  
  

}

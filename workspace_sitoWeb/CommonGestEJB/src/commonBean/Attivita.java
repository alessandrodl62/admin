/*
 * Created on 29/apr/08 by alessandrodl
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
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package commonBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.MapKey;

//@NamedQuery(name="Attivita.selectByRagSociale", query="SELECT at FROM Attivita at WHERE at.ragsociale LIKE :ragsociale ORDER BY ragsociale")


@NamedQueries({
    @NamedQuery(name="Attivita.selectByEnte", query="SELECT at FROM Attivita at WHERE at.id_ente = :id_ente ORDER BY ragsociale"),
	@NamedQuery(name="Attivita.selectByRagSociale", query="SELECT at FROM Attivita at WHERE at.ragsociale LIKE :ragsociale ORDER BY ragsociale"),
    @NamedQuery(name="Attivita.selectByRappLegale", query="SELECT at FROM Attivita at WHERE at.id_legrapp LIKE :id_legrapp ORDER BY id_legrapp")
})

@Entity
public class Attivita implements Serializable {
  
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer   idattivita; //Primary Key
      
      @Column
      private Integer   idanagrich; //chiave esterna con anagrich - dati principali persona giuridica
      
      @OneToOne
      @JoinColumn(name="idanagrich", updatable=false, insertable=false)
      private AnagRichBasicProxy anagrafica;
      
      private String    ragsociale; //ragione sociale attività
      
      /**
       * Chiave tra attività principale ed unità locali.
       * Attività principale ha valore 0, unità locali hanno valore del campo 'idattivita' dell'attività principale
       */
      private Integer   attivitalocale;
      
      private Integer   id_ente;

      private Integer   idprocedure;  //ultimo procedimento che ha gestito l'attività  
     
      
      @Column      
      private Integer   id_legrapp;   //legale rappresentante della ditta - chiave con anagrafica - anagrich 
      
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="id_legrapp", updatable=false, insertable=false)
      private AnagRichBasicProxy rappresentante;
      
      
      private Integer  	codvia;
      private String	via;
      private String  	nciv;
      
      private String	cap;
      private String	citta;
      private String	codcitta;
      private String	prov;
      private String	nazione;
      private Integer	codnazione;
      
      
      private String    formagiuridica; //forma giuridica dell'attività di impresa es. societa a responsabilità limitata, società in nome colletivo, ...
      private Date      datainizio; //data iscrizione registro imprese
      private String    nrea;   //numero registro imprese

      private Integer   naddetti;
      private String    istat_principale;
      
      @CollectionOfElements(fetch = FetchType.EAGER)
      @MapKey ( columns={  @Column( nullable=false )  } )
      private Map<String,String>    istat_secondari; //json  - codici istat_secondari
      
      private String    desc_cicloprod;
      private String    note;
      
//      @Transient
//      private String	codfisc;
//      @Transient
//      private String	partiva;
//      @Transient
//      private String	legrapp;
      
//      @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="commonBean")
//      private Collection<EcoAttAutRumore>  rumoreAutorizza;
//
//      @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="commonBean")
//      private Collection<EcoAttRumore> rumore;

      
      
//      @OneToMany(fetch=FetchType.LAZY, mappedBy="commonBean")
//      private Collection<Eco_elenco_insalubri>  insalubrita;
//      
//      @OneToMany(fetch = FetchType.LAZY, mappedBy="commonBean")
//      private Collection<Eco_attivita_storico>  attivitaStorico;
      
      
//      @ManyToMany
//      @JoinTable(name="Eco_att_ot",
//                 joinColumns={@JoinColumn(name="idattivita")}, 
//                 inverseJoinColumns={@JoinColumn(name="idoggetti")}
//                 )
//      private Set<Ot_oggetti> oggettiTerr;
      
      
 
      
//      public Collection<EcoAttAutRumore> getRumoreAutorizza() {
//        if(rumoreAutorizza == null) rumoreAutorizza=new ArrayList<EcoAttAutRumore>();
//        return rumoreAutorizza;
//      }
//      public void setRumoreAutorizza(Collection<EcoAttAutRumore> rumoreAutorizza) {
//        this.rumoreAutorizza = rumoreAutorizza;
//      }
      
      //primary key
      public Integer getIdattivita() {
        return idattivita;
      }
      public void setIdattivita(Integer idattivita) {
        this.idattivita = idattivita;
      }
      
      
      public Integer getAttivitalocale() {
        return attivitalocale;
      }
      public void setAttivitalocale(Integer attivitalocale) {
        this.attivitalocale = attivitalocale;
      }
      
      
      public Date getDatainizio() {
        return datainizio;
      }
      public void setDatainizio(Date datainizio) {
        this.datainizio = datainizio;
      }
      
      
      public String getDesc_cicloprod() {
        return desc_cicloprod;
      }
      public void setDesc_cicloprod(String desc_cicloprod) {
        this.desc_cicloprod = desc_cicloprod;
      }
      public Integer getId_ente() {
        return id_ente;
      }
      public void setId_ente(Integer id_ente) {
        this.id_ente = id_ente;
      }
      
      public Integer getIdanagrich() {
        return idanagrich;
      }
      public void setIdanagrich(Integer idanagrich) {
        this.idanagrich = idanagrich;
      }
      
      //chiave esterna a tabella gestionale.procedure_type
      public Integer getIdprocedure() {
        return idprocedure;
      }
      public void setIdprocedure(Integer idprocedure) {
        this.idprocedure = idprocedure;
      }
      
      
      public String getRagsociale() {
        return ragsociale;
      }
      public void setRagsociale(String ragsociale) {
        this.ragsociale = ragsociale;
      }
      
      
      public String getIstat_principale() {
        return istat_principale;
      }
      public void setIstat_principale(String istat_principale) {
        this.istat_principale = istat_principale;
      }
 
      public Map<String, String> getIstat_secondari() {
    	if(istat_secondari==null) istat_secondari=new Hashtable<String, String>();  
        return istat_secondari;
      }
      public void setIstat_secondari(Map<String, String> istat_secondari) {
        this.istat_secondari = istat_secondari;
      }
      
      public Integer getNaddetti() {
        return naddetti;
      }
      public void setNaddetti(Integer naddetti) {
        this.naddetti = naddetti;
      }
      public String getNote() {
        return note;
      }
      public void setNote(String note) {
        this.note = note;
      }
      
      
      
      
      public String getFormagiuridica() {
        return formagiuridica;
      }
      public void setFormagiuridica(String formagiuridica) {
        this.formagiuridica = formagiuridica;
      }
      
      //numero di registro
      public String getNrea() {
        return nrea;
      }
      public void setNrea(String nrea) {
        this.nrea = nrea;
      }
 

     
      

      public Integer getId_legrapp() {
        return id_legrapp;
      }
      public void setId_legrapp(Integer id_legrapp) {
        this.id_legrapp = id_legrapp;
      }
	
      
      public Integer getCodvia() {
  			return codvia;
      }
      public void setCodvia(Integer codvia) {
  			this.codvia = codvia;
      }
      
      public String getVia() {
		return via;
	
      }
	
      public void setVia(String via) {
		this.via = via;
	
      }
	
      public String getNciv() {
		return nciv;
	
      }
	
      public void setNciv(String nciv) {
		this.nciv = nciv;
	
      }
      
      public String getCap() {
		return cap;
      }
      public void setCap(String cap) {
		this.cap = cap;
      }
      
      public String getCitta() {
		return citta;
      }
      public void setCitta(String citta) {
		this.citta = citta;
      }
      public String getCodcitta() {
		return codcitta;
      }
      public void setCodcitta(String codcitta) {
		this.codcitta = codcitta;
      }
      public String getProv() {
		return prov;
      }
      public void setProv(String prov) {
		this.prov = prov;
      }
      public String getNazione() {
		return nazione;
      }
      public void setNazione(String nazione) {
		this.nazione = nazione;
      }
      public Integer getCodnazione() {
		return codnazione;
      }
      public void setCodnazione(Integer codnazione) {
		this.codnazione = codnazione;
      }
      
      
 		
		
		public void setAnagrafica(AnagRichBasicProxy anagrafica) {
			this.anagrafica = anagrafica;
		}
		public AnagRichBasicProxy getAnagrafica() {
			return anagrafica;
		}
		
		
		public AnagRichBasicProxy getRappresentante() {
			return rappresentante;
		}
		public void setRappresentante(AnagRichBasicProxy rappresentante) {
			this.rappresentante = rappresentante;
		}
		
		
//		public String getCodfisc() {
//			return codfisc;
//		}
//		public void setCodfisc(String codfisc) {
//			this.codfisc = codfisc;
//		}
//		public String getPartiva() {
//			return partiva;
//		}
//		public void setPartiva(String partiva) {
//			this.partiva = partiva;
//		}
//		public String getLegrapp() {
//			return legrapp;
//		}
//		public void setLegrapp(String legrapp) {
//			this.legrapp = legrapp;
//		}

      
      
      //      public Collection<Eco_att_atmosfera> getAtmosfera() {
//        return atmosfera;
//      }
//      public void setAtmosfera(Collection<Eco_att_atmosfera> atmosfera){
//        this.atmosfera = atmosfera;
//      }
//      
// 
//      public Collection<Eco_att_gas> getGas() {
//        return gas;
//      }
//      public void setGas(Collection<Eco_att_gas> gas){
//        this.gas = gas;
//      }
//      
//      
//      public Collection<Eco_att_idroscarichi> getIdroscarichi() {
//        return idroscarichi;
//      }
//      public void setIdroscarichi(Collection<Eco_att_idroscarichi> idroscarichi) {
//        this.idroscarichi = idroscarichi;
//      }
//      
//      
//      public Collection<Eco_att_materie> getMaterie() {
//        return materie;
//      }
//      public void setMaterie(Collection<Eco_att_materie> materie) {
//        this.materie = materie;
//      }
//      
//      
//      public Collection<Eco_att_rifiuti> getRifiuti() {
//        return rifiuti;
//      }
//      public void setRifiuti(Collection<Eco_att_rifiuti> rifiuti) {
//        this.rifiuti = rifiuti;
//      }
//      
//      
//      
//      public Collection<EcoAttRumore> getRumore() {
//        return rumore;
//      }
//      public void setRumore(Collection<EcoAttRumore> rumore) {
//        this.rumore = rumore;
//      }

 
      
      
//      public Collection<Eco_elenco_insalubri> getInsalubrita() {
//        return insalubrita;
//      }
//      public void setInsalubrita(Collection<Eco_elenco_insalubri> insalubrita) {
//        this.insalubrita = insalubrita;
//      }
//      
//      
//      public Set<Ot_oggetti> getOggettiTerr() {
//        return oggettiTerr;
//      }
//      public void setOggettiTerr(Set<Ot_oggetti> oggettiTerr) {
//        this.oggettiTerr = oggettiTerr;
//      }
//      
//      
//      public Collection<Eco_attivita_storico> getAttivitaStorico() {
//        return attivitaStorico;
//      }
//      public void setAttivitaStorico(Collection<Eco_attivita_storico> attivitaStorico) {
//        this.attivitaStorico = attivitaStorico;
//      }
      
      

}

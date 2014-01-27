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
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;





/*
 * classe che mappa l'Autorizzazione - Nulla Osta ad attività rumorose
 */

@Entity
@Table(name="ecoattautrumore")
@NamedQueries( {
		@NamedQuery(name = "EcoAttAutRumoreProxy.selectByEnte", query = "SELECT aut FROM EcoAttAutRumoreProxy aut WHERE aut.id_ente = :id_ente"),
		@NamedQuery(name = "EcoAttAutRumoreProxy.selectByProtocollo", query = "SELECT aut FROM EcoAttAutRumoreProxy aut WHERE aut.protocollonum = :nprotocollo"),
		@NamedQuery(name = "EcoAttAutRumoreProxy.selectByAttivita", query = "SELECT aut FROM EcoAttAutRumoreProxy aut WHERE aut.idattivita = :idattivita ORDER BY idautorizza")
 })
public class EcoAttAutRumoreProxy  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idautorizza;

	// riferimento al procedimento che gestisce il nulla osta
	private Integer idprocedimento;

	// riferimento a Ente che rilascia autorizzazione
	private Integer id_ente;

	private Integer idattivita; // chiave relazione con tabella Attivita in db
								// gestionale

	@Transient
	private String  attivitaRagsoc;
	@Transient
	private String	attivitacodfisc_partiva;
	@Transient
	private String	attvitaindirizzo;
	
	
	
	private Integer idattivitalocale; // chiave relazione con tabella Attivita
										// in db gestionale - Unità Locali
	@Transient
	private String	unitLocDescr;
	@Transient
	private String	unitLocIndirizzo;

	private Integer idrichiedente; // collegamento con ProcedureAdressesProxy -
									// idAdresse relativo al richiedente
	private String 	qualificarich; // qualifica con il quale il richiedente opera
									// - es. Amministratore, socio delegato,
									// ecc...

	
	private Integer professionista; // collegamento con AnagRichProxy relativo
									// al nominativo del professionista
	@Transient
	private String	professRagsoc;
	@Transient
	private String	professIndirizzo;
	
	
	private Integer professione; // collegamneto con AnagProfessioni relativo
									// alla professione del professionista
	@Transient
	private String	professioneDescr;

	private String	ciclo;			//periodo di generazione del rumore es. diurno, serale, tutto il giorno, notturno
	
	private String 	frequenza;		//frequenza di generazione del rumore es. saltuario, continuo, discontinuo
	
	private String 	impiantooggetto; //descrizione breve dell'impianto/i oggetto della'autorizzazione

	private String	descrizioneimpianto;	//descrizione lunga degli impianti 
	
	private String	classeacusticaimp; // classificazione acustica impianto
										// (classe I, classe II, ..., classe VI)
	private String	classeacusticarec; // !!!!!!classificazione acustica
										// ricettori (classe I, classe II, ...,
										// classe VI)



//	private Integer ricettoreid;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idautorizza")
	private List<EcoAttAutRumoreRicettoriProxy> ricettori;
	
	


	@CollectionOfElements(fetch = FetchType.EAGER)
	@MapKey(columns = { @Column(nullable = false) })
	private Map<String, String> sorgenti; // json - tipo, modello, potenza
											// sonora delle sorgenti di rumore

	private String		livellosorg; // livello in db(A) del rumore presso sorgente
	private boolean 	mitigazione; // ci sono/non ci sono strutture abbattimento 
	private String		mitigaesist; // descrizione strutture abbattimento esistenti 
	private String 		mitigaprev; // descrizione strutture abbattimento previste
	private String 		livellorecett; // livello in db(A) presso recettori
	private String 		climasonoro; // clima sonoro preesistente attività
	private String		contributo; // contributo ad aumento rumorosità ambientale

	private String		limiteemissionediurno; // limite di emissione diurno
											// autorizzato
	private String		limiteemissionenotturno; // limite di emissione notturno
											// autorizzato

	private String 		limiteimmissionediurno; // limite di immissione diurno
											// autorizzato
	private String 		limiteimmissionenotturno;// limite di immissione notturno
											// autorizzato

	private String 		limitedifferenzialediurno; // limite differenziale diurno
												// autorizzato
	private String		limitedifferenzialenotturno; // limite differenziale notturno
												// autirizzato

	private Integer 	protocollonum;
	private Date 		protocollodata;

	
	
	
	
	
	public Integer getIdautorizza() {
		return idautorizza;
	}

	public void setIdautorizza(Integer idautorizza) {
		this.idautorizza = idautorizza;
	}

	public Integer getIdprocedimento() {
		return idprocedimento;
	}

	public void setIdprocedimento(Integer idprocedimento) {
		this.idprocedimento = idprocedimento;
	}



//	public Map<String, String> getRicettori() {
//		if (ricettori == null)
//			ricettori = new Hashtable<String, String>(); // Lazy inizializzazione
//		return ricettori;
//	}
//
//	public void setRicettori(Map<String, String> ricettori) {
//		this.ricettori = ricettori;
//	}

	public Integer getId_ente() {
		return id_ente;
	}

	public void setId_ente(Integer id_ente) {
		this.id_ente = id_ente;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(String frequenza) {
		this.frequenza = frequenza;
	}



	public boolean isMitigazione() {
		return mitigazione;
	}

	public void setMitigazione(boolean mitigazione) {
		this.mitigazione = mitigazione;
	}


	public Map<String, String> getSorgenti() {
		if (sorgenti == null)
			sorgenti = new Hashtable<String, String>(); // Lazy inizializzazione
		return sorgenti;
	}

	public void setSorgenti(Map<String, String> sorgenti) {
		this.sorgenti = sorgenti;
	}




	public Integer getProfessione() {
		return professione;
	}

	public void setProfessione(Integer professione) {
		this.professione = professione;
	}

	public Integer getProfessionista() {
		return professionista;
	}

	public void setProfessionista(Integer professionista) {
		this.professionista = professionista;
	}



	public Integer getIdattivita() {
		return idattivita;
	}

	public void setIdattivita(Integer idattivita) {
		this.idattivita = idattivita;
	}

	public Integer getIdattivitalocale() {
		return idattivitalocale;
	}

	public void setIdattivitalocale(Integer idattivitalocale) {
		this.idattivitalocale = idattivitalocale;
	}

	public String getQualificarich() {
		return qualificarich;
	}

	public void setQualificarich(String qualificarich) {
		this.qualificarich = qualificarich;
	}

	public Integer getIdrichiedente() {
		return idrichiedente;
	}

	public void setIdrichiedente(Integer idrichiedente) {
		this.idrichiedente = idrichiedente;
	}

	
//	public Integer getRicettoreid() {
//		return ricettoreid;
//	}
//
//	public void setRicettoreid(Integer ricettoreid) {
//		this.ricettoreid = ricettoreid;
//	}


	
	
	
	public String getImpiantooggetto() {
		return impiantooggetto;
	}

	public void setImpiantooggetto(String impiantooggetto) {
		this.impiantooggetto = impiantooggetto;
	}

	public String getDescrizioneimpianto() {
		return descrizioneimpianto;
	}

	public void setDescrizioneimpianto(String descrizioneimpianto) {
		this.descrizioneimpianto = descrizioneimpianto;
	}

	public String getClasseacusticaimp() {
		return classeacusticaimp;
	}

	public void setClasseacusticaimp(String classeacusticaimp) {
		this.classeacusticaimp = classeacusticaimp;
	}

	public String getClasseacusticarec() {
		return classeacusticarec;
	}

	public void setClasseacusticarec(String classeacusticarec) {
		this.classeacusticarec = classeacusticarec;
	}

	public String getLivellosorg() {
		return livellosorg;
	}

	public void setLivellosorg(String livellosorg) {
		this.livellosorg = livellosorg;
	}

	public String getMitigaesist() {
		return mitigaesist;
	}

	public void setMitigaesist(String mitigaesist) {
		this.mitigaesist = mitigaesist;
	}

	public String getMitigaprev() {
		return mitigaprev;
	}

	public void setMitigaprev(String mitigaprev) {
		this.mitigaprev = mitigaprev;
	}

	public String getLivellorecett() {
		return livellorecett;
	}

	public void setLivellorecett(String livellorecett) {
		this.livellorecett = livellorecett;
	}

	public String getClimasonoro() {
		return climasonoro;
	}

	public void setClimasonoro(String climasonoro) {
		this.climasonoro = climasonoro;
	}

	public String getContributo() {
		return contributo;
	}

	public void setContributo(String contributo) {
		this.contributo = contributo;
	}

	public String getLimiteemissionediurno() {
		return limiteemissionediurno;
	}

	public void setLimiteemissionediurno(String limiteemissionediurno) {
		this.limiteemissionediurno = limiteemissionediurno;
	}

	public String getLimiteemissionenotturno() {
		return limiteemissionenotturno;
	}

	public void setLimiteemissionenotturno(String limiteemissionenotturno) {
		this.limiteemissionenotturno = limiteemissionenotturno;
	}

	public String getLimiteimmissionediurno() {
		return limiteimmissionediurno;
	}

	public void setLimiteimmissionediurno(String limiteimmissionediurno) {
		this.limiteimmissionediurno = limiteimmissionediurno;
	}

	public String getLimiteimmissionenotturno() {
		return limiteimmissionenotturno;
	}

	public void setLimiteimmissionenotturno(String limiteimmissionenotturno) {
		this.limiteimmissionenotturno = limiteimmissionenotturno;
	}

	public String getLimitedifferenzialediurno() {
		return limitedifferenzialediurno;
	}

	public void setLimitedifferenzialediurno(String limitedifferenzialediurno) {
		this.limitedifferenzialediurno = limitedifferenzialediurno;
	}

	public String getLimitedifferenzialenotturno() {
		return limitedifferenzialenotturno;
	}

	public void setLimitedifferenzialenotturno(String limitedifferenzialenotturno) {
		this.limitedifferenzialenotturno = limitedifferenzialenotturno;
	}

	public Integer getProtocollonum() {
		return protocollonum;
	}

	public void setProtocollonum(Integer protocollonum) {
		this.protocollonum = protocollonum;
	}

	public Date getProtocollodata() {
		return protocollodata;
	}

	public void setProtocollodata(Date protocollodata) {
		this.protocollodata = protocollodata;
	}

	public List<EcoAttAutRumoreRicettoriProxy> getRicettori() {
		
	     if(ricettori==null) ricettori = new ArrayList<EcoAttAutRumoreRicettoriProxy>();
		
		return ricettori;
	}

	public void setRicettori(List<EcoAttAutRumoreRicettoriProxy> ricettori) {
		this.ricettori = ricettori;
	}

	public String getAttivitaRagsoc() {
		return attivitaRagsoc;
	}

	public void setAttivitaRagsoc(String attivitaRagsoc) {
		this.attivitaRagsoc = attivitaRagsoc;
	}



	public String getUnitLocDescr() {
		return unitLocDescr;
	}

	public void setUnitLocDescr(String unitLocDescr) {
		this.unitLocDescr = unitLocDescr;
	}

	public String getUnitLocIndirizzo() {
		return unitLocIndirizzo;
	}

	public void setUnitLocIndirizzo(String unitLocIndirizzo) {
		this.unitLocIndirizzo = unitLocIndirizzo;
	}

	public String getProfessRagsoc() {
		return professRagsoc;
	}

	public void setProfessRagsoc(String professRagsoc) {
		this.professRagsoc = professRagsoc;
	}

	public String getProfessIndirizzo() {
		return professIndirizzo;
	}

	public void setProfessIndirizzo(String professIndirizzo) {
		this.professIndirizzo = professIndirizzo;
	}

	public String getAttivitacodfisc_partiva() {
		return attivitacodfisc_partiva;
	}

	public void setAttivitacodfisc_partiva(String attivitacodfisc_partiva) {
		this.attivitacodfisc_partiva = attivitacodfisc_partiva;
	}

	public String getAttvitaindirizzo() {
		return attvitaindirizzo;
	}

	public void setAttvitaindirizzo(String attvitaindirizzo) {
		this.attvitaindirizzo = attvitaindirizzo;
	}

	public String getProfessioneDescr() {
		return professioneDescr;
	}

	public void setProfessioneDescr(String professioneDescr) {
		this.professioneDescr = professioneDescr;
	}

	
//    public EcoAttAutRumoreRicettori addRicettore(EcoAttAutRumoreRicettori ricettore) {
//        getRicettori().add(ricettore);
//        ricettore.setAutrumore(this);
//        return ricettore;
//    }
//    
//    
//    
//    public EcoAttAutRumoreRicettori removeRicettore(EcoAttAutRumoreRicettori ricettore) {
//    	getRicettori().remove(ricettore);
//    	ricettore.setAutrumore(null);
//        return ricettore;
//    }

	
	
}

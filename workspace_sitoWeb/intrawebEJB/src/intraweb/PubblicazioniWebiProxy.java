package intraweb;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_pubblicazioni")
@NamedQueries({@NamedQuery(name="PubblicazioniWebiProxy.selectByTipo",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_idtipo = :id and prpweb.tpu_datainizio >= :dataini order by prpweb.tpu_datainizio"),
	           @NamedQuery(name="PubblicazioniWebiProxy.selectByUtente",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_idutente <> :id"),
	           @NamedQuery(name="PubblicazioniWebiProxy.selectByPap",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_flpap = 'Y' and prpweb.tpu_flapap <> 'Y' order by prpweb.tpu_dipap"),
	           @NamedQuery(name="PubblicazioniWebiProxy.selectByApap",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_flapap = 'Y' and prpweb.tpu_dfpap >= CURRENT_DATE  order by prpweb.tpu_dipap"),
	           @NamedQuery(name="PubblicazioniWebiProxy.selectBySpap",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_flapap = 'Y' and prpweb.tpu_dfpap < CURRENT_DATE and prpweb.tpu_dipap >= :dataini order by prpweb.tpu_dipap"),
	           @NamedQuery(name="PubblicazioniWebiProxy.selectByVseg",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_flapap = 'Y' and prpweb.tpu_flvseg = :tipo and prpweb.tpu_dfpap <= CURRENT_DATE  order by prpweb.tpu_dipap"),
	           @NamedQuery(name="PubblicazioniWebiProxy.selectByList",query="select prpweb from PubblicazioniWebiProxy prpweb where prpweb.tpu_flapap = 'Y' and prpweb.tpu_dipap >= :dataini and UPPER(prpweb.tpu_titolo) LIKE :seltit order by prpweb.tpu_dipap")	           
		      }) 
public class PubblicazioniWebiProxy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tpu_id;
	
    private Integer tpu_idutente;
    private Integer tpu_idtipo;
    
    private String tpu_titolo;

    private Integer tpu_iduff;
    
    private Timestamp  tpu_datainizio;
    private Timestamp  tpu_datafine;
    
    private String tpu_controllo;
    
    private Integer tpu_numatto;
    private Timestamp tpu_dataatto;
    
    private Integer tpu_protatto;
    private Timestamp tpu_dataprotatto;
    
    private String tpu_categoria;
    private Integer tpu_idsettore;
    
    private String tpu_testo;
    private Integer tpu_lunghtesto;
    
    private String tpu_evid;
    
    private String tpu_href;
    private String tpu_dref;
    

    private String tpu_flpap;
    private String tpu_flapap;
    
    private Timestamp tpu_dipap;
    private Timestamp tpu_dfpap;
    
    private String tpu_nota;
    
    private String tpu_flvseg;
    private Timestamp tpu_dvseg;
    
    @Transient
	private ArrayList<LinkPubblicazioniWebiProxy> listaAllegati = null;
    
    
    @Transient
    private String priorita_pap;
    
    @Transient
    private String doc;
    @Transient
    private String percorso;
    
	public String getTpu_categoria() {
		return tpu_categoria;
	}

	public void setTpu_categoria(String tpu_categoria) {
		this.tpu_categoria = tpu_categoria;
	}

	public String getTpu_controllo() {
		return tpu_controllo;
	}

	public void setTpu_controllo(String tpu_controllo) {
		this.tpu_controllo = tpu_controllo;
	}

	public Timestamp getTpu_dataatto() {
		return tpu_dataatto;
	}

	public void setTpu_dataatto(Timestamp tpu_dataatto) {
		this.tpu_dataatto = tpu_dataatto;
	}

	public Timestamp getTpu_datafine() {
		return tpu_datafine;
	}

	public void setTpu_datafine(Timestamp tpu_datafine) {
		this.tpu_datafine = tpu_datafine;
	}

	public Timestamp getTpu_datainizio() {
		return tpu_datainizio;
	}

	public void setTpu_datainizio(Timestamp tpu_datainizio) {
		this.tpu_datainizio = tpu_datainizio;
	}

	public Timestamp getTpu_dataprotatto() {
		return tpu_dataprotatto;
	}

	public void setTpu_dataprotatto(Timestamp tpu_dataprotatto) {
		this.tpu_dataprotatto = tpu_dataprotatto;
	}

	public String getTpu_evid() {
		return tpu_evid;
	}

	public void setTpu_evid(String tpu_evid) {
		this.tpu_evid = tpu_evid;
	}

	public Integer getTpu_id() {
		return tpu_id;
	}

	public void setTpu_id(Integer tpu_id) {
		this.tpu_id = tpu_id;
	}

	public Integer getTpu_idsettore() {
		return tpu_idsettore;
	}

	public void setTpu_idsettore(Integer tpu_idsettore) {
		this.tpu_idsettore = tpu_idsettore;
	}

	public Integer getTpu_idutente() {
		return tpu_idutente;
	}

	public void setTpu_idutente(Integer tpu_idutente) {
		this.tpu_idutente = tpu_idutente;
	}

	public Integer getTpu_lunghtesto() {
		return tpu_lunghtesto;
	}

	public void setTpu_lunghtesto(Integer tpu_lunghtesto) {
		this.tpu_lunghtesto = tpu_lunghtesto;
	}

	public Integer getTpu_numatto() {
		return tpu_numatto;
	}

	public void setTpu_numatto(Integer tpu_numatto) {
		this.tpu_numatto = tpu_numatto;
	}

	public Integer getTpu_protatto() {
		return tpu_protatto;
	}

	public void setTpu_protatto(Integer tpu_protatto) {
		this.tpu_protatto = tpu_protatto;
	}

	public String getTpu_testo() {
		return tpu_testo;
	}

	public void setTpu_testo(String tpu_testo) {
		this.tpu_testo = tpu_testo;
	}

	public String getTpu_titolo() {
		return tpu_titolo;
	}

	public void setTpu_titolo(String tpu_titolo) {
		this.tpu_titolo = tpu_titolo;
	}

	public Integer getTpu_idtipo() {
		return tpu_idtipo;
	}

	public void setTpu_idtipo(Integer tpu_idtipo) {
		this.tpu_idtipo = tpu_idtipo;
	}

	public String getTpu_dref() {
		return tpu_dref;
	}

	public void setTpu_dref(String tpu_dref) {
		this.tpu_dref = tpu_dref;
	}

	public String getTpu_href() {
		return tpu_href;
	}

	public void setTpu_href(String tpu_href) {
		this.tpu_href = tpu_href;
	}

	public Timestamp getTpu_dfpap() {
		return tpu_dfpap;
	}

	public void setTpu_dfpap(Timestamp tpu_dfpap) {
		this.tpu_dfpap = tpu_dfpap;
	}

	public Timestamp getTpu_dipap() {
		return tpu_dipap;
	}

	public void setTpu_dipap(Timestamp tpu_dipap) {
		this.tpu_dipap = tpu_dipap;
	}

	public String getTpu_flapap() {
		return tpu_flapap;
	}

	public void setTpu_flapap(String tpu_flapap) {
		this.tpu_flapap = tpu_flapap;
	}

	public String getTpu_flpap() {
		return tpu_flpap;
	}

	public void setTpu_flpap(String tpu_flpap) {
		this.tpu_flpap = tpu_flpap;
	}

	public String getPriorita_pap() {
		return priorita_pap;
	}

	public void setPriorita_pap(String priorita_pap) {
		this.priorita_pap = priorita_pap;
	}

	public String getTpu_nota() {
		return tpu_nota;
	}

	public void setTpu_nota(String tpu_nota) {
		this.tpu_nota = tpu_nota;
	}

	public Timestamp getTpu_dvseg() {
		return tpu_dvseg;
	}

	public void setTpu_dvseg(Timestamp tpu_dvseg) {
		this.tpu_dvseg = tpu_dvseg;
	}

	public String getTpu_flvseg() {
		return tpu_flvseg;
	}

	public void setTpu_flvseg(String tpu_flvseg) {
		this.tpu_flvseg = tpu_flvseg;
	}

	public ArrayList<LinkPubblicazioniWebiProxy> getListaAllegati() {
		return listaAllegati;
	}

	public void setListaAllegati(ArrayList<LinkPubblicazioniWebiProxy> listaAllegati) {
		this.listaAllegati = listaAllegati;
	}

	public Integer getTpu_iduff() {
		return tpu_iduff;
	}

	public void setTpu_iduff(Integer tpu_iduff) {
		this.tpu_iduff = tpu_iduff;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getPercorso() {
		return percorso;
	}

	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	
}

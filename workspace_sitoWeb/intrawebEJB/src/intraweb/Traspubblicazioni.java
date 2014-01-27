package intraweb;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="t_traspubblicazioni")
@NamedQueries({@NamedQuery(name="Traspubblicazioni.selectBySoggettoUfficioNopub",query="select tra from Traspubblicazioni tra where tra.tuf_id = :id AND tra.datafree >= :dataini AND UPPER(tra.soggetto) LIKE :desc  AND tra.fpubblic = 'N'  order by tra.datafree"),
	          @NamedQuery(name="Traspubblicazioni.selectByUfficioNopub",query="select tra from Traspubblicazioni tra where tra.tuf_id = :id  AND tra.datafree >= :dataini AND tra.fpubblic = 'N' order by tra.datafree "),	
	          @NamedQuery(name="Traspubblicazioni.selectBySoggettoUfficioPub",query="select tra from Traspubblicazioni tra where tra.tuf_id = :id  AND tra.datafree >= :dataini AND UPPER(tra.soggetto) LIKE :desc  AND tra.fpubblic = 'Y'  order by tra.datafree"),
	          @NamedQuery(name="Traspubblicazioni.selectByUfficioPub",query="select tra from Traspubblicazioni tra where tra.tuf_id = :id  AND tra.datafree >= :dataini AND tra.fpubblic = 'Y' order by tra.datafree "),	
	          @NamedQuery(name="Traspubblicazioni.selectBySoggettoUfficioXpub",query="select tra from Traspubblicazioni tra where tra.tuf_id = :id  AND tra.datafree >= :dataini AND UPPER(tra.soggetto) LIKE :desc  AND tra.fpubblic = 'X'  order by tra.datafree"),
	          @NamedQuery(name="Traspubblicazioni.selectByUfficioXpub",query="select tra from Traspubblicazioni tra where tra.tuf_id = :id  AND tra.datafree >= :dataini AND tra.fpubblic = 'X' order by tra.datafree ")	
              })
public class Traspubblicazioni implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private Integer idtrasp;

	
    private Integer tuf_id;
    private String soggetto;
    private String cfpartiva;
    private String normatit;
    private String atto;
    private String progetto;
    private String contratto;
    private String linkcur;
    
    private Integer idmoda;
    private Double importo;
    private Timestamp datainizio;
    private Timestamp datafine;
    
    private Timestamp dataatto;
    private Timestamp datafree;
    private Integer   numliqui;
    private String    fpubblic;    
    private String    fl_ok;    

	@Transient
	private String modalita;
    
	@Transient
	private String ufficio;
	
	@Transient
	private String responsabile;
	
	
	
    
	public String getAtto() {
		return atto;
	}
	public void setAtto(String atto) {
		this.atto = atto;
	}
	public String getCfpartiva() {
		return cfpartiva;
	}
	public void setCfpartiva(String cfpartiva) {
		this.cfpartiva = cfpartiva;
	}
	public String getContratto() {
		return contratto;
	}
	public void setContratto(String contratto) {
		this.contratto = contratto;
	}
	public Timestamp getDatafine() {
		return datafine;
	}
	public void setDatafine(Timestamp datafine) {
		this.datafine = datafine;
	}
	public Timestamp getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(Timestamp datainizio) {
		this.datainizio = datainizio;
	}
	public Integer getIdmoda() {
		return idmoda;
	}
	public void setIdmoda(Integer idmoda) {
		this.idmoda = idmoda;
	}
	public Integer getIdtrasp() {
		return idtrasp;
	}
	public void setIdtrasp(Integer idtrasp) {
		this.idtrasp = idtrasp;
	}
	public Double getImporto() {
		return importo;
	}
	public void setImporto(Double importo) {
		this.importo = importo;
	}
	public String getLinkcur() {
		return linkcur;
	}
	public void setLinkcur(String linkcur) {
		this.linkcur = linkcur;
	}
	public String getNormatit() {
		return normatit;
	}
	public void setNormatit(String normatit) {
		this.normatit = normatit;
	}
	public String getProgetto() {
		return progetto;
	}
	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}
	public String getSoggetto() {
		return soggetto;
	}
	public void setSoggetto(String soggetto) {
		this.soggetto = soggetto;
	}
	public Integer getTuf_id() {
		return tuf_id;
	}
	public void setTuf_id(Integer tuf_id) {
		this.tuf_id = tuf_id;
	}
	public String getModalita() {
		return modalita;
	}
	public void setModalita(String modalita) {
		this.modalita = modalita;
	}
	public String getResponsabile() {
		return responsabile;
	}
	public void setResponsabile(String responsabile) {
		this.responsabile = responsabile;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public Timestamp getDataatto() {
		return dataatto;
	}
	public void setDataatto(Timestamp dataatto) {
		this.dataatto = dataatto;
	}
	public Timestamp getDatafree() {
		return datafree;
	}
	public void setDatafree(Timestamp datafree) {
		this.datafree = datafree;
	}
	public String getFpubblic() {
		return fpubblic;
	}
	public void setFpubblic(String fpubblic) {
		this.fpubblic = fpubblic;
	}
	public Integer getNumliqui() {
		return numliqui;
	}
	public void setNumliqui(Integer numliqui) {
		this.numliqui = numliqui;
	}
	public String getFl_ok() {
		return fl_ok;
	}
	public void setFl_ok(String fl_ok) {
		this.fl_ok = fl_ok;
	}
    
    
    
    
    
}

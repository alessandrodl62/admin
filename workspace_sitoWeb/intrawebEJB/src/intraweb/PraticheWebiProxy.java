package intraweb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_pratiche")
@NamedQueries({@NamedQuery(name="PraticheWebiProxy.selectByUffId",query="select praweb from PraticheWebiProxy praweb where praweb.pra_iduff = :id order by praweb.pra_nome"),
		       @NamedQuery(name="PraticheWebiProxy.selectByUffNome",query="select praweb from PraticheWebiProxy praweb where praweb.pra_iduff = :id and UPPER(praweb.pra_nome) LIKE :nome order by praweb.pra_nome")
		      }) 
public class PraticheWebiProxy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pra_id;
	
	
	private Integer pra_iduff;
	private String pra_nome;
	private String pra_descr;
	private String pra_documentaz;
	private String pra_contatto;
	private String pra_orario;
	
	private String pra_href;
	private String pra_dref;
	
	
	@Transient
	private String tars_anziano;
	@Transient
	private String tars_cittadino;
	@Transient
	private String tars_donna;
	@Transient
	private String tars_genitore;
	@Transient
	private String tars_bambino;
	@Transient
	private String tars_disabile;
	@Transient
	private String tars_immigrato;
	@Transient
	private String tars_giovane;
	@Transient
	private String tars_associazione;
	@Transient
	private String tari_casa;
	@Transient
	private String tari_averefamiglia;
	@Transient
	private String tari_averefigli;
	@Transient
	private String tari_faresport;
	@Transient
	private String tari_lavorare;
	@Transient
	private String tari_pagaretasse;
	@Transient
	private String tari_salute;
	@Transient
	private String tari_studiare;
	@Transient
	private String tari_tempolibero;
	@Transient
	private String tari_aprireattivita;
	@Transient
	private String tari_mezzotrasporto;
	
	
	// Campi della tabelle IoSono e MiInteressa (t_ariprat, t_arsprat) 
	
	public String getPra_contatto() {
		return pra_contatto;
	}
	public void setPra_contatto(String pra_contatto) {
		this.pra_contatto = pra_contatto;
	}
	public String getPra_descr() {
		return pra_descr;
	}
	public void setPra_descr(String pra_descr) {
		this.pra_descr = pra_descr;
	}
	public String getPra_documentaz() {
		return pra_documentaz;
	}
	public void setPra_documentaz(String pra_documentaz) {
		this.pra_documentaz = pra_documentaz;
	}
	public String getPra_dref() {
		return pra_dref;
	}
	public void setPra_dref(String pra_dref) {
		this.pra_dref = pra_dref;
	}
	public String getPra_href() {
		return pra_href;
	}
	public void setPra_href(String pra_href) {
		this.pra_href = pra_href;
	}
	public Integer getPra_id() {
		return pra_id;
	}
	public void setPra_id(Integer pra_id) {
		this.pra_id = pra_id;
	}
	public Integer getPra_iduff() {
		return pra_iduff;
	}
	public void setPra_iduff(Integer pra_iduff) {
		this.pra_iduff = pra_iduff;
	}
	public String getPra_nome() {
		return pra_nome;
	}
	public void setPra_nome(String pra_nome) {
		this.pra_nome = pra_nome;
	}
	public String getPra_orario() {
		return pra_orario;
	}
	public void setPra_orario(String pra_orario) {
		this.pra_orario = pra_orario;
	}
	public String getTari_aprireattivita() {
		return tari_aprireattivita;
	}
	public void setTari_aprireattivita(String tari_aprireattivita) {
		this.tari_aprireattivita = tari_aprireattivita;
	}
	public String getTari_averefamiglia() {
		return tari_averefamiglia;
	}
	public void setTari_averefamiglia(String tari_averefamiglia) {
		this.tari_averefamiglia = tari_averefamiglia;
	}
	public String getTari_averefigli() {
		return tari_averefigli;
	}
	public void setTari_averefigli(String tari_averefigli) {
		this.tari_averefigli = tari_averefigli;
	}
	public String getTari_casa() {
		return tari_casa;
	}
	public void setTari_casa(String tari_casa) {
		this.tari_casa = tari_casa;
	}
	public String getTari_faresport() {
		return tari_faresport;
	}
	public void setTari_faresport(String tari_faresport) {
		this.tari_faresport = tari_faresport;
	}
	public String getTari_lavorare() {
		return tari_lavorare;
	}
	public void setTari_lavorare(String tari_lavorare) {
		this.tari_lavorare = tari_lavorare;
	}
	public String getTari_mezzotrasporto() {
		return tari_mezzotrasporto;
	}
	public void setTari_mezzotrasporto(String tari_mezzotrasporto) {
		this.tari_mezzotrasporto = tari_mezzotrasporto;
	}
	public String getTari_pagaretasse() {
		return tari_pagaretasse;
	}
	public void setTari_pagaretasse(String tari_pagaretasse) {
		this.tari_pagaretasse = tari_pagaretasse;
	}
	public String getTari_salute() {
		return tari_salute;
	}
	public void setTari_salute(String tari_salute) {
		this.tari_salute = tari_salute;
	}
	public String getTari_studiare() {
		return tari_studiare;
	}
	public void setTari_studiare(String tari_studiare) {
		this.tari_studiare = tari_studiare;
	}
	public String getTari_tempolibero() {
		return tari_tempolibero;
	}
	public void setTari_tempolibero(String tari_tempolibero) {
		this.tari_tempolibero = tari_tempolibero;
	}
	public String getTars_anziano() {
		return tars_anziano;
	}
	public void setTars_anziano(String tars_anziano) {
		this.tars_anziano = tars_anziano;
	}
	public String getTars_associazione() {
		return tars_associazione;
	}
	public void setTars_associazione(String tars_associazione) {
		this.tars_associazione = tars_associazione;
	}
	public String getTars_bambino() {
		return tars_bambino;
	}
	public void setTars_bambino(String tars_bambino) {
		this.tars_bambino = tars_bambino;
	}
	public String getTars_cittadino() {
		return tars_cittadino;
	}
	public void setTars_cittadino(String tars_cittadino) {
		this.tars_cittadino = tars_cittadino;
	}
	public String getTars_disabile() {
		return tars_disabile;
	}
	public void setTars_disabile(String tars_disabile) {
		this.tars_disabile = tars_disabile;
	}
	public String getTars_donna() {
		return tars_donna;
	}
	public void setTars_donna(String tars_donna) {
		this.tars_donna = tars_donna;
	}
	public String getTars_genitore() {
		return tars_genitore;
	}
	public void setTars_genitore(String tars_genitore) {
		this.tars_genitore = tars_genitore;
	}
	public String getTars_giovane() {
		return tars_giovane;
	}
	public void setTars_giovane(String tars_giovane) {
		this.tars_giovane = tars_giovane;
	}
	public String getTars_immigrato() {
		return tars_immigrato;
	}
	public void setTars_immigrato(String tars_immigrato) {
		this.tars_immigrato = tars_immigrato;
	}
	


	
}

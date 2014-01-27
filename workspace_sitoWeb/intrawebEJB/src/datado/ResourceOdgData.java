package datado;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;


public class ResourceOdgData implements Serializable {

  private Integer idmember_proc;
  private Integer idresource;
  private Integer idprocedure;
  private Integer idquestion;
   
   
   private String  ragsociale;
   private String  codfiscale;
   private String  partiva;
   private Integer presenza_assenza; 
   private Integer id_user;
   private Integer idres_substitute;
   private String  indir;
   private String  nciv;
   private String  localita;
   private String  cap;
   private String  nazione;
   private String  prov;
   private String  email;
   private String  tipo_tela;
   private String  tipo_telb;
   private String  telefonoa;
   private String  telefonob;
   private Integer tipo;  // Tipo membro: 0 -  votante; 1 - ospite 
   
   private String descrizione;
   private String sostdescr;
   
   private Timestamp  date_start;
   private Time   ora_start;
   private Timestamp   date_end;
   private Time   ora_end;
   
   private String ruolo;
   
  public Integer getIdmember_proc() {
    return idmember_proc;
  }
  public void setIdmember_proc(Integer idmember_proc) {
    this.idmember_proc = idmember_proc;
  }
  public String getCap() {
    return cap;
  }
  public void setCap(String cap) {
    this.cap = cap;
  }
  public String getCodfiscale() {
    return codfiscale;
  }
  public void setCodfiscale(String codfiscale) {
    this.codfiscale = codfiscale;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Integer getId_user() {
    return id_user;
  }
  public void setId_user(Integer id_user) {
    this.id_user = id_user;
  }
  public Integer getIdprocedure() {
    return idprocedure;
  }
  public void setIdprocedure(Integer idprocedure) {
    this.idprocedure = idprocedure;
  }
  public Integer getIdquestion() {
    return idquestion;
  }
  public void setIdquestion(Integer idquestion) {
    this.idquestion = idquestion;
  }
  public Integer getIdres_substitute() {
    return idres_substitute;
  }
  public void setIdres_substitute(Integer idres_substitute) {
    this.idres_substitute = idres_substitute;
  }
  public Integer getIdresource() {
    return idresource;
  }
  public void setIdresource(Integer idresource) {
    this.idresource = idresource;
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
  public String getPartiva() {
    return partiva;
  }
  public void setPartiva(String partiva) {
    this.partiva = partiva;
  }
  public Integer getPresenza_assenza() {
    return presenza_assenza;
  }
  public void setPresenza_assenza(Integer presenza_assenza) {
    this.presenza_assenza = presenza_assenza;
  }
  public String getProv() {
    return prov;
  }
  public void setProv(String prov) {
    this.prov = prov;
  }
  public String getRagsociale() {
    return ragsociale;
  }
  public void setRagsociale(String ragsociale) {
    this.ragsociale = ragsociale;
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
  public Integer getTipo() {
    return tipo;
  }
  public void setTipo(Integer tipo) {
    this.tipo = tipo;
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
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  public Timestamp getDate_end() {
    return date_end;
  }
  public void setDate_end(Timestamp date_end) {
    this.date_end = date_end;
  }
  public Timestamp getDate_start() {
    return date_start;
  }
  public void setDate_start(Timestamp date_start) {
    this.date_start = date_start;
  }
  public Time getOra_end() {
    return ora_end;
  }
  public void setOra_end(Time ora_end) {
    this.ora_end = ora_end;
  }
  public Time getOra_start() {
    return ora_start;
  }
  public void setOra_start(Time ora_start) {
    this.ora_start = ora_start;
  }
  public String getRuolo() {
    return ruolo;
  }
  public void setRuolo(String ruolo) {
    this.ruolo = ruolo;
  }
public String getSostdescr() {
	return sostdescr;
}
public void setSostdescr(String sostdescr) {
	this.sostdescr = sostdescr;
}
  
}

package intraweb;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="db_pubblica")
@NamedQuery(name="dbpubblica.selectById",query="select dbp from dbpubblica dbp where dbp.pr_cod_prat = :id order by dbp.pr_cod_prat")
public class dbpubblica {
	
	@Id
	private Double pr_cod_prat;
	
	private String oggetto;
	private String pratica;
	private Double id_tipoproc;
	private String desc_tipoproc;
	private String id_tipoprat;
	
	private String desc_tipoprat;
	private String id_uff;
	private String desc_uff;
	private String atto;
	private String tipo_atto;
	private String doc;
	private String percorso;

    private Timestamp  data_atto;
    private Timestamp  data_doc;
    
	public String getAtto() {
		return atto;
	}
	public void setAtto(String atto) {
		this.atto = atto;
	}
	public Timestamp getData_atto() {
		return data_atto;
	}
	public void setData_atto(Timestamp data_atto) {
		this.data_atto = data_atto;
	}
	public String getDesc_tipoprat() {
		return desc_tipoprat;
	}
	public void setDesc_tipoprat(String desc_tipoprat) {
		this.desc_tipoprat = desc_tipoprat;
	}
	public String getDesc_tipoproc() {
		return desc_tipoproc;
	}
	public void setDesc_tipoproc(String desc_tipoproc) {
		this.desc_tipoproc = desc_tipoproc;
	}
	public String getDesc_uff() {
		return desc_uff;
	}
	public void setDesc_uff(String desc_uff) {
		this.desc_uff = desc_uff;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getId_tipoprat() {
		return id_tipoprat;
	}
	public void setId_tipoprat(String id_tipoprat) {
		this.id_tipoprat = id_tipoprat;
	}
	public Double getId_tipoproc() {
		return id_tipoproc;
	}
	public void setId_tipoproc(Double id_tipoproc) {
		this.id_tipoproc = id_tipoproc;
	}
	public String getId_uff() {
		return id_uff;
	}
	public void setId_uff(String id_uff) {
		this.id_uff = id_uff;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	public Double getPr_cod_prat() {
		return pr_cod_prat;
	}
	public void setPr_cod_prat(Double pr_cod_prat) {
		this.pr_cod_prat = pr_cod_prat;
	}
	public String getPratica() {
		return pratica;
	}
	public void setPratica(String pratica) {
		this.pratica = pratica;
	}
	public String getTipo_atto() {
		return tipo_atto;
	}
	public void setTipo_atto(String tipo_atto) {
		this.tipo_atto = tipo_atto;
	}
	public Timestamp getData_doc() {
		return data_doc;
	}
	public void setData_doc(Timestamp data_doc) {
		this.data_doc = data_doc;
	}

	
}

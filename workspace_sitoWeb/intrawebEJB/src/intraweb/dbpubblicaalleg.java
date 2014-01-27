package intraweb;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="db_pubblica_alleg")
@NamedQuery(name="dbpubblicaalleg.selectById",query="select dbpa from dbpubblicaalleg dbpa where dbpa.pr_cod_prat = :id order by dbpa.pr_cod_prat")
public class dbpubblicaalleg {
	
	@Id
	private Double pr_cod_prat;
	
	private String doc;
	private String percorso;

    private Timestamp  data_doc;

	public Timestamp getData_doc() {
		return data_doc;
	}

	public void setData_doc(Timestamp data_doc) {
		this.data_doc = data_doc;
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

	public Double getPr_cod_prat() {
		return pr_cod_prat;
	}

	public void setPr_cod_prat(Double pr_cod_prat) {
		this.pr_cod_prat = pr_cod_prat;
	}
    

	
}

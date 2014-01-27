package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedure_adresses")
public class ProcedureAdressesProxy implements Serializable {

	@Id
    private Integer  idprocadr;
	
    private Integer  idprocedure;
  
    private String  ragsoc;

    private String  indir;
    
    private String  nciv;
    
    private String  cap;
    
    private String  nazione;
    
    private String  email;

    private Integer  idadresse;
  
    private Integer  responsabilita;
  
	private String  codfisc;

	private String  partiva;

	private Integer  tipo;

	private Integer  tipodest;

	private String  localita;

	private String  prov;
    
    private String  ext_data;

	public String getCap() {
		return cap;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public String getEmail() {
		return email;
	}

	public Integer getIdadresse() {
		return idadresse;
	}

	public Integer getIdprocadr() {
		return idprocadr;
	}

	public Integer getIdprocedure() {
		return idprocedure;
	}

	public String getIndir() {
		return indir;
	}

	public String getLocalita() {
		return localita;
	}

	public String getNazione() {
		return nazione;
	}

	public String getNciv() {
		return nciv;
	}

	public String getPartiva() {
		return partiva;
	}

	public String getProv() {
		return prov;
	}

	public String getRagsoc() {
		return ragsoc;
	}

	public Integer getResponsabilita() {
		return responsabilita;
	}

	public Integer getTipo() {
		return tipo;
	}

	public Integer getTipodest() {
		return tipodest;
	}

    
    // campo contenente informazioni personalizzate in base alla verticalizzazione implementata
    public String getExt_data() {
      return ext_data;
    }
  
    public void setExt_data(String ext_data) {
      this.ext_data = ext_data;
    }
	
	

}

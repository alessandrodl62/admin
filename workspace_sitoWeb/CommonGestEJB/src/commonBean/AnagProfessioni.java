package commonBean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQuery(name="AnagProfessioni.selectByIdAdresse", query="SELECT ap FROM AnagProfessioni ap WHERE ap.anagrafica.idAdresse = :idAdresse ORDER BY titolo")
public class AnagProfessioni implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer         idAnagProf;
	
    //@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})   
    //crea una relazione con una tabella di cross-join per cui se cancello la riga padre non cancello la riga figlia mantenendo la relazione nella tabella di cross-join
    //Quando persisto lo faccio sia per il padre che per i figli.
    @ManyToOne
    @JoinColumn(name="idAdresse")
    private AnagRichProxy    anagrafica;
  

    public Integer getIdAnagProf() {
      return idAnagProf;
    }
    public void setIdAnagProf(Integer idAnagProf) {
      this.idAnagProf = idAnagProf;
    }
    
    
    //numero iscrizione Ordine/collegio
	private String      numOrdine;  
    
	//titolo professionale
    private String      titolo;  
    
    //campo contenente informazioni personalizzate in base alla verticalizzazione implementata
    private String      ext_data;   
    
    
    // campo contenente informazioni personalizzate in base alla verticalizzazione implementata
    public String getExt_data() {
      return ext_data;
    }
  
    public void setExt_data(String ext_data) {
      this.ext_data = ext_data;
    }

    public String getNumOrdine() {
      return numOrdine;
    }

    public void setNumOrdine(String numOrdine) {
      this.numOrdine = numOrdine;
    }

    public String getTitolo() {
      return titolo;
    }

    public void setTitolo(String titolo) {
      this.titolo = titolo;
    }

    public AnagRichProxy getAnagrafica() {
      return anagrafica;
    }

    public void setAnagrafica(AnagRichProxy anagrafica) {
      this.anagrafica = anagrafica;
    }

 
	
	

}

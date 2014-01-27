package datado;

import java.io.Serializable;
import java.sql.Timestamp;

public class PubblicazioniStatisticaData implements Serializable {
	
    private Integer tpu_idtipo;
    private String tpu_descr;
    
    private String tpu_titolo;
    private String tpu_testo;
    private String tpu_flpap;
    private String tpu_flapap;
    
    private Timestamp tpu_dipap;
    private Timestamp tpu_dfpap;
    
    private Integer tpu_ncont;
    
    
	public String getTpu_descr() {
		return tpu_descr;
	}
	public void setTpu_descr(String tpu_descr) {
		this.tpu_descr = tpu_descr;
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
	public Integer getTpu_idtipo() {
		return tpu_idtipo;
	}
	public void setTpu_idtipo(Integer tpu_idtipo) {
		this.tpu_idtipo = tpu_idtipo;
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
	public Integer getTpu_ncont() {
		return tpu_ncont;
	}
	public void setTpu_ncont(Integer tpu_ncont) {
		this.tpu_ncont = tpu_ncont;
	}
    
    	
	

}

package datado;

import java.io.Serializable;

public class ImpegnoUtenzaAnnoData implements Serializable {
	
	private Integer idprocadr;
	private Integer idadresse;
	private Integer cod_famiglia;
	
	private Integer idente;

	private Integer annoimpegno;
	
	private Double  impegnato; 
	private Double  liquidato; 
	
	private Double  impegnatofam; 
	private Double  liquidatofam;
	
	public Integer getAnnoimpegno() {
		return annoimpegno;
	}
	public void setAnnoimpegno(Integer annoimpegno) {
		this.annoimpegno = annoimpegno;
	}
	public Integer getCod_famiglia() {
		return cod_famiglia;
	}
	public void setCod_famiglia(Integer cod_famiglia) {
		this.cod_famiglia = cod_famiglia;
	}
	public Integer getIdadresse() {
		return idadresse;
	}
	public void setIdadresse(Integer idadresse) {
		this.idadresse = idadresse;
	}
	public Integer getIdente() {
		return idente;
	}
	public void setIdente(Integer idente) {
		this.idente = idente;
	}
	public Integer getIdprocadr() {
		return idprocadr;
	}
	public void setIdprocadr(Integer idprocadr) {
		this.idprocadr = idprocadr;
	}
	public Double getImpegnato() {
		return impegnato;
	}
	public void setImpegnato(Double impegnato) {
		this.impegnato = impegnato;
	}
	public Double getImpegnatofam() {
		return impegnatofam;
	}
	public void setImpegnatofam(Double impegnatofam) {
		this.impegnatofam = impegnatofam;
	}
	public Double getLiquidato() {
		return liquidato;
	}
	public void setLiquidato(Double liquidato) {
		this.liquidato = liquidato;
	}
	public Double getLiquidatofam() {
		return liquidatofam;
	}
	public void setLiquidatofam(Double liquidatofam) {
		this.liquidatofam = liquidatofam;
	} 
	
}

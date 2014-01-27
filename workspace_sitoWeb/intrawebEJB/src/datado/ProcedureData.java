package datado;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProcedureData implements Serializable {

	
	      private Integer idprocedure;
  
      
          private Integer       id_ente;                  
          private Integer       id_email;               
    
          private Integer       idprocedure_type;      
          private Long          idprocess;             
          private String        idnumerator;           
          private boolean       f_anno;                
        
          private String        oggetto;         
          private String        oggetto_res;           
          private String        anno_label;            
          private Integer       anno_procedure;
          private String        num_label;
          private Integer       num_procedure;
          private String        date_label;
          private Timestamp     date_procedure;
          private String        note;
          private Integer       cod_titolario;
          private String        cod_cat;
          private String        cod_cla;
          private Integer       anno_fas;
          private Integer       num_fas;
          private String        numsotto_fas;
          private Integer       stanza;
          private Integer       scaffale;
          private Integer       piano;
          private Integer       idmodality;
        
          private Integer       idprocedure_generator;
          private String        annogen_label;
          private Integer       anno_generator;
          private String        numgen_label;
          private Integer       num_generator;
          private String        dategen_label;
          
          private Timestamp     date_generator;
        
          private Timestamp     date_presentation;
          private Timestamp     date_loading;
          private Integer       id_userloading; 
          private Integer       id_user;
        
          private String        prot_mittente;
          private String        rif_allegati;
        
          private Integer       id_tprovv;
          private Integer       id_provv;
          private Integer       anno_provv;
          private Timestamp     date_provv;
          private Integer       num_provv;
          private String        outcome;
          private Timestamp     datestart_provv;
          private Timestamp     dateend_provv;

          private Timestamp     dateend_prev;
          private Timestamp     datepreav_end;
          private String        responsabile;
          private String        oldevent;
          
        
          private Timestamp     datestart_procedure;
          private Timestamp     dateend_procedure;
          private Integer       ggdurata;
          private boolean       annulla;
          private Timestamp     date_annulla;
          private boolean       sospesa;
          private Timestamp     date_sospesa;
          private boolean       close_procedure;
          private Timestamp     date_close;
          private Integer       id_unit;
          private String        ext_data;
          
          private String        adresses;
          private String        tipoprocedimento;
          private String        provvedimento; 
          
          
		public Integer getIdprocedure() {
            return idprocedure;
          }
          public Integer getAnno_fas() {
            return anno_fas;
          }
          public Integer getAnno_generator() {
            return anno_generator;
          }
          public String getAnno_label() {
            return anno_label;
          }
          public Integer getAnno_procedure() {
            return anno_procedure;
          }
          public Integer getAnno_provv() {
            return anno_provv;
          }
          public String getAnnogen_label() {
            return annogen_label;
          }
          public boolean isAnnulla() {
            return annulla;
          }
          public boolean isClose_procedure() {
            return close_procedure;
          }
          public String getCod_cat() {
            return cod_cat;
          }
          public String getCod_cla() {
            return cod_cla;
          }
          public Integer getCod_titolario() {
            return cod_titolario;
          }
          public Timestamp getDate_annulla() {
            return date_annulla;
          }
          public Timestamp getDate_close() {
            return date_close;
          }
          public Timestamp getDate_generator() {
            return date_generator;
          }
          public String getDate_label() {
            return date_label;
          }
          public Timestamp getDate_loading() {
            return date_loading;
          }
          public Timestamp getDate_presentation() {
            return date_presentation;
          }
          public Timestamp getDate_procedure() {
            return date_procedure;
          }
          public Timestamp getDate_provv() {
            return date_provv;
          }
          public Timestamp getDate_sospesa() {
            return date_sospesa;
          }
          public Timestamp getDateend_prev() {
            return dateend_prev;
          }
          public Timestamp getDateend_procedure() {
            return dateend_procedure;
          }
          public Timestamp getDateend_provv() {
            return dateend_provv;
          }
          public String getDategen_label() {
            return dategen_label;
          }
          public Timestamp getDatepreav_end() {
            return datepreav_end;
          }
          public Timestamp getDatestart_procedure() {
            return datestart_procedure;
          }
          public Timestamp getDatestart_provv() {
            return datestart_provv;
          }
          public String getExt_data() {
            return ext_data;
          }
          public boolean isF_anno() {
            return f_anno;
          }
          public Integer getGgdurata() {
            return ggdurata;
          }
          public Integer getId_email() {
            return id_email;
          }
          public Integer getId_ente() {
            return id_ente;
          }
          public Integer getId_provv() {
            return id_provv;
          }
          public Integer getId_tprovv() {
            return id_tprovv;
          }
          public Integer getId_unit() {
            return id_unit;
          }
          public Integer getId_user() {
            return id_user;
          }
          public Integer getId_userloading() {
            return id_userloading;
          }
          public Integer getIdmodality() {
            return idmodality;
          }
          public String getIdnumerator() {
            return idnumerator;
          }
         
          public Integer getIdprocedure_generator() {
            return idprocedure_generator;
          }
          public Integer getIdprocedure_type() {
            return idprocedure_type;
          }
          public Long getIdprocess() {
            return idprocess;
          }
          public String getNote() {
            return note;
          }
          public Integer getNum_fas() {
            return num_fas;
          }
          public Integer getNum_generator() {
            return num_generator;
          }
          public String getNum_label() {
            return num_label;
          }
          public Integer getNum_procedure() {
            return num_procedure;
          }
          public Integer getNum_provv() {
            return num_provv;
          }
          public String getNumgen_label() {
            return numgen_label;
          }
          public String getNumsotto_fas() {
            return numsotto_fas;
          }
          public String getOggetto() {
            return oggetto;
          }
          public String getOggetto_res() {
            return oggetto_res;
          }
          public String getOldevent() {
            return oldevent;
          }
          public String getOutcome() {
            return outcome;
          }
          public Integer getPiano() {
            return piano;
          }
          public String getProt_mittente() {
            return prot_mittente;
          }
          public String getResponsabile() {
            return responsabile;
          }
          public String getRif_allegati() {
            return rif_allegati;
          }
          public Integer getScaffale() {
            return scaffale;
          }
          public boolean isSospesa() {
            return sospesa;
          }
          public Integer getStanza() {
            return stanza;
          }

		public String getAdresses() {
			return adresses;
		}

		public void setAdresses(String adresses) {
			this.adresses = adresses;
		}
		public void setAnno_fas(Integer anno_fas) {
			this.anno_fas = anno_fas;
		}
		public void setAnno_generator(Integer anno_generator) {
			this.anno_generator = anno_generator;
		}
		public void setAnno_label(String anno_label) {
			this.anno_label = anno_label;
		}
		public void setAnno_procedure(Integer anno_procedure) {
			this.anno_procedure = anno_procedure;
		}
		public void setAnno_provv(Integer anno_provv) {
			this.anno_provv = anno_provv;
		}
		public void setAnnogen_label(String annogen_label) {
			this.annogen_label = annogen_label;
		}
		public void setAnnulla(boolean annulla) {
			this.annulla = annulla;
		}
		public void setClose_procedure(boolean close_procedure) {
			this.close_procedure = close_procedure;
		}
		public void setCod_cat(String cod_cat) {
			this.cod_cat = cod_cat;
		}
		public void setCod_cla(String cod_cla) {
			this.cod_cla = cod_cla;
		}
		public void setCod_titolario(Integer cod_titolario) {
			this.cod_titolario = cod_titolario;
		}
		public void setDate_annulla(Timestamp date_annulla) {
			this.date_annulla = date_annulla;
		}
		public void setDate_close(Timestamp date_close) {
			this.date_close = date_close;
		}
		public void setDate_generator(Timestamp date_generator) {
			this.date_generator = date_generator;
		}
		public void setDate_label(String date_label) {
			this.date_label = date_label;
		}
		public void setDate_loading(Timestamp date_loading) {
			this.date_loading = date_loading;
		}
		public void setDate_presentation(Timestamp date_presentation) {
			this.date_presentation = date_presentation;
		}
		public void setDate_procedure(Timestamp date_procedure) {
			this.date_procedure = date_procedure;
		}
		public void setDate_provv(Timestamp date_provv) {
			this.date_provv = date_provv;
		}
		public void setDate_sospesa(Timestamp date_sospesa) {
			this.date_sospesa = date_sospesa;
		}
		public void setDateend_prev(Timestamp dateend_prev) {
			this.dateend_prev = dateend_prev;
		}
		public void setDateend_procedure(Timestamp dateend_procedure) {
			this.dateend_procedure = dateend_procedure;
		}
		public void setDateend_provv(Timestamp dateend_provv) {
			this.dateend_provv = dateend_provv;
		}
		public void setDategen_label(String dategen_label) {
			this.dategen_label = dategen_label;
		}
		public void setDatepreav_end(Timestamp datepreav_end) {
			this.datepreav_end = datepreav_end;
		}
		public void setDatestart_procedure(Timestamp datestart_procedure) {
			this.datestart_procedure = datestart_procedure;
		}
		public void setDatestart_provv(Timestamp datestart_provv) {
			this.datestart_provv = datestart_provv;
		}
		public void setExt_data(String ext_data) {
			this.ext_data = ext_data;
		}
		public void setF_anno(boolean f_anno) {
			this.f_anno = f_anno;
		}
		public void setGgdurata(Integer ggdurata) {
			this.ggdurata = ggdurata;
		}
		public void setId_email(Integer id_email) {
			this.id_email = id_email;
		}
		public void setId_ente(Integer id_ente) {
			this.id_ente = id_ente;
		}
		public void setId_provv(Integer id_provv) {
			this.id_provv = id_provv;
		}
		public void setId_tprovv(Integer id_tprovv) {
			this.id_tprovv = id_tprovv;
		}
		public void setId_unit(Integer id_unit) {
			this.id_unit = id_unit;
		}
		public void setId_user(Integer id_user) {
			this.id_user = id_user;
		}
		public void setId_userloading(Integer id_userloading) {
			this.id_userloading = id_userloading;
		}
		public void setIdmodality(Integer idmodality) {
			this.idmodality = idmodality;
		}
		public void setIdnumerator(String idnumerator) {
			this.idnumerator = idnumerator;
		}
		public void setIdprocedure(Integer idprocedure) {
			this.idprocedure = idprocedure;
		}
		public void setIdprocedure_generator(Integer idprocedure_generator) {
			this.idprocedure_generator = idprocedure_generator;
		}
		public void setIdprocedure_type(Integer idprocedure_type) {
			this.idprocedure_type = idprocedure_type;
		}
		public void setIdprocess(Long idprocess) {
			this.idprocess = idprocess;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public void setNum_fas(Integer num_fas) {
			this.num_fas = num_fas;
		}
		public void setNum_generator(Integer num_generator) {
			this.num_generator = num_generator;
		}
		public void setNum_label(String num_label) {
			this.num_label = num_label;
		}
		public void setNum_procedure(Integer num_procedure) {
			this.num_procedure = num_procedure;
		}
		public void setNum_provv(Integer num_provv) {
			this.num_provv = num_provv;
		}
		public void setNumgen_label(String numgen_label) {
			this.numgen_label = numgen_label;
		}
		public void setNumsotto_fas(String numsotto_fas) {
			this.numsotto_fas = numsotto_fas;
		}
		public void setOggetto(String oggetto) {
			this.oggetto = oggetto;
		}
		public void setOggetto_res(String oggetto_res) {
			this.oggetto_res = oggetto_res;
		}
		public void setOldevent(String oldevent) {
			this.oldevent = oldevent;
		}
		public void setOutcome(String outcome) {
			this.outcome = outcome;
		}
		public void setPiano(Integer piano) {
			this.piano = piano;
		}
		public void setProt_mittente(String prot_mittente) {
			this.prot_mittente = prot_mittente;
		}
		public void setResponsabile(String responsabile) {
			this.responsabile = responsabile;
		}
		public void setRif_allegati(String rif_allegati) {
			this.rif_allegati = rif_allegati;
		}
		public void setScaffale(Integer scaffale) {
			this.scaffale = scaffale;
		}
		public void setSospesa(boolean sospesa) {
			this.sospesa = sospesa;
		}
		public void setStanza(Integer stanza) {
			this.stanza = stanza;
		}
		public String getTipoprocedimento() {
			return tipoprocedimento;
		}
		public void setTipoprocedimento(String tipoprocedimento) {
			this.tipoprocedimento = tipoprocedimento;
		}
		public String getProvvedimento() {
			return provvedimento;
		}
		public void setProvvedimento(String provvedimento) {
			this.provvedimento = provvedimento;
		}

	
	

}

package commonBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utenti")
public class UtentiProxy implements Serializable {

	@Id
	private Integer id_user;
	
	  private String desc_user;
	  private String e_mail;
	  private String office_phone;
	  private String office_fax;
	  private String cell1_phone;
	  private String cell2_phone;
	  private String home_phone;
	  private String job_title;
	  private String ind_interno;
	  private String title;
	  private String address;
	  private String n_civ;
	  private String locality;
	  private String posta_code;
	  private String zone_code; 
	  private String cod_fisc;
	  private String part_iva;
	  private String first_name;
	  private String last_name;

      
    public Integer getId_user() {
      return id_user;
    }
      
    public String getAddress() {
      return address;
    }
    public String getCell1_phone() {
      return cell1_phone;
    }
    public String getCell2_phone() {
      return cell2_phone;
    }
    public String getCod_fisc() {
      return cod_fisc;
    }
    public String getDesc_user() {
      return desc_user;
    }
    public String getE_mail() {
      return e_mail;
    }
    public String getFirst_name() {
      return first_name;
    }
    public String getHome_phone() {
      return home_phone;
    }

    public String getInd_interno() {
      return ind_interno;
    }
    public String getJob_title() {
      return job_title;
    }
    public String getLast_name() {
      return last_name;
    }
    public String getLocality() {
      return locality;
    }
    public String getN_civ() {
      return n_civ;
    }
    public String getOffice_fax() {
      return office_fax;
    }
    public String getOffice_phone() {
      return office_phone;
    }
    public String getPart_iva() {
      return part_iva;
    }
    public String getPosta_code() {
      return posta_code;
    }
    public String getTitle() {
      return title;
    }
    public String getZone_code() {
      return zone_code;
    }

	
}

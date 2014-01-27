/*
 * Created on 07/lug/08 by alessandrodl
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

package commonSession;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.FinderException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.LocaleBeanUtils;

import sun.text.resources.DateFormatZoneData_it;

import commonBean.AnagProfessioni;
import commonBean.AnagRichBasicProxy;
import commonBean.AnagRichProxy;
import commonBean.Attivita;
import commonBean.EcoAttAutRumore;
import commonBean.EcoAttAutRumoreProxy;
import commonBean.EcoAttAutRumoreRicettori;
import commonBean.EcoAttAutRumoreRicettoriProxy;
import converters.DateLocaleConverterCustom;
import converters.DoubleLocalConverterCustom;
import converters.IntegerLocalConverterCustom;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;




@Stateless
public class PersistAttivitaFacadeBean implements PersistAttivitaFacade {

  @PersistenceContext(unitName="gestionale") EntityManager GestionaleEm;
  @PersistenceContext(unitName="territorio") EntityManager TerritorioEm;
  
  
  
  private JsonConfig conf = new JsonConfig();
  
  
  
  /**
   * 
   */
  public PersistAttivitaFacadeBean() {
    super();
          conf.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor());
          conf.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
          conf.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor());
          conf.registerJsonValueProcessor(Time.class, new TimeJsonValueProcessor());
          
          
          ConvertUtils.register(new DateLocaleConverterCustom( Locale.ITALY,"dd.MM.yyyy"),Date.class );
          ConvertUtils.register(new DoubleLocalConverterCustom( Locale.ITALY),Double.class );
          ConvertUtils.register(new IntegerLocalConverterCustom( Locale.ITALY),Integer.class );
  }



  public Object find(Object id, Class clazz, String   unit) throws Exception {
    
    try {
     
     
    	
      EntityManager em = null;
      
      if(unit=="TerritorioEm") em = TerritorioEm;
      if(unit=="GestionaleEm") em = GestionaleEm;
     
//      if(unit.equals("GestionaleEm")) em = GestionaleEm;
//          else em = TerrEm;
      
      Object ret = em.find(clazz, id);
      
      return ret;
      
    } catch (Exception e) {
      
      throw e;
    }
    
    
  }

  

  public Boolean savePersistGest(Object obj) throws Exception {

    try {
      
      GestionaleEm.persist(obj);
      GestionaleEm.flush();
      
      return true;
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    
    return false;
    
  }

  
  
  public Boolean savePersist(Object obj) throws Exception {

    try {
      
//      TerrEm.persist(obj);
//      TerrEm.flush();

      GestionaleEm.persist(obj);
      GestionaleEm.flush();

      
      return true;
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    
    return false;
    
  }

  
  public Boolean saveMergeGest(Object obj) throws Exception {
    
    try {
      
      GestionaleEm.merge(obj);
      return true;
      
    } catch (Exception e) {
      
      e.printStackTrace();
      throw e;
      
    }
    
    
    
  }
  
  
  public Boolean saveMergeTerr(Object obj) throws Exception {
    	TerritorioEm.merge(obj);
    	return true;
  }
  
  
  public Boolean saveMergeAutRumore(String json) throws Exception {
	  
	  	Boolean nuovo = false;
	  
	  	Integer idAutorizza = null;

	  	EcoAttAutRumore autRumore = null;
	  	EcoAttAutRumoreRicettori ricettore = null;
	  	
	  	JSONObject autRumoreJson = JSONObject.fromObject(json);
	  
	  	JSONArray ricettori= autRumoreJson.getJSONArray("ricettori");
	  
		JSONArray sorgenti = null;
		JSONArray sorgentiEliminate = null;
		
		JSONArray ricettoriEliminati = null;
	  
//		System.out.println("persistence - json:  "+json);

		try {
			sorgenti = autRumoreJson.getJSONArray("sorgenti");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
		autRumoreJson.remove("sorgenti");
		
		
		try {

			sorgentiEliminate = autRumoreJson.getJSONArray("sorgentieliminate");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		autRumoreJson.remove("sorgentieliminate");
		
		try {
			ricettori = autRumoreJson.getJSONArray("ricettori");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		autRumoreJson.remove("ricettori");
		
		try {
			ricettoriEliminati = autRumoreJson.getJSONArray("ricettorieliminati");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		autRumoreJson.remove("ricettorieliminati");
		
		
		try {

			try {
				idAutorizza = new Integer(autRumoreJson.get("idautorizza").toString());
				//System.out.println("idautorizza:  "+idAutorizza);
			} catch (Exception e) {	}
			
			
			if(idAutorizza!=null){
				
				autRumore = (EcoAttAutRumore)find(idAutorizza, EcoAttAutRumore.class, "TerritorioEm");
				
				nuovo = false;
				
    			//System.out.println("autorizzazione:  "+idAutorizza);
    			
    			if(sorgentiEliminate!=null && sorgentiEliminate.size()>0){
    				
    				JSONObject sorgenteEliminataJson = null;
    				
    				for(int i=0; i<sorgentiEliminate.size(); i++){
    					//System.out.println("sorgenti eliminate: "+sorgentiEliminate.size());
    					sorgenteEliminataJson = sorgentiEliminate.getJSONObject(i);
    					//System.out.println("sorgente eliminata:  "+sorgenteEliminataJson.getString("descrsorg"));
    					autRumore.getSorgenti().remove(sorgenteEliminataJson.getString("descrsorg"));
    				}
    			}
    			
    			
    			if(ricettoriEliminati!=null && ricettoriEliminati.size()>0){
    				
    				JSONObject ricettoreEliminatoJson = null;
    				Integer idRicettoreEliminato = null;
    				
    				for(int i = 0; i<ricettoriEliminati.size(); i++){
    					ricettoreEliminatoJson = ricettoriEliminati.getJSONObject(i);
    					idRicettoreEliminato = new Integer(ricettoreEliminatoJson.getString("idricettore"));
    					delete(idRicettoreEliminato, EcoAttAutRumoreRicettori.class, "TerritorioEm");
    				
    				}
    			}
    			
			}else {
				//nuova attivita
    			//System.out.println("#### è nuovo ! ########");
    			autRumore = new EcoAttAutRumore();  
    			nuovo = true;
			}
			

//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
  
		
		try {
//			System.out.println("persistence - ante populate - ricettori:   "+ricettori.getJSONObject(0).getString("descrizione"));
			//System.out.println("persistence - ante populate - autRumoreJson ricettori:   "+ricettori.getJSONObject(0).getString("descrizione"));
		
////			System.out.println("persistence - ante populate - autRumore ricettori:   "+autRumore.getRicettori().get(0).getDescrizione());
			
//			System.out.println("persistence - ante populate - autRumoreJson ricettori:   "+autRumoreJson.get("descrizioneimpianto").toString());                  
			
//			System.out.println("persistence - ante populate - autRumoreJson json:   "+autRumoreJson.names().toString());
//			
//			JSONArray nomiArray = autRumoreJson.names();
//			JSONArray autRumoreArray = autRumoreJson.toJSONArray(nomiArray);
//			for(int i=0;i<autRumoreArray.size();i++){
//				System.out.println("nome: "+nomiArray.getString(i)+"   valore: "+autRumoreArray.getString(i));
//			
//			}
			
             
			
		} catch (Exception e) {e.printStackTrace();}
		
		
		
		
		LocaleBeanUtils.populate(autRumore, autRumoreJson);
/*		
		try {
			DateFormat   formatter = new SimpleDateFormat("dd.MM.yyyy");
			Date data = (Date)formatter.parse(autRumoreJson.get("protocollodata").toString());    
			autRumore.setProtocollodata(data);
		} catch (Exception e) {}
		autRumore.setIdattivitalocale(Integer.valueOf(autRumoreJson.get("idattivitalocale").toString()));
		autRumore.setContributo(autRumoreJson.get("contributo").toString());
		autRumore.setProfessione(Integer.valueOf(autRumoreJson.get("professione").toString()));
		autRumore.setId_ente(Integer.valueOf(autRumoreJson.get("id_ente").toString()));
		autRumore.setLimiteimmissionediurno(autRumoreJson.get("limiteimmissionediurno").toString());
		autRumore.setProfessionista(Integer.valueOf(autRumoreJson.get("professionista").toString()));
		autRumore.setMitigaesist(autRumoreJson.get("mitigaesist").toString());
		autRumore.setIdattivita(Integer.valueOf(autRumoreJson.get("idattivita").toString()));
		autRumore.setClasseacusticaimp(autRumoreJson.get("classeacusticaimp").toString());
		autRumore.setMitigaprev(autRumoreJson.get("mitigaprev").toString());
		autRumore.setLivellosorg(autRumoreJson.get("livellosorg").toString());
		autRumore.setLimiteemissionediurno(autRumoreJson.get("limiteemissionediurno").toString());
		autRumore.setClimasonoro(autRumoreJson.get("climasonoro").toString());
		autRumore.setProtocollonum(Integer.valueOf(autRumoreJson.get("protocollonum").toString()));
		autRumore.setFrequenza(autRumoreJson.get("frequenza").toString());
		autRumore.setLimiteemissionenotturno(autRumoreJson.get("limiteemissionenotturno").toString());
		autRumore.setDescrizioneimpianto(autRumoreJson.get("descrizioneimpianto").toString());
		autRumore.setCiclo(autRumoreJson.get("ciclo").toString());
		//autRumore.setIdautorizza(Integer.valueOf(autRumoreJson.get("idautorizza").toString()));
		autRumore.setImpiantooggetto(autRumoreJson.get("impiantooggetto").toString());
		autRumore.setLimiteimmissionenotturno(autRumoreJson.get("limiteimmissionenotturno").toString());
	  
*/		
		
		if(sorgenti!=null && sorgenti.size()>0){ 
			//aggiungo le nuove e modifico le esistenti
			for (int i = 0; i < sorgenti.size(); i++) {
				JSONObject sorgente =   sorgenti.getJSONObject(i);  
				autRumore.getSorgenti().put(sorgente.getString("descrsorg"), sorgente.getString("dbemissione"));
			}
		}
   		
	  
	  if(ricettori!=null){
		  //System.out.println("persistence - ricettori lunghezza array: "+ricettori.size());
		  for (int j = 0; j < ricettori.size(); j++) {
			  
			  	ricettore = null;
			  	
				JSONObject ricettoreObj =   ((JSONArray)ricettori).getJSONObject(j);
			
//				System.out.println("#######################################");
//				System.out.println("persistence - ricettore: "+ricettoreObj.getString("classe")+" - "+ricettoreObj.getString("descrizione"));	
//				System.out.println("#######################################");
				
				ricettore = new EcoAttAutRumoreRicettori();
				ricettore.setClasse(ricettoreObj.getString("classe"));
				ricettore.setDescrizione(ricettoreObj.getString("descrizione"));
				ricettore.setDistanza(ricettoreObj.getString("distanza"));
				
//				System.out.println("persistence - ricettore - fine set ");

				ricettore.setAutrumore(autRumore);
				autRumore.getRicettori().add(ricettore);
				
//				System.out.println("persistence - ricettore - fine add ");
			}
	  }

	  
//	  if(ricettoriElimina!=null){
//		  for(int i = 0; i < ((JSONArray) ricettoriElimina).size(); i++){
//			  JSONObject ricettoreElimina = ((JSONArray) ricettoriElimina).getJSONObject(i);
//			  
//			  
//		  }
//		  
//	  }
	  if(nuovo){
		  TerritorioEm.merge(autRumore);
		  //System.out.println("nuovo");
	  }		  
	  else{
		  TerritorioEm.persist(autRumore);
		  //System.out.println("esistente");
	  }
		  
	  
	  
	} catch (Exception e) {
			return false;
			//e.printStackTrace();
	}  	  
	  
	  return true;
  }
  
  
  
  public Boolean saveMerge(Object obj) throws Exception {
    
    try {
      
//      TerrEm.merge(obj);
      GestionaleEm.merge(obj);

      
      return true;
      
    } catch (RuntimeException e) {
      
      e.printStackTrace();
      
    }
    
    return false;
    
  }

  public void delete(Object id, Class clazz, String unit) throws Exception {
    
//    EntityManager em;
    EntityManager em = GestionaleEm;
    if(unit.equals("GestionaleEm")) em = GestionaleEm;
        else em = TerritorioEm;
    
    Object obj = em.find(clazz,id);
    em.remove(obj);
    em.flush();
    
    
  }

  public List resultQuery(Map<String, Object> parametri, String entityName, String unit) throws Exception {
    
//    EntityManager em;
    EntityManager em = GestionaleEm;
    
    String query = null;
    
//    if(unit.equals("GestionaleEm")) em = GestionaleEm;
//        else em = TerrEm;
    
    final StringBuilder str = new StringBuilder("SELECT xy from "+entityName+" xy  WHERE ");
    
    for(Map.Entry<String, Object> elemento : parametri.entrySet()){
      
      String s = null;
      
//      elemento.getKey();
//      elemento.getValue();
      if(elemento.getKey().equals("id_ente") || elemento.getKey().equals("attivitalocale"))
            s = " xy."+elemento.getKey()+" = "+elemento.getValue()+" AND ";
      else
//            s = " xy."+elemento.getKey()+" LIKE "+"'%"+elemento.getValue()+"%'"+" AND ";
      		s = "UPPER(xy."+elemento.getKey()+") LIKE "+"UPPER('%"+elemento.getValue()+"%')"+" AND ";      
      str.append(s);
      
    }
    
    Integer lunghezza = str.length()-5;

    query = str.toString();
    query = query.substring(0, lunghezza);
    
    //System.out.println("server - query"+query);

    Query q = em.createQuery(query);
    
    return q.getResultList();

  }


  public List resultListNativeQuery(String sql, Class clazz, Map<String, Object> parametri, String unit, String orderBy) throws Exception {
	    

    EntityManager em = GestionaleEm;
    
    String query = null;
    
//    if(unit.equals("GestionaleEm")) em = GestionaleEm;
//        else em = TerrEm;
    
    final StringBuilder str = new StringBuilder(sql + " WHERE ");

    for(Map.Entry<String, Object> elemento : parametri.entrySet()){
      
      String s = null;
      
//      elemento.getKey();
//      elemento.getValue();
      //   equals("id_ente")
      if(elemento.getKey().contains("id_ente"))
            s = elemento.getKey()+" = "+elemento.getValue()+" AND ";
      else
            s = "UPPER("+elemento.getKey()+")"+" LIKE "+"UPPER('%"+elemento.getValue()+"%')"+" AND ";
      
      str.append(s);
      
    }
    
    
    
    Integer lunghezza = str.length()-5;

    query = str.toString();
    query = query.substring(0, lunghezza) + " ORDER BY " + orderBy  ; 


    Query q = em.createNativeQuery(query,clazz);
    
    
    return q.getResultList();

  }
 

  public List resultListQueryEJBQL(String sql, Map<String, Object> parametri, String orderBy, String unit) throws Exception {
	    
    EntityManager em = null;
    
    String query = null;
    
    if(unit.equals("GestionaleEm")) em = GestionaleEm;
        else em = TerritorioEm;
    
    
    StringBuilder str = new StringBuilder(sql);
    
    if(parametri!=null){
    	str = str.append(" WHERE ");
    
	    for(Map.Entry<String, Object> elemento : parametri.entrySet()){
	      
	      String s = null;
	      //System.out.println("parametro:   ["+elemento.getKey()+" ]");

	      if(elemento.getKey().contains("id_ente") || elemento.getKey().contains("attivitalocale") ||  elemento.getKey().contains("idautorizza"))
	            s = elemento.getKey()+" = "+elemento.getValue()+" AND ";
	      else
//	            s = elemento.getKey()+" LIKE "+"'%"+elemento.getValue()+"%'"+" AND ";

	      s = " UPPER("+elemento.getKey()+") LIKE "+"UPPER('%"+elemento.getValue()+"%')"+" AND ";
	      str.append(s);
	      
	    }
	    
	}
  
    
    query = str.toString();
    Integer lunghezza = str.length()-5;

    
    if(  parametri!=null && orderBy!=null){

    	query = query.substring(0, lunghezza) + " ORDER BY " + orderBy;     	
    	
    } else if(parametri==null && orderBy!=null){
 
    	query = query + " ORDER BY " + orderBy;
    	
    } else if(parametri!=null && orderBy==null){
    	
    	query = query.substring(0,lunghezza);
    }
    
    //System.out.println("server - query:  "+query);

    Query q = em.createQuery(query);
    
    
    return q.getResultList();

  }
  
  
  
  public List resultListAutorizzaRumore(String sql, Map<String, Object> parametri, String orderBy) throws Exception {

	  
	    EntityManager emTerritorio = TerritorioEm;
	    EntityManager emGestionale = GestionaleEm;
	    
	    String query = null;
	    
//	    if(unit.equals("GestionaleEm")) em = GestionaleEm;
//	        else em = TerritorioEm;
	    
	    
	    StringBuilder str = new StringBuilder(sql);
	    
	    if(parametri!=null){
	    	str = str.append(" WHERE ");
	    
		    for(Map.Entry<String, Object> elemento : parametri.entrySet()){
		      
		      String s = null;
//		      System.out.println("parametro:   ["+elemento.getKey()+" ]");

		      if(elemento.getKey().contains("id_ente") || elemento.getKey().contains("attivitalocale") ||  elemento.getKey().contains("idprocedimento"))
		            s = elemento.getKey()+" = "+elemento.getValue()+" AND ";
		      else
		            s = elemento.getKey()+" LIKE "+"'%"+elemento.getValue()+"%'"+" AND ";
		      str.append(s);
		      
		    }
		}
	  
	    
	    query = str.toString();
	    Integer lunghezza = str.length()-5;

	    
	    if(  parametri!=null && orderBy!=null){

	    	query = query.substring(0, lunghezza) + " ORDER BY " + orderBy;     	
	    	
	    } else if(parametri==null && orderBy!=null){
	 
	    	query = query + " ORDER BY " + orderBy;
	    	
	    } else if(parametri!=null && orderBy==null){
	    	
	    	query = query.substring(0,lunghezza);
	    }
	    
//	    System.out.println("server - query:  "+query);

	
	    try {
			Query q = emTerritorio.createQuery(query);
   
			EcoAttAutRumoreProxy autorizza = (EcoAttAutRumoreProxy) q.getSingleResult();

			
//	    List<EcoAttAutRumoreRicettoriProxy>  ricettori = autorizza.getRicettori();
//	    ListIterator<EcoAttAutRumoreRicettoriProxy> iter = ricettori.listIterator();
//	    while(iter.hasNext()){
//	    	EcoAttAutRumoreRicettoriProxy ricettore = iter.next();
//	    	System.out.println("ricettore:  --- "+ricettore.getDescrizione());
//	    }
			
//	    Map<String, String> sorgenti = autorizza.getSorgenti();
//	    for(Map.Entry<String, String> elemento : sorgenti.entrySet()){
//		      String s = null;
//		      System.out.println("chiave:   ["+elemento.getKey()+" ]");
//		      System.out.println("valore:   ["+elemento.getValue()+" ]");
//	    }
			
			
			Integer idAttivita = autorizza.getIdattivita();
			//System.out.println("server - autorizza - idattivita:  "+idAttivita);
			
			 	String queryAttivita = "SELECT att FROM Attivita att WHERE idattivita = "+idAttivita;
			 	Query qAtt = emGestionale.createQuery(queryAttivita);
			 	Attivita attivita = (Attivita) qAtt.getSingleResult();
			 	
			 	
			 	
			 	autorizza.setAttivitaRagsoc(attivita.getRagsociale());
			 	autorizza.setAttvitaindirizzo(attivita.getCap()+" "+attivita.getCitta()+" - "+attivita.getVia()+", "+attivita.getNciv());
			 	
			 	try {
					Integer idAnagrich = attivita.getIdanagrich();
					
					 	String queryAnagrich = "SELECT an FROM AnagRichBasicProxy an WHERE idAdresse = "+idAnagrich;
					 	Query qAnag = emGestionale.createQuery(queryAnagrich);
					 	AnagRichBasicProxy anagrafica = (AnagRichBasicProxy) qAnag.getSingleResult();
					 	
					 						 	
					 	String partiva = "";
					 	String codfisc = "";
					 	if(anagrafica.getPartiva()!=null && !anagrafica.getPartiva().trim().equals(""))
					 		partiva = "IVA: "+anagrafica.getPartiva();

					 	if(anagrafica.getCodfisc()!=null && !anagrafica.getCodfisc().trim().equals(""))
					 		codfisc = "CF: "+anagrafica.getCodfisc();
					 						 	
					 	if(!partiva.trim().equals("") && !codfisc.trim().equals(""))
					 		autorizza.setAttivitacodfisc_partiva(partiva+" , "+codfisc);
					 	
					 	if(!partiva.trim().equals("") && codfisc.trim().equals(""))
					 		autorizza.setAttivitacodfisc_partiva(partiva);
					 	
					 	if(partiva.trim().equals("") && !codfisc.trim().equals(""))
					 		autorizza.setAttivitacodfisc_partiva(codfisc);


					 	
				} catch (Exception e1) {}
			 	
				try {
				Integer idUnitaLocale = autorizza.getIdattivitalocale();
				 	String queryUnitaLocale = "SELECT att FROM Attivita att WHERE idattivita = "+idUnitaLocale;
				 	Query qUnitaLoc = emGestionale.createQuery(queryUnitaLocale);
				 	Attivita unitaLoc = (Attivita) qUnitaLoc.getSingleResult();
				 	autorizza.setUnitLocIndirizzo(unitaLoc.getCap()+" "+unitaLoc.getCitta()+" - "+unitaLoc.getVia()+", "+unitaLoc.getNciv());
				 	autorizza.setUnitLocDescr(unitaLoc.getRagsociale());
				} catch (Exception e) {}
			 	
				 try {
					Integer idProfessionista = autorizza.getProfessionista();
					  	String queryAnagProf = "SELECT an FROM AnagRichBasicProxy an WHERE idAdresse = "+idProfessionista;
					 	Query qAnagProf = emGestionale.createQuery(queryAnagProf);
					 	AnagRichBasicProxy anagProf = (AnagRichBasicProxy) qAnagProf.getSingleResult();
					 	autorizza.setProfessRagsoc(anagProf.getRagsoc());
					 	autorizza.setProfessIndirizzo(anagProf.getCap()+" "+anagProf.getLocalita()+" - "+anagProf.getIndir()+", "+anagProf.getNciv());
				} catch (Exception e2) {}
			 	
			 	
				 try {
					Integer idProfessione = autorizza.getProfessione();
					 //System.out.println("server - idprofessione: "+idProfessione);
					  	String queryProf = "SELECT ap FROM AnagProfessioni ap WHERE idAnagProf = "+idProfessione;
					 	Query qProf = emGestionale.createQuery(queryProf);
					 	AnagProfessioni prof = (AnagProfessioni) qProf.getSingleResult();
					 	autorizza.setProfessioneDescr(prof.getTitolo());
				} catch (Exception e3) {}

			
			return q.getResultList();
			
		} catch (NoResultException e) {
			
		}
			return new ArrayList();
			
  }
  
  
  
  
  
  
  public List resultListAttivita(Map<String, Object> parametri, String entityName, String unit) throws Exception {
	  
	  EntityManager em = GestionaleEm;

//	  List anag_attivita = new ArrayList();
	  
	  
	  List attivita = resultQuery(parametri, entityName, unit);
	  
;
	  for (Iterator iter = attivita.iterator(); iter.hasNext();) {
		  
		Attivita element = (Attivita) iter.next();
		
//		anag_attivita.addAll(attivita);

//		Map<String, Object> elementMap = new HashMap<String, Object>();
//		elementMap.put("ragsociale", element.getRagsociale());
		
//		System.out.println("idanagrich:  "+element.getIdanagrich());
		
		try {
			AnagRichProxy anagrafica = (AnagRichProxy) find(element.getIdanagrich(),AnagRichProxy.class, unit);
			
//			element.setCodfisc(anagrafica.getCodfisc());
//			element.setPartiva(anagrafica.getPartiva());
//			
//			AnagRichProxy legRapp = (AnagRichProxy)find(element.getId_legrapp(),AnagRichProxy.class, unit);
//			
//			element.setLegrapp(legRapp.getRagsoc());
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	
	  }
	  
	  return attivita;
  }
  
  
  
  public List resultListQuery(String nomeQuery, Map<String, Object> parametri, String unit) throws Exception {
    
//    EntityManager em;
    EntityManager em = GestionaleEm;
    
//    if(unit.equals("GestionaleEm")) em = GestionaleEm;
//        else em = TerrEm;
    
    Query q = em.createNamedQuery(nomeQuery);
    for (String key : parametri.keySet()) {
      q.setParameter(key, parametri.get(key));
    }
    
//    System.out.println("persist: "+q);
    
    return q.getResultList();
  }



  public String jsonArrayQuery(String nomeQuery, Map<String, Object> parametri, String unit) throws Exception {
    //prendo il json creato sul server perchè l'anagrafica è caricata in modo lazy e quindi non caricherebbe tutti gli attributi come ad es. gli array delle professioni
    return JSONArray.fromObject(resultListQuery(nomeQuery, parametri, unit), conf).toString();
  }

  
  
  public String jsonArrayCreateQueryAttivita(Map<String, Object> parametri, String entityName, String unit) throws Exception {
    
	  return JSONArray.fromObject(resultListAttivita(parametri,entityName, unit), conf).toString();
	  
  }

  public String jsonArrayCreateQuery(Map<String, Object> parametri, String entityName, String unit) throws Exception {
	  
    return JSONArray.fromObject(resultQuery(parametri,entityName, unit), conf).toString();
  }
  
  
  public String jsonArrayCreateNativeQuery(String sql,Class clazz,Map<String, Object> parametri, String unit) throws Exception {	    

	  return JSONArray.fromObject(resultListNativeQuery(sql,clazz,parametri, unit,"ragsoc"), conf).toString();
    
    
  }
  
  
  public String jsonArrayCreateQueryEJBQL(String sql, Map<String, Object> parametri, String orderBy, String unit) throws Exception {	    
	    return JSONArray.fromObject(resultListQueryEJBQL(sql,parametri,orderBy, unit), conf).toString();
	  }
  
  
//  public String jsonArrayCreateQueryAutRumoreEJBQL(String sql, Map<String, Object> parametri, String orderBy, String unit) throws Exception {	    
//	    return JSONArray.fromObject(resultListAutorizzaRumore(sql,parametri,orderBy), conf).toString();
//	  }
  
  public String jsonArrayCreateQueryAutRumoreEJBQL(String sql,Map<String, Object> parametri, String orderBy) throws Exception {
		// TODO Auto-generated method stub
		try {
			return JSONArray.fromObject(resultListAutorizzaRumore(sql, parametri, orderBy), conf).toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;// TODO: handle exception
		}
		
	  }  
  
  
  //il getRefernece restituisce un oggetto composto dal solo ID, passando il parametro chiave primaria ed il nome classe
  public Object getReference(Integer id, Class clazz, String unit) throws Exception {
   try {
      
//      EntityManager em;
     EntityManager em = GestionaleEm;
     
//      if(unit.equals("GestionaleEm")) em = GestionaleEm;
//          else em = TerrEm;
      
      return em.getReference(clazz, id);
      
      
    } catch (Exception e) {
      
      throw e;
    }
    
  }


  //il getRefernece restituisce un oggetto composto dal solo ID, passando il parametro chiave primaria ed il nome classe
  public Object getReference(String id, Class clazz, String unit) throws Exception {
    
    return getReference(new Integer(id), clazz, unit);
  }


  
}

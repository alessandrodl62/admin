package ser_vlet;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.locale.LocaleBeanUtils;
import org.hibernate.type.IntegerType;

import commonBean.AnagProfBasicProxy;
import commonBean.AnagProfessioni;
import commonBean.AnagRichBasicProxy;
import commonBean.AnagRichProxy;
import commonBean.Attivita;
import commonBean.EcoAttAutRumore;
import commonBean.EcoAttAutRumoreRicettori;
import commonBean.EcoAttAutRumoreRicettoriProxy;
import commonSession.PersistAttivitaFacade;
import converters.StringRoutine;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/**
 * Servlet implementation class for Servlet: AttivitaServlet
 *
 */
 public class CommonServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
   
   private JsonConfig conf = new JsonConfig();
   
	public CommonServlet() {
		super();
        conf.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor());
        conf.registerJsonValueProcessor(Time.class, new TimeJsonValueProcessor());
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
      try {
		elaboraRequest(request, response);
      } catch (Exception e) {
    	  new ServletException(e);
  	  }
         
        System.out.println("do get servlet!!!");
        
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
		elaboraRequest(request, response);
      } catch (Exception e) {
    	  new ServletException(e);
      }
      System.out.println("do post servlet!!!");
	}   
    
    
    
    protected void elaboraRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      response.setCharacterEncoding("UTF-8");
      request.setCharacterEncoding("UTF-8");
      
      String    command = request.getPathInfo();
      
      if(command == null) command = request.getServletPath();
      
      if(command.equals("/professionisti/creadatiesempio")) creaDatiEsempio(request, response); 
      else if(command.equals("/anagrafica/getpermissions")) getUserPermissions(request, response); 
      else if (command.equals("/anagrafica/list")) anagraficaList(request, response);
      else if (command.equals("/anagrafica/salvaanag")) salvaDatiAnag(request, response);
      else if (command.equals("/professioni/list")) professioniList(request, response);
      else if (command.equals("/professioni/salvaProf")) salvaDatiProf(request, response);
      else if (command.equals("/professioni/cancelProf")) cancellaDatiProf(request, response);
      else if (command.equals("/anagrafica/anagraficaSel")) anagraficaSel(request, response);
      else if (command.equals("/anagrafica/anagraficaProfessioniSel")) anagraficaProfessioniSel(request, response);
      else if (command.equals("/anagditte/salvaAttivita")) salvaDatiAttivita(request, response);
      else if (command.equals("/anagditte/list")) attivitaList(request, response);      
      else if (command.equals("/anagditte/attivitaSel")) attivitaSel(request, response);
      else if (command.equals("/anagditte/cancelAttivita")) cancellaAttivita(request, response);       
      else if (command.equals("/anagditte/salvaAutRumore")) salvaAutRumore(request, response);
      else if (command.equals("/rumore/caricaAutRumore")) autRumoreCarica(request, response);     
      
      
      System.out.println("comando della servlet:  "+command);
      
      
    }
    
    
    private void salvaDatiNullaOsta(HttpServletRequest request, HttpServletResponse response) {
      
      PersistAttivitaFacade persistence = getPersistence(request);
      
      String frequenza  = new String(request.getParameter("frequenza"));
      String oggetto    = new String(request.getParameter("oggetto"));
      
      
    }
    
    
    
    
    
    private void creaDatiEsempio(HttpServletRequest request, HttpServletResponse response) {
      
      try {
          PersistAttivitaFacade persistence = getPersistence(request);
          
//          AnagRichProxy anagRich = new AnagRichProxy();
//          
//          anagRich.setCap("31029");
//          anagRich.setRagsoc("pinco palla");
//          anagRich.setLocalita("vittorio veneto");
//          anagRich.setNciv("44");
//          anagRich.setProv("treviso");
//          anagRich.setIndir("via galileo galilei");
//          anagRich.setId_ente(1);
//          
//          AnagProfessioni professione1 = new AnagProfessioni();
//          professione1.setNumOrdine("039461");
//          professione1.setTitolo("programmer");
//          
//          AnagProfessioni professione2 = new AnagProfessioni();
//          professione2.setNumOrdine("3702");
//          professione2.setTitolo("capomalta");
//      
//          anagRich.getProfessioni().add(professione1);
//          anagRich.getProfessioni().add(professione2);
      
          
          
   /*
    * frammento per scrivere padre e figli consecutivamente
    */
          /*
          EcoAttivita commonBean = new EcoAttivita();
          commonBean.setNrea("numero5206791");
          commonBean.setNaddetti(100);
          commonBean.setRagsociale("ditta fa e desfa");
          //salvo padre
          persistence.savePersist(commonBean);
          
          EcoAttAutRumore autorizza = new EcoAttAutRumore();
          autorizza.setOggetto("impianto puzzoso e maleodorante");
          autorizza.getDistanze().put("case","400");
          autorizza.getDistanze().put("scuola","300");
          autorizza.getDistanze().put("ospedale","1000");
          //aggiungo padre al figlio
          autorizza.setAttivita(commonBean);
          //aggiungo figlio al padre
          commonBean.getRumoreAutorizza().add(autorizza);
          
          //salvo figlio
          persistence.savePersist(autorizza);
          */
          
      } catch (Exception e) {
        
        e.printStackTrace();
      }
      
    }
    
    
    private void getUserPermissions(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
      try {
        
        response.getWriter().write("{professioni:true,altro:false}");
        
      } catch (IOException e) {
        throw new ServletException(e);
      }
      
    }
    
    private void anagraficaList(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
      
      try {
        
        Integer idEnte = new Integer(request.getParameter("id_ente"));
        
        PersistAttivitaFacade persistence = getPersistence(request);
        
        Map<String, Object>  parametri = new HashMap<String, Object>();
        
        parametri.put("idente", idEnte);
        
        
        //prendo il json creato sul server perchè l'anagrafica è caricata in modo lazy e quindi non caricherebbe tutti gli attributi come ad es. gli array delle professioni        
        response.getWriter().write( persistence.jsonArrayQuery("AnagRichBasicProxy.selectByEnte", parametri, "GestionaleEm"));
        
        
      }  catch (Exception e) {
        
        throw new ServletException(e);
      }
      
    }
    
    
    private void anagraficaSel(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
       //Integer idEnte = new Integer(request.getParameter("idente"));
      
      
      
        try {
          PersistAttivitaFacade persistence = getPersistence(request);
   
          Map<String, Object>  parametri = new HashMap<String, Object>();
          
          parametri.put("id_ente", request.getParameter("id_ente"));
//          System.out.println("servlet test id_ente:  ["+request.getParameter("id_ente")+"]");
          if(request.getParameter("ragsoc")!=null && !request.getParameter("ragsoc").equals("")) 
                  parametri.put("ragsoc", request.getParameter("ragsoc"));
          
          if(request.getParameter("localita")!=null && !request.getParameter("localita").equals("")) 
            parametri.put("localita", request.getParameter("localita"));
          
          if(request.getParameter("codfisc")!=null && !request.getParameter("codfisc").equals("")) 
            parametri.put("codfisc", request.getParameter("codfisc"));
          
          if(request.getParameter("partiva")!=null && !request.getParameter("partiva").equals("")) 
            parametri.put("partiva", request.getParameter("partiva"));

          if(request.getParameter("sesso")!=null && !request.getParameter("sesso").equals("")) 
              parametri.put("sesso", request.getParameter("sesso"));
          
//          List lista = persistence.resultQuery(parametri, AnagRichBasicProxy.class.getName(), "GestionaleEm");
//          for (Iterator iter = lista.iterator(); iter.hasNext();) {
//            AnagRichBasicProxy elemento = (AnagRichBasicProxy) iter.next();
//            System.out.println("servlet - soggetto trovato:  "+elemento.getRagsoc());
//          }

          response.getWriter().write(persistence.jsonArrayCreateQuery(parametri, AnagRichBasicProxy.class.getName(), "GestionaleEm"));
          
          
        } catch (Exception e) {
          
         throw new ServletException(e);
        }
    }
    
    private void anagraficaProfessioniSel(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        //Integer idEnte = new Integer(request.getParameter("idente"));
       
       
       
         try {
           PersistAttivitaFacade persistence = getPersistence(request);
    
           Map<String, Object>  parametri = new HashMap<String, Object>();
           
           parametri.put("id_ente", request.getParameter("id_ente"));
//           System.out.println("servlet test id_ente:  ["+request.getParameter("id_ente")+"]");
           if(request.getParameter("ragsoc")!=null && !request.getParameter("ragsoc").equals("")) 
                   parametri.put("ragsoc", request.getParameter("ragsoc"));
           
           if(request.getParameter("localita")!=null && !request.getParameter("localita").equals("")) 
             parametri.put("localita", request.getParameter("localita"));
           
           if(request.getParameter("codfisc")!=null && !request.getParameter("codfisc").equals("")) 
             parametri.put("codfisc", request.getParameter("codfisc"));
           
           if(request.getParameter("partiva")!=null && !request.getParameter("partiva").equals("")) 
             parametri.put("partiva", request.getParameter("partiva"));
    

           String sql = "select " + 
	       "	distinct " +
	       "	anag_rich.idadresse, " +
	       "	cod_famiglia, " +
	       "	id_anagrafe, " +
	       "	id_ente, " +
	       "	ragsoc, " +
	       "	localita,  " +
	       "	indir,  " +
	       "	nciv,  " +
	       "	cap,  " +
	       "	prov, " +
	       "	ragric, " +
	       "	nazione, " +
	       "	email, " +
	       "	codfisc, " +
	       "	partiva, " +
	       "	datanasc, " +
	       "	sesso, " +
	       "	tipo_tela, " +
	       "	tipo_telb, " +
	       "	telefonoa, " +
	       "	telefonob, " +
	       "	note " +
	       "from  " +
	       "	anag_rich " +
	       "inner join anagprofessioni " +
	       "on anagprofessioni.idadresse=anag_rich.idadresse " ;
	          
     
           
           
           response.getWriter().write(persistence.jsonArrayCreateNativeQuery(sql,AnagRichBasicProxy.class ,parametri, "GestionaleEm"));
           
           
         } catch (Exception e) {
           
          throw new ServletException(e);
         }
     }
    
    private void professioniList(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
      try {
        Integer idPersona = new Integer(request.getParameter("idAdresse"));
        
        PersistAttivitaFacade persistence = getPersistence(request);
        
 
        Map<String, Object>  parametri = new HashMap<String, Object>();
        
        parametri.put("idAdresse", idPersona);
        
        
        response.getWriter().write( persistence.jsonArrayQuery("AnagProfBasicProxy.selectByIdAdresse", parametri, "GestionaleEm"));
        
              
      } catch (Exception e) {
        
        throw new ServletException(e);
      } 
      
    }
    
    
    
    private  void salvaDatiAnag(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
      PersistAttivitaFacade persistence = getPersistence(request);
      
      try {
        
        Integer idAdresse = null;
        Object anagObj = null;
        
              try {
            	  
                try {
                	
					idAdresse = new Integer(request.getParameter("idAdresse"));
					
				} catch (Exception e) {
					
				}
				
				if(idAdresse != null){
					anagObj = (AnagRichProxy) persistence.find(idAdresse, AnagRichProxy.class, "GestionaleEm");
				
				}else {
					
	                anagObj= new AnagRichProxy();
				}
				
				//accoppia l'oggetto che arriva dal server con la mappa di valori che arriva dal client
				LocaleBeanUtils.populate(anagObj, request.getParameterMap()); 
				
				System.out.println("salva anagrafica - ragsociale: "+request.getParameter("ragsoc"));
				String ragric = StringRoutine.compatta(request.getParameter("ragsoc")).toUpperCase();
				((AnagRichProxy)anagObj).setRagric(ragric);
				
				
              } catch (Exception e) {
            	   
            	 e.printStackTrace();
            	  
              } finally {

            	  persistence.saveMergeGest(anagObj);
                
              }
        
        
        try {
          response.getWriter().write("{success: true, message: 'salvataggio effettuato' }" );
        } catch (IOException e1) {
          throw new ServletException(e1);
        }
        
        
      
      } catch (Exception e) {

        try {
          response.getWriter().write("{success: false, message:'"+e.getMessage()+"'}");
          e.printStackTrace();
        } catch (IOException e1) {
          throw new ServletException(e1);
        }
      }
      

    }
    
    
    
    
    private void salvaDatiProf(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
      PersistAttivitaFacade persistence = getPersistence(request);
      
 
      
      
      try {
        
        JSONArray  parametri = JSONArray.fromObject(request.getParameter("json"));
        
        for (int i = 0; i < parametri.size(); i++) {
          
          Map valori = (Map) parametri.get(i);
          
          
          if( valori.get("idAnagProf")!= null && !valori.get("idAnagProf").toString().equals(""))
            { 
              Integer idAnagProf = new Integer(valori.get("idAnagProf").toString());
              
              Object profObj = persistence.find(idAnagProf, AnagProfessioni.class, "GestionaleEm");
              
              LocaleBeanUtils.populate(profObj, valori); //accoppia l'oggetto che arriva dal server con la mappa di valori che arriva dal client
              
              persistence.saveMergeGest(profObj);
              
            } else {
              
             //carica l'oggetto anagRich dalla sua chiave primaria da passare poi al bean delle professioni 
              AnagRichProxy anagrafica = (AnagRichProxy) persistence.getReference( valori.get("idAdresse").toString(), AnagRichProxy.class, "GestionaleEm");
              
              AnagProfessioni profNew = new AnagProfessioni();
              profNew.setAnagrafica(anagrafica);
              
              LocaleBeanUtils.populate(profNew, valori);
              
              persistence.saveMergeGest(profNew);
            }
          
        }
        

        
        try {
          response.getWriter().write("{success: true, message: 'salvataggio effettuato' }" );
        } catch (IOException e1) {
          throw new ServletException(e1);
        }
        
        
      } catch (Exception e) {
        
        try {
          response.getWriter().write("{success: false, message: 'errore: "+e.getMessage()+ "'}" );
          e.printStackTrace();
        } catch (IOException e1) {
          throw new ServletException(e1);
        }
      }
      
    }
    
    
    
    
    private void cancellaDatiProf(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      
      PersistAttivitaFacade persistence = getPersistence(request);

      try {
        JSONArray  parametri = JSONArray.fromObject(request.getParameter("json"));

        for (int i = 0; i < parametri.size(); i++) {
          
          Map valori = (Map) parametri.get(i);
          
          Integer idAnagProf = new Integer(valori.get("idAnagProf").toString());
          System.out.println("cancella - id professione: "+idAnagProf);
          //Object profObj = persistence.find(idAnagProf, AnagProfBasicProxy.class, "GestionaleEm"); 
          
          persistence.delete(idAnagProf, AnagProfBasicProxy.class,"GestionaleEm");
          
        }
        
        try {
          response.getWriter().write("{success: true, message: 'cancellazione effettuata' }" );
        } catch (IOException e1) {
          throw new ServletException(e1);
        }
        
        
        
      } catch (Exception e) {
        
        try {
          response.getWriter().write("{success: false, message: 'errore: "+e.getMessage()+ "'}" );
          e.printStackTrace();
        } catch (IOException e1) {
          throw new ServletException(e1);
        }
      }
      
      
      
      
      
    }
    
/*
    private  void salvaDatiAttivita(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	
    	PersistAttivitaFacade persistence = getPersistence(request);
    	
    	Object attObj = null;
    	Integer idAttivita = null;
    	
    	System.out.println(request.getParameter("ragsociale"));
		System.out.println(request.getParameter("id_ente"));
    	
    	try {
			try {
				
				try {
					idAttivita = new Integer(request.getParameter("idattivita"));
					
				} catch (Exception e) {
					
				}
				
				if(idAttivita!= null)
					attObj=persistence.find(idAttivita, Attivita.class, "GestionaleEm");
				else 
					attObj = new Attivita();
				
				LocaleBeanUtils.populate(attObj, request.getParameterMap());
				
				
			}  catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				persistence.saveMergeGest(attObj);
			}
			
	        try {
	            response.getWriter().write("{success: true, message: 'salvataggio effettuato' }" );
	          } catch (IOException e1) {
	            throw new ServletException(e1);
	          }

	          
		} catch (Exception e) {
			
	        try {
	            response.getWriter().write("{success: false, message:'"+e.getMessage()+"'}");
	            e.printStackTrace();
	          } catch (IOException e1) {
	            throw new ServletException(e1);
	          }
		}
    	
    	
    	
    	
    	
    	
    }
*/    
    
    
  
    private  void salvaDatiAttivita(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    	PersistAttivitaFacade persistence = getPersistence(request);
    	String json = request.getParameter("json");
    	Attivita 	att = null;
    	JSONObject 	attivitaJson = null;
    	Integer 	idAttivita = null;
    	JSONArray 	istatSecondarie = null;
    	JSONArray 	istatEliminati = null;
    	JSONArray	unitaLocaliEliminate = null;

    	try {

    		attivitaJson = JSONObject.fromObject(json);

    		try {
    			istatSecondarie = attivitaJson.getJSONArray("istatSecondari");
    			
    			istatEliminati = attivitaJson.getJSONArray("istatEliminati");
    			
    			unitaLocaliEliminate = attivitaJson.getJSONArray("unitaLocaliEliminate");
    			
    		} catch (Exception e) {}


    		try {

    			try {
					idAttivita = new Integer(attivitaJson.get("idattivita").toString());
				} catch (Exception e) {}
    			
    			if(idAttivita!=null){
    				att = (Attivita)persistence.find(idAttivita, Attivita.class, "GestionaleEm");
    			
//    			System.out.println("attivita:  "+idAttivita);
    			
		        		if(unitaLocaliEliminate!=null && unitaLocaliEliminate.size()>0){
		        			
		        			JSONObject unitaLocaleJson = null;
		        			Integer idUnitaLocale = null;
		        			
		        			for(int i= 0; i < unitaLocaliEliminate.size(); i++  ){
		        				
		        				unitaLocaleJson = unitaLocaliEliminate.getJSONObject(i);
		        				idUnitaLocale =  new Integer(unitaLocaleJson.getString("idattivita"));
		//        				System.out.println("unita locale da cancellare - id:  "+idUnitaLocale);
		        	            persistence.delete(idUnitaLocale, Attivita.class,"GestionaleEm");
		        			}
		        			
		        		}
		        		
		        		if(istatEliminati!=null && istatEliminati.size()>0){
		        			
		        			JSONObject	istatEliminatiJson = null;
		        			
		        			for(int i = 0; i<istatEliminati.size(); i++){
		        				
		        				istatEliminatiJson = istatEliminati.getJSONObject(i);
		//        				System.out.println("istat secondario da cancellare - codice:  "+istatEliminatiJson.getString("codice"));			
		        				att.getIstat_secondari().remove(istatEliminatiJson.getString("codice"));
		        				
		        			}
		        		}
    			} else {
    				
    				att = new Attivita();
    			}

    			LocaleBeanUtils.populate(att, attivitaJson);

        		//setto il valore del legale rappresentante post populate perchè il populate lo setta a 0 invece che a null!
        		if(attivitaJson.containsKey("id_legrapp") && att.getId_legrapp() == 0 ) {
        			att.setId_legrapp(null);
//        			System.out.println("pippo");
        		}
        		
        		if(istatSecondarie!=null && istatSecondarie.size()>0){ 
        			//aggiungo le nuove e modifico le esistenti
        			for (int i = 0; i < istatSecondarie.size(); i++) {
        				JSONObject istat =   istatSecondarie.getJSONObject(i);  
        				att.getIstat_secondari().put(istat.getString("codice"), istat.getString("descrizione"));
     
        			}
        		}
    			
    			
    		} catch (Exception e) {
    			e.printStackTrace(); 
    		} finally {
    			
//        		System.out.println("json attivita:   ------ "+attivitaJson);
//        		System.out.println("ante populate:  id_legrapp ->  "+attivitaJson.containsKey("id_legrapp"));

        		//salvo l'attività 
        		persistence.saveMergeGest(att);
    			
    		}

    		try {
    			response.getWriter().write("{success: true, message: 'salvataggio effettuato' }" );
    		} catch (IOException e1) {
    			throw new ServletException(e1);
    		}



    	} catch (Exception e) {

    		try {
    			response.getWriter().write("{success: false, message:'"+e.getMessage()+"'}" );
    			e.printStackTrace();
    		} catch (IOException e1) {
    			throw new ServletException(e1);
    		}
    	}


    }

    
    
    private void cancellaAttivita(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        PersistAttivitaFacade persistence = getPersistence(request);

        try {
          JSONArray  parametri = JSONArray.fromObject(request.getParameter("json"));

          for (int i = 0; i < parametri.size(); i++) {
            
            Map valori = (Map) parametri.get(i);
            
            Integer idAttivita = new Integer(valori.get("idattivita").toString());
            System.out.println("cancella - id attivita: "+idAttivita);
            //Object profObj = persistence.find(idAnagProf, AnagProfBasicProxy.class, "GestionaleEm"); 
            
            persistence.delete(idAttivita, Attivita.class,"GestionaleEm");
            
          }
          
          try {
            response.getWriter().write("{success: true, message: 'cancellazione effettuata' }" );
          } catch (IOException e1) {
            throw new ServletException(e1);
          }
          
          
          
        } catch (Exception e) {
          
          try {
            response.getWriter().write("{success: false, message: 'errore: "+e.getMessage()+ "'}" );
            e.printStackTrace();
          } catch (IOException e1) {
            throw new ServletException(e1);
          }
        }
    }
    
    
    
    private void attivitaList(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        
        try {
          
          Integer idEnte = new Integer(request.getParameter("id_ente"));
          
          PersistAttivitaFacade persistence = getPersistence(request);
          
          Map<String, Object>  parametri = new HashMap<String, Object>();
          
          parametri.put("idente", idEnte);
          
          
          //prendo il json creato sul server perchè l'anagrafica è caricata in modo lazy e quindi non caricherebbe tutti gli attributi come ad es. gli array delle professioni        
          response.getWriter().write( persistence.jsonArrayQuery("Attivita.selectByEnte", parametri, "GestionaleEm"));
          
          
        }  catch (Exception e) {
          
          throw new ServletException(e);
        }
        
      }
    
    
    private void attivitaSel(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        //Integer idEnte = new Integer(request.getParameter("idente"));
       
       
       
         try {
           PersistAttivitaFacade persistence = getPersistence(request);
    
           Map<String, Object>  parametri = new HashMap<String, Object>();
           
          parametri.put("id_ente", request.getParameter("id_ente"));
//           System.out.println("servlet test id_ente:  ["+request.getParameter("id_ente")+"]");
           if(request.getParameter("ragsoc")!=null && !request.getParameter("ragsoc").equals("")) 
                   parametri.put("ragsociale", request.getParameter("ragsoc"));
           
           if(request.getParameter("citta")!=null && !request.getParameter("citta").equals("")) 
             parametri.put("citta", request.getParameter("citta"));
           
           if(request.getParameter("anagrafica.codfisc")!=null && !request.getParameter("anagrafica.codfisc").equals("")) 
             parametri.put("anagrafica.codfisc", request.getParameter("anagrafica.codfisc"));
           
           if(request.getParameter("anagrafica.partiva")!=null && !request.getParameter("anagrafica.partiva").equals("")) 
             parametri.put("anagrafica.partiva", request.getParameter("anagrafica.partiva"));
    
           if(request.getParameter("nrea")!=null && !request.getParameter("nrea").equals("")) 
               parametri.put("nrea", request.getParameter("nrea"));
          
           if(request.getParameter("attivitalocale")!=null && !request.getParameter("attivitalocale").equals(""))
        	   parametri.put("attivitalocale", request.getParameter("attivitalocale"));

/*           
           else 
           
        	   //parametri.put("attivitalocale", null);
/*        	   
        	   
			response.getWriter().write(persistence.jsonArrayCreateQueryAttivita(parametri, Attivita.class.getName(), "GestionaleEm"));   	   

*/           
           
           
//           String sql = "Select " +
//      		" attivita.idattivita as idattivita," +
//      		" attivita.idanagrich as idanagrich," +
//      		" attivita.ragsociale as ragsociale," +
//      		" attivita.attivitalocale as attivitalocale," +
//      		" attivita.id_ente as id_ente," +
//      		" attivita.idprocedure as  idprocedure," +
//      		" attivita.id_legrapp as id_legrapp," +
//      		" attivita.formagiuridica as formagiuridica," +
//      		" attivita.datainizio as datainizio," +
//      		" attivita.nrea as nrea," +
//      		" attivita.naddetti as naddetti," +
//      		" attivita.istat_principale as istat_principale," +
//      		" attivita.desc_cicloprod as desc_cicloprod," +
//      		" attivita.note as note," +
//      		" attivita.codvia as codvia," +
//      		" attivita.via as via," +
//      		" attivita.nciv as nciv," +
//      		" attivita.cap as cap," +
//      		" attivita.citta as citta," +
//      		" attivita.codcitta as codcitta," +
//      		" attivita.prov as prov," +
//      		" attivita.nazione as nazione," +
//      		" attivita.codnazione as codnazione," +
//      		" from attivita " +
//      		" left outer join anag_rich " +
//      		" on attivita.idanagrich=anag_rich.idadresse ";          
//           
//           response.getWriter().write(persistence.jsonArrayCreateNativeQuery(sql,Attivita.class ,parametri, "GestionaleEm"));  
           
          
           
           
           String sql = "Select " +
         			" att " +
         			" from Attivita att ";


           response.getWriter().write(persistence.jsonArrayCreateQueryEJBQL(sql,parametri,"att.ragsociale", "GestionaleEm"));
 
           
//           System.out.println("JSON :   "+persistence.jsonArrayCreateQuery(parametri, Attivita.class.getName(), "GestionaleEm"));
           
         } catch (Exception e) {
           
          throw new ServletException(e);
         }
     }
    
/*    
    private void salvaAutRumore(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	
     	PersistAttivitaFacade persistence = getPersistence(request);
    	String json = request.getParameter("json");
    	
    	EcoAttAutRumore autRumore = null;
    	JSONObject autRumoreJson = null;
    	Integer idAutorizza = null;
    	
    	JSONArray sorgenti = null;
    	JSONArray sorgentiEliminate = null;
    	
    	
    	JSONArray ricettori = null;
    	JSONArray ricettoriEliminati = null;

    	try {

    		autRumoreJson = JSONObject.fromObject(json);

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

    			idAutorizza = new Integer(autRumoreJson.get("idautorizza").toString()); 
    			autRumore = (EcoAttAutRumore) persistence.find(idAutorizza, EcoAttAutRumore.class, "TerritorioEm");
    			
    			System.out.println("autorizzazione:  "+idAutorizza);
    			
    			if(sorgentiEliminate!=null && sorgentiEliminate.size()>0){
    				
    				JSONObject sorgenteEliminataJson = null;
    				
    				for(int i=0; i<sorgentiEliminate.size(); i++){
    					
    					sorgenteEliminataJson = sorgentiEliminate.getJSONObject(i);
    					System.out.println("sorgente eliminata descr:  "+sorgenteEliminataJson.getString("descrizione"));
    					autRumore.getSorgenti().remove(sorgenteEliminataJson.getString("descrizione"));
    					
    				}
    				
    			}
    			
    			
    			if(ricettoriEliminati!=null && ricettoriEliminati.size()>0){
    				
    				JSONObject ricettoreEliminatoJson = null;
    				Integer idRicettoreEliminato = null;
    				
    				for(int i = 0; ricettoriEliminati.size()>0; i++){
    					
    					ricettoreEliminatoJson = ricettoriEliminati.getJSONObject(i);
    					idRicettoreEliminato = new Integer(ricettoreEliminatoJson.getString("idricettore"));
    					persistence.delete(idRicettoreEliminato, EcoAttAutRumoreRicettori.class, "TerritorioEm");
    					
    				}
    				
    			}
    			

    		} catch (Exception e) {
    			//nuova attivita 
    			
    			System.out.println("#### è nuovo ! ########");
    			autRumore = new EcoAttAutRumore();

    		} finally {
    			//serve?

    		}

    		System.out.println("json rumore: ---- "+autRumoreJson);
    		
    		//populate
    		LocaleBeanUtils.populate(autRumore, autRumoreJson);  


    		
    		if(sorgenti!=null && sorgenti.size()>0){ 
    			System.out.println("sorgenti - lunghezza: "+sorgenti.size());
    			//aggiungo le nuove e modifico le esistenti
    			for (int i = 0; i < sorgenti.size(); i++) {
    				JSONObject sorgente =   sorgenti.getJSONObject(i);
    				System.out.println("sorgente descrizione:  "+sorgente.getString("descrsorg"));
    				autRumore.getSorgenti().put(sorgente.getString("descrsorg"), sorgente.getString("dbemissione"));
 
    			}

    		}


    		
    		//salvo
//    		persistence.saveMergeTerr(autRumore);
    		
    		System.out.println("inizio syso di debug");
    		System.out.println("ricettori - lunghezza: "+ricettori.size());
    		
    		
    		
       		boolean res = persistence.saveMergeAutRumore(autRumore, json);

    		try {
    			response.getWriter().write("{success: true, message: 'salvataggio effettuato' }" );
    		} catch (IOException e1) {
    			throw new ServletException(e1);
    		}



    	} catch (Exception e) {
    		e.printStackTrace();
    		try {
    			response.getWriter().write("{success: false, message: 'Errore : " + e.getMessage()+ "' }" );
    			
    		} catch (IOException e1) {
    			throw new ServletException(e1);
    		}
    	}
    	
    }
*/    
    
  
    private  void salvaAutRumore(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    	PersistAttivitaFacade persistence = getPersistence(request);
    	String json = request.getParameter("json");
/*    	
    	EcoAttAutRumore autRumore = null;
*/    	
//    	JSONObject autRumoreJson = null;
/*
    	Integer idAutorizza = null;
    	
    	JSONArray sorgenti = null;
    	JSONArray sorgentiEliminate = null;
    	
    	
    	JSONArray ricettori = null;
    	JSONArray ricettoriEliminati = null;
*/
    	try {

//    		autRumoreJson = JSONObject.fromObject(json);
/*
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
    				//System.out.println("idautorizza:  "+idAutorizza);
    				autRumore = (EcoAttAutRumore)persistence.find(idAutorizza, EcoAttAutRumore.class, "TerritorioEm");
    				
        			System.out.println("autorizzazione:  "+idAutorizza);
        			
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
        					idRicettoreEliminato = new Integer(ricettoreEliminatoJson.getString("idricettore"));//????
        					persistence.delete(idRicettoreEliminato, EcoAttAutRumoreRicettori.class, "TerritorioEm");
        				
        				}
        			}
    			}else {
    				//nuova attivita
        			//System.out.println("#### è nuovo ! ########");
        			autRumore = new EcoAttAutRumore();    				
    			}

    			

    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			//serve?
    		}

    		System.out.println("json rumore: ---- "+autRumoreJson);
    		
    		//populate
    		LocaleBeanUtils.populate(autRumore, autRumoreJson);  
   		
    		if(sorgenti!=null && sorgenti.size()>0){ 
    			//aggiungo le nuove e modifico le esistenti
    			for (int i = 0; i < sorgenti.size(); i++) {
    				JSONObject sorgente =   sorgenti.getJSONObject(i);  
    				autRumore.getSorgenti().put(sorgente.getString("descrsorg"), sorgente.getString("dbemissione"));
    			}
    		}
   		
    		//salvo
//    		persistence.saveMergeTerr(autRumore);
    		
//    		System.out.println("inizio syso di debug");
//    		System.out.println("ricettori - lunghezza: "+ricettori.size());
*/    		
       		boolean res = persistence.saveMergeAutRumore(json);

    		try {
    			response.getWriter().write("{success: true, message: 'salvataggio effettuato' }" );
    		} catch (IOException e1) {
    			throw new ServletException(e1);
    		}



    	} catch (Exception e) {
    		e.printStackTrace();
    		try {
    			response.getWriter().write("{success: false, message: 'Errore : " + e.getMessage()+ "' }" );
    			
    		} catch (IOException e1) {
    			throw new ServletException(e1);
    		}
    	}


    }
  
    
    

	private void autRumoreCarica(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	
    	try {
    		
			PersistAttivitaFacade persistence = getPersistence(request);
			
			Map<String, Object>  parametri = new HashMap<String, Object>();
			
					parametri.put("id_ente", request.getParameter("currentEnte"));
//         System.out.println("servlet test id_ente:  ["+request.getParameter("id_ente")+"]");
			
				if(request.getParameter("currentIdProcedimento")!=null && !request.getParameter("currentIdProcedimento").equals("")) 
			         parametri.put("idprocedimento", request.getParameter("currentIdProcedimento"));
/*			 
				if(request.getParameter("currentIdAutorizza")!=null && !request.getParameter("currentIdAutorizza").equals("")) 
					parametri.put("idautorizza", request.getParameter("currentIdAutorizza"));
*/			 
			
			 String sql = "Select " +
				" autr "+
				" from EcoAttAutRumoreProxy autr ";
			 
			 //System.out.println("autorizzazione rumore:  "+persistence.jsonArrayCreateQueryAutRumoreEJBQL(sql,parametri,null));
			 
			 response.getWriter().write(persistence.jsonArrayCreateQueryAutRumoreEJBQL(sql,parametri,null));
			 
		} catch (Exception e) {
			
			throw new ServletException(e);
		}
    	
    }
    
    
    
    
    private void anagrafSelById(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
    	PersistAttivitaFacade persistence = getPersistence(request);

    	AnagRichBasicProxy anagDitta = null;
    	
    	
        try {
        	
        	Integer idEnte = new Integer(request.getParameter("id_ente"));
        	
        	Integer idAnag = new Integer(request.getParameter("idanagrich"));
        	Integer idLegRapp = new Integer(request.getParameter("id_legrapp"));
        	
        	if(idAnag!=null)
        		anagDitta = (AnagRichBasicProxy)persistence.find(idAnag, AnagRichBasicProxy.class, "GestionaleEm");
        	else
        		anagDitta = (AnagRichBasicProxy)persistence.find(idLegRapp, AnagRichBasicProxy.class, "GestionaleEm");
        	
        	Map<String, Object>  parametri = new HashMap<String, Object>();
            
            parametri.put("idente", idEnte);
            parametri.put("idAdresse", anagDitta);
        	
        	
        	response.getWriter().write(persistence.jsonArrayQuery("AnagProfBasicProxy.selectByIdAdresse", parametri, "GestionaleEm"));
        	
        } catch (Exception e) {
          
          throw new ServletException(e);
        } 
        
      }
    
    
    
    private PersistAttivitaFacade getPersistence(HttpServletRequest  request) throws NullPointerException {
      
      return (PersistAttivitaFacade) request.getSession().getServletContext().getAttribute("app.persistence");
      
    }
    
}
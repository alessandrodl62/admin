import intraweb.LinkPraticheWebiProxy;
import intraweb.LinkPubblicazioniWebiProxy;
import intraweb.MasterUrlWebiProxy;
import intraweb.PraticheWebiProxy;
import intraweb.PubblicazioniWebiProxy;
import intraweb.TipoPubbliProxy;
import intraweb.Traspubblicazioni;
import intrawebsession.IntrawebPersistenceFacade;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


import commons.DBDouble;
import commons.DateJsonValueProcessor;
import commons.DecodData;
import commons.DecodNumber;
import commons.TimeJsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/**
 * Servlet implementation class for Servlet: EconomRpc
 *
 */

public class IntrawebRpc extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public IntrawebRpc() {
		super();
		
		conf.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor());
		conf.registerJsonValueProcessor(Time.class, new TimeJsonValueProcessor());
		
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		elaborateRequest( request,  response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		elaborateRequest( request,  response);
		
	}   	  	    
	
	
	protected void elaborateRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		
		if (command == null)
			command = request.getServletPath();
		
		if (command.equals("/intraweb/messilist")) MessiList( request,  response);
		else if (command.equals("/intraweb/trasList")) TrasList(request,  response);
		else if (command.equals("/intraweb/modalitalist")) ModalitaList(request,  response);
		else if (command.equals("/intraweb/trasupdate")) TrasUpdate(request,  response);
		else if (command.equals("/intraweb/traspubblica")) TrasPubblica(request,  response);
		else if (command.equals("/intraweb/trasxpubblica")) TrasXpubblica(request,  response);
		else if (command.equals("/intraweb/pubblicazioniweb")) pubblicazioniwebList(request,  response);
		else if (command.equals("/intraweb/tipoweb")) tipowebList(request,  response);
		else if (command.equals("/intraweb/pubbllinkweb")) pubbllinkwebList(request,  response);
		else if (command.equals("/intraweb/prawebdbupdate")) pratichewebdbUpdate(request,  response);
		else if (command.equals("/intraweb/prawebdbdelete")) pratichewebdbDelete(request,  response);
		else if (command.equals("/intraweb/prawebdbpubblica")) pubblicawebdb(request,  response);
		else if (command.equals("/intraweb/docwebdbadd")) docwebdbAdd(request,  response);
		else if (command.equals("/intraweb/docwebdbupdate")) docwebdbUpdate(request,  response);
		else if (command.equals("/intraweb/docwebdbremove")) docwebdbRemove(request,  response);
		else if (command.equals("/intraweb/ufficiweb")) ufficiwebList(request,  response);
		else if (command.equals("/intraweb/praticheweb")) pratichewebList(request,  response);
		else if (command.equals("/intraweb/pralinkweb")) pralinkwebList(request,  response);
		else if (command.equals("/intraweb/prawebupdate")) pratichewebUpdate(request,  response);
		else if (command.equals("/intraweb/prawebdelete")) pratichewebDelete(request,  response);
		else if (command.equals("/intraweb/arspupdate")) arspUpdate(request,  response);
		else if (command.equals("/intraweb/aripupdate")) aripUpdate(request,  response);
		else if (command.equals("/intraweb/docwebadd")) docwebAdd(request,  response);
		else if (command.equals("/intraweb/docwebupdate")) docwebUpdate(request,  response);
		else if (command.equals("/intraweb/docwebremove")) docwebRemove(request,  response);
		else if (command.equals("/intraweb/pranolinkweb")) pranolinkwebList(request,  response);
		else if (command.equals("/intraweb/prawebaddsel")) docwebAddSel(request,  response);
		else if (command.equals("/intraweb/attilistdec")) attiListSel(request,  response);
		else if (command.equals("/intraweb/tipopubbllist")) tipopubblList(request,  response);
		else if (command.equals("/intraweb/updatetipopubblicazione")) tipopubblicazioneUpdate(request,  response);
		else if (command.equals("/intraweb/deletetipopubblicazione")) tipopubblicazioneDelete(request,  response);
		
		
	}
	
	private void returnArray(Object obj, HttpServletResponse response) {
		
		try {
			
			response.getWriter().write(JSONArray.fromObject(obj,conf).toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    private void returnObject(Object obj, HttpServletResponse response) {
		
		try {
			
//			GregorianCalendar calendar = new GregorianCalendar();
//			calendar.setTimeInMillis(((Timestamp)obj).getTime());
			
			
			response.getWriter().write(JSONObject.fromObject(obj,conf).toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    private void returnError(String message, HttpServletResponse response) {
    	
		try {
			
			response.getWriter().write("{success:false,message:\""+message+"\"}");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    private void returnSuccess(String message, HttpServletResponse response) {
    	
		try {
			response.getWriter().write("{success:true,message:\""+message+"\"}");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    
	private void MessiList(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
//			PersistenceFacade persistence = getPersistence(request);
			Object persistence = getObjectPersistence(request);
			
			String search = "";
			if (request.getParameter("searc") != null)
			  search = request.getParameter("searc");

			returnArray(MethodUtils.invokeMethod(persistence, "getMessi", new Object[] {search}), response);
			
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
		
	}
	
	
	private void TrasList(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
//			PersistenceFacade persistence = getPersistence(request);
			Object persistence = getObjectPersistence(request);
			
			String search = "";
			if (request.getParameter("descr") != null)
			  search = request.getParameter("descr");
			
			Integer id =  new Integer(request.getParameter("utente"));
			Integer anno = new Integer(request.getParameter("annodaselect"));
			
//			String 
			String  selezione = request.getParameter("selezione");

			returnArray(MethodUtils.invokeMethod(persistence, "getPubblicazioniWeb", new Object[] {id,search,selezione,anno}), response);
			
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
		
	}
	
	
	private void ModalitaList(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
//			PersistenceFacade persistence = getPersistence(request);
			Object persistence = getObjectPersistence(request);
			
			returnArray(MethodUtils.invokeMethod(persistence, "getModalitaWeb", new Object[] {}), response);
			
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
		
	}
	
	private void pubblicazioniwebList(HttpServletRequest request, HttpServletResponse response) {

		
		Object persistence = getObjectPersistence(request);
		
		Integer utente = new Integer(request.getParameter("utente"));
		Integer tipo = new Integer(request.getParameter("tipo"));
		
		String  descrizione = "";
		if (request.getParameter("descr") != null)
			descrizione = request.getParameter("descr");
		
		String  selezione = request.getParameter("selezione");
		
		Integer daanno = new Integer(request.getParameter("annodaselect"));

		try {
			
			returnArray(MethodUtils.invokeMethod(persistence, "getPubblicazioniWeb", new Object[] {utente,tipo,descrizione,selezione,daanno}), response);
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
	}
	
	private void tipowebList(HttpServletRequest request, HttpServletResponse response) {

		
		Object persistence = getObjectPersistence(request);
		
		Integer utente = new Integer(request.getParameter("id"));
		Integer ente = new Integer(request.getParameter("ente"));

		try {
			
			returnArray(MethodUtils.invokeMethod(persistence, "getTipoWebFromUser", new Object[] {utente,ente}), response);
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
	}
	
	private void pubbllinkwebList(HttpServletRequest request, HttpServletResponse response) {

		
		Object persistence = getObjectPersistence(request);
		
		Integer pubbl = new Integer(request.getParameter("idpratica"));

		try {
			
			returnArray(MethodUtils.invokeMethod(persistence, "getLinkPubblicazioniWeb", new Object[] {pubbl}), response);
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
	}
	
	private void tipopubblList(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
//			PersistenceFacade persistence = getPersistence(request);
			Object persistence = getObjectPersistence(request);
			
			String search = "";
			if (request.getParameter("searc") != null)
			  search = request.getParameter("searc");
			

			returnArray(MethodUtils.invokeMethod(persistence, "getTipoPubblicazioniWeb", new Object[] {search}), response);
			
			
		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
		
		
	}	
	
	  private void pratichewebdbUpdate(HttpServletRequest request, HttpServletResponse response) {
		    try {

		      Object persistence = getObjectPersistence(request);
		      
		      // Utente non decodificato (id utente non web) se in inserimento
		      // -------------------------------------------------------------
		      Integer tpu_idutente   = new Integer(request.getParameter("tpu_idutente"));
		      
		      
		      String tpu_controllo = "N";
		      
		      if (request.getParameter("tpu_controllo") != null) 
		    	  tpu_controllo = request.getParameter("tpu_controllo");
		      
		      
		      PubblicazioniWebiProxy pratica = new PubblicazioniWebiProxy();
		      
		      pratica.setTpu_id(new Integer(request.getParameter("tpu_id")));
		      Integer uff_id   = new Integer(request.getParameter("iduffici"));
		      pratica.setTpu_iduff(uff_id);

		      
		      Integer pra_cod = 0;
		      
		      if (request.getParameter("pr_cod_prat") != null && !request.getParameter("pr_cod_prat").trim().equals("0")) 
		    	  pra_cod = new Integer(request.getParameter("pr_cod_prat"));
		      
/*		      if (request.getParameter("doc") != null && !request.getParameter("doc").trim().equals("")) 
		    	  pratica.setDoc(request.getParameter("doc"));
		      
		      if (request.getParameter("percorso") != null && !request.getParameter("percorso").trim().equals("")) 
		    	  pratica.setPercorso(request.getParameter("percorso")); */
		      
		      
				if ((request.getParameter("tpu_datainizio") != null) && (! request.getParameter("tpu_datainizio").equals(""))) 
					pratica.setTpu_datainizio(DecodData.getStrFormatTimeStamp(request.getParameter("tpu_datainizio")));		      
		      
				if ((request.getParameter("tpu_datafine") != null) && (! request.getParameter("tpu_datafine").equals(""))) 
					pratica.setTpu_datafine(DecodData.getStrFormatTimeStamp(request.getParameter("tpu_datafine")));		      
		      

				if ((request.getParameter("tpu_dipap") != null) && (! request.getParameter("tpu_dipap").equals(""))) 
					pratica.setTpu_dipap(DecodData.getStrFormatTimeStamp(request.getParameter("tpu_dipap")));
				else 
					pratica.setTpu_dipap(null);

				
				if ((request.getParameter("tpu_dfpap") != null) && (! request.getParameter("tpu_dfpap").equals(""))) 
					pratica.setTpu_dfpap(DecodData.getStrFormatTimeStamp(request.getParameter("tpu_dfpap")));
				else 
					pratica.setTpu_dipap(null);
				
				pratica.setTpu_flpap("N");
				if ((request.getParameter("tpu_flpap") != null) && (! request.getParameter("tpu_flpap").equals("")))
					pratica.setTpu_flpap(request.getParameter("tpu_flpap"));
				

				pratica.setTpu_flapap("N");
				if ((request.getParameter("tpu_flapap") != null) && (! request.getParameter("tpu_flapap").equals("")))
					pratica.setTpu_flapap(request.getParameter("tpu_flapap"));
				
				pratica.setTpu_idtipo(new Integer(request.getParameter("tpu_idtipo")));
			      
				pratica.setTpu_titolo(request.getParameter("tpu_titolo"));
				pratica.setTpu_testo(request.getParameter("tpu_testo"));

				pratica.setTpu_idutente(tpu_idutente);
				
				pratica.setTpu_controllo(tpu_controllo);
				
				
				// Dati dell'atto
				// --------------
				if ((request.getParameter("tpu_dataatto") != null) && (! request.getParameter("tpu_dataatto").equals(""))) 
					pratica.setTpu_dataatto(DecodData.getStrFormatTimeStamp(request.getParameter("tpu_dataatto")));		      

				if ((request.getParameter("tpu_numatto") != null) && (! request.getParameter("tpu_numatto").equals(""))) 
					pratica.setTpu_numatto(new Integer(request.getParameter("tpu_numatto")));		      
				
				pratica.setTpu_href("");
				if (request.getParameter("tpu_href") != null)
					pratica.setTpu_href(request.getParameter("tpu_href").trim());
					
				pratica.setTpu_dref("");
				if (request.getParameter("tpu_dref") != null)
					pratica.setTpu_dref(request.getParameter("tpu_dref").trim());

				
				if (request.getParameter("tpu_nota") != null)
					pratica.setTpu_nota(request.getParameter("tpu_nota").trim());
				
		      String errormessage1 = "";
		      String errormessage2 = "";
		      String errormessage3 = "";
		      String errormessage = "";
		      
		      String datainih = "";
		      String dataini =  "";
		      
		      String datafinh = "";
		      String datafin =  "";
		      
		      String flpaph = "N";
		      String flpap  = "N";
		      
		      
		      
		      
		      if (request.getParameter("tpu_hdipap") != null)
		    	  datainih = request.getParameter("tpu_hdipap").trim();
		      
		      if (request.getParameter("tpu_dipap") != null)
		    	  dataini = request.getParameter("tpu_dipap").trim();
		      
		      if (request.getParameter("tpu_hdfpap") != null)
		    	  datafinh = request.getParameter("tpu_hdfpap").trim();
		      
		      if (request.getParameter("tpu_dfpap") != null)
		    	  datafin = request.getParameter("tpu_dfpap").trim();
		      
		      // Flag di richiesta pubblicazione 
		      // -------------------------------

		      if (request.getParameter("tpu_hflpap") != null)
		    	  flpaph = request.getParameter("tpu_hflpap");
		      
		      if (request.getParameter("tpu_flpap") != null) {
		    	  if (request.getParameter("tpu_flpap").trim().toUpperCase().equals("TRUE"))
		    	       flpap = "Y"; 
		    	  else if (request.getParameter("tpu_flpap").trim().toUpperCase().equals("FALSE"))
		    	       flpap = "N";
		    	  else 
		    		  flpap = request.getParameter("tpu_flpap").trim();
		      }	  
		      
		      //System.out.println(" FLAG DA MODIFICARE ["+request.getParameter("tpu_hflpap")+"]");
		      // System.out.println(" FLAG MODIFICATO ["+request.getParameter("tpu_flpap")+"]");
		      
		      if (! flpap.equals(flpaph)) 
		    	  errormessage1 = " Modificato il flag di pubblicazione con valore ["+flpap+"]";

		      if (! datainih.equals(dataini)) {
		    	  
		    	  if (dataini.equals(""))
		    		  errormessage2 = "Cancellata data inizio ";
		    	  else 
		    		  errormessage2 = "Modificata / Inserita data inizio con valore ["+dataini+"]"; 
		      }
		      
		      if (! datafinh.equals(datafin)) {
		    	  
		    	  if (datafin.equals(""))
		    		  errormessage3 = "Cancellata data fine ";
		    	  else 
		    		  errormessage3 = "Modificata / Inserita data fine con valore ["+datafin+"]"; 
		      }
		      
		      if (!errormessage1.trim().equals("") || !errormessage2.trim().equals("") || !errormessage3.trim().equals("")) {
		    	  
		    	    if (!errormessage1.trim().equals(""))
		                 errormessage = errormessage1;
		    	    
		    	    if (!errormessage2.trim().equals("")) {
		    	    	if (!errormessage.equals(""))
		                  errormessage = errormessage +" - "+errormessage2;
		    	    	else 
			              errormessage = errormessage2;
		    	    }
		    	    
		    	    if (!errormessage3.trim().equals("")) {
		    	    	if (!errormessage.equals(""))
		                  errormessage = errormessage +" - "+errormessage3;
		    	    	else 
			              errormessage = errormessage3;
		    	    }
		      }      
		            
		            

		      Integer returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "updatePrawebdb", new Object[] {pratica,pra_cod,errormessage});
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
	          returnError("0", response); 
		      
		    } catch (Exception e) {
		      returnError(e.getMessage(), response);
		      e.printStackTrace();
		    }
		  }	
	
		private void pratichewebdbDelete(HttpServletRequest request, HttpServletResponse response) {

			try {
				Object persistence = getObjectPersistence(request);
				
				Integer praid = Integer.valueOf(request.getParameter("key"));
				Integer userid = Integer.valueOf(request.getParameter("user"));
				
				Boolean returnvalue;
					returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "removePubblicaWebdb", new Object[] {praid,userid});
					
			if (returnvalue)
				returnSuccess("Rimozione pubblicazione avvenuta con successo", response);
			else 
				returnError("Rimozione publicazione NON AVVENUTA", response);

		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
			
		}
	
		  private void docwebdbAdd(HttpServletRequest request, HttpServletResponse response) {
			    try {

			      Object persistence = getObjectPersistence(request);
			      FileItem fileItem = null;
			      String optionalFileName = "";
			  	  FTPClient clientftp;
			  	  
			  	  String titolo = "";
			  	  Integer idpratica = 0;
			  	  Integer idutente = 0;
			  	  Boolean okwrite = false;

			      
					//request.setCharacterEncoding("UTF-8");
			        final String separator = java.lang.System.getProperty("file.separator");
			        
			        
					  ServletFileUpload servletFieldUpload = new ServletFileUpload(new DiskFileItemFactory());
				        
					  HashMap requestMap = new HashMap();
					  
					  List fieldItemsList;
			        
						fieldItemsList = servletFieldUpload.parseRequest(request);

						  Iterator it = fieldItemsList.iterator();
							 
						  while (it.hasNext()){
							 	
						    FileItem fieldItemTemp = (FileItem)it.next();
						
						    if (fieldItemTemp.isFormField()) {
						    	requestMap.put(fieldItemTemp.getFieldName(), fieldItemTemp.getString());
						 
							      if (fieldItemTemp.getFieldName().equals("filename"))
							        optionalFileName = fieldItemTemp.getString();
							    }
							    else
							    	fileItem = fieldItemTemp;
						    
			      
						  }
						  
						  
						  
				if ((requestMap.get("tlp_idpubbl") != null) && (!requestMap.get("tlp_idpubbl").equals("-1"))) 
					idpratica = Integer.valueOf(requestMap.get("tlp_idpubbl").toString().trim());
				
				
				if ((requestMap.get("tlp_user") != null) && (!requestMap.get("tlp_user").equals("-1"))) 
	     			idutente = Integer.valueOf(requestMap.get("tlp_user").toString().trim());
				
				if ((requestMap.get("tlp_titolo") != null) && (!requestMap.get("tlp_titolo").equals(""))) 
					titolo = (String)requestMap.get("tlp_titolo");
					
				
				  if (fileItem!=null) {
					  
					    String fileName = fileItem.getName();
					    if (fileItem.getSize() > 0){
					    	
					    	
				        if (optionalFileName.trim().equals("")) fileName = FilenameUtils.getName(fileName);
						else  fileName = optionalFileName;
				        
				        
				        InputStream strsend = fileItem.getInputStream();
				        
					/*	
					 * Solo per testare lo stream di invio
					 * 
					 * int lines = 0, width = 0;
						StringBuilder buf = new StringBuilder();
						try {
							BufferedReader rdr = new BufferedReader(new InputStreamReader(strsend, "utf-8"));
							String line = null;
							while ((line = rdr.readLine()) != null) {
								System.out.println(line);
							}
							rdr.close();
						} catch (Exception ex) {
							// ignore
						} */
						
				        
		    				clientftp = new FTPClient();
	  					    clientftp.addProtocolCommandListener(new ProtocolCommandListener(){
				
							  public void protocolCommandSent(ProtocolCommandEvent arg0) {}
							  public void protocolReplyReceived(ProtocolCommandEvent arg0) {}
						    });

	  					MasterUrlWebiProxy returnvalue = (MasterUrlWebiProxy)MethodUtils.invokeMethod(persistence, "getMasterUrlWeb", null );
	  					
	  					TipoPubbliProxy  tipopubbl     = (TipoPubbliProxy)MethodUtils.invokeMethod(persistence, "getTipopubblWeb", new Object[] {idpratica});
	  					
	  					if (tipopubbl != null) {
	  						
	  						
	     					clientftp.connect(returnvalue.getTmu_host().trim());
	  					
	  	    				clientftp.enterLocalPassiveMode();
	  		    			int reply = clientftp.getReplyCode();
	  					
	  					
		  					if (FTPReply.isPositiveCompletion(reply)) {
		  						
		  						
									if (clientftp.login(returnvalue.getTmu_user().trim(),returnvalue.getTmu_psw().trim())) {
										
										if (clientftp.isConnected()) {
											
											
											clientftp.setFileType(FTPClient.BINARY_FILE_TYPE);
											
											// Se l'invio FTP è riuscito scrivo i dati 
											// ---------------------------------------
											
											if (clientftp.storeFile(returnvalue.getTmu_pathftp()+tipopubbl.getTtp_pathdestinazione()+idpratica.toString().trim()+fileItem.getName(),strsend)) {

												LinkPubblicazioniWebiProxy docpubblicazione = new LinkPubblicazioniWebiProxy();
												
												
												docpubblicazione.setTlp_idpubbl(idpratica);
												
												docpubblicazione.setTlp_url((returnvalue.getTmu_homepage()+tipopubbl.getTtp_pathdestinazione()+idpratica.toString().trim()+fileItem.getName()).trim());
												docpubblicazione.setTlp_titolo(titolo);
												docpubblicazione.setTlp_nomefile(idpratica.toString().trim()+fileItem.getName().trim());
												
												docpubblicazione.setTlp_user(idutente);
												
												okwrite = (Boolean)MethodUtils.invokeMethod(persistence, "newDocdbPraweb", new Object[] {idpratica,docpubblicazione});
												
												

		   									//	System.out.println(" HELLO, CONNECTION OK, MA BRAVO.... ["+returnvalue.getTmu_psw().trim()+"] NOME FILE ["+returnvalue.getTmu_pathftp()+returnvalue.getTmu_pathpratiche()+fileItem.getName()+"]");
												
											} 
		
											
											clientftp.disconnect();
											
										}
										
										
									}
		  						
		  						
		  						
		  						
		  						
		  						
		  					} // if (FTPReply.isPositiveCompletion(reply
		  					
	  					}  // if (tipopubbl != null			        
						}  // if (fileItem.getSize() > 0 
					    	
					  
				  } // if (fileItem!=null
				
	/*				if (okwrite) {
		    			returnSuccess("Inserimento allegato avvenuto con successo", response);
					}	
					else
					    returnError("Aggiornamento dati non riuscito", response); */
						  
			      
			      
			    } catch (Exception e) {
				      returnError(e.getMessage(), response);
				      e.printStackTrace();
				}  	
			      
			    }	      
		
	
	  private void TrasUpdate(HttpServletRequest request, HttpServletResponse response) {
		    try {

		    	
		      Object persistence = getObjectPersistence(request);
		      
		      Integer idutente = new Integer(request.getParameter("idutente"));
		      
		      Integer idtrasp = new Integer(request.getParameter("idtrasp"));
		      String fpubblic  = request.getParameter("fpubblic");
		      
		      String progetto  = request.getParameter("progetto").trim();
		      String contratto  = request.getParameter("contratto").trim();
		      String linkcur  = request.getParameter("linkcur").trim();
		      Integer idmoda = new Integer(request.getParameter("id_moda"));
		      
		      Traspubblicazioni trasp = new Traspubblicazioni();
		      
		      trasp.setIdtrasp(idtrasp);
		      trasp.setFpubblic(fpubblic);
		      trasp.setProgetto(progetto);
		      trasp.setContratto(contratto);
		      trasp.setLinkcur(linkcur);
		      trasp.setIdmoda(idmoda);
		      
		      Integer returnvalue = 0;

		      returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "updateTras", new Object[] {trasp,idutente}); 
		      
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
	              returnError("0", response);  
		      
		      
		      
		    } catch (Exception e) {
			      returnError(e.getMessage(), response);
			      e.printStackTrace();
			    }
		      
		    }	
	  
	  
		private void pubblicawebdb(HttpServletRequest request, HttpServletResponse response) {

			try {
				Object persistence = getObjectPersistence(request);
				
				Integer praid = Integer.valueOf(request.getParameter("key"));
				
				String controllo = "N";
				if (request.getParameter("cont") != null && !request.getParameter("cont").trim().equals(""))
					controllo = request.getParameter("cont").trim().toUpperCase(); 
				
				String returnvalue;
					returnvalue = (String)MethodUtils.invokeMethod(persistence, "pubblicaWebdb", new Object[] {praid,controllo});
					
			if (returnvalue != null)
				returnSuccess(returnvalue, response);
			else 
				returnError("", response);

		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
			
		}
		
		  private void docwebdbUpdate(HttpServletRequest request, HttpServletResponse response) {

			    try {
			    	
				      Object persistence = getObjectPersistence(request);
				      
				      
				      Integer id_doc = new Integer(request.getParameter("tlp_id"));
				      String titolo   = request.getParameter("tlp_titolo");
				      
				      
				      Boolean returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "updateDocdbPraweb", new Object[] {id_doc,titolo});
				      
				      if (returnvalue) 
				          returnSuccess(returnvalue.toString(), response);
				      else 
		    	          returnError("0", response); 
				      
			    } catch (Exception e) {
				      returnError(e.getMessage(), response);
				      e.printStackTrace();
				}  	
				      

			  }	      
			  
		  private void docwebdbRemove(HttpServletRequest request, HttpServletResponse response) {

			    try {
			    	
				      Object persistence = getObjectPersistence(request);
				      
	    			  //	System.out.println(" ELIMINATA PUBBLICAZIONE ");
				      
				      Integer id_doc = new Integer(request.getParameter("tlp_id"));
				      
				      Integer id_user = new Integer(request.getParameter("tlp_user"));
				      
				      Boolean returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "removeDocdbPraweb", new Object[] {id_doc,id_user});
				      
				      if (returnvalue) 
				          returnSuccess(returnvalue.toString(), response);
				      else 
		    	          returnError("0", response); 
				      
			    } catch (Exception e) {
				      returnError(e.getMessage(), response);
				      e.printStackTrace();
				}  	
				      

			  }	      
	  

	  private void TrasPubblica(HttpServletRequest request, HttpServletResponse response) {
		    try {

		    	
		      Object persistence = getObjectPersistence(request);
		      
		      Integer idutente = new Integer(request.getParameter("idutente"));
		      
		      Integer idtrasp = new Integer(request.getParameter("idtrasp"));
		      String fpubblic  = request.getParameter("fpubblic");
		      
		      String progetto  = request.getParameter("progetto").trim();
		      String contratto  = request.getParameter("contratto").trim();
		      String linkcur  = request.getParameter("linkcur").trim();
		      Integer idmoda = new Integer(request.getParameter("id_moda"));
		      
		      Traspubblicazioni trasp = new Traspubblicazioni();
		      
		      trasp.setIdtrasp(idtrasp);
		      trasp.setFpubblic(fpubblic);
		      trasp.setProgetto(progetto);
		      trasp.setContratto(contratto);
		      trasp.setLinkcur(linkcur);
		      trasp.setIdmoda(idmoda);
		      
		      Integer returnvalue = 0;

		      returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "pubblicaTras", new Object[] {trasp,idutente}); 
		      
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
	              returnError("0", response);  
		      
		      
		      
		    } catch (Exception e) {
			      returnError(e.getMessage(), response);
			      e.printStackTrace();
			    }
		      
		    }	
	  
	  private void pratichewebUpdate(HttpServletRequest request, HttpServletResponse response) {
		    try {

		      Object persistence = getObjectPersistence(request);
		      
		      Integer pra_id = new Integer(request.getParameter("pra_id"));
		      Integer uff_id   = new Integer(request.getParameter("iduffici"));
		      String href = "";
		      String dref = "";
		      String contatto = "";
		      String orario = "";
		      
		      String nome = request.getParameter("nome");
		      String descr = request.getParameter("descr");
		      String documentaz = request.getParameter("documentaz");
		      
		      if (request.getParameter("contatto") != null)
		    	  contatto = request.getParameter("contatto");
		      if (request.getParameter("orario") != null)
		    	  orario = request.getParameter("orario");
		      
		      
		      if (request.getParameter("href") != null)
		           href = request.getParameter("href");
		      if (request.getParameter("dref") != null)
  		      dref = request.getParameter("dref");
		      
		      
		      PraticheWebiProxy pratica = new PraticheWebiProxy();
		      
            if (! pra_id.equals(0))
		       pratica.setPra_id(pra_id);
            
		      pratica.setPra_nome(nome);
		      pratica.setPra_descr(descr);
		      pratica.setPra_documentaz(documentaz);
		      pratica.setPra_contatto(contatto);
		      pratica.setPra_orario(orario);
		      
		      pratica.setPra_href(href);
		      pratica.setPra_dref(dref);
		      
		      
		      pratica.setPra_iduff(uff_id);

		      Integer returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "updatePraweb", new Object[] {pratica});
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
  	          returnError("0", response); 
		      
		    } catch (Exception e) {
		      returnError(e.getMessage(), response);
		      e.printStackTrace();
		    }
		  }	
	  
	  private void tipopubblicazioneUpdate(HttpServletRequest request, HttpServletResponse response) {
		    try {

		      Object persistence = getObjectPersistence(request);
		      
		      Integer ttp_id = new Integer(request.getParameter("ttp_id"));
		      
		      
		      String ttp_descr = request.getParameter("ttp_descr");
		      String ttp_testo = "";
		      String ttp_tipo = "";
		      String ttp_pathdestinazione = "";
		      
		      if (request.getParameter("ttp_tipo") != null)
		    	  ttp_tipo = request.getParameter("ttp_tipo");

		      if (request.getParameter("ttp_testo") != null)
		    	  ttp_testo = request.getParameter("ttp_testo");
		      
		      if (request.getParameter("ttp_pathdestinazione") != null)
		    	  ttp_pathdestinazione = request.getParameter("ttp_pathdestinazione");

		      String ttp_flalbo = request.getParameter("ttp_hflalbo");
		      String ttp_flnews = request.getParameter("ttp_hflnews");
		      String ttp_flattiv = request.getParameter("ttp_hflattiv");
		      String ttp_fldatascad = request.getParameter("ttp_hfldatascad");
		      String ttp_suser = request.getParameter("ttp_hsuser");
		      
		      String ttp_user = "";
		      if (request.getParameter("ttp_user") != null)
		    	  ttp_user = request.getParameter("ttp_user");
		      
		      String ttp_fllotus = "";
		      if (request.getParameter("ttp_fllotus") != null)
		    	  ttp_fllotus = request.getParameter("ttp_fllotus");
		      
		      String ttp_camponatto = "";
		      if (request.getParameter("ttp_camponatto") != null)
		    	  ttp_camponatto = request.getParameter("ttp_camponatto");
		      
		      String ttp_campodatto = "";
		      if (request.getParameter("ttp_campodatto") != null)
		    	  ttp_campodatto = request.getParameter("ttp_campodatto");
		      
		      String ttp_tipoattolotus = "";
		      if (request.getParameter("ttp_tipoattolotus") != null)
		    	  ttp_tipoattolotus = request.getParameter("ttp_tipoattolotus");
		      
		      
		      Integer ttp_numord = 0;
		      if (request.getParameter("ttp_numord") != null)
		    	  ttp_numord = new Integer(request.getParameter("ttp_numord"));

		      Integer ttp_idini = 0;
		      if (request.getParameter("ttp_idini") != null)
		    	  ttp_idini = new Integer(request.getParameter("ttp_idini"));

		      Integer ttp_ggalbo = 0;
		      if (request.getParameter("ttp_ggalbo") != null)
		    	  ttp_ggalbo = new Integer(request.getParameter("ttp_ggalbo"));
		      
		      
		      TipoPubbliProxy pratica = new TipoPubbliProxy();
		      
          if (! ttp_id.equals(0))
		       pratica.setTtp_id(ttp_id);
          
		      pratica.setTtp_campodatto(ttp_campodatto);
		      pratica.setTtp_camponatto(ttp_camponatto);
		      pratica.setTtp_descr(ttp_descr);
		      pratica.setTtp_flalbo(ttp_flalbo);
		      pratica.setTtp_flattiv(ttp_flattiv);
		      pratica.setTtp_fldatascad(ttp_fldatascad);
		      pratica.setTtp_fllotus(ttp_fllotus);
		      pratica.setTtp_flnews(ttp_flnews);
		      pratica.setTtp_ggalbo(ttp_ggalbo);
		      pratica.setTtp_id(ttp_id);
		      pratica.setTtp_numord(ttp_numord);
		      pratica.setTtp_pathdestinazione(ttp_pathdestinazione);
		      pratica.setTtp_suser(ttp_suser);
		      pratica.setTtp_testo(ttp_testo);
		      pratica.setTtp_tipo(ttp_tipo);
		      pratica.setTtp_tipoattolotus(ttp_tipoattolotus);
		      pratica.setTtp_idini(ttp_idini);
		      pratica.setTtp_user(ttp_user);
		      
		      
		      

		      Integer returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "updateTipoPraweb", new Object[] {pratica});
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
	          returnError("0", response); 
		      
		    } catch (Exception e) {
		      returnError(e.getMessage(), response);
		      e.printStackTrace();
		    }
		  }
	  
		private void pratichewebDelete(HttpServletRequest request, HttpServletResponse response) {

			try {
				Object persistence = getObjectPersistence(request);
				
				Integer praid = Integer.valueOf(request.getParameter("key"));
				
				Boolean returnvalue;
					returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "removePubblicaWeb", new Object[] {praid});
					
			if (returnvalue)
				returnSuccess("Rimozione pubblicazione avvenuta con successo", response);
			else 
				returnError("Rimozione publicazione NON AVVENUTA", response);

		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
			
		}
		
		private void tipopubblicazioneDelete(HttpServletRequest request, HttpServletResponse response) {

			try {
				Object persistence = getObjectPersistence(request);
				
				Integer praid = Integer.valueOf(request.getParameter("key"));
				
				Boolean returnvalue;
					returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "removeTipoPubblWeb", new Object[] {praid});
					
			if (returnvalue)
				returnSuccess("", response);
			else 
				returnError("Rimozione tipo pubblicazione NON AVVENUTA", response);

		} catch (Exception e) {
			returnError(e.getMessage(), response);
			e.printStackTrace();
		}
			
		}	  
	  
	  private void TrasXpubblica(HttpServletRequest request, HttpServletResponse response) {
		    try {

		    	
		      Object persistence = getObjectPersistence(request);
		      
		      Integer idutente = new Integer(request.getParameter("idutente"));
		      
		      Integer idtrasp = new Integer(request.getParameter("idtrasp"));
		      String fpubblic  = request.getParameter("fpubblic");
		      
		      String progetto  = request.getParameter("progetto").trim();
		      String contratto  = request.getParameter("contratto").trim();
		      String linkcur  = request.getParameter("linkcur").trim();
		      Integer idmoda = new Integer(request.getParameter("id_moda"));
		      
		      Traspubblicazioni trasp = new Traspubblicazioni();
		      
		      trasp.setIdtrasp(idtrasp);
		      trasp.setFpubblic(fpubblic);
		      trasp.setProgetto(progetto);
		      trasp.setContratto(contratto);
		      trasp.setLinkcur(linkcur);
		      trasp.setIdmoda(idmoda);
		      
		      Integer returnvalue = 0;

		      returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "xpubblicaTras", new Object[] {trasp,idutente}); 
		      
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
	              returnError("0", response);  
		      
		      
		      
		    } catch (Exception e) {
			      returnError(e.getMessage(), response);
			      e.printStackTrace();
			    }
		      
		    }	
	  
	  private void 	  arspUpdate(HttpServletRequest request, HttpServletResponse response) {
	      Object persistence = getObjectPersistence(request);
	      
		    try {	      
											  
		      Integer id = new Integer(request.getParameter("pra_idiosono"));
		      
		      Integer anziano       = 0; 
		      Integer cittadino     = 0;
		      Integer donna         = 0; 
		      Integer genitore      = 0;
		      Integer bambino       = 0; 
		      Integer disabile      = 0; 
		      Integer immigrato     = 0; 
		      Integer giovane       =  0;  
		      Integer associazione  =  0;
		      
		      
		      if (request.getParameter("tars_anziano") != null)
		         anziano   =  new Integer(request.getParameter("tars_anziano"));
		      if (request.getParameter("tars_cittadino") != null)
		         cittadino    = new Integer(request.getParameter("tars_cittadino"));
		      if (request.getParameter("tars_donna") != null)
	    	      donna   =  new Integer(request.getParameter("tars_donna"));
		      if (request.getParameter("tars_genitore") != null)
	       	      genitore   =  new Integer(request.getParameter("tars_genitore"));
		      if (request.getParameter("tars_bambino") != null)
	    	      bambino   =  new Integer(request.getParameter("tars_bambino"));
		      if (request.getParameter("tars_disabile") != null)
	    	      disabile   =  new Integer(request.getParameter("tars_disabile"));
		      if (request.getParameter("tars_immigrato") != null)
	    	      immigrato   =  new Integer(request.getParameter("tars_immigrato"));	      
		      
		      if (request.getParameter("tars_giovane") != null)
		    	  giovane = new Integer(request.getParameter("tars_giovane"));
		      if (request.getParameter("tars_associazione") != null)
		    	  associazione = new Integer(request.getParameter("tars_associazione"));
	      
	      
//	      System.out.println("--------------------------------------------------------");
//	      System.out.println(" id ["+id+"]");
//	      System.out.println(" anziano ["+anziano+"]");
//	      System.out.println(" cittadino ["+cittadino+"]");
//	      System.out.println(" donna ["+donna+"]");
//	      System.out.println(" genitore ["+genitore+"]");
//	      System.out.println(" bambino ["+bambino+"]");
//	      System.out.println(" disabile ["+disabile+"]");
//	      System.out.println(" immigrato ["+immigrato+"]");
//	      System.out.println(" giovane ["+giovane+"]");
//	      System.out.println(" associazione ["+associazione+"]");
//	      System.out.println("=========================================================");
	      	      
		  
//		  aripUpdate

		      Integer returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "updateArsp", new Object[] {id,
																							                   anziano,
																							                   cittadino,
																							                   donna,
																							                   genitore,
																							                   bambino,
																							                   disabile,
																							                   immigrato,
																							                   giovane,
																							                   associazione});
		      
		      
		      
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
  	          returnError("0", response);  
		      
		    } catch (Exception e) {
		      returnError(e.getMessage(), response);
		      e.printStackTrace();
		    }		      
		      
	  }
	  
	  private void 	  aripUpdate(HttpServletRequest request, HttpServletResponse response) {
	      Object persistence = getObjectPersistence(request);
	      
		    try {	      
											  
		      Integer id = new Integer(request.getParameter("pra_idmiinte"));
		      
		      
				Integer tari_casa             = 0;
				Integer tari_averefamiglia    = 0;
				Integer tari_averefigli       = 0;
				Integer tari_faresport        = 0;
				Integer tari_lavorare         = 0;
				Integer tari_pagaretasse      = 0;
				Integer tari_salute           = 0;
				Integer tari_studiare         = 0;
				Integer tari_tempolibero      = 0;
				Integer tari_aprireattivita   = 0;
				Integer tari_mezzotrasporto	  = 0;  
		      
		      if (request.getParameter("tari_casa") != null)
		    	  tari_casa   =  new Integer(request.getParameter("tari_casa"));
	      
		      if (request.getParameter("tari_averefamiglia") != null)
		    	  tari_averefamiglia   =  new Integer(request.getParameter("tari_averefamiglia"));
		      if (request.getParameter("tari_averefigli") != null)
		    	  tari_averefigli   =  new Integer(request.getParameter("tari_averefigli"));
		      if (request.getParameter("tari_faresport") != null)
		    	  tari_faresport   =  new Integer(request.getParameter("tari_faresport"));
		      
		      if (request.getParameter("tari_lavorare") != null)
		    	  tari_lavorare   =  new Integer(request.getParameter("tari_lavorare"));
		      
		      if (request.getParameter("tari_pagaretasse") != null)
		    	  tari_pagaretasse   =  new Integer(request.getParameter("tari_pagaretasse"));
		      if (request.getParameter("tari_salute") != null)
		    	  tari_salute   =  new Integer(request.getParameter("tari_salute"));
		      
		      if (request.getParameter("tari_studiare") != null)
		    	  tari_studiare   =  new Integer(request.getParameter("tari_studiare"));
		      if (request.getParameter("tari_tempolibero") != null)
		    	  tari_tempolibero   =  new Integer(request.getParameter("tari_tempolibero"));
		      
		      if (request.getParameter("tari_aprireattivita") != null)
		    	  tari_aprireattivita   =  new Integer(request.getParameter("tari_aprireattivita"));
		      if (request.getParameter("tari_mezzotrasporto") != null)
		    	  tari_mezzotrasporto   =  new Integer(request.getParameter("tari_mezzotrasporto"));
	      
//	      System.out.println("--------------------------------------------------------");
//	      System.out.println(" id ["+id+"]");
//	      System.out.println(" anziano ["+anziano+"]");
//	      System.out.println(" cittadino ["+cittadino+"]");
//	      System.out.println(" donna ["+donna+"]");
//	      System.out.println(" genitore ["+genitore+"]");
//	      System.out.println(" bambino ["+bambino+"]");
//	      System.out.println(" disabile ["+disabile+"]");
//	      System.out.println(" immigrato ["+immigrato+"]");
//	      System.out.println(" giovane ["+giovane+"]");
//	      System.out.println(" associazione ["+associazione+"]");
//	      System.out.println("=========================================================");
	      	      
		  
//		  aripUpdate

		      Integer returnvalue = (Integer)MethodUtils.invokeMethod(persistence, "updateArip", new Object[] {id,
																								    		  tari_casa,
																								    		  tari_averefamiglia,
																								    		  tari_averefigli,
																								    		  tari_faresport,
																								    		  tari_lavorare,
																								    		  tari_pagaretasse,
																								    		  tari_salute,
																								    		  tari_studiare,
																								    		  tari_tempolibero,
																								    		  tari_aprireattivita,
																								    		  tari_mezzotrasporto});
		      
		      
		      
		      
		      if (returnvalue != null) 
		          returnSuccess(returnvalue.toString(), response);
		      else 
  	          returnError("0", response);  
		      
		    } catch (Exception e) {
		      returnError(e.getMessage(), response);
		      e.printStackTrace();
		    }		      
		      
	  }
	  
	  
	  private void docwebAdd(HttpServletRequest request, HttpServletResponse response) {
		    try {

		      Object persistence = getObjectPersistence(request);
		      FileItem fileItem = null;
		      String optionalFileName = "";
		  	  FTPClient clientftp;
		  	  
		  	  String titolo = "";
		  	  Integer idpratica = 0;

		      
				//request.setCharacterEncoding("UTF-8");
		        final String separator = java.lang.System.getProperty("file.separator");
		        
		        
				  ServletFileUpload servletFieldUpload = new ServletFileUpload(new DiskFileItemFactory());
			        
				  HashMap requestMap = new HashMap();
				  
				  List fieldItemsList;
		        
					fieldItemsList = servletFieldUpload.parseRequest(request);

					  Iterator it = fieldItemsList.iterator();
						 
					  while (it.hasNext()){
						 	
					    FileItem fieldItemTemp = (FileItem)it.next();
					
					    if (fieldItemTemp.isFormField()) {
					    	requestMap.put(fieldItemTemp.getFieldName(), fieldItemTemp.getString());
					 
						      if (fieldItemTemp.getFieldName().equals("filename"))
						        optionalFileName = fieldItemTemp.getString();
						    }
						    else
						    	fileItem = fieldItemTemp;
					    
		      
					  }
					  
					  
					  
			if ((requestMap.get("pra_id_doc") != null) && (!requestMap.get("pra_id_doc").equals("-1"))) 
				idpratica = Integer.valueOf(requestMap.get("pra_id_doc").toString().trim());
			
			
			if ((requestMap.get("prl_titolo") != null) && (!requestMap.get("prl_titolo").equals(""))) 
				titolo = (String)requestMap.get("prl_titolo");
				
			
			
			  if (fileItem!=null){
				  
				    String fileName = fileItem.getName();
				    if (fileItem.getSize() > 0){
				    	
				    	
			        if (optionalFileName.trim().equals("")) fileName = FilenameUtils.getName(fileName);
					else  fileName = optionalFileName;
			        
			        
			        InputStream strsend = fileItem.getInputStream();
			        
				/*	
				 * Solo per testare lo stream di invio
				 * 
				 * int lines = 0, width = 0;
					StringBuilder buf = new StringBuilder();
					try {
						BufferedReader rdr = new BufferedReader(new InputStreamReader(pippo, "utf-8"));
						String line = null;
						while ((line = rdr.readLine()) != null) {
							System.out.println(line);
						}
						rdr.close();
					} catch (Exception ex) {
						// ignore
					} */
					
			        
	    				clientftp = new FTPClient();
  					clientftp.addProtocolCommandListener(new ProtocolCommandListener(){
			
						  public void protocolCommandSent(ProtocolCommandEvent arg0) {}
						  public void protocolReplyReceived(ProtocolCommandEvent arg0) {}
					    });
  					
  					MasterUrlWebiProxy returnvalue = (MasterUrlWebiProxy)MethodUtils.invokeMethod(persistence, "getMasterUrlWeb", null );
  					
  					
  					clientftp.connect(returnvalue.getTmu_host().trim());
  					
  					clientftp.enterLocalPassiveMode();
  					int reply = clientftp.getReplyCode();
  					
  					
  					if (FTPReply.isPositiveCompletion(reply)) {
  						
  						
							if (clientftp.login(returnvalue.getTmu_user().trim(),returnvalue.getTmu_psw().trim())) {
								
								if (clientftp.isConnected()) {
									
									clientftp.setFileType(FTPClient.BINARY_FILE_TYPE);
									
									// Se l'invio FTP è riuscito scrivo i dati 
									// ---------------------------------------
									
									if (clientftp.storeFile(returnvalue.getTmu_pathftp()+returnvalue.getTmu_pathpratiche()+idpratica.toString().trim()+fileItem.getName(),strsend)) {
										
										LinkPraticheWebiProxy docpratica = new LinkPraticheWebiProxy();
										
										docpratica.setPrl_nomefile(idpratica.toString().trim()+fileItem.getName().trim());
										docpratica.setPrl_url(returnvalue.getTmu_homepage()+returnvalue.getTmu_pathpratiche()+idpratica.toString().trim()+fileItem.getName().trim());
										docpratica.setPrl_titolo(titolo);
										
										Boolean okwrite = (Boolean)MethodUtils.invokeMethod(persistence, "newDocPraweb", new Object[] {idpratica,docpratica});
										
										
										//if (okwrite)
   									//	System.out.println(" HELLO, CONNECTION OK, MA BRAVO.... ["+returnvalue.getTmu_psw().trim()+"] NOME FILE ["+returnvalue.getTmu_pathftp()+returnvalue.getTmu_pathpratiche()+fileItem.getName()+"]");
										
									} 

									
									clientftp.disconnect();
									
								}
								
								
							}
  						
  					}
  					
			        
					}   
				    	
				  
			  }
			
		      
		    } catch (Exception e) {
			      returnError(e.getMessage(), response);
			      e.printStackTrace();
			}  	
		      
	    }	      
	  
	  private void docwebUpdate(HttpServletRequest request, HttpServletResponse response) {

		    try {
		    	
			      Object persistence = getObjectPersistence(request);
			      
			      
			      Integer pra_id_doc = new Integer(request.getParameter("pra_id_doc"));
			      String titolo   = request.getParameter("prl_titolo");
			      
			      
			      Boolean returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "updateDocPraweb", new Object[] {pra_id_doc,titolo});
			      
			      if (returnvalue) 
			          returnSuccess(returnvalue.toString(), response);
			      else 
	    	          returnError("0", response); 
			      
		    } catch (Exception e) {
			      returnError(e.getMessage(), response);
			      e.printStackTrace();
			}  	
			      

		  }	      
		  
	  private void docwebRemove(HttpServletRequest request, HttpServletResponse response) {

		    try {
		    	
			      Object persistence = getObjectPersistence(request);
			      
			      
			      Integer pra_id_doc = new Integer(request.getParameter("id_doc"));
			      
			      Boolean returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "removeDocPraweb", new Object[] {pra_id_doc});
			      
			      if (returnvalue) 
			          returnSuccess(returnvalue.toString(), response);
			      else 
	    	          returnError("0", response); 
			      
		    } catch (Exception e) {
			      returnError(e.getMessage(), response);
			      e.printStackTrace();
			}  	
			      

		  }	      
	  
	  
		private void ufficiwebList(HttpServletRequest request, HttpServletResponse response) {

			
			Object persistence = getObjectPersistence(request);
			
			Integer utente = new Integer(request.getParameter("id"));
			String  allStr = request.getParameter("all");
			Boolean all = false;
			if (allStr.equals("X"))
				all = true;

			try {
				
				returnArray(MethodUtils.invokeMethod(persistence, "getUfficiWeb", new Object[] {utente,all}), response);
				
			} catch (Exception e) {
				returnError(e.getMessage(), response);
				e.printStackTrace();
			}
			
		}
		
	  
		private void pratichewebList(HttpServletRequest request, HttpServletResponse response) {

			
			Object persistence = getObjectPersistence(request);
			
			Integer ufficio = 0;
			Integer utente = new Integer(request.getParameter("utente"));
			if (request.getParameter("ufficio") != null && !request.getParameter("ufficio").trim().equals(""))
			    ufficio = new Integer(request.getParameter("ufficio"));
			
			String  nome = request.getParameter("nome");

			try {
				
				returnArray(MethodUtils.invokeMethod(persistence, "getPraticheWeb", new Object[] {utente,ufficio,nome}), response);
				
			} catch (Exception e) {
				returnError(e.getMessage(), response);
				e.printStackTrace();
			}
			
		}
		
		private void attiListSel(HttpServletRequest request, HttpServletResponse response) {

			Object persistence = getObjectPersistence(request);
			
			String descrizione = "";
			if (request.getParameter("descrizione") != null && !request.getParameter("descrizione").trim().equals(""))
				descrizione = request.getParameter("descrizione").trim(); 
			
			
			String tipo = request.getParameter("tipo").trim();
			
			
			String dataicar = null;
			if ((request.getParameter("datai") != null) && (! request.getParameter("datai").equals(""))) 
				dataicar = request.getParameter("datai");
			else
				dataicar = "";
			
			
			String  nome = request.getParameter("nome");

			try {
				
				returnArray(MethodUtils.invokeMethod(persistence, "getAttiDelisa", new Object[] {descrizione,tipo,dataicar}), response);
				
			} catch (Exception e) {
				returnError(e.getMessage(), response);
				e.printStackTrace();
			}
			
		}
				
		
		private void pranolinkwebList(HttpServletRequest request, HttpServletResponse response) {

			
			Object persistence = getObjectPersistence(request);
			
			Integer pubbl = new Integer(request.getParameter("idpratica"));

			try {
				
				returnArray(MethodUtils.invokeMethod(persistence, "getNotLinkPraticheWeb", new Object[] {pubbl}), response);
				
			} catch (Exception e) {
				returnError(e.getMessage(), response);
				e.printStackTrace();
			}
			
		}
		
		
		
		private void pralinkwebList(HttpServletRequest request, HttpServletResponse response) {

			
			Object persistence = getObjectPersistence(request);
			
			Integer pubbl = new Integer(request.getParameter("idpratica"));

			try {
				
				returnArray(MethodUtils.invokeMethod(persistence, "getLinkPraticheWeb", new Object[] {pubbl}), response);
				
			} catch (Exception e) {
				returnError(e.getMessage(), response);
				e.printStackTrace();
			}
			
		}
		
		  private void docwebAddSel(HttpServletRequest request, HttpServletResponse response) {

			    try {
			    	
				      Object persistence = getObjectPersistence(request);
				      
				      
				      Integer pra_id_doc = new Integer(request.getParameter("keyadd"));
				      Integer pra_id = new Integer(request.getParameter("idpratica"));
				      
				      
				      
				      Boolean returnvalue = (Boolean)MethodUtils.invokeMethod(persistence, "addselDocPraweb", new Object[] {pra_id_doc,pra_id});
				      
				      if (returnvalue) 
				          returnSuccess(returnvalue.toString(), response);
				      else 
		    	          returnError("0", response); 
				      
			    } catch (Exception e) {
				      returnError(e.getMessage(), response);
				      e.printStackTrace();
				}  	
				      

			  }	      
	  
		
	  
	private IntrawebPersistenceFacade getPersistence(HttpServletRequest request) throws NullPointerException {
		return (IntrawebPersistenceFacade)request.getSession().getAttribute("app.persistence");
	}

	private Object getObjectPersistence(HttpServletRequest request) throws NullPointerException {
		return request.getSession().getAttribute("app.persistence");
	}
	
	private JsonConfig conf = new JsonConfig();
	
}
package intrawebsession;

import intraweb.Ariprati;
import intraweb.Arsprati;
import intraweb.AutxtipopubiProxy;
import intraweb.LinkPraticheWebiProxy;
import intraweb.LinkPubblicazioniWebiProxy;
import intraweb.LogTableiProxy;
import intraweb.MasterUrlWebiProxy;
import intraweb.Modassegnazione;
import intraweb.PratPubblicazioniWebiProxy;
import intraweb.PraticheWebiProxy;
import intraweb.PubblicazioniWebiProxy;
import intraweb.SettoriWebiProxy;
import intraweb.TipoPubbliProxy;
import intraweb.Traspubblicazioni;
import intraweb.UfficiTrasWebProxy;
import intraweb.UtentiTrasWebProxy;
import intraweb.dbpubblica;
import intraweb.dbpubblicaalleg;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;



public @Stateless 
class IntrawebPersistenceFacadeBean implements IntrawebPersistenceFacade {
	@PersistenceContext(unitName="gestionale") EntityManager GestionaleEm;
	@PersistenceContext(unitName="anagrafe") EntityManager AnagrafeEm;
	@PersistenceContext(unitName="webdb") EntityManager WebDb;

	public Object get(Object prototype) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(Object object) throws Exception {
		try {
			GestionaleEm.merge(object);
			GestionaleEm.flush();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public Object getById(long id, String className) throws Exception {
		try {
			Object ret = GestionaleEm.createQuery(
			"SELECT c FROM " + className + " c WHERE c.id=:clasId")
			.setParameter("clasId",id)
			.getSingleResult();	
			
			
			 return ret;
		} catch (Exception e) {
			throw e;
		}
		
	}

	public Object findByPrimaryKey(Class clazz, Object key) throws Exception {
		
		return GestionaleEm.find(clazz, key);
	}

	public Object findByWebPrimaryKey(Class clazz, Object key) throws Exception {
		
		return WebDb.find(clazz, key);
	}

	public List<Traspubblicazioni> getPubblicazioniWeb (Integer utente,String descrizione,String selezione,Integer daanno)  throws Exception {
		
		
		List<Traspubblicazioni> pubblicazioniReturn = new ArrayList<Traspubblicazioni>();
		
		  GregorianCalendar calendar = new GregorianCalendar();
		  calendar.set(Calendar.YEAR,daanno);
		  calendar.set(Calendar.MONTH,0);
		  calendar.set(Calendar.DAY_OF_MONTH,0);

		// Reperisci id ufficio da utente
		// ------------------------------
		  
		  
			List retUtenti = WebDb.createNamedQuery("UtentiTrasWebProxy.selectByUser")
			.setParameter("id",utente)
			.getResultList();
		  
		 if (retUtenti.size() > 0 ) {	
		  
/*		  UtentiTrasWebProxy utentefind = (UtentiTrasWebProxy)findByWebPrimaryKey(UtentiTrasWebProxy.class,utente);
		  List retPubblicazioni = null;
		  
		  if (utentefind != null) { */
			
			 List retPubblicazioni = null;
			 UtentiTrasWebProxy utentefind =  (UtentiTrasWebProxy)retUtenti.get(0);
			 
     		UfficiTrasWebProxy ufficiofind = (UfficiTrasWebProxy)findByWebPrimaryKey(UfficiTrasWebProxy.class,utentefind.getTus_idufficio());	  
		
	     	if (ufficiofind != null) {
	     		
	     		Integer iduff = ufficiofind.getTuf_id();
	     		
	     		// Testa se espresso soggetto
	     		// --------------------------
	     		if (!descrizione.trim().equals(""))  {
	     			
	     			String descr = "%"+descrizione.trim().toUpperCase()+"%";
	     			
					// Testa tipo interrogazione
					// -------------------------
					  
					  
					if (selezione.equals("0"))  // Da pubblicare
						retPubblicazioni = WebDb.createNamedQuery("Traspubblicazioni.selectBySoggettoUfficioNopub")
						.setParameter("id",iduff)
						.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
						.setParameter("desc",descr)
						.getResultList();
						
					else if (selezione.equals("1"))	// Pubblicati
						
						retPubblicazioni = WebDb.createNamedQuery("Traspubblicazioni.selectBySoggettoUfficioPub")
						.setParameter("id",iduff)
						.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
						.setParameter("desc",descr)
						.getResultList();
						
					else if (selezione.equals("2"))   // Da non pubblicare
						
						retPubblicazioni = WebDb.createNamedQuery("Traspubblicazioni.selectBySoggettoUfficioXpub")
						.setParameter("id",iduff)
						.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
						.setParameter("desc",descr)
						.getResultList();
						
	     			
	     		} else {
	     			
	     			
					if (selezione.equals("0"))  // Da pubblicare
						retPubblicazioni = WebDb.createNamedQuery("Traspubblicazioni.selectByUfficioNopub")
						.setParameter("id",iduff)
						.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
						.getResultList();
						
					else if (selezione.equals("1"))	// Pubblicati
						
						retPubblicazioni = WebDb.createNamedQuery("Traspubblicazioni.selectByUfficioPub")
						.setParameter("id",iduff)
						.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
						.getResultList();
						
					else if (selezione.equals("2"))   // Da non pubblicare
						
						retPubblicazioni = WebDb.createNamedQuery("Traspubblicazioni.selectByUfficioXpub")
						.setParameter("id",iduff)
						.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
						.getResultList();
	     			
	     		}
	     		
				
		    }
	     	
	     	if (retPubblicazioni != null) {
	     		
	     	// Carica se definita tipo modalita
	     	// --------------------------------
	     	
	     	for (Iterator iter = retPubblicazioni.iterator(); iter.hasNext();) {
				Traspubblicazioni element = (Traspubblicazioni) iter.next();
				
				String modalita = "";
				if (!element.getIdmoda().equals(0)) {
					
					Modassegnazione	 modalitafind = (Modassegnazione)findByWebPrimaryKey(Modassegnazione.class,element.getIdmoda());
					if (modalitafind != null)
						modalita = modalitafind.getDescrizione();
		    		
				}
				element.setModalita(modalita);
			}
	     	
        		pubblicazioniReturn = retPubblicazioni;
        		
	     	}
	     	
	     	
		
		  }	
		
			return pubblicazioniReturn;
		
	}
	
	public List<Modassegnazione> getModalitaWeb()  throws Exception {
		
		return WebDb.createNamedQuery("Modassegnazione.selectAll")
		.getResultList();
		
	}
	
	public ArrayList<TipoPubbliProxy> getTipoWebFromUser(Integer user,Integer ente) {
		ArrayList<TipoPubbliProxy> listaTipo = new ArrayList<TipoPubbliProxy>();
		
		// ---------------------------------------
		// 1) Ricerca delle risorse di tipo utente
		// ---------------------------------------
		
		List retUser = WebDb.createNamedQuery("UtentiTrasWebProxy.selectByUser")
		.setParameter("id", user)
		.getResultList();
		
		for (Iterator iter = retUser.iterator(); iter.hasNext();) {
			UtentiTrasWebProxy element = (UtentiTrasWebProxy) iter.next();
			
			
			
			// -----------------------------------
			// carica tipo pubblicazioni collegate
			// -----------------------------------

			List retTipo = WebDb.createNamedQuery("AutxtipopubiProxy.selectByUser")
			.setParameter("id", element.getTus_id())
			.getResultList();
			
			for (Iterator itertipo = retTipo.iterator(); itertipo.hasNext();) {
				
				AutxtipopubiProxy elementaut = (AutxtipopubiProxy) itertipo.next();
				
				try {
					
					
					final Object proctypeobj = WebDb.find(TipoPubbliProxy.class,elementaut.getTat_idtipopub());
					if (proctypeobj != null) {
						
						TipoPubbliProxy proctype = (TipoPubbliProxy)proctypeobj;
						
						listaTipo.add(proctype);
	
					}	
				
				} catch (Exception e) {
					e.printStackTrace();
				}  
		}
		}	
		
		return listaTipo;
	}
	
	public List<LinkPubblicazioniWebiProxy> getLinkPubblicazioniWeb(Integer id) throws Exception {
		ArrayList<LinkPubblicazioniWebiProxy> linkPubblReturn = new ArrayList<LinkPubblicazioniWebiProxy>();
		
		ArrayList<LinkPubblicazioniWebiProxy> LinkList = (ArrayList<LinkPubblicazioniWebiProxy>)WebDb.createNamedQuery("LinkPubblicazioniWebiProxy.selectByPubbl")
		.setParameter("id",id)
		.getResultList();	
		
		if (LinkList != null)
			linkPubblReturn = LinkList; 
		
		
		return linkPubblReturn;
	}
	
	public List<dbpubblica> getAttiDelisa(String descrizione,String tipo,String datai) throws Exception {
		
		ArrayList<dbpubblica> attilist = new ArrayList<dbpubblica>();
		
		HashMap<Double,dbpubblica> unica = new HashMap<Double,dbpubblica>(); 
		
//		System.out.println("desxcrizione ["+descrizione+"]");
//		System.out.println("dataini ["+datai+"]");
		
/*		String selectstr = "SELECT DISTINCT pr_cod_prat,oggetto,pratica,id_tipoproc,desc_tipoproc, "+
		" id_tipoprat,desc_tipoprat,id_uff,desc_uff,atto,tipo_atto "+
		"  FROM db_pubblica "; */
		String selectstr = "SELECT db "+
		"  FROM dbpubblica db ";
		String congiunzione = " WHERE ";
		boolean esegui = false;

		selectstr += congiunzione+ " db.id_tipoprat ='"+tipo+"' ";
		congiunzione = " AND ";
		
		
		if (datai != null && ! datai.trim().equals("")) {
	       selectstr += congiunzione+ " TO_CHAR(db.data_atto, 'YYYY-MM-DD') >= '"+ InverseDate(datai)+"'";
		   congiunzione = " AND ";		    
		}
		
		if (!descrizione.trim().equals("")) 
			selectstr += congiunzione+ " db.atto LIKE '%"+descrizione.trim()+"%'";
		

//        System.out.println(selectstr);		
		
		System.out.println(selectstr + " ORDER BY db.atto");
				
		ArrayList<dbpubblica> ret = (ArrayList<dbpubblica>)AnagrafeEm.createQuery(
				selectstr + " ORDER BY atto")
				.getResultList();
				
		if (ret.size() > 0) {
			
			for (Iterator iter = ret.iterator(); iter.hasNext();) {
				dbpubblica element = (dbpubblica) iter.next();

			     
/*			     System.out.println("ATTO "+element.getAtto());
			     System.out.println("DOC "+element.getDoc());
			     System.out.println("PERCORSO "+element.getPercorso());
			     System.out.println("OGGETTO "+element.getOggetto());
			     System.out.println("CODICE "+element.getPr_cod_prat());
			     System.out.println("-----------------------------------------"); */
			     
			     
			     
				
				unica.put(element.getPr_cod_prat(), element);

			}
     	//	 attilist = ret;
		
		}

		Set<Double> list  = unica.keySet();
		Iterator iter = list.iterator();
					
		while(iter.hasNext()) {
		     Object key = iter.next();
		     dbpubblica value = (dbpubblica)unica.get(key);
		     
		     attilist.add(value); 
		}
		
		
		
		return attilist;
	}
	
	
	public Integer updatePrawebdb(PubblicazioniWebiProxy pratica,Integer pracod,String message) throws Exception {
		
		
		Integer idReturn = 0;
		
		// Testa se aggiornamento o nuovo inserimento da id pratica
		// se uguale a 0 nuovo inserimento altrimenti aggiornamento
		// --------------------------------------------------------

		Integer idutente = 0;
		Integer idsettore = 0;
		
		// Id utente esterno al web -> utente del sistema
		// viene usato quello di connessione, successivamente decodificato
		// su quello interno web (vedi punto a))
		// -------------------------------------
		
		Integer iduteext = pratica.getTpu_idutente();

		
		// Reperimento id Utente web da id gestionale
		// ------------------------------------------
		
		List retUser = WebDb.createNamedQuery("UtentiTrasWebProxy.selectByUser")
		.setParameter("id", iduteext)
		.getResultList();
		
		for (Iterator iter = retUser.iterator(); iter.hasNext();) {
			UtentiTrasWebProxy element = (UtentiTrasWebProxy) iter.next();
			idutente = element.getTus_id();
			idsettore = element.getTus_userid();
		}
		
		if (pratica.getTpu_id() == null || pratica.getTpu_id().equals(0)) {
			
			PubblicazioniWebiProxy pratwebnew = new PubblicazioniWebiProxy();
			
			pratwebnew.setTpu_idsettore(idsettore);
			pratwebnew.setTpu_idutente(idutente);
			
			pratwebnew.setTpu_datainizio(pratica.getTpu_datainizio());
			pratwebnew.setTpu_datafine(pratica.getTpu_datafine());
			
			pratwebnew.setTpu_titolo(pratica.getTpu_titolo());
			pratwebnew.setTpu_testo(pratica.getTpu_testo());
			
			pratwebnew.setTpu_idtipo(pratica.getTpu_idtipo());
			pratwebnew.setTpu_iduff(pratica.getTpu_iduff());
			
			pratwebnew.setTpu_href(pratica.getTpu_href());
			pratwebnew.setTpu_dref(pratica.getTpu_dref());
			
			pratwebnew.setTpu_dataatto(pratica.getTpu_dataatto());
			pratwebnew.setTpu_numatto(pratica.getTpu_numatto());
			
			// per nuovo inserimento aggiorna flag di avvenuta pubblicazione a N
			// -----------------------------------------------------------------
			
			pratwebnew.setTpu_flapap(pratica.getTpu_flapap());
			pratwebnew.setTpu_flpap(pratica.getTpu_flpap());
			
			pratwebnew.setTpu_dipap(pratica.getTpu_dipap());
			pratwebnew.setTpu_dfpap(pratica.getTpu_dfpap());
			pratwebnew.setTpu_nota(pratica.getTpu_nota());
			
			pratwebnew.setTpu_controllo("N");
			pratwebnew.setTpu_flvseg("N");
			
			WebDb.persist(pratwebnew);
			
			idReturn = pratwebnew.getTpu_id();
			

			// Reperimento documento principale ed invio FTP
			// ---------------------------------------------
			
     		dbpubblica principale = (dbpubblica)AnagrafeEm.find(dbpubblica.class, new Double(pracod));
     		
     		if (principale != null && principale.getPercorso()  != null && ! principale.getPercorso().trim().equals("")) {
			
     			
            FTPClient clientftp = null;
            Boolean okwrite = false;
            
            
			clientftp = new FTPClient();
				clientftp.addProtocolCommandListener(new ProtocolCommandListener(){
	
				  public void protocolCommandSent(ProtocolCommandEvent arg0) {}
				  public void protocolReplyReceived(ProtocolCommandEvent arg0) {}
			    });
            
				MasterUrlWebiProxy returnvalue = getMasterUrlWeb();					
				
				TipoPubbliProxy  tipopubbl     = getTipopubblWeb(idReturn);
				
				if (tipopubbl != null) {     			


					clientftp.connect(returnvalue.getTmu_host().trim());

					clientftp.enterLocalPassiveMode();
					int reply = clientftp.getReplyCode();



					if (FTPReply.isPositiveCompletion(reply)) {


						if (clientftp.login(returnvalue.getTmu_user().trim(),returnvalue.getTmu_psw().trim())) {

							if (clientftp.isConnected()) {


								clientftp.setFileType(FTPClient.BINARY_FILE_TYPE);

								// Scrittura del principale
								// ------------------------
								
								if (principale.getPercorso()  != null && ! principale.getPercorso().trim().equals("")) {
								
									String path = principale.getPercorso().trim().replaceAll("gestdoc", "gestdocm2m");
									String fileName = new File(path).getName();	
									InputStream inputdoc = new FileInputStream(path); 				
								

									if (clientftp.storeFile(returnvalue.getTmu_pathftp()+tipopubbl.getTtp_pathdestinazione()+idReturn.toString().trim()+fileName.trim(),inputdoc)) {

										
										System.out.println(" PERCORSO PRINCIPALE ["+principale.getPercorso()+"]");
										
										LinkPubblicazioniWebiProxy docpubblicazione = new LinkPubblicazioniWebiProxy();


										docpubblicazione.setTlp_idpubbl(idReturn);

										docpubblicazione.setTlp_url((returnvalue.getTmu_homepage()+tipopubbl.getTtp_pathdestinazione()+idReturn.toString().trim()+fileName.trim()).trim());
										docpubblicazione.setTlp_titolo(principale.getDoc());
										docpubblicazione.setTlp_nomefile(idReturn.toString().trim()+fileName.trim());

										docpubblicazione.setTlp_user(idutente);

										okwrite = newDocdbPraweb(idReturn,docpubblicazione);

										//	System.out.println(" HELLO, CONNECTION OK, MA BRAVO.... ["+returnvalue.getTmu_psw().trim()+"] NOME FILE ["+returnvalue.getTmu_pathftp()+returnvalue.getTmu_pathpratiche()+fileItem.getName()+"]");
										
										if (!okwrite ) 
											throw new Exception();
									}									
									
									
								
								}

								// -------------------------------------------
								// reperimento allegati al documento pricipale
								// db_pubblica e invio via FTP
								// -------------------------------------------

								List dapubblicare = AnagrafeEm.createNamedQuery("dbpubblicaalleg.selectById")
								.setParameter("id", new Double(pracod))
								.getResultList();

								for (Iterator iterone = dapubblicare.iterator(); iterone.hasNext();) {

									dbpubblicaalleg elementone = (dbpubblicaalleg) iterone.next();


									if (elementone.getPercorso()  != null && ! elementone.getPercorso().trim().equals("")) {
										System.out.println(" PERCORSO ALLEGATO ["+elementone.getPercorso()+"]");

										
										String path = elementone.getPercorso().trim().replaceAll("gestdoc", "gestdocm2m");
										String fileName = new File(path).getName();	
										InputStream inputdoc = new FileInputStream(path); 				




										// Se l'invio FTP è riuscito scrivo i dati 
										// ---------------------------------------

										if (clientftp.storeFile(returnvalue.getTmu_pathftp()+tipopubbl.getTtp_pathdestinazione()+idReturn.toString().trim()+fileName.trim(),inputdoc)) {

											LinkPubblicazioniWebiProxy docpubblicazione = new LinkPubblicazioniWebiProxy();


											docpubblicazione.setTlp_idpubbl(idReturn);

											docpubblicazione.setTlp_url((returnvalue.getTmu_homepage()+tipopubbl.getTtp_pathdestinazione()+idReturn.toString().trim()+fileName.trim()).trim());
											docpubblicazione.setTlp_titolo(elementone.getDoc());
											docpubblicazione.setTlp_nomefile(idReturn.toString().trim()+fileName.trim());

											docpubblicazione.setTlp_user(idutente);

											okwrite = newDocdbPraweb(idReturn,docpubblicazione);


											//	System.out.println(" HELLO, CONNECTION OK, MA BRAVO.... ["+returnvalue.getTmu_psw().trim()+"] NOME FILE ["+returnvalue.getTmu_pathftp()+returnvalue.getTmu_pathpratiche()+fileItem.getName()+"]");

										} 

									}

								} // for ..

							} // if (clientftp.isConnected())

						} // if (clientftp.login(returnvalue.getTmu_user().

					} //	(FTPReply.isPositiveCompletion(reply))		
					
					clientftp.disconnect();

					if (!okwrite ) 
						throw new Exception();
					

				}  // if (tipopubbl != null		  					
			
     		} // if principale != null
						
			
			
		} else {
			
			PubblicazioniWebiProxy pratweb;

			pratweb = (PubblicazioniWebiProxy)WebDb.find(PubblicazioniWebiProxy.class, pratica.getTpu_id());

			pratweb.setTpu_idsettore(idsettore);
			pratweb.setTpu_idutente(idutente);
			
			pratweb.setTpu_titolo(pratica.getTpu_titolo());
			pratweb.setTpu_testo(pratica.getTpu_testo());

			pratweb.setTpu_iduff(pratica.getTpu_iduff());
			
			pratweb.setTpu_datainizio(pratica.getTpu_datainizio());
			pratweb.setTpu_datafine(pratica.getTpu_datafine());
			
			pratweb.setTpu_dataatto(pratica.getTpu_dataatto());
			pratweb.setTpu_numatto(pratica.getTpu_numatto());
			
			pratweb.setTpu_href(pratica.getTpu_href());
			pratweb.setTpu_dref(pratica.getTpu_dref());

			// non aggiornare flag di avvenuta pubblicazione albo pretorio
			// altrimenti la rimette in circolazione
			// -----------------------------------------------------------
			
			pratweb.setTpu_flpap(pratica.getTpu_flpap());
			
			pratweb.setTpu_dipap(pratica.getTpu_dipap());
			pratweb.setTpu_dfpap(pratica.getTpu_dfpap());
			
			pratweb.setTpu_nota(pratica.getTpu_nota());
			
			WebDb.merge(pratweb);
			
			idReturn = pratica.getTpu_id();
			
		}
		
		
		// punto a)
		// Se presente un messaggio di modifica dati del log, scrivi record di log
		// -----------------------------------------------------------------------
		
		if (!message.trim().equals("")) {
			
			LogTableiProxy logtab = new LogTableiProxy();
			logtab.setId_pubbl(idReturn);
			
			
			logtab.setId_user(getIdUserWeb(iduteext));
			logtab.setDesc_event(message.trim());
			WebDb.persist(logtab);
			
		}
	
	WebDb.flush();
		
		
		return idReturn;
		
	}
	
	
	public Integer updateTipoPraweb(TipoPubbliProxy pratica) throws Exception {
		
		Integer idReturn = 0;
		
		TipoPubbliProxy praticanew = null;
		
		
		if (pratica.getTtp_id() == null ||  pratica.getTtp_id().equals(0)) {
			
			praticanew = new TipoPubbliProxy(); 
			
			praticanew.setTtp_campodatto(pratica.getTtp_campodatto());
			praticanew.setTtp_camponatto(pratica.getTtp_camponatto());
			praticanew.setTtp_descr(pratica.getTtp_descr());
			praticanew.setTtp_flalbo(pratica.getTtp_flalbo());
			praticanew.setTtp_flattiv(pratica.getTtp_flattiv());
			praticanew.setTtp_fldatascad(pratica.getTtp_fldatascad());
			praticanew.setTtp_fllotus(pratica.getTtp_fllotus());
			praticanew.setTtp_flnews(pratica.getTtp_flnews());
			praticanew.setTtp_ggalbo(pratica.getTtp_ggalbo());
			praticanew.setTtp_idini(pratica.getTtp_idini());
			praticanew.setTtp_numord(pratica.getTtp_numord());
			praticanew.setTtp_pathdestinazione(pratica.getTtp_pathdestinazione());
			praticanew.setTtp_suser(pratica.getTtp_suser());
			praticanew.setTtp_testo(pratica.getTtp_testo());
			praticanew.setTtp_tipo(pratica.getTtp_tipo());
			praticanew.setTtp_tipoattolotus(pratica.getTtp_tipoattolotus());
			praticanew.setTtp_user(pratica.getTtp_user());
			
            WebDb.persist(praticanew);
			
			idReturn = praticanew.getTtp_id();
			
		} else {
			
			praticanew = (TipoPubbliProxy)WebDb.find(TipoPubbliProxy.class, pratica.getTtp_id());
			
			praticanew.setTtp_campodatto(pratica.getTtp_campodatto());
			praticanew.setTtp_camponatto(pratica.getTtp_camponatto());
			praticanew.setTtp_descr(pratica.getTtp_descr());
			praticanew.setTtp_flalbo(pratica.getTtp_flalbo());
			praticanew.setTtp_flattiv(pratica.getTtp_flattiv());
			praticanew.setTtp_fldatascad(pratica.getTtp_fldatascad());
			praticanew.setTtp_fllotus(pratica.getTtp_fllotus());
			praticanew.setTtp_flnews(pratica.getTtp_flnews());
			praticanew.setTtp_ggalbo(pratica.getTtp_ggalbo());
			praticanew.setTtp_idini(pratica.getTtp_idini());
			praticanew.setTtp_numord(pratica.getTtp_numord());
			praticanew.setTtp_pathdestinazione(pratica.getTtp_pathdestinazione());
			praticanew.setTtp_suser(pratica.getTtp_user());
			praticanew.setTtp_testo(pratica.getTtp_testo());
			praticanew.setTtp_tipo(pratica.getTtp_tipo());
			praticanew.setTtp_tipoattolotus(pratica.getTtp_tipoattolotus());
			praticanew.setTtp_user(pratica.getTtp_user());
			praticanew.setTtp_suser(pratica.getTtp_suser());
			
			WebDb.merge(praticanew);
			
			idReturn = pratica.getTtp_id();			
			
		}
		
	    WebDb.flush();
		
		
		return idReturn;		
		
		
	}
	
	public Boolean removePubblicaWebdb(Integer id, Integer user) throws Exception {
		
		try {
			

			PubblicazioniWebiProxy pratweb;
			pratweb = (PubblicazioniWebiProxy)WebDb.find(PubblicazioniWebiProxy.class, id);
			
			if (pratweb != null) {	
				
				// Rimuovi documenti allegati
				// --------------------------
				
				List LinkList = WebDb.createNamedQuery("LinkPubblicazioniWebiProxy.selectByPubbl")
				.setParameter("id",pratweb.getTpu_id())
				.getResultList();	
				
				for (Iterator iter = LinkList.iterator(); iter.hasNext();) {
					LinkPubblicazioniWebiProxy element = (LinkPubblicazioniWebiProxy) iter.next();
					WebDb.remove(element);
				}
				
				Integer idpubbl = pratweb.getTpu_id(); 
				String fpubbl = pratweb.getTpu_flpap();
				String titolo = pratweb.getTpu_titolo();
		
				WebDb.remove(pratweb);
				
				// registra su storico avvenuta cancellazione da parte dell'utente
				// ---------------------------------------------------------------
				
				if (fpubbl.trim().equals("Y")) {
					
					LogTableiProxy logtab = new LogTableiProxy();
					logtab.setId_pubbl(idpubbl);
					
					// Reperimento utente id tramite tabella di congiunzione tra utenti web ed utenti gestionale
					// -----------------------------------------------------------------------------------------
					
					logtab.setId_user(getIdUserWeb(user));
					logtab.setDesc_event("Eliminata Pubblicazione ["+titolo+"]");
					WebDb.persist(logtab);				
					
				}
				
				WebDb.flush();
				return true;
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;		
	}
	
	
	public Boolean  removeTipoPubblWeb(Integer id) throws Exception {
		
		try {
			
			// testa se non esistenti pubblicazioni per tipo in cancellazione
			// --------------------------------------------------------------
			
			  GregorianCalendar calendar = new GregorianCalendar();
			  calendar.set(Calendar.YEAR,1900);
			  calendar.set(Calendar.MONTH,0);
			  calendar.set(Calendar.DAY_OF_MONTH,0);
			  
			
			List retPubblicazioni = WebDb.createNamedQuery("PubblicazioniWebiProxy.selectByTipo")
			.setParameter("id",id)
			.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
			.getResultList();			
			
            if (retPubblicazioni.size() == 0) {

				TipoPubbliProxy pratweb;
				pratweb = (TipoPubbliProxy)WebDb.find(TipoPubbliProxy.class, id);
				
				if (pratweb != null) {	
					
			
					WebDb.remove(pratweb);
					
					WebDb.flush();
					return true;
				}	
         }	
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;		
		
	}
	
	public String pubblicaWebdb(Integer id,String cont) throws Exception {
		
		try {
			

			PubblicazioniWebiProxy pratweb;
			pratweb = (PubblicazioniWebiProxy)WebDb.find(PubblicazioniWebiProxy.class, id);
			
			if (pratweb != null) {	
				
				String tpu_controllo = "N";
				
				// Testa cont ed inverti il contenuto
				// SE N -> Y, se Y -> X
				// ----------------------------------
				
				if (cont.equals("N"))
				   tpu_controllo = "Y"; 
				
				pratweb.setTpu_controllo(tpu_controllo);
		
				WebDb.merge(pratweb);
				
				
				WebDb.flush();
				return tpu_controllo;
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return null;		
		
	}
	
	public Boolean newDocdbPraweb(Integer pratica,LinkPubblicazioniWebiProxy linkpubblicazione) throws Exception {
		
		// Scrittura nuovo link del documento correlato alla pubblicazione
		// ---------------------------------------------------------------
		
		if (!pratica.equals(0)) {

			try {
			
			LinkPubblicazioniWebiProxy webPubbl = new LinkPubblicazioniWebiProxy();
			
			webPubbl.setTlp_nomefile(linkpubblicazione.getTlp_nomefile());
			webPubbl.setTlp_titolo(linkpubblicazione.getTlp_titolo());
			webPubbl.setTlp_url(linkpubblicazione.getTlp_url());
			webPubbl.setTlp_idpubbl(linkpubblicazione.getTlp_idpubbl());
			webPubbl.setTlp_flone("N");
			//webPubbl.setTlp_user(linkpubblicazione.getTlp_user());
			
			if (linkpubblicazione.getTlp_flone() != null  && linkpubblicazione.getTlp_flone().trim().equals("Y"))
				webPubbl.setTlp_flone("Y");
			
			WebDb.persist(webPubbl);
			
			// Scrittura su storico di avvenuta pubblicazione dell'allegato
			// se scelto flag di pubblicazione Albo pretorio
			// ------------------------------------------------------------
			
			
			
			PubblicazioniWebiProxy pubblicaz;

			pubblicaz = (PubblicazioniWebiProxy)WebDb.find(PubblicazioniWebiProxy.class, webPubbl.getTlp_idpubbl());
			
			if (pubblicaz != null && pubblicaz.getTpu_flpap().trim().equals("Y")) {
				
				LogTableiProxy logtab = new LogTableiProxy();
				logtab.setId_pubbl(webPubbl.getTlp_idpubbl());
				logtab.setId_user(getIdUserWeb(linkpubblicazione.getTlp_user()));
				logtab.setDesc_event("Aggiunto allegato alla pubblicazione ["+webPubbl.getTlp_nomefile()+"]");
				WebDb.persist(logtab);				
			}
			
			WebDb.flush();

			return true;
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}	

		}		
			
		return false;		
		
	}
	
	public Boolean  updateDocdbPraweb(Integer id, String titolo) throws Exception {
		
	    try {		
			
	    	LinkPubblicazioniWebiProxy doclink =	WebDb.find(LinkPubblicazioniWebiProxy.class, id);
	    	if (doclink != null) {
	    		
	    	   doclink.setTlp_titolo(titolo);	
	    	   WebDb.merge(doclink);
	    	   WebDb.flush();
	           return true;
	         	
	    	}   
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;
			
			
		}
	
	public Boolean  removeDocdbPraweb(Integer id,Integer user) throws Exception {
		
	    try {		
			
	    	LinkPubblicazioniWebiProxy doclink =	WebDb.find(LinkPubblicazioniWebiProxy.class, id);
	    	
	    	Integer idpubbl = doclink.getTlp_idpubbl();
	    	String nomefile = doclink.getTlp_nomefile();
	    	WebDb.remove(doclink);
	    	
	    	// Scrittura su storico se gestione a flag di pubblicazione Albo Pretorio
	    	// ----------------------------------------------------------------------
			PubblicazioniWebiProxy pubblicaz;

			pubblicaz = (PubblicazioniWebiProxy)WebDb.find(PubblicazioniWebiProxy.class, idpubbl);
			
			if (pubblicaz != null && pubblicaz.getTpu_flpap().trim().equals("Y")) {
				
				
				LogTableiProxy logtab = new LogTableiProxy();
				logtab.setId_pubbl(idpubbl);
				
				// Reperimento utente id tramite tabella di congiunzione tra utenti web ed utenti gestionale
				// -----------------------------------------------------------------------------------------
				
				logtab.setId_user(getIdUserWeb(user));
				logtab.setDesc_event("Eliminato allegato alla pubblicazione ["+nomefile+"]");
				WebDb.persist(logtab);				
			}
	    	
	    	
    	    WebDb.flush();
	    	return true;
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;
			
			
		}	
	
	
	
	public MasterUrlWebiProxy getMasterUrlWeb() throws Exception {
		
		ArrayList<MasterUrlWebiProxy> MastList = (ArrayList<MasterUrlWebiProxy>)WebDb.createNamedQuery("MasterUrlWebiProxy.selectByOnline")
		.getResultList();	
		
		for (Iterator iter = MastList.iterator(); iter.hasNext();) {
			MasterUrlWebiProxy element = (MasterUrlWebiProxy) iter.next();
			return element;
			
		}
		
		return null;
		
	}
	
	public TipoPubbliProxy getTipopubblWeb(Integer id) throws Exception {
		
		try {
			

			PubblicazioniWebiProxy pratweb;
			pratweb = (PubblicazioniWebiProxy)WebDb.find(PubblicazioniWebiProxy.class, id);
			
			if (pratweb != null) {	

				// Reperisci tipo pubblicazione da id tipo della pubblicazione
				// -----------------------------------------------------------
				
				TipoPubbliProxy tipopubbl = (TipoPubbliProxy)WebDb.find(TipoPubbliProxy.class, pratweb.getTpu_idtipo()); 
				
				if (tipopubbl != null)
				    return tipopubbl;  

			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return null;		
	}
	
	
	
	public Integer updateTras(Traspubblicazioni trasp,Integer idutente)   throws Exception {
		
		
		Traspubblicazioni	 traspupdate = (Traspubblicazioni)findByWebPrimaryKey(Traspubblicazioni.class,trasp.getIdtrasp());
		
		if (traspupdate != null ){
			
			traspupdate.setIdmoda(trasp.getIdmoda());
			traspupdate.setProgetto(trasp.getProgetto());
			traspupdate.setContratto(trasp.getContratto());
			traspupdate.setLinkcur(trasp.getLinkcur());
			WebDb.merge(traspupdate);
			WebDb.flush();
			
			return traspupdate.getIdtrasp();
		} else {
			return null;
		}
		
		
	}
	
	public List<PubblicazioniWebiProxy> getPubblicazioniWeb (Integer utente,Integer tipo,String descrizione,String selezione,Integer daanno)  throws Exception {
		
		List<PubblicazioniWebiProxy> pubblicazioniReturn = new ArrayList<PubblicazioniWebiProxy>();
		
		
		  GregorianCalendar calendar = new GregorianCalendar();
		  calendar.set(Calendar.YEAR,daanno);
		  calendar.set(Calendar.MONTH,0);
		  calendar.set(Calendar.DAY_OF_MONTH,0);
		  
		
		List retPubblicazioni = WebDb.createNamedQuery("PubblicazioniWebiProxy.selectByTipo")
		.setParameter("id",tipo)
		.setParameter("dataini",new Timestamp(calendar.getTimeInMillis()))
		.getResultList(); 

		boolean okWrite = true;
		String descrsearch = "";
		
		for (Iterator iter = retPubblicazioni.iterator(); iter.hasNext();) {
			PubblicazioniWebiProxy element = (PubblicazioniWebiProxy) iter.next();
			
			okWrite = true;
			descrsearch = "";
			
			// Testa per tipo (Pubblicati, Non pubblicati)
			// -------------------------------------------
			
			if (selezione.equals("1") && ! element.getTpu_controllo().equals("Y")) 
				okWrite = false;				
			
			if (selezione.equals("0") &&  element.getTpu_controllo().equals("Y")) 
				okWrite = false;		
			
			
			// Testa per descrizione se espressa
			// ---------------------------------
            if (okWrite) {
            	if (descrizione != null) 
                	descrsearch = descrizione.trim().toUpperCase();

            	
            	    // Se epressa ricerca per descrizione significativa compara sul contenuto
            	    // ----------------------------------------------------------------------
            	
            	    if (!descrsearch.equals("")) {
            	    	
            	    	int pos = element.getTpu_titolo().toUpperCase().indexOf(descrsearch);
            	    	
            	    	if (pos == -1)
            				okWrite = false;
            	    	
            	    	
            	    }
            		
            	}
            
              // Se possibile scrittura scrivi
              // -----------------------------
            
             if (okWrite) 
            	 pubblicazioniReturn.add(element);
            
            }
			
		return pubblicazioniReturn;
			
		}
	
	
	public Integer pubblicaTras(Traspubblicazioni trasp,Integer idutente)   throws Exception {

		Traspubblicazioni	 traspupdate = (Traspubblicazioni)findByWebPrimaryKey(Traspubblicazioni.class,trasp.getIdtrasp());
		
		if (traspupdate != null ){
			
			traspupdate.setIdmoda(trasp.getIdmoda());
			traspupdate.setProgetto(trasp.getProgetto());
			traspupdate.setContratto(trasp.getContratto());
			traspupdate.setLinkcur(trasp.getLinkcur());
			
			if (trasp.getFpubblic().equals("N") || trasp.getFpubblic().equals("X")) {
				traspupdate.setFpubblic("Y");
				traspupdate.setFl_ok("Y");
			}	
				
			if (trasp.getFpubblic().equals("Y")) {
				traspupdate.setFpubblic("N");
				traspupdate.setFl_ok("");
			}	
				
			WebDb.merge(traspupdate);
			WebDb.flush();
			
			return traspupdate.getIdtrasp();
		} else {
			return null;
		}
		
	}

	public Integer xpubblicaTras(Traspubblicazioni trasp,Integer idutente)   throws Exception {

		Traspubblicazioni	 traspupdate = (Traspubblicazioni)findByWebPrimaryKey(Traspubblicazioni.class,trasp.getIdtrasp());
		
		if (traspupdate != null ){
			
			traspupdate.setIdmoda(trasp.getIdmoda());
			traspupdate.setProgetto(trasp.getProgetto());
			traspupdate.setContratto(trasp.getContratto());
			traspupdate.setLinkcur(trasp.getLinkcur());
			
			traspupdate.setFpubblic("X");
			traspupdate.setFl_ok("Y");
				
			WebDb.merge(traspupdate);
			WebDb.flush();
			
			return traspupdate.getIdtrasp();
		} else {
			return null;
		}
		
	}
	
	public List<UfficiTrasWebProxy> getUfficiWeb(Integer user,Boolean all) throws Exception {
		ArrayList<UfficiTrasWebProxy> ufficiReturn = new ArrayList<UfficiTrasWebProxy>();
		
		// Preleva da Utenti per user id del progetto principale
		// -----------------------------------------------------
		
		String descr_sett = "";
		boolean first = true;
		UfficiTrasWebProxy primo = new UfficiTrasWebProxy();
		primo.setTuf_compl("Tutti gli uffici di competenza");
		primo.setTuf_id(0);
		
		
		List  UserList = WebDb.createNamedQuery("UtentiTrasWebProxy.selectByUser")
		.setParameter("id",user)
		.getResultList();	
		

		for (Iterator iter = UserList.iterator(); iter.hasNext();) {
			UtentiTrasWebProxy element = (UtentiTrasWebProxy) iter.next();
			
			// Per ogni utente reperisco i settori
			// -----------------------------------

			List  SettoriList = null;
			
			if (element.getTus_tuttisettori().trim().equals("Y")) { 
     			SettoriList = WebDb.createNamedQuery("SettoriWebiProxy.selectAll")
		    	.getResultList();
			}
			else {
     			SettoriList = WebDb.createNamedQuery("SettoriWebiProxy.selectById")
	    		.setParameter("id",element.getTus_idsettore())
		    	.getResultList();
			}	
			

			
			for (Iterator iterator = SettoriList.iterator(); iterator.hasNext();) {
				SettoriWebiProxy elsett = (SettoriWebiProxy) iterator.next();
				
				descr_sett = elsett.getTse_descr();
				
				// Per ogni settore reperisco gli uffici
				// -------------------------------------

				List  UfficiList = WebDb.createNamedQuery("UfficiTrasWebProxy.selectById")
				.setParameter("id",elsett.getTse_id())
				.getResultList();	
				
				
				for (Iterator iteratoruff = UfficiList.iterator(); iteratoruff
						.hasNext();) {
					UfficiTrasWebProxy eluff = (UfficiTrasWebProxy) iteratoruff.next();
					
					eluff.setTuf_compl(descr_sett+": "+eluff.getTuf_descr());
					
					if (first && all)
						ufficiReturn.add(primo);
 
					 ufficiReturn.add(eluff);
					
					first = false;
				}
				
				
				
				
				
			} // for (Iterator iterator = SettoriList.iterator
			
		} // for (Iterator iter = UserList.iterator(); 
		
		
		
		
		
		
		return ufficiReturn; 
	}
	
	
	/* (non-Javadoc)
	 * @see meetingsession.MeetingPersistenceFacade#getPraticheWeb(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public List<PraticheWebiProxy> getPraticheWeb(Integer user,Integer ufficio,String nome) throws Exception {
		
		ArrayList<PraticheWebiProxy> praticheReturn = new ArrayList<PraticheWebiProxy>();
		List<UfficiTrasWebProxy>   ufficiscelti = new ArrayList<UfficiTrasWebProxy>(); 
		
		
		// Se scelti tutti gli uffici ricavali dall'utente
		// Altrimenti decodifica quello scelto
		// -----------------------------------------------
		
		
		if (ufficio.equals(0)) {
			
			ufficiscelti = getUfficiWeb(user,false);
			
		} else {
			
				UfficiTrasWebProxy uffkey = WebDb.find(UfficiTrasWebProxy.class, ufficio);
				ufficiscelti.add(uffkey);
			
		}
		
		
		// Per Ogni ufficio reperisco le pratiche da ritornare
		// Se espressa ricerca su nome eseguo ricerca composta
		// altrimenti solo per ufficio
		// ---------------------------------------------------

		
		ArrayList<PraticheWebiProxy>  PraticheList = null;
		
		for (Iterator iter = ufficiscelti.iterator(); iter.hasNext();) {
			UfficiTrasWebProxy element = (UfficiTrasWebProxy) iter.next();
			
			if (nome != null && ! nome.trim().equals("")) {

				
				PraticheList = (ArrayList<PraticheWebiProxy>)WebDb.createNamedQuery("PraticheWebiProxy.selectByUffNome")
				.setParameter("id",element.getTuf_id())
				.setParameter("nome","%"+nome.trim().toUpperCase()+"%")
				.getResultList();	

				// Gestire il caricamento per ogni pratica delle pubblicazioni Io Sono e Mi Interessa
				// ----------------------------------------------------------------------------------
				
				for (Iterator iterator = PraticheList.iterator(); iterator
						.hasNext();) {
					
					PraticheWebiProxy elementpra = (PraticheWebiProxy) iterator.next();
					

					// Carica leggendo da aripra e arspra
					// ----------------------------------
					
					setPubblicazioni(elementpra);
					
					
					
				}
				
				if (PraticheList != null)
					praticheReturn.addAll(PraticheList);
				
			} else {

				
				PraticheList = (ArrayList<PraticheWebiProxy>)WebDb.createNamedQuery("PraticheWebiProxy.selectByUffId")
				.setParameter("id",element.getTuf_id())
				.getResultList();	

				for (Iterator iterator = PraticheList.iterator(); iterator
						.hasNext();) {
					PraticheWebiProxy elementpra1 = (PraticheWebiProxy) iterator.next();

                       
					

					// Carica leggendo da aripra e arspra
					// ----------------------------------
					
					setPubblicazioni(elementpra1);
					
				}
				
				if (PraticheList != null)
					praticheReturn.addAll(PraticheList); 
					
			}
			
		} // for (Iterator iter = ufficiscelti.iterator(); 
		
		// valorizza l'array di ritorno delle pratiche scelte
		// --------------------------------------------------

		
		return praticheReturn;
		
	}
	
	public List<TipoPubbliProxy> getTipoPubblicazioniWeb(String descrizione) throws Exception {
		
		ArrayList<TipoPubbliProxy> praticheReturn = new ArrayList<TipoPubbliProxy>();
		String searc = "";
		if (descrizione != null)
			searc = descrizione.trim().toUpperCase(); 
		
		praticheReturn = (ArrayList<TipoPubbliProxy>)WebDb.createNamedQuery("TipoPubbliProxy.selectByDescr")
		.setParameter("desc","%"+searc+"%")
		.getResultList();	
		
		return praticheReturn;
	}
	
	private void setPubblicazioni(PraticheWebiProxy data) {
		
		data.setTari_aprireattivita("0");
		data.setTari_averefamiglia("0");
		data.setTari_averefigli("0");
		data.setTari_casa("0");
		data.setTari_faresport("0");
		data.setTari_lavorare("0");
		data.setTari_mezzotrasporto("0");
		data.setTari_pagaretasse("0");
		data.setTari_salute("0");
		data.setTari_studiare("0");
		data.setTari_tempolibero("0");
		
		data.setTars_anziano("0");
		data.setTars_associazione("0");
		data.setTars_bambino("0");
		data.setTars_cittadino("0");
		data.setTars_disabile("0");
		data.setTars_donna("0");
		data.setTars_genitore("0");
		data.setTars_giovane("0");
		data.setTars_immigrato("0");		

		// Per prima cosa pulisci tabella Io Sono con id pratica
		// -----------------------------------------------------
		
		List LinkListiosono = WebDb.createNamedQuery("Arsprati.selectByPrat")
		.setParameter("id",data.getPra_id())
		.getResultList();	
		
		for (Iterator iter = LinkListiosono.iterator(); iter.hasNext();) {
			Arsprati elementio = (Arsprati) iter.next();
			
			switch (elementio.getTars_id()) {
			case 1:
				data.setTars_anziano("1");
				break;
			case 2:
				data.setTars_cittadino("2");
				break;
			case 3:
				data.setTars_donna("3");
				break;
			case 4:
				data.setTars_genitore("4");
				break;
			case 5:
				data.setTars_bambino("5");
				break;
			case 6:
				data.setTars_disabile("6");
				break;
			case 7:
				data.setTars_immigrato("7");		
				break;
			case 8:
				data.setTars_giovane("8");
				break;
			case 9:
				data.setTars_associazione("9");
				break;

			default:
				break;
			}
			
		}			
		

		// Per prima cosa pulisci tabella Mi Interessa con id pratica
		// ----------------------------------------------------------
		
		List LinkListmiinte = WebDb.createNamedQuery("Ariprati.selectByPrat")
		.setParameter("id",data.getPra_id())
		.getResultList();	
		
		for (Iterator iter = LinkListmiinte.iterator(); iter.hasNext();) {
			Ariprati elementmi = (Ariprati) iter.next();
			
			switch (elementmi.getTari_id()) {
			case 1:
				data.setTari_casa("1");
				break;
			case 2:
				data.setTari_averefamiglia("2");
				break;
			case 3:
				data.setTari_averefigli("3");
				break;
			case 4:
				data.setTari_faresport("4");
				break;
			case 5:
				data.setTari_lavorare("5");
				break;
			case 6:
				data.setTari_mezzotrasporto("6");
				break;
			case 7:
				data.setTari_pagaretasse("7");
				break;
			case 8:
				data.setTari_salute("8");
				break;
			case 9:
				data.setTari_studiare("9");
				break;
			case 10:
				data.setTari_tempolibero("10");		
				break;
			case 11:
				data.setTari_aprireattivita("11");
				break;

			default:
				break;
			}
			
		}	
		
	}
	
	public Integer updatePraweb(PraticheWebiProxy pratica) throws Exception {
		
		
		Integer idReturn = 0;
		
		// Testa se aggiornamento o nuovo inserimento da id pratica
		// se uguale a 0 nuovo inserimento altrimenti aggiornamento
		// --------------------------------------------------------

		if (pratica.getPra_id() == null || pratica.getPra_id() == 0) {
			
			WebDb.persist(pratica);
			
			idReturn = pratica.getPra_id();
		} else {
			
			PraticheWebiProxy pratweb;

			pratweb = (PraticheWebiProxy)WebDb.find(PraticheWebiProxy.class, pratica.getPra_id());

			pratweb.setPra_contatto(pratica.getPra_contatto());
			pratweb.setPra_descr(pratica.getPra_descr());
			pratweb.setPra_documentaz(pratica.getPra_documentaz());
			pratweb.setPra_dref(pratica.getPra_dref());
			pratweb.setPra_href(pratica.getPra_href());
			pratweb.setPra_iduff(pratica.getPra_iduff());
			pratweb.setPra_nome(pratica.getPra_nome());
			pratweb.setPra_orario(pratica.getPra_orario());
			
			WebDb.merge(pratweb);
			
			idReturn = pratica.getPra_id();
			
		}
	
	WebDb.flush();
		
		
		return idReturn;
		
	}
	
	public Boolean removePubblicaWeb(Integer id) throws Exception {

		try {
			

			PraticheWebiProxy pratweb;
			pratweb = (PraticheWebiProxy)WebDb.find(PraticheWebiProxy.class, id);
			
			if (pratweb != null) {
				
				
				// Per prima cosa pulisci tabella Io Sono con id pratica
				// -----------------------------------------------------
				
				List LinkListiosono = WebDb.createNamedQuery("Arsprati.selectByPrat")
				.setParameter("id",id)
				.getResultList();	
				
				for (Iterator iter = LinkListiosono.iterator(); iter.hasNext();) {
					Arsprati elementio = (Arsprati) iter.next();
					
					WebDb.remove(elementio);
				}			
				

				// Per prima cosa pulisci tabella Mi Interessa con id pratica
				// ----------------------------------------------------------
				
				List LinkListmiinte = WebDb.createNamedQuery("Ariprati.selectByPrat")
				.setParameter("id",id)
				.getResultList();	
				
				for (Iterator iter = LinkListmiinte.iterator(); iter.hasNext();) {
					Ariprati elementmi = (Ariprati) iter.next();
					
					WebDb.remove(elementmi);
				}			
				
				
				// Rimuovo tutti i documenti collegati
				// -----------------------------------
				
				
				List LinkList = WebDb.createNamedQuery("PratPubblicazioniWebiProxy.selectByPratica")
				.setParameter("id",id)
				.getResultList();	
				
				for (Iterator iter = LinkList.iterator(); iter.hasNext();) {
					PratPubblicazioniWebiProxy element = (PratPubblicazioniWebiProxy) iter.next();
					
					WebDb.remove(element);
					
					
				}
			

				WebDb.remove(pratweb);
				
				
				WebDb.flush();
				return true;
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;
		}
	
	public Integer updateArsp(Integer id, Integer anziano,Integer cittadino,Integer donna,Integer genitore,Integer bambino,Integer disabile,Integer immigrato,Integer giovane,Integer associazione) throws Exception {
		
		try {
		
			// Per prima cosa pulisci tabella Io Sono con id pratica
			// -----------------------------------------------------
			
			List LinkList = WebDb.createNamedQuery("Arsprati.selectByPrat")
			.setParameter("id",id)
			.getResultList();	
			
			for (Iterator iter = LinkList.iterator(); iter.hasNext();) {
				Arsprati element = (Arsprati) iter.next();
				
				WebDb.remove(element);
			}			
			
			
			// Aggiungi elementi scelti
			// ------------------------
			
			if (! anziano.equals(0)) {
				Arsprati ars1 = new Arsprati();
				ars1.setIdprat(id);
				ars1.setTars_id(anziano);
	    	    WebDb.persist(ars1);
			}
			
			if (! cittadino.equals(0)) {
				Arsprati ars2 = new Arsprati();
				ars2.setIdprat(id);
				ars2.setTars_id(cittadino);
	    	    WebDb.persist(ars2);
			}
            
			if (! donna.equals(0)) {
				Arsprati ars3 = new Arsprati();
				ars3.setIdprat(id);
				ars3.setTars_id(donna);
	    	    WebDb.persist(ars3);
			}
			if (! genitore.equals(0)) {
				Arsprati ars4 = new Arsprati();
				ars4.setIdprat(id);
				ars4.setTars_id(genitore);
	    	    WebDb.persist(ars4);
			}
			if (! bambino.equals(0)) {
				Arsprati ars5 = new Arsprati();
				ars5.setIdprat(id);
				ars5.setTars_id(bambino);
	    	    WebDb.persist(ars5);
			}
			if (! disabile.equals(0)) {
				Arsprati ars6 = new Arsprati();
				ars6.setIdprat(id);
				ars6.setTars_id(disabile);
	    	    WebDb.persist(ars6);
			}
			if (! immigrato.equals(0)) {
				Arsprati ars7 = new Arsprati();
				ars7.setIdprat(id);
				ars7.setTars_id(immigrato);
	    	    WebDb.persist(ars7);
			}
			if (! giovane.equals(0)) {
				Arsprati ars8 = new Arsprati();
				ars8.setIdprat(id);
				ars8.setTars_id(giovane);
	    	    WebDb.persist(ars8);
			}
			if (! associazione.equals(0)) {
				Arsprati ars9 = new Arsprati();
				ars9.setIdprat(id);
				ars9.setTars_id(associazione);
	    	    WebDb.persist(ars9);
			}
	    	
	    	WebDb.flush();
	    	
			return id;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	public Integer updateArip(Integer id, Integer tari_casa,
			Integer tari_averefamiglia,Integer tari_averefigli,
			Integer tari_faresport,Integer tari_lavorare,
			Integer tari_pagaretasse,Integer tari_salute,
			Integer tari_studiare,Integer tari_tempolibero,
			Integer tari_aprireattivita,Integer tari_mezzotrasporto) throws Exception {
		
		try {
		
			// Per prima cosa pulisci tabella Mi interessa con id pratica
			// ----------------------------------------------------------
			
			List LinkList = WebDb.createNamedQuery("Ariprati.selectByPrat")
			.setParameter("id",id)
			.getResultList();	
			
			for (Iterator iter = LinkList.iterator(); iter.hasNext();) {
				Ariprati element = (Ariprati) iter.next();
				
				WebDb.remove(element);
			}			
			
			
			// Aggiungi elementi scelti
			// ------------------------
			
			if (! tari_casa.equals(0)) {
				Ariprati ari1 = new Ariprati();
				ari1.setIdprat(id);
				ari1.setTari_id(tari_casa);
	    	    WebDb.persist(ari1);
			}
			
			if (! tari_averefamiglia.equals(0)) {
				Ariprati ari2 = new Ariprati();
				ari2.setIdprat(id);
				ari2.setTari_id(tari_averefamiglia);
	    	    WebDb.persist(ari2);
			}
            
			if (! tari_averefigli.equals(0)) {
				Ariprati ari3 = new Ariprati();
				ari3.setIdprat(id);
				ari3.setTari_id(tari_averefigli);
	    	    WebDb.persist(ari3);
			}
			if (! tari_faresport.equals(0)) {
				Ariprati ari4 = new Ariprati();
				ari4.setIdprat(id);
				ari4.setTari_id(tari_faresport);
	    	    WebDb.persist(ari4);
			}
			if (! tari_lavorare.equals(0)) {
				Ariprati ari5 = new Ariprati();
				ari5.setIdprat(id);
				ari5.setTari_id(tari_lavorare);
	    	    WebDb.persist(ari5);
			}
			if (! tari_pagaretasse.equals(0)) {
				Ariprati ari6 = new Ariprati();
				ari6.setIdprat(id);
				ari6.setTari_id(tari_pagaretasse);
	    	    WebDb.persist(ari6);
			}
			if (! tari_salute.equals(0)) {
				Ariprati ari7 = new Ariprati();
				ari7.setIdprat(id);
				ari7.setTari_id(tari_salute);
	    	    WebDb.persist(ari7);
			}
			if (! tari_studiare.equals(0)) {
				Ariprati ari8 = new Ariprati();
				ari8.setIdprat(id);
				ari8.setTari_id(tari_studiare);
	    	    WebDb.persist(ari8);
			}
			if (! tari_tempolibero.equals(0)) {
				Ariprati ari9 = new Ariprati();
				ari9.setIdprat(id);
				ari9.setTari_id(tari_tempolibero);
	    	    WebDb.persist(ari9);
			}

			if (! tari_aprireattivita.equals(0)) {
				Ariprati ari10 = new Ariprati();
				ari10.setIdprat(id);
				ari10.setTari_id(tari_aprireattivita);
	    	    WebDb.persist(ari10);
			}
			
			if (! tari_mezzotrasporto.equals(0)) {
				Ariprati ari11 = new Ariprati();
				ari11.setIdprat(id);
				ari11.setTari_id(tari_mezzotrasporto);
	    	    WebDb.persist(ari11);
			}
			
	    	WebDb.flush();
	    	
			return id;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public Boolean newDocPraweb(Integer pratica,LinkPraticheWebiProxy linkpratiche) throws Exception {
		
		// Scrittura nuovo link del documento correlato alla pubblicazione
		// ---------------------------------------------------------------
		
		
		
		if (!pratica.equals(0)) {

			try {
			WebDb.persist(linkpratiche);
			
			// Aggancia il documento alla pratica
			// ----------------------------------
			
			PratPubblicazioniWebiProxy praticadoc = new PratPubblicazioniWebiProxy();
			
			praticadoc.setPrp_praid(pratica);
			praticadoc.setPrp_pubblid(linkpratiche.getPrl_id());
			WebDb.persist(praticadoc);

			WebDb.flush();

			return true;
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}	

		}		
			
		return false;		
		
	}
	
	public Boolean  updateDocPraweb(Integer id, String titolo) throws Exception {
		
	    try {		
			
	    	LinkPraticheWebiProxy doclink =	WebDb.find(LinkPraticheWebiProxy.class, id);
	    	if (doclink != null) {
	    		
	    	   doclink.setPrl_titolo(titolo);	
	    	   WebDb.merge(doclink);
	    	   WebDb.flush();
	           return true;
	         	
	    	}   
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;
			
			
		}
	
	public Boolean  removeDocPraweb(Integer id) throws Exception {
		
	    try {		
			
	    	PratPubblicazioniWebiProxy doclink =	WebDb.find(PratPubblicazioniWebiProxy.class, id);
	    	WebDb.remove(doclink);
    	    WebDb.flush();
	    	return true;
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;
			
			
		}
	
	
	public List<LinkPraticheWebiProxy> getLinkPraticheWeb(Integer id) throws Exception {
		
		ArrayList<LinkPraticheWebiProxy> linkPraReturn = new ArrayList<LinkPraticheWebiProxy>();
		ArrayList<PratPubblicazioniWebiProxy> LinkList = null;
		
		// prelevo dall'id della pubblicazione i link correlati
		// ----------------------------------------------------
		
		LinkList = (ArrayList<PratPubblicazioniWebiProxy>)WebDb.createNamedQuery("PratPubblicazioniWebiProxy.selectByPratica")
		.setParameter("id",id)
		.getResultList();	
		
		
		for (Iterator iter = LinkList.iterator(); iter.hasNext();) {
			PratPubblicazioniWebiProxy element = (PratPubblicazioniWebiProxy) iter.next();
			
			// Per ciascun link reperisco l'allegato connesso
			// ----------------------------------------------
			

			LinkPraticheWebiProxy allegato = WebDb.find(LinkPraticheWebiProxy.class, element.getPrp_pubblid());
			allegato.setPrp_id(element.getPrp_id());
			linkPraReturn.add(allegato);
			
		}
		
		
		return linkPraReturn;
	}
	
	public Boolean  addselDocPraweb(Integer iddoc,Integer idprat) throws Exception {
		
	    try {			

	    	// Aggiungi legame pubblicazione - documento
	    	// -----------------------------------------
	    	
	    	PratPubblicazioniWebiProxy pratDoc = new PratPubblicazioniWebiProxy();
	    	
	    	pratDoc.setPrp_praid(idprat);
	    	pratDoc.setPrp_pubblid(iddoc);
	    	
	    	WebDb.persist(pratDoc);
	    	WebDb.flush();	    	
	    	
	    	return true;
		
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
			return false;
		
		
	}
	
	
	
	public List<LinkPraticheWebiProxy> getNotLinkPraticheWeb(Integer id) throws Exception {
		
		ArrayList<LinkPraticheWebiProxy> linkPraReturn = new ArrayList<LinkPraticheWebiProxy>();
		
		// prelevo dall'id della pubblicazione i link correlati
		// ----------------------------------------------------
		
		linkPraReturn = (ArrayList<LinkPraticheWebiProxy>)WebDb.createNamedQuery("LinkPraticheWebiProxy.selectAll")
		.getResultList();	
		
		
		return linkPraReturn;
	}

	
	
	private Integer getIdUserWeb(Integer idutente) {
		
		
		List adresseFamily = WebDb.createNamedQuery("UtentiTrasWebProxy.selectByUser")
        .setParameter("id", idutente)
        .getResultList();
		
		
		for (Iterator iter = adresseFamily.iterator(); iter.hasNext();) {
			UtentiTrasWebProxy element = (UtentiTrasWebProxy) iter.next();
			
			return element.getTus_id();
			
		} 
		
		   return 0; 
		
	}
	
	private  String InverseDate(String data) {
		
		return data.substring(6,10)+"-"+data.substring(3,5)+"-"+data.substring(0,2);
		
		
	}
	
	
}

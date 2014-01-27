package intrawebsession;

import intraweb.LinkPraticheWebiProxy;
import intraweb.LinkPubblicazioniWebiProxy;
import intraweb.MasterUrlWebiProxy;
import intraweb.Modassegnazione;
import intraweb.PraticheWebiProxy;
import intraweb.PubblicazioniWebiProxy;
import intraweb.TipoPubbliProxy;
import intraweb.Traspubblicazioni;
import intraweb.UfficiTrasWebProxy;
import intraweb.dbpubblica;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;


@Local
public interface IntrawebPersistenceFacade {
	public Object get(Object prototype)throws Exception; 
	public void set(Object object) throws Exception; 
	public Object getById(long id,String className)throws Exception; 
	public Object findByPrimaryKey(Class clazz, Object key)throws Exception;
	public Object findByWebPrimaryKey(Class clazz, Object key) throws Exception;
	public List<Traspubblicazioni> getPubblicazioniWeb (Integer utente,String descrizione,String selezione,Integer daanno)  throws Exception;
	public List<Modassegnazione> getModalitaWeb ()  throws Exception;
	public Integer updateTras(Traspubblicazioni trasp,Integer idutente)   throws Exception;
	public Integer pubblicaTras(Traspubblicazioni trasp,Integer idutente)   throws Exception;
	public Integer xpubblicaTras(Traspubblicazioni trasp,Integer idutente)   throws Exception;
	public List<PubblicazioniWebiProxy> getPubblicazioniWeb (Integer utente,Integer tipo,String descrizione,String selezione,Integer daanno)  throws Exception;
	public ArrayList<TipoPubbliProxy> getTipoWebFromUser(Integer user,Integer ente) throws Exception;	
	public List<LinkPubblicazioniWebiProxy> getLinkPubblicazioniWeb(Integer id) throws Exception;
	public Integer updatePrawebdb(PubblicazioniWebiProxy pratica,Integer pracod,String message) throws Exception;
	public Boolean removePubblicaWebdb(Integer id,Integer user) throws Exception;
	public String pubblicaWebdb(Integer id,String cont) throws Exception;
	public MasterUrlWebiProxy getMasterUrlWeb() throws Exception;
	public TipoPubbliProxy getTipopubblWeb(Integer id)  throws Exception;
	public Boolean newDocdbPraweb(Integer pratica,LinkPubblicazioniWebiProxy linkpubblicazione) throws Exception;
	public Boolean  updateDocdbPraweb(Integer id, String titolo) throws Exception;
	public Boolean  removeDocdbPraweb(Integer id,Integer user) throws Exception;
	public List<UfficiTrasWebProxy> getUfficiWeb(Integer user,Boolean all) throws Exception;
	public List<PraticheWebiProxy> getPraticheWeb(Integer user,Integer ufficio,String nome) throws Exception;
	public List<LinkPraticheWebiProxy> getLinkPraticheWeb(Integer id) throws Exception;
	public Integer updatePraweb(PraticheWebiProxy pratica) throws Exception;
	public Boolean removePubblicaWeb(Integer id) throws Exception;
	public Integer updateArsp(Integer id, Integer anziano,Integer cittadino,Integer donna,Integer genitore,Integer bambino,Integer disabile,Integer immigrato,Integer giovane,Integer associazione) throws Exception;
	public Integer updateArip(Integer id, Integer tari_casa,Integer tari_averefamiglia,Integer tari_averefigli,Integer tari_faresport,Integer tari_lavorare,Integer tari_pagaretasse,Integer tari_salute,Integer tari_studiare,Integer tari_tempolibero,Integer tari_aprireattivita,Integer tari_mezzotrasporto) throws Exception;
	public Boolean newDocPraweb(Integer pratica,LinkPraticheWebiProxy linkpratiche) throws Exception;
	public Boolean  updateDocPraweb(Integer id, String titolo) throws Exception;
	public Boolean  removeDocPraweb(Integer id) throws Exception; 
	public List<LinkPraticheWebiProxy> getNotLinkPraticheWeb(Integer id) throws Exception;
	public Boolean  addselDocPraweb(Integer iddoc,Integer idprat) throws Exception;
	public List<dbpubblica> getAttiDelisa(String descrizione,String tipo,String datai) throws Exception;
	public List<TipoPubbliProxy> getTipoPubblicazioniWeb(String descrizione) throws Exception;
	public Integer updateTipoPraweb(TipoPubbliProxy pratica) throws Exception;
	public Boolean  removeTipoPubblWeb(Integer id) throws Exception;
}

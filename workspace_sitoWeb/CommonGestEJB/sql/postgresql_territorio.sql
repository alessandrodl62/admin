

--- generazione database ---

CREATE DATABASE territorio ENCODING 'UTF-8';


--- cancella database ---

DROP DATABASE territorio

--- generazione tabelle ---



CREATE TABLE  eco_attivita
			(
 	           idattivita           SERIAL NOT NULL,
 	           idanagrich			INTEGER NOT NULL,
 	           idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	           datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,	
               nrea                 CHAR(25),  			   
 	           ragsociale           CHAR(250),
 	           ragsoc_leg           CHAR(250),
			   id_ente         		INTEGER NOT NULL,
			   naddetti				INTEGER NOT NULL DEFAULT 0,
			   istat_principale		INTEGER,
			   istat_secondario1	INTEGER,
			   istat_secondario2	INTEGER,
			   istat_secondario3	INTEGER,
			   istat_secondario4	INTEGER,
			   istat_secondario5	INTEGER,
			   istat_secondario6	INTEGER,
			   istat_secondario7	INTEGER,
			   istat_secondario8	INTEGER,
			   istat_secondario9	INTEGER,
			   istat_secondario0	INTEGER,
			   desc_cicloprod		TEXT,
			   note					TEXT,
			   prescrizione         TEXT,   
 	
			   PRIMARY KEY (idattivita)


 	        );
 	        
 	        COMMENT ON TABLE eco_attivita IS 'intestazione scheda attivit� produttive - fine principale ';
 	        
 	        COMMENT ON COLUMN eco_attivita.idanagrich IS 'chiave esterna a tabella gestionale.anag_rich';
 	        COMMENT ON COLUMN eco_attivita.idprocedure IS 'chiave esterna a tabella gestionale.procedure_type';
 			COMMENT ON COLUMN eco_attivita.naddetti IS 'numero di addetti attivita';
 			COMMENT ON COLUMN eco_attivita.nrea IS 'numero di registro ';

 			COMMENT ON COLUMN eco_attivita.istat_principale IS 'codice istat attivita economiche - attivita economica principale - codifica tabella istatcodattivita';
			COMMENT ON COLUMN eco_attivita.istat_secondario1 IS 'codice istat attivita economiche - attivita economica secondaria - codifica tabella istatcodattivita';
			COMMENT ON COLUMN eco_attivita.desc_cicloprod IS 'descrizione del ciclo produttivo';
			
			
			GRANT ALL ON eco_attivita TO PUBLIC;
			
			

			
			
CREATE TABLE eco_elenco_insalubri
			(
				idelenco_ins		SERIAL NOT NULL,
			    classe				INTEGER,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
				idelenco            INTEGER UNIQUE NOT NULL,
				idattiext           INTEGER,
 	           	datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
 	           	
			   PRIMARY KEY (idelenco_ins),
			   
		       FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		       ON DELETE RESTRICT
       		   ON UPDATE CASCADE
			
 	        );

 	        COMMENT ON TABLE eco_elenco_insalubri IS 'classificazione ditte insalubri';
			COMMENT ON COLUMN eco_elenco_insalubri.classe IS 'classificazione 0 - industrie prima classe; 1 - industrie seconda classe';
			COMMENT ON COLUMN eco_elenco_insalubri.idelenco IS 'classificazione da elenco (vedi eco_sostanze)';
			
CREATE TABLE eco_att_materie
			(
				idmaterie			SERIAL NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	           	datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
				utilizzo			TEXT,
				descrizione			TEXT,
				quantitautil		NUMERIC(11,4),
				frequenza			CHAR(20),
				idunmisutil			INTEGER NOT NULL DEFAULT 0,
				quantitastock		NUMERIC(11,4),
				idunmisstock        INTEGER NOT NULL DEFAULT 0,
				idrischio           INTEGER UNIQUE NOT NULL DEFAULT 0,
				prevenzione			TEXT,	
				idprudenza			INTEGER UNIQUE NOT NULL DEFAULT 0,
				comppericolosi		TEXT,
				pericoli			TEXT,
			
			PRIMARY KEY (idmaterie),
			
		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
       		ON UPDATE CASCADE
			
			);
			
 	        COMMENT ON TABLE eco_att_materie IS 'materie prime, sostanze, composti detenuti utilizzati o prodotti';

			
 			COMMENT ON COLUMN eco_att_materie.quantitautil IS 'quantita media utilizzata nel periodo definito dalla frequenza';
 			COMMENT ON COLUMN eco_att_materie.quantitastock IS 'quantita immagazzinata';
 			COMMENT ON COLUMN eco_att_materie.idrischio IS 'pericoli e rischi associati al materiale, sostanza';
 			COMMENT ON COLUMN eco_att_materie.prevenzione IS 'misure preventive per ridurre i rischi';
			COMMENT ON COLUMN eco_att_materie.frequenza IS 'intervallo di tempo di utilizzo materie e sostanze';
			COMMENT ON COLUMN eco_att_materie.comppericolosi IS 'componentipericolosi';
			COMMENT ON COLUMN eco_att_materie.pericoli IS 'pericoli connessi a utilizzo materie-sostanze';

			GRANT ALL ON eco_att_materie TO PUBLIC;


CREATE TABLE eco_att_atmosfera
			(
				idatmosfera			SERIAL NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
				tipoemissioni		CHAR(250),
				puntiemissione		INTEGER,
				inquinanti			TEXT,
				diffconv			CHAR(20),
				autorizzato			BOOLEAN DEFAULT FALSE,
				autorizzazione		INTEGER,
				odore				BOOLEAN DEFAULT FALSE,
				odorefase			TEXT,
				odoresostanze		TEXT,
				contromisure_odore		TEXT,
				contromisure_emissione		TEXT,
				
			
			PRIMARY KEY (idatmosfera),
			
		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
       		ON UPDATE CASCADE
			
			);
			
			COMMENT ON TABLE eco_att_atmosfera IS 'emissioni in atmosfera';
 			COMMENT ON COLUMN eco_att_atmosfera.tipoemissioni IS 'descrizione del tipo di emissioni';
 			COMMENT ON COLUMN eco_att_atmosfera.puntiemissione IS 'numero di punti di emissione';
 			COMMENT ON COLUMN eco_att_atmosfera.inquinanti IS 'sostanze inquinanti';
 			COMMENT ON COLUMN eco_att_atmosfera.diffconv IS 'emissioni diffuse oppure convogliate';
 			COMMENT ON COLUMN eco_att_atmosfera.odore IS 'emissioni odorigene oopure no';
 			COMMENT ON COLUMN eco_att_atmosfera.odorefase IS 'fase emissione odori';
 			COMMENT ON COLUMN eco_att_atmosfera.odoresostanze IS 'sostanze che generano odore';
			COMMENT ON COLUMN eco_att_atmosfera.autorizzato IS 'emissioni autorizzate vero/falso';
			COMMENT ON COLUMN eco_att_atmosfera.autorizzazione IS 'chiave esterna tabella gestionale.attiext';
			COMMENT ON COLUMN eco_att_atmosfera.contromisure_odore IS 'misure riduzione odore';
			COMMENT ON COLUMN eco_att_atmosfera.contromisure_emissione IS 'contromisure connesse sorgente emissione in atmosfera';
 			
			GRANT ALL ON eco_att_atmosfera TO PUBLIC;
	
		


CREATE TABLE eco_att_idroscarichi
			(
				idacqua				SERIAL NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
				usoacqua			BOOLEAN DEFAULT FALSE,
				fasiuso				TEXT,
				prelievo			TEXT,
				quantita			NUMERIC(11,4),
				idunmis			    INTEGER NOT NULL DEFAULT 0,
				trattamento			BOOLEAN DEFAULT FALSE,
				smaltimento			TEXT,
				autorizzato			BOOLEAN DEFAULT FALSE,
				autorizzazione		INTEGER,
				contromisure		TEXT,
				
			
			PRIMARY KEY (idacqua),
			
		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
       		ON UPDATE CASCADE
			
			);
			
			COMMENT ON TABLE eco_att_idroscarichi IS 'scarichi idrici';
 			COMMENT ON COLUMN eco_att_idroscarichi.usoacqua IS 'utilizzo acqua nel ciclo produttivo vero/falso';
 			COMMENT ON COLUMN eco_att_idroscarichi.fasiuso IS 'fasi produttive in cui viene utilizzata acqua';
 			COMMENT ON COLUMN eco_att_idroscarichi.prelievo IS 'fonte di prelievo acqua: corso acqua, pozzzo, acquedotto, ecc...';
 			COMMENT ON COLUMN eco_att_idroscarichi.trattamento IS 'presenza impianto di trattento acqua reflua';
 			COMMENT ON COLUMN eco_att_idroscarichi.smaltimento IS 'modalita di smaltimento acque reflue: fogna nera, fogna mista, in corso acqua, in corso con pretrattamento, ecc... ';
			COMMENT ON COLUMN eco_att_idroscarichi.autorizzato IS 'emissioni autorizzate vero/falso';
			COMMENT ON COLUMN eco_att_idroscarichi.autorizzazione IS 'chiave esterna tabella gestionale.attiext';
 			COMMENT ON COLUMN eco_att_idroscarichi.contromisure IS 'misure adottate per riduzione inquinamento';
 			
			GRANT ALL ON eco_att_idroscarichi TO PUBLIC;
			
			
			
			
CREATE TABLE eco_att_rifiuti
			(
				idrifiuti			SERIAL NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,
				descrizione			TEXT,
				codice_cer			INTEGER,
				quantitaperiodo		NUMERIC(11,4),
				periodo				CHAR(20),
				idunmisperiodo		INTEGER NOT NULL DEFAULT 0,
				quantitastock		NUMERIC(11,4),
				idunmisstock		INTEGER NOT NULL DEFAULT 0,
				smaltimento			TEXT,
				contromisure		TEXT,
				idsmaltimento		INTEGER NOT NULL DEFAULT 0,
				
			
			PRIMARY KEY (idrifiuti),
			
		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
       		ON UPDATE CASCADE
			
			);
			
			COMMENT ON TABLE eco_att_rifiuti IS 'produzione di rifiuti';
 			COMMENT ON COLUMN eco_att_rifiuti.descrizione IS 'descrizione del tipo di rifiuti prodotti';
 			COMMENT ON COLUMN eco_att_rifiuti.codice_cer IS 'codice CER dei rifiuti';
 			COMMENT ON COLUMN eco_att_rifiuti.quantitaperiodo IS 'quantita di rifiuti prodotti nel periodo considerato';
 			COMMENT ON COLUMN eco_att_rifiuti.periodo IS 'periodo considerato per misurare la quantita di rifiuti prodotta: mese, bimestre, ecc...';
 			COMMENT ON COLUMN eco_att_rifiuti.quantitastock IS 'quantita di rifiuti immagazzinati prima di essere smaltiti';
 			COMMENT ON COLUMN eco_att_rifiuti.smaltimento IS 'modalita di smaltimento dei rifiuti. Ditta che effettua lo smaltimento';
 			COMMENT ON COLUMN eco_att_rifiuti.contromisure IS 'misure adottate per riduzione inquinamento';
 			
			GRANT ALL ON eco_att_rifiuti TO PUBLIC;
			
			
			
CREATE TABLE eco_att_rumore
			(
				idrumore			SERIAL NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure     	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,								
				iddocproc			INTEGER DEFAULT 0,	
				emissione			BOOLEAN DEFAULT FALSE,
				valutazione			BOOLEAN DEFAULT FALSE,
				contromisure		TEXT,
				sorgente			TEXT,
				idattiext			INTEGER,

			PRIMARY KEY (idrumore),
			
		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
       		ON UPDATE CASCADE

			
			);
			
			COMMENT ON TABLE eco_att_rumore  IS 'emissioni sonore';
			COMMENT ON COLUMN eco_att_rumore.emissione IS 'emissione di rumore vero/falso';
 			COMMENT ON COLUMN eco_att_rumore.valutazione IS 'effettuata valutazione emissioni sonore vero/falso';
 			COMMENT ON COLUMN eco_att_rumore.iddocproc IS 'chiave esterna a documento allegato';
 			COMMENT ON COLUMN eco_att_rumore.contromisure IS 'misure riduzione inquinamento';
 			COMMENT ON COLUMN eco_att_rumore.sorgente IS 'descrizione sorgente del rumore';
 			COMMENT ON COLUMN eco_att_rumore.idattiext IS 'chiave esterna ad atti autorizzativi'; 			 			
			
			GRANT ALL ON eco_att_rumore TO PUBLIC;
			
			
CREATE TABLE eco_att_gas
			(
				idgas				SERIAL NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,								
				denominazione		TEXT,
				autorizzato			BOOLEAN DEFAULT FALSE,
				autorizzazione		INTEGER,

			PRIMARY KEY (idgas),
			
		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
       		ON UPDATE CASCADE

			
			);
			
			COMMENT ON TABLE eco_att_gas IS 'detenzione di gas tossici';
 			COMMENT ON COLUMN eco_att_gas.denominazione IS 'descrizione dl tipo di gas tossici detenuti';
			COMMENT ON COLUMN eco_att_gas.autorizzato IS 'emissioni autorizzate vero/falso';
			COMMENT ON COLUMN eco_att_gas.autorizzazione IS 'chiave esterna tabella gestionale.attiext';
						
			GRANT ALL ON eco_att_gas TO PUBLIC;			

	
--- ******************** storico ************************** ---	
			
			
CREATE TABLE   eco_attivita_storico
			(
			   id_storattivita 		SERIAL NOT NULL,
 	           idattivita           INTEGER NOT NULL,
 	           idanagrich			INTEGER NOT NULL,
 	           idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	           datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,	
               nrea                 CHAR(25),  			   
 	           ragsociale           CHAR(250),
 	           ragsoc_leg           CHAR(250),
			   id_ente         		INTEGER NOT NULL,
			   naddetti				INTEGER NOT NULL DEFAULT 0,
			   istat_principale		INTEGER,
			   istat_secondario1	INTEGER,
			   istat_secondario2	INTEGER,
			   istat_secondario3	INTEGER,
			   istat_secondario4	INTEGER,
			   istat_secondario5	INTEGER,
			   istat_secondario6	INTEGER,
			   istat_secondario7	INTEGER,
			   istat_secondario8	INTEGER,
			   istat_secondario9	INTEGER,
			   istat_secondario0	INTEGER,
			   desc_cicloprod		TEXT,
			   note					TEXT,
			   prescrizione         TEXT,  
 	
			   PRIMARY KEY (id_storattivita),

		    FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		    ON DELETE RESTRICT
 
       		
 	        );
 	        

			GRANT ALL ON eco_attivita_storico TO PUBLIC;


CREATE TABLE eco_att_ot_sto
			(
				idattivita				INTEGER NOT NULL,
				idoggetti               INTEGER NOT NULL, 
				PRIMARY KEY (idattivita, idoggetti),
			
			   FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idoggetti) REFERENCES  ot_oggetti (idoggetti)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_att_ot_sto IS 'Tabella relazione tra attivita e tabella ot_oggetti';
GRANT ALL ON eco_att_ot_sto TO PUBLIC;


			
			
CREATE TABLE eco_att_materie_sto
			(
				id_stormaterie		SERIAL NOT NULL,
				idmaterie			INTEGER NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	           	datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
				utilizzo			TEXT,
				descrizione			TEXT,
				quantitautil		NUMERIC(11,4),
				frequenza			CHAR(20),
				idunmisutil			INTEGER NOT NULL DEFAULT 0,
				quantitastock		NUMERIC(11,4),
				idunmisstock        INTEGER NOT NULL DEFAULT 0,
				idrischio           INTEGER UNIQUE NOT NULL DEFAULT 0,
				prevenzione			TEXT,	
				idprudenza			INTEGER UNIQUE NOT NULL DEFAULT 0,
				comppericolosi		TEXT,
				pericoli			TEXT,
			
			PRIMARY KEY (id_stormaterie),
			
		    FOREIGN KEY (idattivita) REFERENCES eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,


		    FOREIGN KEY (idmaterie) REFERENCES  eco_att_materie (idmaterie)
   		    ON DELETE RESTRICT
			
			);
			

			GRANT ALL ON eco_att_materie_sto TO PUBLIC;
			
			
			
CREATE TABLE eco_att_atmosfera_sto
			(
				id_storatmosfera	SERIAL NOT NULL,
				idatmosfera			INTEGER NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
				tipoemissioni		CHAR(250),
				puntiemissione		INTEGER,
				inquinanti			TEXT,
				diffconv			CHAR(20),
				autorizzato			BOOLEAN DEFAULT FALSE,
				autorizzazione		INTEGER,
				odore				BOOLEAN DEFAULT FALSE,
				odorefase			TEXT,
				odoresostanze		TEXT,
				contromisure_odore		TEXT,
				contromisure_emissione		TEXT,
				
			
			PRIMARY KEY (id_storatmosfera),
	
			FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,
			
		    FOREIGN KEY (idatmosfera) REFERENCES  eco_att_atmosfera (idatmosfera)
   		    ON DELETE RESTRICT
			
			);
			
 			
			GRANT ALL ON eco_att_atmosfera_sto TO PUBLIC;


CREATE TABLE eco_att_idroscarichi_sto
			(
				id_storacqua		SERIAL NOT NULL,
				idacqua				INTEGER NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,				
				usoacqua			BOOLEAN DEFAULT FALSE,
				fasiuso				TEXT,
				prelievo			TEXT,
				quantita			NUMERIC(11,4),
				idunmis			    INTEGER NOT NULL DEFAULT 0,
				trattamento			BOOLEAN DEFAULT FALSE,
				smaltimento			TEXT,
				autorizzato			BOOLEAN DEFAULT FALSE,
				autorizzazione		INTEGER,
				contromisure		TEXT,
				
			
			PRIMARY KEY (id_storacqua),
			
			FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,
			
		    FOREIGN KEY (idacqua) REFERENCES  eco_att_idroscarichi (idacqua)
   		    ON DELETE RESTRICT
			
			);
			
 			
			GRANT ALL ON eco_att_idroscarichi_sto TO PUBLIC;


CREATE TABLE eco_att_rifiuti_sto
			(
				id_storifiuti		SERIAL NOT NULL,
				idrifiuti			INTEGER NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,
				descrizione			TEXT,
				codice_cer			INTEGER,
				quantitaperiodo		NUMERIC(11,4),
				periodo				CHAR(20),
				idunmisperiodo		INTEGER NOT NULL DEFAULT 0,
				quantitastock		NUMERIC(11,4),
				idunmisstock		INTEGER NOT NULL DEFAULT 0,
				smaltimento			TEXT,
				contromisure		TEXT,
				idsmaltimento		INTEGER NOT NULL DEFAULT 0,
			
			PRIMARY KEY (id_storifiuti),
			
			FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,
			
		    FOREIGN KEY (idrifiuti) REFERENCES  eco_att_rifiuti (idrifiuti)
   		    ON DELETE RESTRICT
			
			);
			
 			
			GRANT ALL ON eco_att_rifiuti_sto TO PUBLIC;
			
			
			
CREATE TABLE eco_att_rumore_sto
			(
				id_storumore		SERIAL NOT NULL,
				idrumore			INTEGER NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure     	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,								
				iddocproc			INTEGER DEFAULT 0,	
				emissione			BOOLEAN DEFAULT FALSE,
				valutazione			BOOLEAN DEFAULT FALSE,
				contromisure		TEXT,
				sorgente			TEXT,
				idattiext			INTEGER,

			PRIMARY KEY (id_storumore),
			
			FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,
			
		    FOREIGN KEY (idrumore) REFERENCES  eco_att_rumore (idrumore)
   		    ON DELETE RESTRICT

			
			);
			
			
			GRANT ALL ON eco_att_rumore_sto TO PUBLIC;


CREATE TABLE eco_att_gas_sto
			(
				id_stogas			SERIAL NOT NULL,
				idgas				INTEGER NOT NULL,
				idattivita			INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
 	            datainizio			DATE NOT NULL DEFAULT CURRENT_DATE,								
				denominazione		TEXT,
				autorizzato			BOOLEAN DEFAULT FALSE,
				autorizzazione		INTEGER,

			PRIMARY KEY (id_stogas),
			
			FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,
			
		    FOREIGN KEY (idgas) REFERENCES  eco_att_gas (idgas)
   		    ON DELETE RESTRICT

			
			);
			
			
			GRANT ALL ON eco_att_gas_sto TO PUBLIC;	

CREATE TABLE eco_elenco_insalubri_sto
			(
			    idelenco_ins_sto      SERIAL NOT NULL,
				idelenco_ins		INTEGER NOT NULL,
				idprocedure      	INTEGER NOT NULL DEFAULT 0,
			    classe				INTEGER,
				idattivita			INTEGER NOT NULL,
				idelenco            INTEGER UNIQUE NOT NULL,
				idattiext           INTEGER,
 	           	datainizio			DATE NOT NULL,				
 	            datafine 			DATE NOT NULL,								
 	           	
			   PRIMARY KEY (idelenco_ins_sto),

			FOREIGN KEY (idattivita) REFERENCES  eco_attivita_storico (id_storattivita)
   		    ON DELETE RESTRICT,
   		    
		    FOREIGN KEY (idelenco_ins) REFERENCES  eco_elenco_insalubri (idelenco_ins)
   		    ON DELETE RESTRICT
			
 	        );

 	        COMMENT ON TABLE eco_elenco_insalubri_sto IS 'classificazione ditte insalubri';
			COMMENT ON COLUMN eco_elenco_insalubri_sto.classe IS 'classificazione 0 - industrie prima classe; 1 - industrie seconda classe';
			COMMENT ON COLUMN eco_elenco_insalubri_sto.idelenco IS 'classificazione da elenco (vedi eco_sostanze)';

-- tabelle relazione storicizzate

CREATE TABLE eco_insalubri_sostanze_sto
			(
				idelencoins				INTEGER NOT NULL,
				idelencosos				INTEGER NOT NULL, 
				PRIMARY KEY (idelencoins, idelencosos),
			
			   FOREIGN KEY (idelencoins) REFERENCES  eco_elenco_insalubri_sto (idelenco)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idelencosos) REFERENCES  eco_sostanze (idelenco)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_insalubri_sostanze IS 'Tabella relazione tra eco_elenco_insalubri e eco_sostanze';
GRANT ALL ON eco_insalubri_sostanze TO PUBLIC;





CREATE TABLE eco_materie_rischio_sto
			(
				idrischiomat				INTEGER NOT NULL,
				idrischioris				INTEGER NOT NULL, 
				PRIMARY KEY (idrischiomat, idrischioris),
			
			   FOREIGN KEY (idrischiomat) REFERENCES  eco_att_materie_sto (idrischio)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idrischioris) REFERENCES  tab_rischio (idrischio)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_materie_rischio IS 'Tabella relazione tra eco_att_materie e eco_sostanze';
GRANT ALL ON eco_materie_rischio TO PUBLIC;




CREATE TABLE eco_materie_prudenza_sto
			(
				idprudenzamat				INTEGER NOT NULL,
				idprudenzapru				INTEGER NOT NULL, 
				PRIMARY KEY (idprudenzamat, idprudenzapru),
			
			   FOREIGN KEY (idprudenzamat) REFERENCES  eco_att_materie_sto (idprudenza)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idprudenzapru) REFERENCES  eco_prudenza (idprudenza)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_materie_prudenza IS 'Tabella relazione tra eco_att_materie e eco_prudenza';
GRANT ALL ON eco_materie_prudenza TO PUBLIC;






--- ********************************************************** ---

--- tabelle di codifica ---



CREATE TABLE eco_sostanze
			(
				idelenco				SERIAL NOT NULL,
				cod_sostanze            CHAR(5),
				descr_sostanze			TEXT,
				codice                  CHAR(5),
				descrizione			    TEXT,
				
				PRIMARY KEY (idelenco)
			
			);

			COMMENT ON TABLE eco_sostanze IS 'codice  Elenco ditte insalubri - codici sostanze';
			COMMENT ON COLUMN eco_sostanze.cod_sostanze IS 'codice identificativo delle sostanze A, B, C';			
			COMMENT ON COLUMN eco_sostanze.codice IS 'codice dei prodotti e lavorazioni';			
			
GRANT ALL ON eco_sostanze TO PUBLIC;			



	
CREATE TABLE istatcodattivita
			(	
				idistat				SERIAL NOT NULL,
				codice				char(25) UNIQUE NOT NULL,
				descrizione			char(250) NOT NULL,
				
				PRIMARY KEY (idistat)
			
			);	
			
			COMMENT ON TABLE istatcodattivita IS 'codice  ISTAT attivita produttive';
			COMMENT ON COLUMN istatcodattivita.codice IS'codice ISTAT';
 			COMMENT ON COLUMN istatcodattivita.descrizione IS 'descrizione codice ISTAT attivita';
			
GRANT ALL ON istatcodattivita TO PUBLIC;


CREATE TABLE codice_cer
			(	
				idcer				SERIAL NOT NULL,
				codice				CHAR(25) UNIQUE NOT NULL,
				descrizione			char(250) NOT NULL,
				
				PRIMARY KEY (idcer)
			
			);
			
			COMMENT ON TABLE codice_cer IS 'codice  Catalogo europeo dei rifiuti - Gazzetta Ufficialle n. 108 del 10 maggio 2002';
			COMMENT ON COLUMN codice_cer.codice IS'codice CER';
 			COMMENT ON COLUMN codice_cer.descrizione IS 'descrizione del tipo di rifiuti prodotti';
 			 	
			GRANT ALL ON codice_cer TO PUBLIC;

			

CREATE TABLE ot_classi
			(
				idclasse				SERIAL NOT NULL,
				descrizione             TEXT, 
				PRIMARY KEY (idclasse)
			
			);

COMMENT ON TABLE ot_classi IS 'Tabella codifica descrizioni degli oggetti territoriali';
GRANT ALL ON ot_classi TO PUBLIC;



CREATE TABLE ot_oggetti
			(
				idoggetti				SERIAL NOT NULL,
				idclasse				INTEGER,
				iccarto					BIGINT,
				descrizione             CHAR(250),
				datainizio				DATE,
				datafine				DATE,
				
				PRIMARY KEY (idoggetti),
			
			FOREIGN KEY (idclasse) REFERENCES  ot_classi (idclasse)
   		    ON DELETE RESTRICT
			
			
			
			);

COMMENT ON TABLE ot_oggetti IS 'Tabella master degli oggetti cartografici';
GRANT ALL ON ot_oggetti TO PUBLIC;			


CREATE TABLE zto
			(
				idzto				SERIAL NOT NULL,
				idente				INTEGER NOT NULL,
				codente				INTEGER,
				codice				CHAR(50) UNIQUE NOT NULL,	
				descrizione			CHAR(250) NOT NULL,
				
				PRIMARY KEY (idzto)
			
			);
			
			COMMENT ON TABLE zto IS 'codice  Zone Territoriali Omogenee - PRG - leggi urbanistiche regionali - DM 1444 del 1968';
			COMMENT ON COLUMN zto.idente IS'identificativo ente - rif. tabella TAB_ENTI';			
			COMMENT ON COLUMN zto.codente IS'codice ente Istat';
			COMMENT ON COLUMN zto.codice IS'codice ZTO';
 			COMMENT ON COLUMN zto.descrizione IS 'descrizione della ZTO';
			
			
GRANT ALL ON zto TO PUBLIC;			

		

CREATE TABLE ot_zto
			(
				idoggetti				INTEGER NOT NULL,
				idzto					INTEGER NOT NULL,

				PRIMARY KEY (idoggetti, idzto),
			
			FOREIGN KEY (idoggetti) REFERENCES  ot_oggetti (idoggetti)
   		    ON DELETE RESTRICT,
			
			FOREIGN KEY (idzto) REFERENCES  zto (idzto)
   		    ON DELETE RESTRICT
			
			);

COMMENT ON TABLE ot_zto IS 'Tabella relazione con tabella - zto - zone territoriali omogenee';
GRANT ALL ON ot_zto TO PUBLIC;			


CREATE TABLE codvie
			(		

				idvia			    SERIAL NOT NULL,
				idente				INTEGER NOT NULL,
				codente				INTEGER,
				codice				CHAR(25) NOT NULL,
				denominazione		CHAR(250) NOT NULL,
				
				PRIMARY KEY (idvia)
			
			);	
			
			COMMENT ON TABLE codvie IS 'codice  toponomastica aree pubblica circolazione';
			COMMENT ON COLUMN codvie.codice IS'codice area di circolazione';
			COMMENT ON COLUMN codvie.idente IS'identificativo ente - rif. tabella TAB_ENTI';			
			COMMENT ON COLUMN codvie.codente IS'codice ente istat';			
 			COMMENT ON COLUMN codvie.denominazione IS 'denominazione area pubblica circolazione';
			
GRANT ALL ON codvie TO PUBLIC;

		
	
CREATE TABLE ot_indirizzi
			(
				idindirizzi				SERIAL NOT NULL,
				idoggetti				INTEGER NOT NULL,
				idvia					INTEGER NOT NULL,
				civico					INTEGER,
				subcivico				CHAR(20),
				
				PRIMARY KEY (idindirizzi),
			
			FOREIGN KEY (idoggetti) REFERENCES  ot_oggetti (idoggetti)
   		    ON DELETE RESTRICT,
			
			FOREIGN KEY (idvia) REFERENCES codvie  (idvia)
   		    ON DELETE RESTRICT
			
			);

COMMENT ON TABLE ot_indirizzi IS 'Tabella indirizzi';
GRANT ALL ON ot_indirizzi TO PUBLIC;			

CREATE TABLE ot_catasto
			(
				idcatasto				SERIAL NOT NULL,
				idoggetti				INTEGER NOT NULL,
				tipo					CHAR(5) NOT NULL,
				comune                  CHAR(7),
				sezione_amm             CHAR(50),
				sezione_cens            CHAR(50),
				sezione_urb             CHAR(50),
				foglio					CHAR(5),
                denominatore			CHAR(20),
				allegato				CHAR(5),
				mappale                 CHAR(20),
				submappale     			CHAR(20),
				
				PRIMARY KEY (idcatasto),
			
			FOREIGN KEY (idoggetti) REFERENCES  ot_oggetti (idoggetti)
   		    ON DELETE RESTRICT
			
			
			);

COMMENT ON TABLE ot_catasto IS 'Tabella catasto';
COMMENT ON COLUMN ot_catasto.comune IS'codice catastale del comune es. Conegliano - C957';
COMMENT ON COLUMN ot_catasto.sezione_amm IS'codice catastale sezione amministrativa - solo per catasto fabbricati';
COMMENT ON COLUMN ot_catasto.sezione_cens IS'codice catastale sezione censuaria - solo per catasto terreni';
COMMENT ON COLUMN ot_catasto.sezione_urb IS'codice catastale sezione urbana - solo per catasto fabbricati';
COMMENT ON COLUMN ot_catasto.foglio IS'foglio della mappa catastale';
COMMENT ON COLUMN ot_catasto.denominatore IS'relativo ad immobili del catasto fondiario - provincie di UD-TS-GO';
COMMENT ON COLUMN ot_catasto.allegato IS'sub divisione de foglio';

GRANT ALL ON ot_catasto TO PUBLIC;			


	



CREATE TABLE tab_rischio
			(
				idrischio				SERIAL NOT NULL,
				descrizione             CHAR(250), 
				PRIMARY KEY (idrischio)
			
			);

COMMENT ON TABLE tab_rischio IS 'Tabella descrizioni rischio';

CREATE TABLE tab_unita_misura
			(
				idunmis				SERIAL NOT NULL,
				descrizione         CHAR(250),
				tipo                CHAR(20), 
				indice_conv         NUMERIC(12,5) NOT NULL DEFAULT 0, 
			
				PRIMARY KEY (idunmis)
			);

			COMMENT ON TABLE tab_unita_misura IS 'Unit� di misura';
			COMMENT ON COLUMN tab_unita_misura.indice_conv IS 'indice di conversione per tipo';			

GRANT ALL ON tab_unita_misura TO PUBLIC;			


CREATE TABLE eco_smaltimento
			(
				idsmaltimento		SERIAL NOT NULL,
				descrizione         TEXT,
			
				PRIMARY KEY (idsmaltimento)
			);

			COMMENT ON TABLE eco_smaltimento IS 'decodifica modalita di smaltimento rifiuti';

GRANT ALL ON eco_smaltimento TO PUBLIC;		


CREATE TABLE eco_prudenza
			(
				idprudenza			SERIAL NOT NULL,
				descrizione         TEXT,
			
				PRIMARY KEY (idprudenza)
			);

			COMMENT ON TABLE eco_prudenza IS 'misure di prudenza sui materiali';

GRANT ALL ON eco_prudenza TO PUBLIC;	

---  tabella da scrivere in area gestionale ---		
			
CREATE TABLE attiext
			(		
				idattiext			SERIAL NOT NULL,
				identeext			INTEGER NOT NULL DEFAULT 0,
				iddocproc			INTEGER,
				descrizione			CHAR(250),
				data				DATE NOT NULL,
				numero				INTEGER,
				note				TEXT,
				
				PRIMARY KEY (idattiext)
			);
GRANT ALL ON attiext TO PUBLIC;	

--- ***********************************************************************************
		

--- tabelle di relazione ---

CREATE TABLE eco_att_ot
			(
				idattivita				INTEGER NOT NULL,
				idoggetti               INTEGER NOT NULL, 
				PRIMARY KEY (idattivita, idoggetti),
			
			   FOREIGN KEY (idattivita) REFERENCES  eco_attivita (idattivita)
   		       ON DELETE RESTRICT,

			   
			   
			   FOREIGN KEY (idoggetti) REFERENCES  ot_oggetti (idoggetti)
   		       ON DELETE RESTRICT
       		   
			
			
			);

COMMENT ON TABLE eco_att_ot IS 'Tabella relazione tra attivita e tabella ot_oggetti';
GRANT ALL ON eco_att_ot TO PUBLIC;




CREATE TABLE eco_insalubri_sostanze
			(
				idelencoins				INTEGER NOT NULL,
				idelencosos				INTEGER NOT NULL, 
				PRIMARY KEY (idelencoins, idelencosos),
			
			   FOREIGN KEY (idelencoins) REFERENCES  eco_elenco_insalubri (idelenco)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idelencosos) REFERENCES  eco_sostanze (idelenco)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_insalubri_sostanze IS 'Tabella relazione tra eco_elenco_insalubri e eco_sostanze';
GRANT ALL ON eco_insalubri_sostanze TO PUBLIC;





CREATE TABLE eco_materie_rischio
			(
				idrischiomat				INTEGER NOT NULL,
				idrischioris				INTEGER NOT NULL, 
				PRIMARY KEY (idrischiomat, idrischioris),
			
			   FOREIGN KEY (idrischiomat) REFERENCES  eco_att_materie (idrischio)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idrischioris) REFERENCES  tab_rischio (idrischio)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_materie_rischio IS 'Tabella relazione tra eco_att_materie e eco_sostanze';
GRANT ALL ON eco_materie_rischio TO PUBLIC;




CREATE TABLE eco_materie_prudenza
			(
				idprudenzamat				INTEGER NOT NULL,
				idprudenzapru				INTEGER NOT NULL, 
				PRIMARY KEY (idprudenzamat, idprudenzapru),
			
			   FOREIGN KEY (idprudenzamat) REFERENCES  eco_att_materie (idprudenza)
   		       ON DELETE RESTRICT,
			   
			   
			   FOREIGN KEY (idprudenzapru) REFERENCES  eco_prudenza (idprudenza)
   		       ON DELETE RESTRICT
			
			);

COMMENT ON TABLE eco_materie_prudenza IS 'Tabella relazione tra eco_att_materie e eco_prudenza';
GRANT ALL ON eco_materie_prudenza TO PUBLIC;




--- **********************************************************************************************

--- cancella tabelle ---

DROP TABLE eco_elenco_insalubri_sto;

DROP TABLE eco_att_materie_sto;

DROP TABLE eco_att_atmosfera_sto;

DROP TABLE eco_att_idroscarichi_sto;

DROP TABLE eco_att_rifiuti_sto;

DROP TABLE eco_att_rumore_sto;

DROP TABLE eco_att_gas_sto;


-- **************** --

DROP TABLE eco_att_attivita_storico;

--- **************** ---

DROP TABLE eco_elenco_insalubri;

DROP TABLE eco_att_materie;

DROP TABLE eco_att_atmosfera;
			
DROP TABLE eco_att_idroscarichi;
			
DROP TABLE eco_att_rifiuti;

DROP TABLE eco_att_rumore;

DROP TABLE eco_att_gas;

-- ***************** --

DROP TABLE eco_attivita;

-- ***************** --

DROP TABLE istatcodattivita;

DROP TABLE zto;

DROP TABLE codvie;

DROP TABLE eco_sostanze;

DROP TABLE attiext;

DROP TABLE tab_unita_misura;

DROP TABLE tab_rischio;

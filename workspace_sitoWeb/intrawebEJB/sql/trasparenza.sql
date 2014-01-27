   	CREATE TABLE t_modassegnazione (
   	       idmoda              SERIAL NOT NULL,
   	       descrizione         TEXT,
        	
		   PRIMARY KEY (idmoda)
   	);
   	
        GRANT ALL ON TABLE t_modassegnazione TO postgres;
        COMMENT ON TABLE t_modassegnazione IS 'tabella di definizione modalita di assegnazione';   	


   	CREATE TABLE t_traspubblicazioni (
   	       idtrasp              SERIAL NOT NULL,
   	       tuf_id               INTEGER NOT NULL,            
           importo              NUMERIC(9,2) DEFAULT 0,
   	       soggetto             TEXT,
   	       cfpartiva            TEXT,
           modalita             TEXT,   	          
   	       normatit             TEXT,
   	       idmoda               INTEGER NOT NULL,
   	       atto                 TEXT,
   	       progetto             TEXT,
   	       contratto            TEXT,
   	       linkcur              TEXT,
           datainizio           DATE,
           datafine             DATE,
           dataatto             DATE,
           datafree             DATE,
           numliqui             INTEGER,
           fpubblic             CHAR(1) NOT NULL DEFAULT 'N', // Y - pubblicato, N - non pubblicato, X - Da NON pubblicare   
        	
		   PRIMARY KEY (idtrasp),
		   
                   FOREIGN KEY (tuf_id) REFERENCES t_uffici (tuf_id)
            	   ON DELETE RESTRICT 
		    	   ON UPDATE CASCADE        		   
		   
   	);
   	
        GRANT ALL ON TABLE t_traspubblicazioni TO postgres;
        COMMENT ON TABLE t_traspubblicazioni IS 'tabella di definizione pubblicazioni trasparenza atti';   	
   	
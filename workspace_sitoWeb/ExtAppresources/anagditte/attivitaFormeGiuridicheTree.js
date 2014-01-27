Ext.namespace('Attivita.tree');

Attivita.tree.FormeGiuridiche = function(config){

	var _this = this;

	var defaults = {
		id:'im-tree',
		title: 'Attivita Economiche - Forme Giuridiche',
		loader: new Ext.tree.TreeLoader(),
		rootVisible:true,
		lines:false,
		autoScroll:true,
		listeners:{
			dblclick: function(nodo, evento){
				nodo.text;
			
				console.log(nodo.text);
			}
		
		},
		root: new Ext.tree.AsyncTreeNode({
			text:'Forme giuridiche',
			expanded:true,
			children:[{
                                text:'Forme diritto privato',
                                expanded:true,
                                children:[{
					text:'Imprenditore individuale, libero professionista e lavoratore autonomo',
                                    	iconCls:'user',
					expanded:false,
                                    	leaf:false,
						children:[
							{text:'Imprenditore individuale agricolo',iconCls:'',leaf:true},
							{text:'Imprenditore individuale non agricolo',iconCls:'',leaf:true},
							{text:'Libero professionista',iconCls:'',leaf:true},
							{text:'Lavoratore autonomo',iconCls:'',leaf:true}
						]
                                	},{
					text:'Società di persone',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Società semplice',iconCls:'',leaf:true},
							{text:'Società in nome colletivo',iconCls:'',leaf:true},
							{text:'Società in accomandita semplice',iconCls:'',leaf:true},
							{text:'Studio associato o società di professionisti',iconCls:'',leaf:true},
							{text:'Società di fatto o irregolare, comunione ereditaria',iconCls:'',leaf:true}
						]
					},{
					text:'Società di capitali',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Società per azioni',iconCls:'',leaf:true},
							{text:'Società a responsabilità limitata',iconCls:'',leaf:true},
							{text:'Società a responsabilità limitata con un unico socio',iconCls:'',leaf:true},
							{text:'Società in accomandita per azioni',iconCls:'',leaf:true}
						]
					},{
					text:'Società Cooperativa',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Società cooperativa a mutualità prevalente',iconCls:'',leaf:true},
							{text:'Società cooperativa diversa',iconCls:'',leaf:true},
							{text:'Società cooperativa sociale',iconCls:'',leaf:true},
							{text:'Società di mutua assicurazione',iconCls:'',leaf:true}
						]
					},{
					text:'Consorzio di diritto privato ed altre forme di cooperazione fra imprese',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Consorzio di diritto privato',iconCls:'',leaf:true},
							{text:'Società consortile',iconCls:'',leaf:true},
							{text:'Associazione o raggrupamento temporaneo di imprese',iconCls:'',leaf:true},
							{text:'Gruppo europeo di intersse economico',iconCls:'',leaf:true}
						]
					},{
					text:'Ente pubblico economico, azienda speciale e azienda pubblica di servizi',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Ente pubblico economico',iconCls:'',leaf:true},
							{text:'Azienda speciale ai sensi del T.U.267/2000',iconCls:'',leaf:true},
							{text:'Azienda pubblica di servizi alle persone ai sensi del d.lgs.n.207/2001',iconCls:'',leaf:true}
						]
					},{
					text:'Ente privato con personalità giuridica',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Associazione riconosciuta',iconCls:'',leaf:true},
							{text:'Fondazione',iconCls:'',leaf:true},
							{text:'Fondazione bancaria',iconCls:'',leaf:true},
							{text:'Ente ecclesiastico',iconCls:'',leaf:true},
							{text:'Società di mutuo soccorso',iconCls:'',leaf:true},
							{text:'Altra forma di ente privato con personalità giuridica',iconCls:'',leaf:true}
						]
					},{
					text:'Ente privato senza personalità giuridica',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Associazione non riconosciuta',iconCls:'',leaf:true},
							{text:'Comitato',iconCls:'',leaf:true},
							{text:'Condominio',iconCls:'',leaf:true},
							{text:'Altra forma di ente privato senza personalità giuridica',iconCls:'',leaf:true}
						]
					},{
					text:'Impresa o ente privato costituito all&#39; estero non altrimenti classificabile che svolge una attività economica in Italia',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Impresa o ente privato costituito all&#39; estero non altrimenti classificabile che svolge una attività economica in Italia',iconCls:'',leaf:true}
						]
					}]
			},{
				text:'Forme disciplinate dal diritto pubblico',
                                expanded:true,
				children:[{
					text:'Organo costituzionale o a rilevanza costituzionale',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Organo costituzionale o a rilevanza costituzionale',iconCls:'',leaf:true}
						]
					},{
					text:'Amministrazione dello Stato',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Presidenza del consiglio',iconCls:'',leaf:true},
							{text:'Ministero',iconCls:'',leaf:true},
							{text:'Agenzia dello stato',iconCls:'',leaf:true},
							{text:'Archivio notarile',iconCls:'',leaf:true}
						]
					
					},{
					text:'Autorità indipendente',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Autorità indipendente',iconCls:'',leaf:true}
							]
					
					},{
					text:'Regione e autonomia locale',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Regione',iconCls:'',leaf:true},
							{text:'Provincia',iconCls:'',leaf:true},
							{text:'Comune',iconCls:'',leaf:true},
							{text:'Comunità montana o isolana',iconCls:'',leaf:true},
							{text:'Unione di comuni',iconCls:'',leaf:true},
							{text:'Città metropolitana',iconCls:'',leaf:true}
						]
					
					},{
					text:'Azienda o ente del servizio sanitario nazionale',
                                    	iconCls:'user',
                                    	leaf:false,
						children:[
							{text:'Azienda o ente del servizio sanitario nazionale',iconCls:'',leaf:true}
						]
						
					},{
					text:'Istituto, scuola e università pubblico',
					iconCls:'user',
					leaf:false,
						children:[
							{text:'Istituto e scuola pubblica di ogni ordine e grado',iconCls:'',leaf:true},
							{text:'Università pubblica',iconCls:'',leaf:true}
						]
					
					},{
					text:'Ente pubblico non economico',
					iconCls:'user',
					leaf:false,
						children:[
							{text:'Istituto o ente pubblico di ricerca',iconCls:'',leaf:true},
							{text:'Istituto pubblico di assistenza e beneficenza',iconCls:'',leaf:true},
							{text:'Camera di commercio',iconCls:'',leaf:true},
							{text:'Ordine e collegio professionale',iconCls:'',leaf:true},
							{text:'Consorzio di diritto pubblico',iconCls:'',leaf:true},
							{text:'Ente parco',iconCls:'',leaf:true},
							{text:'Ente o autorità portuale',iconCls:'',leaf:true},
							{text:'Ente di sviluppo agricolo regionale o di altro ente locale',iconCls:'',leaf:true},
							{text:'Ente per il turismo',iconCls:'',leaf:true},
							{text:'Ente ambientale regionale',iconCls:'',leaf:true},
							{text:'Ente per la ricerca e per l&#39; aggiornamento educativo',iconCls:'',leaf:true},
							{text:'Altro ente pubblico non economico nazionale',iconCls:'',leaf:true}
						]
					
				}]
			}]//fine secondo children
			
		})
	} //chiusura -- defaults




	Attivita.tree.FormeGiuridiche.superclass.constructor.call(this, Ext.apply({},  config , defaults));

}

Ext.extend(Attivita.tree.FormeGiuridiche, Ext.tree.TreePanel);

//registro l'oggetto EditForm
Ext.reg('formegiurtree', Attivita.tree.FormeGiuridiche)
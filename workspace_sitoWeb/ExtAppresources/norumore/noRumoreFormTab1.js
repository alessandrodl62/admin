Ext.namespace('Rumore.form');

Rumore.form.noRumoreForm1 = function(config){

	var _this = this

	// ########## TAB 0 ##########
 
// 	var richiedente = {xtype:'textfield', name:'richiedente', fieldLabel:'Richiedente',}
	var richQualif = {xtype:'textfield',name:'qualita', fieldLabel:'Qualifica richiedente'}
//	var ditta	= {xtype:'textfield', name:'ditta', fieldLabel:'Attività - denominazione ',}

	var professione	= {xtype:'textfield', name:'professione', fieldLabel:'Professione', readOnly:true}


	var fiscale	= {xtype:'textfield', name:'fiscale', fieldLabel:'Codice Fiscale - Partita IVA', readOnly:true}
	var domfiscale	= {xtype:'textfield', name:'domfiscale', fieldLabel:'Domicilio fiscale', readOnly:true}

	var indirUnitLoc = {xtype:'textfield', name:'indirunitloc', fieldLabel:'Unità locale - indirizzo', readOnly: true}
//	var ulsel	= {xtype:'button',}
// 	var unitalocale = {xtype:'textfield', name:'unita', fieldLabel:'ragione sociale',}
	var descimp	= {xtype:'textfield', name:'descimpianto', fieldLabel:'Impianto/Attività',}
	

	// ---------

	var storeCiclo = new Ext.data.SimpleStore({
		fields: ['cicloattivita'],
		data: [['ciclo continuo'],['diurno'],['serale'],['notturno']]
	});

	var storeClassi = new Ext.data.SimpleStore({
		fields:['classi'],
		data:[['classe I'],['classe II'],['classe III'],['classe IV'],['classe V'],['classe VI']]
	});
	
	var storeFreq = new Ext.data.SimpleStore({
		fields: ['freqattivita'],
		data: [['continuo'],['discontinuo'],['saltuario']]
	});

	//-----

	// ######### TAB 1 ###########

	var longdescimp	= {xtype:'htmleditor', height:100, width:400, enableFont: false, enableLinks: false, enableSourceEdit: false, name:'descrizioneimpianto', fieldLabel:'Descrizione impianto/attività'}

	var impiantiFreq = {xtype:'combo', store: storeFreq, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, 		displayField: 'freqattivita', hiddenName:'ciclo', fieldLabel: 'Frequenza attività'}

	var impiantiCiclo = {xtype:'combo', store: storeCiclo, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, 		displayField: 'cicloattivita', hiddenName:'ciclo', fieldLabel: 'Ciclo attività'}

	var classeImpianti = {xtype:'combo', store: storeClassi, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, displayField: 'classi', fieldLabel: 'Classe zona rumore', hiddenName:'classeimpianti'}


	var emissioneImpianto = {xtype:'textfield', name:'dbimpianto', fieldLabel:'Livello emissione - dB'}

	var climaSonoro = {xtype:'textfield', name:'clima', fieldLabel:'Clima sonoro preesistente'}

	var contribSonoro = {xtype:'textfield', name:'contributo', fieldLabel:'Contributo rumore'}


	// ######### TAB 2 ###########

	

	var classUnita = {xtype:'combo', store: storeClassi, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, 		displayField: 'classi', hiddenName:'classeAcusticaImp', fieldLabel: 'Classificazione acustica area impianto'}
// 	var classRecettori = {xtype:'combo', store: storeClassi, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, 		displayField: 'classi', hiddenName:'classeAcusticaRec', fieldLabel: 'Classificazione acustica area recettori'}
	
	var dsSorgentiGrid = new Ext.data.JsonStore({
		url:'',
		fields:['descrizione','dbemissione']

	})
	var cmSorg = new Ext.grid.ColumnModel([
		{ header:'sorgente', dataIndex:'descrizione', width:350, editor: new Ext.form.TextField({ allowBlank:false})},
		{ header:'dB emissione', dataIndex:'dbemissione', width:120, editor: new Ext.form.NumberField({ allowBlank:false, maxLength:20})}


	]);
	var insertSorg = Ext.data.Record.create([
		{name:'descrizione', type:'string'},
		{name:'dbemissione', type:'string'}
	])
	var gridSorgente = new Ext.grid.EditorGridPanel({
		cm: cmSorg,
		ds: dsSorgentiGrid,		
		width:600,
		height:200,
		title:'Sorgenti rumore',
		frame:true,
		clicksToEdit:1,
		tbar:[{
			text:'inserisci',
			handler: function(){
				var nuovo = new insertSorg({
					descrizione: '',
					dbemissione:''

				});
				gridSorgente.stopEditing();
				dsSorgentiGrid.insert(0,nuovo);
				gridSorgente.startEditing(0,0);
			}
		}]

	})




	// ########### TAB 3 ############

	// griglia  distanze da recettori rumore
	var dsDistanzeGrid = new Ext.data.JsonStore({
		//autoLoad: true,
		url:'',
		fields:['recettore','distanza', 'classeRecettori']
	})	

	var storeRifDistanze = new Ext.data.SimpleStore({fields:['rifdist'], data:[['abitazione singola'], ['gruppo abitazioni'], ['condominio/i'], ['scuola'], ['ospedale'], ['casa riposo'], ['edifici/spazi collettivi']] })
	var cm = new Ext.grid.ColumnModel([
		{ id:'tipo', dataIndex:'recettore', header:'recettore', width:200, editor:new Ext.form.ComboBox({ store: storeRifDistanze, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, displayField: 'rifdist', hiddenName:'rifdistrecettori' }) 
		},
		{ header:'distanza (metri)', dataIndex:'distanza', width:120, editor: new Ext.form.TextField({ allowBlank:false, maskRe:/[0-9]/, maxLength:20})},
		{ id:'classrecettori', dataIndex:'classeRecettori', header:'classe', width:150, editor:new Ext.form.ComboBox({ store: storeClassi, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, displayField: 'classi', hiddenName:'classirecettori' })}

	]);
	var insert = Ext.data.Record.create([
		{name:'recettore', type:'string'},
		{name:'distanza', type:'string'},
		{name:'classeRecettori', type:'string'}
	])

	var grid = new Ext.grid.EditorGridPanel({
		cm: cm,
		ds: dsDistanzeGrid,		
		width:600,
		height:200,
		title:'Recettori',
		frame:true,
		clicksToEdit:1,
		tbar:[{
			text:'inserisci',
			handler: function(){
				var nuovo = new insert({
					recettore: '',
					distanza:''
				});
				grid.stopEditing();
				dsDistanzeGrid.insert(0,nuovo);
				grid.startEditing(0,0);
			}
		}]

	})


	// ########### TAB 4 ############


	var abbattimento = {xtype:'htmleditor', height:120, width:400, enableFont: false, enableLinks: false, enableSourceEdit: false, name:'abbatti', fieldLabel:'Mitigazioni esistenti'}
	
	var mitiga = {xtype:'htmleditor', height:120, width:400, enableFont: false, enableLinks: false, enableSourceEdit: false, name:'mitiga', fieldLabel:'Mitigazioni previste'}

	// ########### TAB 5 ############
	
	var dataNo = {xtype:'datefield', name:'datano', fieldLabel:'Data Nulla Osta'}
	var protNo = {xtype:'numberfield', name:'protno', fieldLabel:'Protocollo Nulla Osta'}

	var limiteEmissDiurno = {xtype:'textfield', name:'limiteemissdiurno', fieldLabel:'Limite emissione diurno - dB'}
	var limiteEmissNotte = {xtype:'textfield', name:'limiteemissnotte', fieldLabel:'Limite emissione notturno - dB'}
	var limiteImmissDiurno = {xtype:'textfield', name:'limiteimmissdiurno', fieldLabel:'Limite immissione diurno - dB'}
	var limiteImmissNotte = {xtype:'textfield', name:'limiteimissnotte', fieldLabel:'Limite immissione notturno - dB'}
	



	var formDefaults = { border: false, style:'padding:10px', labelWidth: 250}
	var itemDefaults = { anchor:'99%'}

	var richSel	= {xtype:'trigger', 
				onTriggerClick : function(){
					var main = new Anagrafica.app.Main({
						onCaricaSelezione: function(record){
							var richiedente = {
								data:{
									richiedente:record.data.ragsoc,
									//fiscale:record.data.codfisc
								}
							}							
							_this.getForm().loadRecord(richiedente);
					console.dir(record)}
					});
					
					
				}, 
			readOnly : true,
			fieldLabel:'Richiedente' ,
			fit:true,
			triggerClass : 'x-trigger-search' ,
			itemCls  : 'x-trigger-comp-element' ,
			name:'richiedente',
			id:'trigger-richiedente' ,
			allowBlank:false

        }
	
	var profSel	= {xtype:'trigger', 
				onTriggerClick : function(){
					var main = new Anagrafica.app.Main({
						onCaricaSelezione: function(record){
							var professionista = {
								data:{
									professionista:record.data.ragsoc,
									//fiscale:record.data.codfisc
								}
							}							
							_this.getForm().loadRecord(professionista);
					console.dir(record)}
					});
					
					
				}, 
			readOnly : true,
			fieldLabel:'professionista' ,
			fit:true,
			triggerClass : 'x-trigger-search' ,
			itemCls  : 'x-trigger-comp-element' ,
			name:'professionista',
			id:'trigger-professionista' ,
			allowBlank:false

        }


	var dittaSel = {xtype:'trigger', 
				onTriggerClick : function(){
				//apertura window
				}, 
			readOnly : true,
			fieldLabel:'Attività - denominazione' ,
			fit:true,
			triggerClass : 'x-trigger-search' ,
			name:'ditta',
			id:'trigger-ditta' ,
			allowBlank:false
	}

	var unitLocSel	= {xtype:'trigger', 
				onTriggerClick : function(){
				//apertura window
				}, 
			readOnly : true,
			fieldLabel:'Unità locale' ,
			fit:true,
			triggerClass : 'x-trigger-search' ,
			name:'unitalocale',
			id:'trigger-unitalocale' ,
			allowBlank:false
        }

	var datigenerali = {
		labelWidth:170,
		title:'Dati generali',
		items:[dittaSel, fiscale, domfiscale, unitLocSel, indirUnitLoc, descimp, profSel, professione],
		defaults:{anchor:'98%'}
	}

	var impianti = {
		labelWidth:170,
		title:'Attività/Impianti',
		items:[longdescimp,  impiantiCiclo, impiantiFreq, classeImpianti, emissioneImpianto, climaSonoro, contribSonoro],
		defaults:{anchor:'98%'}

	}


	var sorgenti = {
	
		title:'Sorgenti',
		items:[gridSorgente],
		defaults:{anchor:'98%'}

	}

	var recettori = {
		title:'Recettori',
		items:[grid],
		defaults:{anchor:'98%'}

	}

	var mitigazioni = {
		labelWidth:120,
		title:'Mitigazioni',
		items:[abbattimento, mitiga],
		defaults:{anchor:'98%'}

	}

	var nullaosta = {
		labelWidth:200,
		title:'Nulla Osta',
		items:[dataNo, protNo, limiteEmissDiurno, limiteEmissNotte, limiteImmissDiurno, limiteImmissNotte],
		defaults:{anchor:'98%'}

	}



	var tabpanel = new Ext.TabPanel({
		autoHeight:true,
		items: [datigenerali, impianti, sorgenti, recettori, mitigazioni, nullaosta],
		activeTab: 0,
		defaults:{layout: 'form', frame: true, autoHeight:true}
	})

	var defaults = {
		
		items:[tabpanel],
		frame:true,
		monitorResize:true,
		defaults: formDefaults
		

	}

	


	Rumore.form.noRumoreForm1.superclass.constructor.call(this, Ext.apply({},  config , defaults))
 

}


Ext.extend(Rumore.form.noRumoreForm1, Ext.form.FormPanel);

//registro l'oggetto EditForm
Ext.reg('norumoreformedit_a', Rumore.form.noRumoreForm1)

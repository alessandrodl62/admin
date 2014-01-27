Ext.namespace('Attivita.form');

	
Attivita.form.EditForm = function(config){

{name: 'id_anagrich', type: 'int'},
{name: 'id_ente', type: 'int'},
{name: 'attivitalocale', type: 'int'},
{name: 'idprocedure', type: 'int'},
{name: 'id_legrapp', type: 'int'},
'formagiuridica',
{name: 'datainizio', type: 'date', dateFormat: 'dd.MM.yyyy'},  
'ragsociale',
'nrea',
'naddetti',
'istat_principale',
'desc_cicloprod',
'note'


// 	var storeTipoTel = new Ext.data.SimpleStore({
// 		fields: ['tipo_tel'],
// 		data: [['CASA'],['UFFICIO'],['MOBILE'],['FAX'],['PERSONALE']]
// 	});


	var idanagrich = {xtype:'hidden', name:'id_anagrich'}
	var idente = {xtype:'hidden', name:'id_ente', value: appContext.currentEnte}
	var idprocedure = {xtype:'hidden', name:'idprocedure', value: appContext.currentProcedure}
	var legrapp = {xtype:'trigger', 
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
	var formagiuridica = {
		id:' ',
		xtype:'combo', 
		editable: false, 
		valueField:'value', 
		displayField:'description',
		mode: 'local',
		triggerAction:'all',
		width:200,
		emptyText:'Select value ...',
		selectOnFocus:true,
		value: formRecord.data.ProfileLnkSalesPerson,
		store: new Ext.data.SimpleStore({
			autoLoad:true,
			fields: ['formagiuridica'],
			data:[[''],['']]
		})
		hiddenName:' ',
		fieldLabel: ' ' ,
		allowBlank:false
	}


	var ragsoc = {xtype:'textfield', name:'ragsoc', fieldLabel:'ragione sociale', allowBlank:false}



	var ragric = {xtype:'textfield', name:'ragric', fieldLabel:'ragione sociale', allowBlank:false}
	
	var localita = {xtype:'textfield', name:'localita', fieldLabel:'località', allowBlank:false}
	var prov = {xtype:'textfield', name:'prov', fieldLabel:'provincia', allowBlank:false}
	var indir = {xtype:'textfield', name:'via', fieldLabel:'via', allowBlank:false}
	var nciv = {xtype:'textfield', name:'nciv', fieldLabel:'numero civico', allowBlank:false}
	var cap = {xtype:'textfield', name:'cap', fieldLabel:'CAP', allowBlank:false, maskRe:/[0-9]/, maxLength:5, minLength:5, maxLengthText:'La lunghezza è di 5 caratteri', minLengthText:'La lunghezza è di 5 caratteri'}
	var nazione = {xtype:'textfield', name:'nazione', fieldLabel:'nazione', allowBlank:false}
	var email = {xtype:'textfield', name:'email', fieldLabel:'e-mail', vtype: 'email' }
	var codfisc = {xtype:'textfield', name:'codfisc', fieldLabel:'codice fiscale', allowBlank:false}
	var partiva = {xtype:'textfield', name:'partiva', fieldLabel:'partita IVA'}
	var datanasc = {xtype:'datefield', name:'datanasc', fieldLabel:'data di nascita', format: 'd.m.Y'}
	var sesso = {xtype:'combo', store: storeComboSex, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, displayField: 	'descrizioneSex', valueField:'sesso', hiddenName:'sesso', fieldLabel: 'sesso', editable:false, allowBlank: false}
	var tipo_tela = {xtype:'combo', store: storeTipoTel, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, 		displayField: 'tipo_tel', hiddenName:'tipo_tela', fieldLabel: 'Telefono Tipo'}
	var tipo_telb = {xtype:'combo', store: storeTipoTel, emptyText:'Seleziona ...',  mode:'local', typeAhead: true, triggerAction: 'all', selectOnFocus:true, 		displayField: 'tipo_tel', hiddenName:'tipo_telb', fieldLabel: 'Telefono Tipo'}

	//var tipo_telb = {xtype:'textfield', name:'tipo_telb', fieldLabel:'telefono B'}
	var telefonoa = {xtype:'textfield', name:'telefonoa', fieldLabel:'numero tel', maskRe:/[0-9]/, maxLength:20}
	var telefonob = {xtype:'textfield', name:'telefonob', fieldLabel:'numero tel', maskRe:/[0-9]/}
	var note = {xtype:'textarea', name:'note', fieldLabel:'note', anchor:'95%', labelStyle: 'margin-left: 20px', labelWidth:50}


	var formDefaults = { border: false, style:'padding:10px', labelWidth:100}
	var itemDefaults = { anchor:'99%'}

	var _this = this;



	this.saveAction = function(){
	
		_this.getForm().submit({
			url:'/terrgest/AttivitaServlet/anagrafica/salvaanag',
			success:function(){
				if(appContext.currentAnagRecord!=null)
					_this.updateCurrentRecord();
				else
					_this.fireEvent('recordadded', _this);
				Ext.MessageBox.alert('Avviso','Salvataggio avvenuto');
				
			},
			failure:function(){
				Ext.MessageBox.show({
					title:'Avviso',
					msg: 'dati non salvati!  Controlla campi',
					minWidth: 200,
					buttons: Ext.Msg.OK

				});
			}
		})	
	
	}





	var editFormLeftCol = {
		columnWidth:0.5,
		layout:'form',
		border:false,
		//xtype:'fieldset',
/*		title:'dati principali',*/
		autoHeight:true,
		style:'padding:10px; margin-right:5px',
		items:[ragsoc, datanasc, sesso, codfisc, partiva, email, tipo_tela, telefonoa],
		defaults: itemDefaults
		
	}

	var editFormRightCol = {
		columnWidth:0.5,
		layout:'form',
		border:false,
		//xtype:'fieldset',		
/*		title:'dati tecnici',*/		
		autoHeight:true,		
		style:'padding:10px',
		items:[nazione, prov, localita, cap, indir, nciv, tipo_telb, telefonob],
		defaults: itemDefaults
		
	}

	var editFormCenter = {

		//columnWidth: 1,
		//columnWidth:1,
		layout: 'column',
		xtype: 'fieldset',
		//border:true,
		//title: 'dati principali',
		autoHeight:true,
		items: [editFormLeftCol, editFormRightCol],
		defaults: itemDefaults
	}


	var editFormColumns ={
		layout:'column',
		items:[ editFormLeftCol,editFormRightCol]

	}




	var defaults = {

		items:[idAdresse, idAnagProf, idente, editFormCenter, note],
		defaults: formDefaults,
		monitorResize:true,
		//autoHeight: true,
		frame:true,
		updateCurrentRecord: function(){
			_this.getForm().updateRecord(appContext.currentAnagRecord);
			appContext.currentAnagRecord.commit();
			
		},
		setRecord: function(record){
			_this.getForm().loadRecord(record) //espongo la funzione nativa per caricare il form con il record	
		}
		
	}

	//chiama il costruttore della superclasse (Ext.form.FormPanel) creando un array di parametri che mette insieme config e defaults
	Attivita.form.EditForm.superclass.constructor.call(this, Ext.apply({},  config , defaults))
}

	
Ext.extend(Attivita.form.EditForm, Ext.form.FormPanel);

//registro l'oggetto EditForm
Ext.reg('attivitaformedit', Attivita.form.EditForm)

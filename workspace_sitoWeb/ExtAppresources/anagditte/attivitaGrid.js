Ext.namespace('Attivita.grid');

Attivita.grid.attivitaGrid = function(config){

	var _this=this;

	var dsAttivitaGrid = new Ext.data.JsonStore({
		//autoLoad: true,
		url:'/terrgest/AttivitaServlet/anagrafica/attivitaSel',
		fields:[
			{name: 'id_anagrich', type: 'int'},
			{name: 'id_ente', type: 'int'},
			{name: 'attivitalocale', type: 'int'},
			{name: 'idprocedure', type: 'int'},
			{name: 'id_legrapp', type: 'int'},
			'formagiuridica',
			{name: 'datainizio', type: 'date', dateFormat: 'dd.MM.yyyy'},  //il dateFormat deve corrispondere con il formato di Json           sulla servlet/server - generato da: DateJsonValueProcessor
			'ragsociale',
			'nrea',
			'naddetti',
			'istat_principale',
			'desc_cicloprod',
			'note'
		]	//nome dei campi del record nel bean (campi json) 
	})	


	var colAttivitaGrid = [
		{header:'ragione sociale', dataIndex:'ragsociale', width:150, sortable: true},
		{header:'forma giuridica', dataIndex:'formagiuridica', width:100, sortable: true},
		{header:'n° iscrizione registro:', dataIndex:'nrea', width:50},
		{header:'data iscrizione', dataIndex:'datainizio', width:50},
		{header:'attivita istat', dataIndex:'istat_principale', width:70},
		{header:'produzione', dataIndex:'desc_cicloprod', width:200},
	]



	this.dataVoid={
		id_anagrich:'',
		id_ente: appContext.currentEnte,
		attivitalocale:'',
		idprocedure:'',
		id_legrapp:'',
		formagiuridica:'',
		datainizio:'',
		ragsociale:'',
		nrea:'',
		naddetti:'',
		istat_principale:'',
		desc_cicloprod:'',
		note:''
	}

	

	var defaults = {
		
		title:'Anagrafica',
		ds:dsAttivitaGrid,
		columns:colAttivitaGrid,
		frame:true,
		height:120,
		loadMask: true    //carica la maschera di attesa al caricamento della griglia

// 		listeners: {
// 			rowdblclick : function(grid, rowIndex,  e ){
// 				var ds=grid.getStore();
// 				var record = ds.getAt(rowIndex);
// 				editWin.show();
// 				editForm.setRecord(record);
// 			}
// 			
// 		}
		
	}





	Attivita.grid.AttivitaGrid.superclass.constructor.call(this, Ext.apply({},  config , defaults))


}


Ext.extend(Attivita.grid.AttivitaGrid, Ext.grid.GridPanel);

//registro l'oggetto EditForm
Ext.reg('attivitagrid', Attivita.grid.AttivitaGrid)
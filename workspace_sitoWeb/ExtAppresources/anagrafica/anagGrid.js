Ext.namespace('Anagrafica.grid');

Anagrafica.grid.AnagGrid = function(config){

	var _this=this;

	var dsAnagGrid = new Ext.data.JsonStore({
		//autoLoad: true,
		url:'/commongest/CommonServlet/anagrafica/anagraficaSel',
		fields:['idAdresse',
			'cod_famiglia',
			'id_anagrafe',
			'id_ente',
			'ragsoc',
			'localita', 
			'indir', 
			'nciv', 
			'cap', 
			'prov',
			'ragric',
			'nazione',
			'email',
			'codfisc',
			{name: 'id_anagrafe', type: 'int'},
			'partiva',
			{name: 'datanasc', type: 'date', dateFormat: 'dd.MM.yyyy'},  //il dateFormat deve corrispondere con il formato di Json sulla servlet/server - generato da: DateJsonValueProcessor
			'sesso',
			'tipo_tela',
			'tipo_telb',
			'telefonoa',
			'telefonob',
			'note']	//nome dei campi del record nel bean (campi json) 
	})	


	var colAnagGrid = [
		{header:'ragione sociale', dataIndex:'ragsoc', width:150, sortable: true},
		{header:'località', dataIndex:'localita', width:100, sortable: true},
		{header:'via', dataIndex:'indir', width:100},
		{header:'n° civico', dataIndex:'nciv', width:20},
		{header:'provincia', dataIndex:'prov', width:70},
		{header:'codice fiscale', dataIndex:'codfisc', width:100},
	]



	this.dataVoid={
		idAdresse:'',
		cod_famiglia:'',
		id_anagrafe:'',
		id_ente: appContext.currentEnte,
		ragsoc:'',
		località:'',
		indir:'',
		nciv:'',
		cap:'',
		prov:'',
		ragric:'',
		nazione:'',
		email:'',
		codfisc:'',
		partiva:'',
		datanasc:'',
		sesso:'',
		tipo_tela:'',
		tipo_telb:'',
		telefonoa:'',
		tipo_telb:'',
		note:''
	
	}

	

	var defaults = {
		
		title:'Anagrafica',
		ds:dsAnagGrid,
		columns:colAnagGrid,
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





	Anagrafica.grid.AnagGrid.superclass.constructor.call(this, Ext.apply({},  config , defaults))


}


Ext.extend(Anagrafica.grid.AnagGrid, Ext.grid.GridPanel);

//registro l'oggetto EditForm
Ext.reg('anagraficagrid', Anagrafica.grid.AnagGrid)
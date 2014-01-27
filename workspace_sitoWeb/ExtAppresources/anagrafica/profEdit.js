


Ext.namespace('Anagrafica.grid');

Anagrafica.grid.ProfEdit = function(config){

var _this = this

this.recordAnagrafica = null;

this.saveGridData = function(){
	
		var arecords = [];
		
		Ext.each(dsProfGrid.getModifiedRecords(), function(record){arecords.push(record.data)}); //carica l'array 'arecords'
		
		var dataparams = {json: Ext.util.JSON.encode(arecords)}
		
		Ext.Ajax.request({
			url:'/commongest/CommonServlet/professioni/salvaProf',
			method:'POST',
			params:dataparams,
			success: function(resp,opt){
				var respObj = Ext.decode(resp.responseText)
				if(respObj.success){
				 	updatedata = true;
				 	dsProfGrid.commitChanges();
				 	Ext.MessageBox.alert('Salvataggio avvenuto');
				} else Ext.MessageBox.alert('dati non salvati!');
			},
			failure: function(resp, opt){
				Ext.MessageBox.alert('dati non salvati!');
			}

		});		
	}


this.deleteGridData = function(){

		var dataparams = {json: Ext.util.JSON.encode(deletedTmp)}
		Ext.Ajax.request({
			url:'/commongest/CommonServlet/professioni/cancelProf',
			method:'POST',
			params: dataparams,
			success: function(resp,opt){
				var respObj = Ext.decode(resp.responseText)
				if(respObj.success){
				 	updatedata = true;
				 	dsProfGrid.commitChanges();
					Ext.MessageBox.alert('Salvataggio avvenuto');

// 				 	alert('aggiornamento professioni avvenuto');
				} else {
					Ext.MessageBox.alert('dati non salvati!');

// 					alert('aggiornamento non avvenuto. Errori')	
				}
			},
			failure: function(resp, opt){
				Ext.MessageBox.alert('dati non salvati!');
			}

		});

}

var deletedTmp = []    //array temporaneo dove archivio i record in attesa di essere cancellati o meno

this.isDirty = function(){
			if(deletedTmp.length>0) return true;
			if(this.getStore().getModifiedRecords().length >0) return true;
			return false;
			
		}


this.deleting = function(){
	if(deletedTmp.length>0) return true;
	else return false;
}

this.appending = function(){
	if(this.getStore().getModifiedRecords().length >0) return true;
	else	return false;
}


this.clear = function(){
			deletedTmp=[];

}

var storeComboProf =  new Ext.data.SimpleStore({
	fields: ['titolo'],
	data: [['Medico'],['Ingegnere'],['Architetto'],['Geologo'],['Geometra'],['Perito']]

});

var elencoProf = new Ext.form.ComboBox({
	store: storeComboProf,
	emptyText:'Seleziona una professione...',
	mode:'local',
	typeAhead: true,
	triggerAction: 'all',
	selectOnFocus:true,
	displayField: 'titolo'

})


var insert = Ext.data.Record.create([
	{name:'idAdresse', type:'string'},
	{name:'idAnagProf', type:'string'},

	{name:'numOrdine', type:'string'},
	{name:'titolo', type:'string'}

]);


var dsProfGrid = new Ext.data.JsonStore({
		//autoLoad: true,
		url:'/commongest/CommonServlet/professioni/list',
		fields:['idAnagProf',
			'idAdresse',
			'numOrdine',
			'titolo']	//nome dei campi del record nel bean (campi json) 
	})	



var colProfGrid = [

		
		{header:'N° Iscrizione Ordine', dataIndex:'numOrdine', width:120, editor: new Ext.form.TextField({allowBlank: false})},
//		{header:'Titolo', dataIndex:'titolo', width:120, editor: new Ext.form.TextField({allowBlank: false})}
		{header:'Titolo', dataIndex:'titolo', width:120, editor: elencoProf}

	]



var defaults = {
		
		title:'Professione',
		ds:dsProfGrid,
		columns:colProfGrid,
		frame:true,
		height:120,
		sm: new Ext.grid.RowSelectionModel({singleSelect: true}),   //se voglio ottenere la riga selezionata devo sostituire il  CellSelectionModel con il RowSelectionModel
		tbar:[{
			text:'Nuova iscrizione',
			handler: function(){
				var nuovo = new insert({
					numOrdine: '',
					titolo:null,
					idAdresse: appContext.currentAnagRecord.data.idAdresse,
					idAnagProf:''
				});
				_this.stopEditing();
				dsProfGrid.insert(0,nuovo);
				_this.startEditing(0,0);
			}
		},
		{
			text:'Cancella iscrizione',
			handler: function(){

				var selModel = _this.getSelectionModel();
				var selection = selModel.getSelected();

				deletedTmp.push(selection.data);
				dsProfGrid.remove(selection);
				console.dir(deletedTmp);
// 				_this.deleteGridData();				
			}
		}],
		buttonAlign: 'center',
//		clicksToEdit: 1     //basta un click del mouse per editare la griglia ed anche aprire la combo

//------ esempio di listeners se la funzione di visualizzazione sta qui dentro -------
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


	Anagrafica.grid.ProfEdit.superclass.constructor.call(this, Ext.apply({},  config , defaults))

}

Ext.extend(Anagrafica.grid.ProfEdit, Ext.grid.EditorGridPanel);

//registro l'oggetto EditForm
Ext.reg('profgrid', Anagrafica.grid.ProfEdit)
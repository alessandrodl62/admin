var appContext = {
	currentAnagRecord: null,
	currentEnte: 2

};

Ext.onReady(function(){

		
    Ext.QuickTips.init();

	var west = {
		title:'ricerca',
		//frame:true,
		region:'west',
/*		xtype:'panel',*/
		xtype:'anagraficacercaform',
		split: true,
		collapsible: true,
		margins:'3 0 3 3',
		cmargins:'3 3 3 3',
		width:'40%',
		listeners: {
			ricerca: function(params){
				Ext.getCmp('btn-seleziona').disable();
				var grid = Ext.getCmp('grid-anagraficapersone');
				grid.getStore().load({params: params, url:'/commongest/CommonServlet/anagrafica/anagraficaSel'})

			}

		}
	}


	var center = {
		region: 'center',
		title: 'elenco',
		id:'grid-anagraficapersone', 
		frame: true,
		margins:'3 0 3 0',
		xtype: 'anagraficagrid', //utilizzo il nome registrato in editForm
		tbar:[{
			text:'Nuova iscrizione',
			handler: function(){
				var dataForm = Ext.getCmp('grid-anagraficapersone').dataVoid;
				var finestra = new Anagrafica.form.WinEdit({
					listeners:{recordadded: function(){
						Ext.getCmp('grid-anagraficapersone').getStore().reload();	//registrazione all'evento 'recordadded' della window che effettua il broadcast dell'omonimo evento sulla form
					}}
				});
				finestra.setValues(dataForm);
				finestra.show();
				}
		},
		{
			text:'seleziona',
			id:'btn-seleziona',
			disabled: true,
			handler: function(){
				var griglia = Ext.getCmp('grid-anagraficapersone');
				var record = griglia.getSelectionModel().getSelected();
				griglia.fireEvent('caricaselezione', record);   //registrarsi su questo evento 'addListeners' sul modulo chiamante
			}

		}],
		listeners: {
/*			rowdblclick: function(grid, rowIndex,  e ){
				var ds=grid.getStore();
				var record = ds.getAt(rowIndex);
				var finestra = new Anagrafica.form.WinEdit();
				finestra.show();
				finestra.setRecord(record);
				finestra.loadProfessioni(record.data.idAdresse)
			}*/
			cellclick: function(grid, rowIndex, columnIndex, e) {
				Ext.getCmp('btn-seleziona').enable();
				if(columnIndex != 0)
					return;
				Ext.get(document.body).mask('caricamento in corso...');
				

				//esegue il blocco di istruzioni
				(function(){
					var ds=grid.getStore();
					var record = ds.getAt(rowIndex);
					var finestra = new Anagrafica.form.WinEdit();
					finestra.addListener('show', function(){Ext.get(document.body).unmask()})
					finestra.show();
					appContext.currentAnagRecord = record;
					finestra.setRecord(record);
					finestra.loadProfessioni(record.data.idAdresse)
					
				}).defer(100)



			},
 			rowdblclick: function(grid, rowIndex, e){
				var ds=grid.getStore();
				var record = ds.getAt(rowIndex);
				grid.fireEvent('caricaselezione', record);   //registrarsi su questo evento 'addListeners' sul modulo chiamante es.ricerca; in questo caso viene passato il record come parametro

			}
			
		}
	};
	var vp = new Ext.Panel({
		layout:'border',
		items:[west, center]
	})
	
	var win = new Ext.Window({
		layout:'fit',
		title: 'Anagrafica Persone',
		closable:true,
		width:800,
		height:350,
		//border:false,
		plain:false,
		items: [vp]

	});

	win.show();

	
	//Ext.getCmp('grid-anagraficapersone').getStore().load({params:{'idente': appContext.currentEnte}})
	//appContext.currentEnte = Ext.getCmp('grid-anagraficapersone').getStore().get('idente')


	



// 	var win = new Ext.Window({
// 		width:700,
// 		height:500,
// 		frame:true,
// 		title:'anagrafica',
// 		items:{
// 			xtype:'anagraficaformedit'
// 		},
// 		buttons:[{
// 			text:'salva',
// 			handler:function(){
// 				Ext.getCmp('frm-anagraficapersone').saveAction();  //corrsipondenza tra pannello e xtype
// 			}	
// 		}]
// 	})

// 	win.show()
	//Ext.getCmp('center-grid').getStore().load({params:{'idente': 1}})
	//professionisti.editWin.show()	

	
});
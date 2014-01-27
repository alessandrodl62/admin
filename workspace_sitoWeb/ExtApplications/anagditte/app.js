var appContext = {
	currentAnagRecord: null,
	currentEnte: 2

};

Ext.onReady(function(){

		
    Ext.QuickTips.init();

// 	var west = {
// 		title:'ricerca',
// 		//frame:true,
// 		region:'west',
// /*		xtype:'panel',*/
// 		xtype:'anagraficacercaform',
// 		split: true,
// 		collapsible: true,
// 		margins:'3 0 3 3',
// 		cmargins:'3 3 3 3',
// 		width:'40%',
// 		listeners: {
// 			ricerca: function(params){
// 				Ext.getCmp('btn-seleziona').disable();
// 				var grid = Ext.getCmp('grid-anagraficapersone');
// 				grid.getStore().load({params: params, url:'/terrgest/AttivitaServlet/anagrafica/anagraficaSel'})
// 
// 			}
// 
// 		}
// 	}



	var center = {
		region: 'center',
		title: 'Anagrafica Ditte - Forme Giuridiche',
		id:'tree-formegiur', 
		frame: true,
		margins:'3 0 3 0',
		xtype: 'formegiurtree', //utilizzo il nome registrato in editForm

	};
	var vp = new Ext.Panel({
		layout:'border',
		items:[center]
	})
	
	var win = new Ext.Window({
		layout:'fit',
		title: 'Anagrafica Ditte',
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
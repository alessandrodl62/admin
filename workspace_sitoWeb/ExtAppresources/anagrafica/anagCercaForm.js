Ext.namespace('Anagrafica.form');

	
Anagrafica.form.AnagCercaForm = function(config){

		
	var idente = {xtype:'hidden', name:'id_ente', value: appContext.currentEnte}
	var ragsoc = {xtype:'textfield', name:'ragsoc', fieldLabel:'ragione sociale'}
	var localita = {xtype:'textfield', name:'localita', fieldLabel:'località'}
	var codfisc = {xtype:'textfield', name:'codfisc', fieldLabel:'codice fiscale'}
	var partiva = {xtype:'textfield', name:'partiva', fieldLabel:'partita IVA'}
	var cerca = {
			xtype:'button',
			text:'Ricerca',
			handler: function(){
				_this.cerca();
			}
	}

	var _this = this;

	this.cerca = function(){
		_this.fireEvent('ricerca', _this.getForm().getValues())
	} 

// 	var cercaForm = {
// 
// 		columnWidth:1,
// 		layout: 'form',
// 		xtype: 'fieldset',
// 		frame:true,
// 		//title: 'dati principali',
// 		items: [ragsoc, localita],
// 		defaults: itemDefaults
// 	}


	var defaults = {
		border: true, 
//		bodyStyle:'padding:10px', 
		labelWidth:100,
		items:[idente, ragsoc, localita, codfisc, partiva, cerca],
		defaults: {},
		monitorResize:true,
		frame:true
	}	

	Anagrafica.form.AnagCercaForm.superclass.constructor.call(this, Ext.apply({},  config , defaults))


	//attiva la funzione di invio da tastiera dopo l'evento 'render' dell'elemento DOM this.getEl
	this.addListener('render', function(){
		var map = new Ext.KeyMap(this.getEl(), {
			key: Ext.EventObject.ENTER,
			fn: this.cerca,
			scope: this
		});
	});	

}


Ext.extend(Anagrafica.form.AnagCercaForm, Ext.form.FormPanel);

//registro l'oggetto EditForm
Ext.reg('anagraficacercaform', Anagrafica.form.AnagCercaForm)
Ext.namespace('Anagrafica.form');

Anagrafica.form.WinEdit = function(config){

	var _this = this;	

	var editform = new Anagrafica.form.EditForm({
		title: 'dati anagrafici',
		autoHeight:true,
		buttons: [{
			text:'Registra modifiche',
			handler:function(){
				editform.saveAction();  //corrispondenza tra pannello e xtype
				//profeditgrid.saveGridData();
				//Ext.MessageBox.alert('Conferma salvataggio', 'Dati salvati');
			}
	
		}]
	})
	
	editform.on('recordadded', function(){
		_this.fireEvent('recordadded')	//broadcast dell'evento avvenuto sulla form
	
	})

	var profeditgrid = new Anagrafica.grid.ProfEdit({
		height: 420,
		title: 'dati professioni',	
		buttons: [{
			text:'Registra modifiche',
			handler:function(){
/*				alert(profeditgrid.deleting());
				alert(profeditgrid.appending());*/
				
				if(profeditgrid.appending())  profeditgrid.saveGridData();  //corrispondenza tra pannello e xtype 

				if(profeditgrid.deleting())  profeditgrid.deleteGridData();
				
				profeditgrid.clear();
				//Ext.MessageBox.alert('Conferma salvataggio', 'Dati salvati');
			}
	
		}]


	})

	var tabpanel = new Ext.TabPanel({
		
		items: [editform, profeditgrid ],
		activeTab: 0
	})




	var defaults = {
		modal: true,
		width:700,
		height:520,
		frame:true,
		title:'anagrafica',
		items: tabpanel, 
		buttons:[
			{
			text:'chiudi',
			handler: function(){ 
				_this.hide()
			}
		}],
		closeAction: 'hide'
	}

	this.setRecord = editform.setRecord;	//espongo il metodo setRecord della form nella windows
	
	this.setValues = editform.getForm().setValues;
	this.findField= editform.getForm().findField;




	this.loadProfessioni = function(idAdresse){
		profeditgrid.getStore().load({params: {idAdresse: idAdresse}})
	}

	Anagrafica.form.WinEdit.superclass.constructor.call(this, Ext.apply({},  config , defaults));
}


Ext.extend(Anagrafica.form.WinEdit, Ext.Window);

//registro l'oggetto EditForm
Ext.reg('anagwineditform', Anagrafica.form.WinEdit)
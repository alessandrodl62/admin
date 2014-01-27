Ext.namespace('Attivita.formegiur');

Attivita.formegiur.WinFormeGiuridiche = function(config){
	
	var _this=this; 

	var formeGiuridiche = new Attivita.formegiur.FormeGiuridiche({});


	var defaults = {
		modal: true,
		width:700,
		height:520,
		frame:true,
		title:'anagrafica',
		tbar:[{
			text:'seleziona',
			handler:function(){
// 				var griglia = Ext.getCmp('grid-anagraficapersone');
// 				var record = griglia.getSelectionModel().getSelected();
// 				if(config.onCaricaSelezione)  config.onCaricaSelezione(record)

			}
		}]
		items: formeGiuridiche,
		buttons:[{
			text:'chiudi',
			handler: function(){ 
				_this.hide()
			}
		}]

	}


	var pannello = new Ext.panel({
		
		

	})




	Attivita.formegiur.WinFormeGiuridiche.superclass.constructor.call(this, Ext.apply({},  config , defaults));
}


Ext.extend(Attivita.formegiur.WinFormeGiuridiche, Ext.Window);

//registro l'oggetto EditForm
Ext.reg('attivitawinformegiuridiche', Attivita.formegiur.WinFormeGiuridiche)	


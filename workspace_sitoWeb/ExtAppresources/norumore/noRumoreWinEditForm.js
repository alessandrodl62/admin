Ext.namespace('Rumore.form');

Rumore.form.noRumoreWinEdit = function(config){


	var _this = this;

	var form = new Rumore.form.noRumoreForm1({
		//title: 'dati generali',
		autoHeight:true
	})


	


	var defaults = {
		layout:'fit',
		modal: true,
		width:700,
		height:400,
		frame:true,
		title:'Nulla Osta Acustico',
		items: [form], 
		buttons:[
			{
			text:'chiudi',
// 			handler: function(){ 
// 				if(profeditgrid.isDirty()) Ext.MessageBox.confirm('Conferma', 'Modifiche in sospeso! Vuoi salvarle?', function(btn){
// 					
// 					if(btn=='yes') {profeditgrid.saveGridData(); profeditgrid.deleteGridData(); _this.hide;}
// 					if(btn=='no') _this.hide;
// 				}); 
/*				
				_this.hide()
				
			}*/
			},{
			text:'salva',
			handler: function(){
				_this.submit();
			}
		}],
		closeAction: 'hide'



	}




	Rumore.form.noRumoreWinEdit.superclass.constructor.call(this, Ext.apply({},  config , defaults));

}

Ext.extend(Rumore.form.noRumoreWinEdit, Ext.Window);

//registro l'oggetto EditForm
Ext.reg('norumorewinedit', Rumore.form.noRumoreWinEdit)
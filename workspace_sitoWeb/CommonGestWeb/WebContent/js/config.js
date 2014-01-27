var debug=false;

function setAjaxLinks(){
	$("a.ajax").each(function(){
		var href = this.href;
		$(this).click( function() {setLoadAction(href);}).href("#");
	});
		
	$("a#btn_save").click(function(){
		$('form').submit();	
	});
	
	$("a#btn_delete").each(function(){
		var href = this.href;
		
		$(this).click( function() {
			
			if(confirm('Confermi La Cancellazione?')){
				$.ajax('GET', href,{}, function(r) {
                        eval(r.responseText);
                });
			};
			
		});
		this.href="#";
	});
	
		
}
 
 function setTableAjaxLinks(){
	$("table td a.ajax").each(function(){
		var href = this.href;
		$(this).click( function() {setLoadAction(href);}).href("#");
	});
	
	$("table.sortable").tableSorter({
		sortClassAsc: 'sortUp', // class name for asc sorting action
		sortClassDesc: 'sortDown', // class name for desc sorting action
		highlightClass: 'highlight', // class name for sort column highlighting.
		headerClass: 'largeHeaders', // class name for headers (th's)
		dateFormat: 'dd/mm/yyyy' // set date format for non iso dates default us, in this case override and set uk-format
	});	
}

function setAjaxForm(){
	
	if(!debug) 	$('form.ajax').ajaxForm();	
	else 		$('form.ajax').ajaxForm("#debug");
	
	if(!debug) 	$('form#frm_search').ajaxForm("#src_result",setTableAjaxLinks);	
	else 		$('form#frm_search').ajaxForm("#debug",setTableAjaxLinks);
}
function toggleDebug(){ 
	if(debug) debug=false; else debug=true; 
	$("#debug").html("debug " + debug);
	setForm();
}

function setLoadActionFunction(){
	setAjaxLinks();
	setAjaxForm();
	$(".fxunfold").hide();
	$("body").fadeIn("slow"); 
	$('.fxunfold').UnFold(400, 80);
}

function setLoadAction(purl,pparameters,pfunc,ptarget){
	var emptyFunc = function(){};
	var parameters = pparameters || '{}';
	var func=pfunc || emptyFunc;
	var target = ptarget|| '#content';
	var url = purl|| '#';
		 
	$("body").hide();		
	$(target).load(url,parameters,setLoadActionFunction);
	
	$("#debug").html("");
	
	/*
	$('#btnreload').click(function(){
		
		$(target).load(url,parameters,func);
		
		if(debug){
			$("#debug").html(
				"<br>target " + target +
				"<br>parameters " + parameters +
				"<br>func " + func 
			);
			
			alert($(target).html());
		}
	})
	*/
	if(debug){
		$("#debug").html(
			"<br>target " + target +
			"<br>parameters " + parameters +
			"<br>func " + func 
		);
		
		alert($(target).html());
	}
}

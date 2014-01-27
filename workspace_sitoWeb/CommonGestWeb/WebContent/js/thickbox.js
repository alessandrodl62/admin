/*
 * Thickbox 1.1 - One box to rule them all.
 * By Cody Lindley (http://www.codylindley.com)
 * Under an Attribution, Share Alike License
 * Thickbox is built on top of the very light weight jquery library.
 */

//on page load call TB_init
//$(document).ready(TB_init);

//add thickbox to href elements that have a class of .thickbox
function TB_init(){
	
	$("a.thickbox").click(function(){
	
		parent.TB_show(this.id,this.href);
		this.blur();
		return false;
	});
}

var TB_LoadedWindows =1 ;

function TB_onclick(id,obj,x,y,height,width){	
	TB_show(id,obj.href,x,y,height,width);
	obj.blur();
	return false;
}

function TB_onclick_cap(caption,id,obj,x,y,height,width){	
	var px = x || -1;
    var py = y || -1;
    var pheight = height || -1;
    var pwidth = width || -1;
	
	var sz = getPageSize();
		
		
	if ((pheight == -1) && (pwidth == -1)) {

		pwidth = sz[0]-40 ;
		pheight = sz[1]-40 ;
	
	}	
	
	TB_show(id,obj.href,x,y,pheight,pwidth);
	obj.blur();
	$("#TB_window"+id).prepend("<div class='TB_caption' ><div class='TB_caption_text'>"+caption+"</div><a href='#' class='TB_closeWindowButton' id='TB_closeWindowButton" + id + "'>Chiudi</a></div>"); 
	$("#TB_closeWindowButton" + id)
	.click(function(){TB_remove(id)});
	
	
	return false;
}

function TB_show(id,url,x,y,height, width) {//function called when the user clicks on a thickbox link

    var px = x || -1;
    var py = y || -1;
    var pheight = height || -1;
    var pwidth = width || -1;

	try {

		$("body").append("<div class='TB_overlay' id='TB_overlay" + id + "'></div><div class='TB_window' id='TB_window" + id + "'></div>");
		
		$("#TB_window"+id).css("zIndex",111+3*TB_LoadedWindows);
		$("#TB_overlay"+id).css("zIndex",110+3*TB_LoadedWindows);
	
		if ((px != -1) && (py != -1)) {
    		$(window).resize(TB_position);
	    	$(window).scroll(TB_position);
	    } else {
	    
	     // da completare
	    
	    }	
 		
		$("#TB_overlay"+id).show();
					
		var queryString = url.replace(/^[^\?]+\??/,'');
		var params = parseQuery( queryString ); 
		var sz = getPageSize();
		
		
		if ((pheight != -1) && (pwidth != -1)) {
			TB_WIDTH = pwidth;
			TB_HEIGHT = pheight;
		} else {
			TB_WIDTH = sz[0]-48-80*(TB_LoadedWindows-1);
			TB_HEIGHT = sz[1]-45-80*(TB_LoadedWindows-1);
		
		}	
			 
		ajaxContentW = TB_WIDTH - 30;
		ajaxContentH = TB_HEIGHT - 30;
		$("#TB_window"+id).append("<iframe src='" + url + "' class='TB_ajaxContent' name='TB_ajaxContent" + id + "' id='TB_ajaxContent" + id + "' frameborder='0' style='width:"+ajaxContentW+"px;height:"+ajaxContentH+"px;'></iframe>");
		
 		if ((px == -1) || (py == -1)) 
  			TB_position(id);
  		else	
  			TB_position_XY(px,py,id);
  			
		$("#TB_window"+id).slideDown("normal");
		
		TB_LoadedWindows++;
	} catch(e) {
		alert( e );
	}
	
}

//helper functions below

function TB_remove(id) {

	$("#TB_window"+id).each(function(){$('#TB_window'+id+',#TB_overlay'+id).remove();});
	TB_LoadedWindows--;
	return false;
}

function TB_position_XY(x,y,id) {

	var pagesize = getPageSize();
  
  	if (window.innerHeight && window.scrollMaxY) {	
  	
		yScroll = window.innerHeight + window.scrollMaxY;
		
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
	
		yScroll = document.body.scrollHeight;
		
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
	
		yScroll = document.body.offsetHeight;
		
  	}
	
	var arrayPageScroll = getPageScrollTop();
	
	$("#TB_window"+id).css({width:TB_WIDTH+"px",height:TB_HEIGHT+"px", left: x+"px", top: y+"px" });
	
	$("#TB_overlay"+id).css("height",yScroll +"px");
	
	
}

function TB_position(id) {

	var pagesize = getPageSize();
  
  	if (window.innerHeight && window.scrollMaxY) {	
		yScroll = window.innerHeight + window.scrollMaxY;
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
		yScroll = document.body.scrollHeight;
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
		yScroll = document.body.offsetHeight;
  	}
	
	var arrayPageScroll = getPageScrollTop();
	
	$("#TB_window"+id).css({width:TB_WIDTH+"px",height:TB_HEIGHT+"px",
	  left: ((pagesize[0] - TB_WIDTH)/2)+"px", top: (arrayPageScroll[1] + ((pagesize[1]-TB_HEIGHT)/2))+"px" });
	
	$("#TB_overlay"+id).css("height",yScroll +"px");

}

function parseQuery ( query ) {
   var Params = new Object ();
   if ( ! query ) return Params; // return empty object
   var Pairs = query.split(/[;&]/);
   for ( var i = 0; i < Pairs.length; i++ ) {
      var KeyVal = Pairs[i].split('=');
      if ( ! KeyVal || KeyVal.length != 2 ) continue;
      var key = unescape( KeyVal[0] );
      var val = unescape( KeyVal[1] );
      val = val.replace(/\+/g, ' ');
      Params[key] = val;
   }
   return Params;
}


function getPageScrollTop(){
	var yScrolltop;
	if (self.pageYOffset) {
		yScrolltop = self.pageYOffset;
	} else if (document.documentElement && document.documentElement.scrollTop){	 // Explorer 6 Strict
		yScrolltop = document.documentElement.scrollTop;
	} else if (document.body) {// all other Explorers
		yScrolltop = document.body.scrollTop;
	}
	arrayPageScroll = new Array('',yScrolltop) 
	return arrayPageScroll;
}

function getPageSize(){
	var de = document.documentElement;
	var w = window.innerWidth || self.innerWidth || (de&&de.clientWidth) || document.body.clientWidth;
	var h = window.innerHeight || self.innerHeight || (de&&de.clientHeight) || document.body.clientHeight;
	
	arrayPageSize = new Array(w,h) 
	return arrayPageSize;
}

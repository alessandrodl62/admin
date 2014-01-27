// ===================================================================
// Author: Mestriner Paolo
//
//
// NOTICE: You may use this code for any purpose, commercial or
// private, without any further permission from the author. You may
// remove this notice from your final code if you wish, however it is
// appreciated by the author if at least my web site address is kept.
//
// You may *NOT* re-distribute this code in any way except through its
// use. That means, you can include it in your product, or your web
// site, or any other form where the code is actually being used. You
// may not put the plain javascript up on your site for download or
// include it in your javascript libraries for download. 
// If you wish to share this code with others, please just point them
// to the URL instead.
// Please DO NOT link directly to my .js files from your site. Copy
// the files to your server and use them there. Thank you.
// ===================================================================

// HISTORY
// ------------------------------------------------------------------

// ------------------------------------------------------------------
// isNumber ( number_string)
// Returns true if number string  
// is a valid number. Else returns false.
// Testa una stringa contenente anche i punti delle migliaia 
// e la virgola dei decimali. E' permesso digitare pi? punti delle migliaia
// anche consecutivamente, poich? poi il numero viene definito 
// togliendo tutti i punti e sostituiendo la virgola con il punto
// in formato "americano"
// ------------------------------------------------------------------
function isNumber(val) {

var numvirgole = 0;
var posvirgola = -1;

	for (var i = 0; i < val.length; i++) {
	  var c = val.charAt(i);
	  var Num1 =  parseInt(c,10);

	  if ((isNaN(Num1)) && (c != ".") && (c != ",")) {
	   return false;
	  }
	  
	  if (c == ",")  {
	    numvirgole++;
		posvirgola = i;
	  }	
	}
	
	if (numvirgole > 1) 
	   return false;
	   
   return true;	
	
}


// ------------------------------------------------------------------
// getNumberFromString(number_string)
// Returns  number   if number_string
// is a valid number. Else returns NaN.
// Testa una stringa contenente anche i punti delle migliaia 
// e la virgola dei decimali. E' permesso digitare pi? punti delle migliaia
// anche consecutivamente, poich? poi il numero viene definito 
// togliendo tutti i punti e sostituiendo la virgola con il punto
// in formato "americano"
// ------------------------------------------------------------------
function getNumberFromString(val)  {

var numbervalue = 0;
var posvirgola = -1;
var interi = "";
var decimali = "";

    if (isNumber(Trim(val))) {
	
       posvirgola = val.indexOf(",");
	   
	   if (posvirgola > -1) {
		interi = val.substr(0,posvirgola);
	    decimali = "."+val.substr(posvirgola+1,(val.length-posvirgola));
		
	   }
	else	
        interi = val;
	   
       var interi = OnlyNumber(interi);
	   
	   return parseFloat(interi+decimali);
	} 
	
	return NaN;
}


// ------------------------------------------------------------------
// formatNumber(number)
// Returns  number_string from number (ferma ed arrotonda alla seconda
// cifra decimale)
// Mette i punti delle migliaia.. e sostituisce il punto dei decimali
// con la virgola in formato "italiano".
// ------------------------------------------------------------------
function formatNumber(val) {

var posvirgola = -1;
var numberstring = val+"";

 numberstring = numberstring.replace(".",",");
 var posvirgola = numberstring.indexOf(",");
 
var decimali = "";
var interi  = "";
var decimalidaarrotindare;

	if (posvirgola > -1) {
		interi = numberstring.substr(0,posvirgola);
	    decimali = numberstring.substr(posvirgola,(numberstring.length-posvirgola));
		
		if (decimali.length > 3) {
			if (decimali.substring(3,4) == "9") {
				
			  if (decimali.substring(1,3) != "99") {	
     	           decimalidaarrotindare = parseInt(decimali.substring(1,3),10);
	    		   decimalidaarrotindare++;
		    	   decimali = ","+decimalidaarrotindare;
				} else {
				  interidaincrementare = parseInt(numberstring.substr(0,posvirgola));	
				  interidaincrementare++;
		          interi = ""+interidaincrementare;
				  decimali = ""; 		  	
				}     			
			}
			if (decimali.substring(3,4) == "0") {
			   decimali = decimali.substring(0,3);  			
			}
     	} 	
	}	
	else	
        interi = numberstring;

		return (pointsToInt(interi)+decimali);
 
}

// ------------------------------------------------------------------
// OnlyNumber(val)
// Returns  string without points from string 
// Toglie i punti delle migliaia..
// ------------------------------------------------------------------
function OnlyNumber(val) {

var onlynumber = "";
var numbervalue = 0;

  for (var i = 0; i < val.length;  i++) {
      numbervalue = parseInt(val.charAt(i),10)
     if (! isNaN(numbervalue))
	   onlynumber = onlynumber + numbervalue;
  }

  return onlynumber;
}

// ------------------------------------------------------------------
// pointsToInt(onlyint)
// Returns  string with points from string 
// Mette i punti delle migliaia.. 
// ------------------------------------------------------------------
function pointsToInt(onlyint) {

var numconpunti = "";
var j = 0;

  for (var i = onlyint.length-1; i >= 0; i--) {

	if (((j%3)  == 0) && (j > 0))
      numconpunti =  onlyint.charAt(i) +"."+ numconpunti;
	else  
      numconpunti =  onlyint.charAt(i) + numconpunti;
	 j++; 
 }  
 
 return numconpunti; 
}

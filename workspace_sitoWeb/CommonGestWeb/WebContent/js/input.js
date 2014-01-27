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

// ------------------------------------------------------------------
// USES:  [defined into HTML source]
// 1) number.js from control number format
// 2) date.js from control date format

// HISTORY
// ------------------------------------------------------------------

var CANC1 = 46;
var CANC2 = 8;


// ------------------------------------------------------------------
// deleteInput( input_field, event)
// EVENT to attachment:  onkeydown
// Returns "" from a input_fields if  pressed CANC or BACKSPACE
// ------------------------------------------------------------------
function deleteInput(f,e) {

  /* e.which per Netscape, Mozzilla*/
  if (e.which) { 
  
    /* abilitato tasto CANC e BACKSPACE */
    if ((e.which == CANC1) || (e.which == CANC2)) {
	 f.value = ""; 
	} 
	
  }
  else	{
  /* e.which per Intenet Exploorer */
    if (e.keyCode) {
	
    /* abilitato tasto CANC e BACKSPACE */
    if ((e.keyCode == CANC1) || (e.keyCode == CANC2)) {
	 f.value = ""; 
	} 
	}
  }
	return true;
}


// ------------------------------------------------------------------
// returnInteger(input_field, event)
// EVENT to attachment:  onkeyup
// Returns "" if not integer number from a input_fields 
// ------------------------------------------------------------------
function returnInteger(f,e) {

for (var i = 0; i < f.value.length; i++) {
  var Num1 =  parseInt(f.value.charAt(i));

  if (isNaN(Num1))  {
   f.value = "";
   break;
  }
}
}

// ------------------------------------------------------------------
// returnNumber(input_field, event)
// EVENT to attachment:  onkeyup
// Returns "" if not integer number from a input_fields 
// ------------------------------------------------------------------
function returnNumber(f,e) {

if (! isNumber( f.value)) {
   f.value = "";
   
} else {

var decimali = "";
var intericonpunti  = "";
var posvirgola = -1;
    posvirgola = f.value.indexOf(",");

	if (posvirgola > -1) {
		intericonpunti = f.value.substr(0,posvirgola);
	    decimali = f.value.substr(posvirgola+1,(f.value.length-posvirgola));
	}	
	else	
       intericonpunti = f.value;
	
var interisenzapunti = OnlyNumber(intericonpunti);

var numberend =  "";

	if ((posvirgola > -1) && (posvirgola < (f.value.length))) 
	    numberend =  interisenzapunti+","+decimali;
	else 
	    numberend =  interisenzapunti;
		
if (! isNaN(interisenzapunti))	
	f.value = numberend; 
else	
   f.value =  "";
} 
   
return true;
}


// ------------------------------------------------------------------
// exitNumber(input_field)
// EVENT to attachment:  onblur
// Returns "" if not integer number from a input_fields 
// else return number with points and comma
// ------------------------------------------------------------------
function exitNumber(f) {

var decimali = "";
var interi  = "";
var valore = "";
var posvirgola = f.value.indexOf(',');

    if (posvirgola == f.value.length-1) {
	   f.value = "";
	   return;
	}   
   
	if (posvirgola > 0) {
	   decimali = f.value.substr(posvirgola+1,(f.value.length-posvirgola));
       interi = f.value.substr(0,posvirgola);
	} else 
       interi = f.value;

	var interisenzapunti = OnlyNumber(interi);   
    valore = pointsToInt(interisenzapunti); 
  
	if (posvirgola > 0) 
	   valore = valore +","+decimali;
  
  f.value = valore;
}


// ------------------------------------------------------------------
// returnDate(input_field, event)
// EVENT to attachment:  onkeyup
// Returns "" if not Date correct, else date string from 
// a input_fields 
// ------------------------------------------------------------------
function returnDate(f,e) {

var last_char = f.value.charAt(f.value.length-1);

var v = parseInt(last_char);

if ((isNaN(v)) && (last_char != "-"))
	f.value = "";


  if (f.value.length > 9)
	  f.value = f.value.substring(0,10);
	  
  if (f.value.length == 2 || f.value.length == 5)
      f.value = f.value +"-"; 

  if (! ctl_date(f.value))
	f.value = ""; 
	
	return true;
}


// ------------------------------------------------------------------
// ctl_date(dateStr)
// Returns false if not Date correct, else true
// ------------------------------------------------------------------
function ctl_date(dateStr) {


if ( dateStr.length > 2) {
var ggInt1 =  parseInt(dateStr.substr(0,1));
var ggInt2 =  parseInt(dateStr.substr(1,1));
var ggInt =  parseInt(dateStr.substr(0,2),10);
}   

if (dateStr.length > 4) {
var mmInt1 =  parseInt(dateStr.substr(3,1));
var mmInt2 =  parseInt(dateStr.substr(4,1));
var mmInt =  parseInt(dateStr.substr(3,2),10);
}   
   
if (dateStr.length > 9) {
var aaInt1 =  parseInt(dateStr.substr(6,1));
var aaInt2 =  parseInt(dateStr.substr(7,1));
var aaInt3 =  parseInt(dateStr.substr(8,1));
var aaInt4 =  parseInt(dateStr.substr(9,1));
var aaInt =  parseInt(dateStr.substr(6,1)+
                      dateStr.substr(7,1)+
					  dateStr.substr(8,1)+
                      dateStr.substr(9,1),10);
                      
}   

/* Controllo per il giorno digitato*/
if  (dateStr.length > 2) { 

 if (isNaN(ggInt1) || isNaN(ggInt2)) 
    return false; 

 if (ggInt > 31 || ggInt < 1) 
    return false; 

}

/* Controllo per il mese digitato*/
if  (dateStr.length > 4) { 
 if ( (isNaN(mmInt1)) || (isNaN(mmInt2))) 
  return false; 

 if ((mmInt > 12) || (mmInt < 1)) 
   return false; 

  /* Controllo per il giorno mese dell'anno digitato*/
   if ((mmInt == 2) && (ggInt > 29))
    return false; 

   if ((mmInt == 4) || (mmInt == 6) || (mmInt == 9)) {
     if (ggInt > 30)
       return false; 
}

}


/* Controllo per la correttezza dell'anno digitato*/
if  (dateStr.length > 9) { 

 if ( (isNaN(aaInt1)) || (isNaN(aaInt2)) || (isNaN(aaInt3)) || (isNaN(aaInt4))) 
 return false;
 
 if (aaInt < 1900)
 return false; 

 var resto = aaInt%4;
 if ((resto > 0) && (ggInt > 28) && (mmInt == 2 ))
 return false; 
}

return true;
}


// ------------------------------------------------------------------
// exitDate(input_field)
// EVENT to attachment:  onblur
// Returns "" if not date format from a input_fields 
// ------------------------------------------------------------------
function exitDate(f) {

 if (!isDate(f.value,"dd-MM-yyyy")) {
 
   if (f.defaultValue) {
     f.value = f.defaultValue;
   }	 
   else	 
     f.value = "";
 }  
}

/* Funzione da cancellare  - DI PROVA */
/* Funzione da cancellare  - DI PROVA */
function verify(f)
{

	if ((f.firstname.value == null) || (f.firstname.value == "")) {
			alert("obbligatorio digitare il cognome ");
			f.firstname.focus();
	}		
	else {
	f.firstname.value=" MA CHE ..... FAI? ";
	f.firstname.select();
	}
	
	if (f.datanasc) {
	  alert(getDateFromFormat(f.datanasc.value,"dd-MM-yyyy")); 
	  f.data_nasc_num.value = getDateFromFormat(f.datanasc.value,"dd-MM-yyyy"); 
/*	  alert(f.data_nasc_num.value); */
	}  
/*	  alert("CI STA' datanascita "+f.datanasc.value); */

    if (f.schei) {
	  f.schei_num.value =  returnNumber(f.schei,null);
	}
	
	if (f.venduto) {
	var numero = getNumberFromString(f.venduto.value);
	alert("numero ["+numero+"]");
	alert("stringa ["+formatNumber(numero)+"]"); 
	
	}
	  
return true;
}

  function Trim(valueOld)
   {
   
   re=/\s+$|^\s+/g;
     return valueOld.replace(re,"");
   }  

   function LTrim()
   {
   re=/^\s+/g;
   with (document.modulo)
      {
      output.value=input.value.replace(re,"");
      }
   }

   function RTrim()
   {
   re=/\s+$/g;
   with (document.modulo)
      {
      output.value=input.value.replace(re,"");
      }
   }  

function IsEmpty(aTextField) {
   
   if ((Trim(aTextField.value).length==0) ||
   (aTextField.value==null)) {
      return true;
   }
   else { return false; }
}	

function IsNotEmpty(aTextField) {

   if ((Trim(aTextField.value).length==0) ||
   (aTextField.value==null)) {
      return false;
   }
   else { return true; }
}	

/*
 * Created on 26-gen-2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package commons;


public class  StringRoutine {
  
  public StringRoutine(){
    //vuoto di proposito
    
  }
  
	public static String compatta(String s) {
		
		// Trasforma tutto in minuscolo 
		// per comparazioni
		final String sLower = s.toLowerCase();
		
		// Carica lo StringBuffer perla lettura e
		// le eventuali cancellazioni e sostituzione
		StringBuffer h = new StringBuffer(sLower);
		
		int punt = 0;
		boolean erasechar = false;
		
		// Togli caratteri inutili e spazi
		while (true) {
		
			if (punt > h.toString().length()-1) break;

			final char carat = h.charAt(punt);
			final Character carattere = carat;
			
			erasechar = false;
			
			if ((carattere.toString().equals(" ")) ||
					   (carattere.toString().equals(".")) ||
					   (carattere.toString().equals("/")) ||
					   (carattere.toString().equals(",")) ||
					   (carattere.toString().equals(":")) ||
					   (carattere.toString().equals(";")) ||
					   (carattere.toString().equals("§")) ||
					   (carattere.toString().equals("'")) ||
					   (carattere.toString().equals("|")) ||
					   (carattere.toString().equals("")) ||
					   (carattere.toString().equals("\\")) ||
					   (carattere.toString().equals("$")) ||
					   (carattere.toString().equals("%")) ||
					   (carattere.toString().equals("#")) ||
					   (carattere.toString().equals("(")) ||
					   (carattere.toString().equals(")")) ||
					   (carattere.toString().equals("=")) ||
					   (carattere.toString().equals("?")) ||
					   (carat == '\'') ||
					   (carat == '\"') ||
					   (carat == '\b') ||
					   (carat == '\n') ||
					   (carat == '\t') ||
					   (carat == '\r') ||
					   (carat == '\f'))  {

						h.delete(punt,punt+1);
						erasechar = true;
						
					}
			
			if (!erasechar)
   			 punt++;
			
		}	
		
		punt = 0;
		
		while (true) {

			if (punt > h.toString().length()-1) break;
			
			final char carat = h.charAt(punt);
			final Character carattere = carat;
			
			erasechar = false;
			

			// Sostituzione caratteri speciali
			// -------------------------------
				h.replace(punt,punt+1,converCaratter(carattere.toString()));
				
				// Elimina doppie consecutive
				// --------------------------
				if (punt < h.toString().length()-1) {
					
	    			final char caratsuccnew = h.charAt(punt);
				    final Character caratterenew = caratsuccnew;
					
	    			final char caratsucc = h.charAt(punt+1);
				    final Character caratteresucc = caratsucc;


				    if (caratterenew.toString().equals(converCaratter(caratteresucc.toString()))) {
						h.delete(punt,punt+1);
						erasechar = true;
				    } 
				}

			
			
			if (!erasechar)
    			 punt++;
			 
			 
			
		}
		
		return h.toString();
		
	}

	public static String togliCaratteriSpeciali(String s) {
		
		// Carica lo StringBuffer perla lettura e
		// le eventuali cancellazioni e sostituzione
		StringBuffer h = new StringBuffer(s);
		int punt = 0;
		boolean erasechar = false;
		
		// Togli caratteri inutili e spazi
		while (true) {
		
			erasechar = false;
			
			if (punt > h.toString().length()-1) break;

			final char carat = h.charAt(punt);
			
			if ((carat == '\'') ||
					   (carat == '\"') ||
					   (carat == '\b') ||
					   (carat == '\n') ||
					   (carat == '\t') ||
					   (carat == '\r') ||
					   (carat == '\f'))  {

						h.delete(punt,punt+1);
						erasechar = true;
						
					}
			
			if (!erasechar)
   			 punt++;
			
		}	

		return h.toString();
		
	}
	
	
	private static String converCaratter(String carDaConv) {
	
		// Sostituzione caratteri speciali
		// -------------------------------
		if ((carDaConv.toString().equals("è")) ||  
				(carDaConv.toString().equals("é")))
			return "e";

		if (carDaConv.toString().equals("à"))
			return "a";
		
		if (carDaConv.toString().equals("ò"))
			 return "o";
		
		if (carDaConv.toString().equals("ù"))
			return "u";
		
		
		if ((carDaConv.toString().equals("ì")) ||
		   (carDaConv.toString().equals("j")) ||
		   (carDaConv.toString().equals("y")))
			return "i";
		
		if (carDaConv.toString().equals("w"))
			return "v";
		
		return  carDaConv;
		
		
	}
	
  
  
}

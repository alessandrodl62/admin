

public class DecodNumber {

	
	
public static String restituisciNumeroPuro(String s) {
		
		
		// Carica lo StringBuffer perla lettura e
		// le eventuali cancellazioni e sostituzione
		StringBuffer h = new StringBuffer(s);
		
		int punt = 0;
		boolean erasechar = false;
		
		// Togli caratteri .
		while (true) {
		
			if (punt > h.toString().length()-1) break;

			final char carat = h.charAt(punt);
			final Character carattere = carat;
			
			erasechar = false;
			
			if (carattere.toString().equals("."))  {

						h.delete(punt,punt+1);
						erasechar = true;
			} 			
			if (!erasechar)
   			 punt++;
			
		}	
		
		
		return h.toString().replace(',','.');
		
	}
	


}

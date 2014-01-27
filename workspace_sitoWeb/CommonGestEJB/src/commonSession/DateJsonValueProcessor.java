package commonSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/*
 * richiamato dalla funzione che generail Json per convertire le date in stringa
 * 
 */

public class DateJsonValueProcessor implements JsonValueProcessor {
  
   public static final String DATEPATTERN = "dd.MM.yyyy";
   
   private DateFormat dateFormat;

    public DateJsonValueProcessor() {
	 	 dateFormat = new SimpleDateFormat(DATEPATTERN);
    }

	public DateJsonValueProcessor(String datePattern) {
	super();
	  try {
		
		  dateFormat = new SimpleDateFormat(datePattern);
         		  
    	} catch (Exception e) {
    		 dateFormat = new SimpleDateFormat(DATEPATTERN);
	    }
	
    }

	public Object processArrayValue(Object value, JsonConfig config) {
        		
		return process(value);
	}

	public Object processObjectValue(String key, Object value, JsonConfig config) {
		
		return process(value);
	}

	private Object process(Object value) {
		if (value == null)
			return "";
		
		return dateFormat.format((Date)value);
	}
	
}

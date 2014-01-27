

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class TimeJsonValueProcessor implements JsonValueProcessor {
   public static final String TIMEPATTERN ="HH:mm";
   
   
   private DateFormat dateFormat;

    public TimeJsonValueProcessor() {
	 	 dateFormat = new SimpleDateFormat(TIMEPATTERN);
    }

	public TimeJsonValueProcessor(String datePattern) {
	super();
	  try {
		
		  dateFormat = new SimpleDateFormat(datePattern);
         		  
    	} catch (Exception e) {
    		 dateFormat = new SimpleDateFormat(TIMEPATTERN);
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

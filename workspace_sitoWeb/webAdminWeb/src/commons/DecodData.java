package commons;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DecodData {

	public static String getDateTimeFormatStr(Timestamp datein) {
		
			if (datein != null) {
				calendar.setTimeInMillis(datein.getTime());
				
					final String dateRev = formatter.format(calendar.getTime()).substring(0,10);
					return dateRev.substring(8,10)+"."+dateRev.substring(5,7)+"."+dateRev.substring(0,4);
				}	
				
				return "";
			
	}

	
	public static Timestamp getStrFormatTimeStamp(String datein) {
		
		Date myDate = null;
		try {
		     myDate = myDateFormat.parse(datein); 
		     return new Timestamp(myDate.getTime()); 
		     
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public static java.sql.Date getStrDataSql(String datein) {
		
		     try {
		    	 myDateFormat.parse(datein);
		    	 
		    	 Calendar stCal = Calendar.getInstance();
		    	 stCal.setTime(myDateFormat.parse(datein));
		    	 return new java.sql.Date(stCal.getTimeInMillis());
		    	 
				
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			return null;
		
	}

	public static Time getStrFormatOnlyTimeStamp(String orain) {
		
		Date myDate = null;
		try {
		     myDate = myTimeFormat.parse(orain); 
		     return new Time(myDate.getTime()); 
		     
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	
	public static Integer getStrFormatInteger(String value) {
		
		if ((value != null) && (!value.equals("")))
			return  Integer.decode(value);
		
		return null;
	}
	
	public static Integer getYear(String value) {
		
		if ((value != null) && (!value.equals("")))
    		return Integer.getInteger(value.substring(7,10));		
		
		return null;
	}
	
	private  static DateFormat myDateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private  static DateFormat myTimeFormat = new SimpleDateFormat("HH:mm");
	private  static Calendar calendar = new GregorianCalendar();  // Gregorian Calendar usato nel session
	private  static DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd'-'hh:mm:ss"); // Formatter delle date usato nel session
	
	
}

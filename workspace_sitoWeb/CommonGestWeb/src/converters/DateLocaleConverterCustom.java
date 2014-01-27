/*
 * Opero gestore procedimenti amministrativi
 * e sportello del cittadino
 */
package converters;

import java.util.Locale;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * The Class DateLocaleConverterCustom.
 */
public class DateLocaleConverterCustom  extends DateLocaleConverter{
	
	/**
	 * Instantiates a new date locale converter custom.
	 * 
	 * @param locale
	 *            the locale
	 * @param pattern
	 *            the pattern
	 */
	public DateLocaleConverterCustom(Locale locale,String pattern){
		super(locale,pattern);
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.beanutils.locale.BaseLocaleConverter#convert(java.lang.Class, java.lang.Object)
	 */
	public Object convert(Class type, Object value) {
		if(value == null || value.toString().length() < 1)
			return null;

		return super.convert(type, value);
	}
}

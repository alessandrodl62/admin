/*
 * Opero gestore procedimenti amministrativi
 * e sportello del cittadino
 */
package converters;
 
import java.util.Locale;

import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;
import org.apache.commons.beanutils.locale.converters.IntegerLocaleConverter;

 
/**
 * The Class LongLocalConverterCustom.
 */
public class LongLocalConverterCustom extends IntegerLocaleConverter {
	
	 
	/**
	 * Instantiates a new long local converter custom.
	 * 
	 * @param locale
	 *            the locale
	 */
	public LongLocalConverterCustom(Locale locale){
		super(locale);
	}
	 
	/**
	 * Convert.
	 * 
	 * @param type
	 *            the type
	 * @param value
	 *            the value
	 * 
	 * @return the object
	 */
	public Object convert(Class type, Object value) {
		if(value == null || value.toString().length() < 1)
			return new Long(0);

		return new Long(value.toString().replace(',','.'));
	}
}

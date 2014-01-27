/*
 * Opero gestore procedimenti amministrativi
 * e sportello del cittadino
 */
package converters;
 
import java.util.Locale;

import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;
import org.apache.commons.beanutils.locale.converters.IntegerLocaleConverter;

/**
 * The Class IntegerLocalConverterCustom.
 */
public class IntegerLocalConverterCustom extends IntegerLocaleConverter {
	
	/**
	 * Instantiates a new integer local converter custom.
	 * 
	 * @param locale
	 *            the locale
	 */
	public IntegerLocalConverterCustom(Locale locale){
		super(locale);
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.beanutils.locale.BaseLocaleConverter#convert(java.lang.Class, java.lang.Object)
	 */
	public Object convert(Class type, Object value) {
		if(value == null || value.toString().length() < 1)
			return new Integer(0);

		return new Integer(value.toString().replace(',','.'));
	}
}

/*
 * Opero gestore procedimenti amministrativi
 * e sportello del cittadino
 */
package converters;
 
import java.util.Locale;

import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;

/**
 * The Class DoubleLocalConverterCustom.
 */
public class DoubleLocalConverterCustom extends DoubleLocaleConverter {
	
	/**
	 * Instantiates a new double local converter custom.
	 * 
	 * @param locale
	 *            the locale
	 */
	public DoubleLocalConverterCustom(Locale locale){
		super(locale);
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.beanutils.locale.BaseLocaleConverter#convert(java.lang.Class, java.lang.Object)
	 */
	public Object convert(Class type, Object value) {
		if(value == null || value.toString().length() < 1)
			return new Double(0);

		return new Double(value.toString().replace(',','.'));
	}
}

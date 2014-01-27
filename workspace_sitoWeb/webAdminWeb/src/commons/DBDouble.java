/*
 * Created on 22-feb-2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package commons;

/**
 * @author ALESSANDRODL
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class DBDouble {

  static public double parseDouble(String s) {
    if( s==null || s.length()==0) return 0;
    
    final String value_str = s.replace(".","").replace(',', '.'); 
    
    return Double.parseDouble(value_str);
    
  }
}

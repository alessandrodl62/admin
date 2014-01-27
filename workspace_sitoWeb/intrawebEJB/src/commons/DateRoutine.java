/*
 * Created on 26-gen-2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package commons;

import java.sql.Timestamp;
import java.util.Calendar;

public class  DateRoutine {
  
  public DateRoutine(){
    //vuoto di proposito
    
  }
/**
 * Compara due date di tipo Calendar. Il metodo elabora le due date azzerando la parte relativa ad ore, minuti e secondi
 * in modo da poter confrontare solamente giorno, mese ed anno.
 * 
 * @param primaData
 * @param secondaData
 * @return il valore <code>-1</code> se il <code>Calendar primaData</code> \u00E8
     *      prima dell'argomento <code>Calendar secondaData</code>; il valore 
     *      <code>1</code> se il <code>Calendar primaData</code> è successivo
     *      all'argomento  <code>Calendar secondaData</code>; e un valore uguale  
     *      a <code>0</code> se i due argomenti <code>Calendar</code> sono 
     *      tra loro uguali.
 */
  public static int comparaDate(Calendar primaData, Calendar secondaData) {
    
    int primaDataYear = primaData.get(Calendar.YEAR);
    int primaDataMonth = primaData.get(Calendar.MONTH);
    int primaDataDay = primaData.get(Calendar.DAY_OF_MONTH);
    primaData.set(primaDataYear,primaDataMonth, primaDataDay,0,0,0);
    primaData.set(Calendar.MILLISECOND, 0);
    Timestamp prima = new Timestamp(primaData.getTimeInMillis());
//System.out.println("primadata:  "+prima);

    int secondaDataYear = secondaData.get(Calendar.YEAR);
    int secondaDataMonth = secondaData.get(Calendar.MONTH);
    int secondaDataDay = secondaData.get(Calendar.DAY_OF_MONTH);
    secondaData.set(secondaDataYear,secondaDataMonth, secondaDataDay,0,0,0);
    secondaData.set(Calendar.MILLISECOND, 0);
    Timestamp seconda = new Timestamp(secondaData.getTimeInMillis());
//System.out.println("secondata:  "+seconda);
//System.out.println(primaData.before(secondaData) ? -1 : (primaData.after(secondaData) ? 1 : 0));
    return (primaData.before(secondaData) ? -1 : (primaData.after(secondaData) ? 1 : 0));
  }
  
  
}

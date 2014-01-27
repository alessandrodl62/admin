/*
 * Created on 18/set/08 by alessandrodl
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

package commonBean;

public class  StringRoutine {
  
  public StringRoutine(){
    //vuoto di proposito
    
  }
  
    public static String compatta(String s) {
        
        // Trasforma tutto in minuscolo 
        // per comparazioni
        final String sLower = s.toLowerCase();
        
        // Carica lo StringBuffer perla lettura e
        // le eventuali cancellazioni e sostituzione
        StringBuffer h = new StringBuffer(sLower);
        
        int punt = 0;
        boolean erasechar = false;
        
        // Togli caratteri inutili e spazi
        while (true) {
        
            if (punt > h.toString().length()-1) break;

            final char carat = h.charAt(punt);
            final Character carattere = carat;
            
            erasechar = false;
            
            if ((carattere.toString().equals(" ")) ||
                       (carattere.toString().equals(".")) ||
                       (carattere.toString().equals("/")) ||
                       (carattere.toString().equals(",")) ||
                       (carattere.toString().equals(":")) ||
                       (carattere.toString().equals(";")) ||
                       (carattere.toString().equals("§")) ||
                       (carattere.toString().equals("'")) ||
                       (carattere.toString().equals("|")) ||
                       (carattere.toString().equals("")) ||
                       (carattere.toString().equals("\\")) ||
                       (carattere.toString().equals("$")) ||
                       (carattere.toString().equals("%")) ||
                       (carattere.toString().equals("#")) ||
                       (carattere.toString().equals("(")) ||
                       (carattere.toString().equals(")")) ||
                       (carattere.toString().equals("=")) ||
                       (carattere.toString().equals("?")) ||
                       (carat == '\'') ||
                       (carat == '\"') ||
                       (carat == '\b') ||
                       (carat == '\n') ||
                       (carat == '\t') ||
                       (carat == '\r') ||
                       (carat == '\f'))  {

                        h.delete(punt,punt+1);
                        erasechar = true;
                        
                    }
            
            if (!erasechar)
             punt++;
            
        }   
        
        punt = 0;
        
        while (true) {

            if (punt > h.toString().length()-1) break;
            
            final char carat = h.charAt(punt);
            final Character carattere = carat;
            
            erasechar = false;
            

            // Sostituzione caratteri speciali
            // -------------------------------
                h.replace(punt,punt+1,converCaratter(carattere.toString()));
                
                // Elimina doppie consecutive
                // --------------------------
                if (punt < h.toString().length()-1) {
                    
                    final char caratsuccnew = h.charAt(punt);
                    final Character caratterenew = caratsuccnew;
                    
                    final char caratsucc = h.charAt(punt+1);
                    final Character caratteresucc = caratsucc;


                    if (caratterenew.toString().equals(converCaratter(caratteresucc.toString()))) {
                        h.delete(punt,punt+1);
                        erasechar = true;
                    } 
                }

            
            
            if (!erasechar)
                 punt++;
             
             
            
        }
        
        return h.toString();
        
    }

    public static String togliCaratteriSpeciali(String s) {
        
        // Carica lo StringBuffer perla lettura e
        // le eventuali cancellazioni e sostituzione
        StringBuffer h = new StringBuffer(s);
        int punt = 0;
        boolean erasechar = false;
        
        // Togli caratteri inutili e spazi
        while (true) {
        
            erasechar = false;
            
            if (punt > h.toString().length()-1) break;

            final char carat = h.charAt(punt);
            
            if ((carat == '\'') ||
                       (carat == '\"') ||
                       (carat == '\b') ||
                       (carat == '\n') ||
                       (carat == '\t') ||
                       (carat == '\r') ||
                       (carat == '\f'))  {

                        h.delete(punt,punt+1);
                        erasechar = true;
                        
                    }
            
            if (!erasechar)
             punt++;
            
        }   

        return h.toString();
        
    }
    
    
    private static String converCaratter(String carDaConv) {
    
        // Sostituzione caratteri speciali
        // -------------------------------
        if ((carDaConv.toString().equals("è")) ||  
                (carDaConv.toString().equals("é")))
            return "e";

        if (carDaConv.toString().equals("à"))
            return "a";
        
        if (carDaConv.toString().equals("ò"))
             return "o";
        
        if (carDaConv.toString().equals("ù"))
            return "u";
        
        
        if ((carDaConv.toString().equals("ì")) ||
           (carDaConv.toString().equals("j")) ||
           (carDaConv.toString().equals("y")))
            return "i";
        
        if (carDaConv.toString().equals("w"))
            return "v";
        
        return  carDaConv;
        
        
    }
    
  
  
}

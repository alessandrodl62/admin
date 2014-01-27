/**
 * 
 */
package commonBean;

import java.io.Serializable;

/**
 * @author PAOLOM
 *
 */
public class ItemComp implements Comparable, Serializable {


	public ItemComp(String aOrderitem, Object aKeyitem)
	{
		orderitem = aOrderitem;
		keyitem = aKeyitem;
	}

	public Object getKeyitem() {
		return keyitem;
	}
	

	public String getOrderitem() {
		return orderitem;
	}

	public boolean equals(Object other)
	{
		
		if (getClass() != other.getClass()) return false;
		
		ItemComp otherItem = (ItemComp)other;
		return (keyitem == otherItem.getKeyitem());
			
		
	}
	
	public int hashCode()
	{
		return 13 * orderitem.hashCode() + 17 * keyitem.hashCode();
		
	}
	
	
	public int compareTo(Object other) {
		
		ItemComp otheritem = (ItemComp)other;
		return (orderitem.compareTo(otheritem.getOrderitem()));
		
	}

	private String orderitem;
	private Object keyitem;
}

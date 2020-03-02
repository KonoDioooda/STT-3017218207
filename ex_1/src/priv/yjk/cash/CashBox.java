package priv.yjk.cash;

import java.util.HashSet;
import java.util.Set;

public class CashBox {
	
	public static final int[] cashes = {1, 1, 1, 5, 5, 10, 20, 50};
	
	public static int getTotal() {
		int total = 0;
		for (int i = 0; i < cashes.length; i++) {
			total += cashes[i];
		}
		return total;
	}
	
	
	public static final Set<Integer> canTakeOut = new HashSet<Integer>();
	
	// ÊÖ¶¯Çî¾Ù
	static {
		{
			for(int i = 0; i <= getTotal(); i++) {
				canTakeOut.add((Integer)i);
			}
			
			for(int i = 4; i < getTotal(); i += 5) {
				canTakeOut.remove(i);
			}
			
			canTakeOut.remove(45);
			canTakeOut.remove(46);
			canTakeOut.remove(47);
			canTakeOut.remove(48);
			
		}
	};
	
	public static boolean takeOut(int amount) {
		if (canTakeOut.contains((Integer)amount))
			return true;
		else
			return false;
		
	}
	
}

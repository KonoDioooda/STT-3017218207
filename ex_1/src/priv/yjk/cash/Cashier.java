package priv.yjk.cash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Cashier {
	
	private Map<Integer, Integer> cashes;
	
	public Cashier(Map<Integer, Integer> cashes) {
		this.cashes = cashes;
	}
	
//	public Map<Integer, Integer> cashes = new HashMap<Integer, Integer>() {
//		{
//			put(50, 1);
//			put(20, 1);
//			put(10, 1);
//			put(5, 2);
//			put(3, 1);
//		}
//	};

	public int getTotal() {
		int total = 0;
		for (Integer cash : this.cashes.keySet()) {
			total += cash * this.cashes.get(cash);
		}
		return total;
	}

	// 贪心算法
	// 某些情况下可能不适用
	public boolean takeOut(int amount) {

		boolean res = false;
		
		if (amount > getTotal()) {
			return false;
		}
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (Integer value : this.cashes.keySet()) {
			values.add(value);
		}
		
		// 由大到小排序
		values.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 == o2) return 0;
				else return o2.compareTo(o1);
			}
		});
		
		Map<Integer, Integer> current_cashes = new HashMap<>(this.cashes);
		
		while(true) {
			if (amount == 0) {
				res = true;
				break;
			}
			
			for(int i = 0; i < values.size(); i++) {
				int count = current_cashes.get(values.get(i));
				if (amount >= values.get(i) && count > 0) {
					amount -= values.get(i);
					current_cashes.replace(values.get(i), count-1);
					break;
				}
				else if (i == values.size()-1) {
					return false;
				}
			}
		}
		
		return res;
	}

	
	public static void main(String[] args) {
		boolean b = new Cashier(new HashMap<Integer, Integer>() {
			{
				put(50, 1);
				put(20, 1);
				put(10, 1);
				put(5, 2);
				put(1, 3);
			}
		}).takeOut(9);
		System.out.print(b);
	}
}

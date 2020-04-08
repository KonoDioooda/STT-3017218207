package priv.yjk.mujava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BackPackTest {
	
	@Test
	public void test() {
		int m = 10;
		int n = 3;
		int w[] = {3, 4, 5};
		int p[] = {4, 5, 6};
		
		int[][] c = {
				{0, 0, 4, 4, 4, 4, 4, 4, 4, 4},
				{0, 0, 4, 5, 5, 5, 9, 9, 9, 9},
				{0, 0, 4, 5, 6, 6, 9, 10, 11, 11},
		};
		
		int[][] result = BackPack.BackPack_Solution(m, n, w, p);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
//				System.out.println(c[i][j] + " " + result[i+1][j+1]);
				assertEquals(c[i][j], result[i+1][j+1]);
			}
		}
		
	}

}

package priv.yjk.mujava;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class BubbleSortTest {
	
	@Test
	public void test1() {
		int[] original = {1, 6, 2, 2, 5};
		int[] sorted = {1, 2, 2, 5, 6};
		assertArrayEquals(sorted, BubbleSort.BubbleSort(original));
	}
	
	@Test
	public void test2() {
		int[] original = {100, 625, 32, 12, 5, 2};
		int[] sorted = {2, 5, 12, 32, 100, 625};
		assertArrayEquals(sorted, BubbleSort.BubbleSort(original));
	}
	
	@Test
	public void test3() {
		int[] original = {1, 0, -3};
		int[] sorted = {-3, 0 ,1};
		assertArrayEquals(sorted, BubbleSort.BubbleSort(original));
	}

}

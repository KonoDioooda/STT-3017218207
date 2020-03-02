package priv.yjk.cash;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCashier {
	
	private Cashier cashier;
	private int amount;
	private boolean expected;
	
	public TestCashier(int amount, boolean expected) {
		this.amount = amount;
		this.expected = expected;
	}

	@Parameters
	public static Collection getData() {
		return Arrays.asList(new Object[][] {
			{0, true},
			{1, true},
			{4, false},
			{13, true},
			{41, true},
			{45, false},
			{76, true},
			{80, true},
			{84, false},
			{91, true},
			{93, true},
			{96, false}
		});
	}
	
	@Before
	public void init() {
		this.cashier = new Cashier(new HashMap<Integer, Integer>() {
			{
				put(50, 1);
				put(20, 1);
				put(10, 1);
				put(5, 2);
				put(1, 3);
			}
		});
	}
	
	@Test
	public void test() {
		assertEquals(cashier.takeOut(amount), expected);
	}
	
	@After
	public void finish() {
		System.out.println("A Test finished!");
	}

}

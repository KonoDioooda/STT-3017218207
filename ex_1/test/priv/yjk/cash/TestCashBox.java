package priv.yjk.cash;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TestCashBox {
	
	private int amount;
	private boolean expected;
	
	public TestCashBox(int amount, boolean expected) {
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

	@Test
	public void test() {
		assertEquals(CashBox.takeOut(amount), expected);
	}

}

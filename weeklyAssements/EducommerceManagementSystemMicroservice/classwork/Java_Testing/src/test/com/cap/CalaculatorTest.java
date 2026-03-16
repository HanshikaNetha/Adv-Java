package test.com.cap;
import main.com.cap.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class CalaculatorTest {
	@Test
	public void testAdd() {
		Calculator calc=new Calculator();
		Assertions.assertEquals(5, calc.add(2, 3));
	}
	@Test
	public void testsubtract() {
		Calculator c=new Calculator();
		Assertions.assertEquals(2, c.subtract(5, 3));
	}
	@Test
	public void testIsEven() {
		Calculator c=new Calculator();
		Assertions.assertTrue(c.IsEven(4));
		Assertions.assertFalse(c.IsEven(5));
		Assertions.assertTrue(c.IsEven(3));
	}
	//edge case testing
	@Test
	public void testDivide() {
		Calculator c=new Calculator();
		Assertions.assertEquals(3,  c.divide(9,  3));
	}
}

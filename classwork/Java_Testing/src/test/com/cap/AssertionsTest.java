package test.com.cap;
import main.com.cap.Assertionse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
public class AssertionsTest {
	Assertionse a;
	@BeforeEach
	public void initialize() {
		a=new Assertionse();
	}
	@DisplayName("assertEquals")
	@Test
	public void check() {
		Assertions.assertEquals(4, a.add(2,  2));
	}
	@DisplayName("assrtNotEquals")
	@Test 
	public void check1() {
		Assertions.assertNotEquals(5,  a.add(2,  2));
	}
	@DisplayName("assertTrue")
	@Test
	public void check2() {
		Assertions.assertTrue(a.isLetter('e'));
	}
	@Test
	@DisplayName("aseertFalse")
	public void check3() {
		Assertions.assertFalse(a.isLetter('9'));
	}
	@Test
	public void check4() {
		Assertions.assertNull(a.getNull());
	}
	@Test
	public void check5() {
		Assertions.assertNotNull(a.gteName());
	}
	@Test
	public void check6() {
		Assertions.assertThrows(ArithmeticException.class,()->{a.divide(4,  0);});
	}
	@Test
	public void check7() {
		Assertionse a=new Assertionse();
		Assertionse b=a;
		Assertions.assertSame(a, b);
	}
	@Test 
	public void check8() {
		Assertionse b=new Assertionse();
		Assertionse c=new Assertionse();
		Assertions.assertNotSame(b, c);
	}
	
}

package test.com.cap;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import main.com.cap.*;
public class ParameterizedTest_ValueSource {
	Calculator c;
	@BeforeEach
	public void initialize() {
		c=new Calculator();
	}
	@ParameterizedTest
	@ValueSource(ints= {2, 4, 6, 8})
	public void testEvaluetion(int num) {
		Assertions.assertTrue(c.IsEven(num));
	}
}

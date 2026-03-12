package test.com.cap;
import main.com.cap.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import org.junit.jupiter.api.Assertions;
public class ParameterizedTests_CsvSource {
	Calculator c;
	@BeforeEach
	public void initialize() {
		c=new Calculator();
	}
	@ParameterizedTest
	@CsvSource({
		"2, 3, 5", 
		"0, 0, 0", 
		"100, 200, 300"
	})
	public void testAddParamterized(int a, int b, int expected) {
		Assertions.assertEquals(expected, c.add(a,  b));
	}
	
	
}

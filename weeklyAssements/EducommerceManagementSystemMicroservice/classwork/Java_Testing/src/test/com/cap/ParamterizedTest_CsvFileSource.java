package test.com.cap;
import main.com.cap.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
public class ParamterizedTest_CsvFileSource {
	Calculator c;
	@BeforeEach
	public void initialize() {
		c=new Calculator();
	}
	@ParameterizedTest
	@CsvFileSource(files="test_data.csv", numLinesToSkip=1)
	public void simpleAddTest(int a, int b, int expected) {
		System.out.println("Simple @CSVFILESOURCE test: "+a+" + "+b);
		Assertions.assertEquals(expected, c.add(a,  b));
	}
}

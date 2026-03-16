package test.com.cap;
import main.com.cap.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
public class ParamterizedTest_CsvSource {
	Factorial f;
	@BeforeEach
	public void initialize() {
		f=new Factorial();
	}
	@ParameterizedTest
	@CsvSource({"24, 4",
		"120, 5",
		"6, 2"
	})
	public void checkFac(int expected, int n) {
		Assertions.assertEquals(expected, f.fac(n));
	}
}

package test.com.cap;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import main.com.cap.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

public class ParameterizedTest_MethodSorce {
	Calculator c;
	@BeforeEach
	public void initialize() {
		c=new Calculator();
	}
	@ParameterizedTest
	@MethodSource("provideDivisionTestCases")
	public void testDivideMethodScource(int a, int b, int expected) {
		Assertions.assertEquals(expected, c.divide(a, b));
	}
	private static Stream<Arguments> provideDivisionTestCases(){
		return Stream.of(
				Arguments.of(20, 4, 5), 
				Arguments.of(15, 5, 3), 
				Arguments.of(0, 7, 0), 
				Arguments.of(100, 25, 4)
				);
	}
}

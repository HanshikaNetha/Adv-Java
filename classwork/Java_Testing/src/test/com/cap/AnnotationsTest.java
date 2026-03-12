package test.com.cap;
import main.com.cap.Annotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
public class AnnotationsTest {
	static Annotations a;
	@BeforeAll
	public static  void BeforeALLc() {
		System.out.println("not started yet");
		a=new Annotations();
	}
	@BeforeEach
	public void BEforeEache() {
		System.out.println("exceuted before every method");
	}
	@AfterEach
	public void AfterEachc() {
		System.out.println("Executed after every method");
	}
	@AfterAll
	public static void AfterAllc() {
		a=null;
		System.out.println("everthings done");
	}
	@Test
	public void FirstTest() {
		Assertions.assertEquals("first", a.first());
	}
	@Disabled
	@Test
	public void SecondTest() {
		Assertions.assertEquals("second", a.second());
	}
	@Test
	public void ThirdTEst() {
		Assertions.assertEquals("Third", a.third());
	}
	@DisplayName("This is showing integer")
	@Test
	public void numberTest() {
		Assertions.assertEquals(2, a.number(2));
	}
}

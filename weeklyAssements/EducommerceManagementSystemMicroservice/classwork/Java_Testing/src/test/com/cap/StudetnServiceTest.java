package test.com.cap;
import main.com.cap.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
public class StudetnServiceTest {
	static StudentService s;
	@BeforeAll
	public static  void initialize() {
		s=new StudentService();
	}
	@Test
	public void checkAge() {
		Assertions.assertTrue(s.isEligible(21));
	}
	@Test
	public void checAge() {
		Assertions.assertFalse(s.isEligible(11));
	}
	@AfterAll
	public static void destroy() {
		s=null;
	}
	
}

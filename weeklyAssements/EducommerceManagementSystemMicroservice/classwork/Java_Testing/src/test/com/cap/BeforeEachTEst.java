package test.com.cap;
import main.com.cap.BeforeEAchc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
public class BeforeEachTEst {
	BeforeEAchc a;
	@BeforeEach
	public void initialize() {
		a = new BeforeEAchc();
	}
	@Test
	public void SameNAmeTEst() {
		Assertions.assertTrue(a.SAmename("jui", "jui"));
	}
	@Test
	public void nameLEngthMAtch() {
		Assertions.assertEquals(6, a.lengthNAme("guitim"));
	}

}

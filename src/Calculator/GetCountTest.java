package Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetCountTest {

	@Test
	void testCases() {
		StringCalculator.Add("1,2,3");
		try {
			StringCalculator.Add("abcd");
			fail("NumberFormatException");
			} catch (NumberFormatException e) {
		 
	 }
	}


}

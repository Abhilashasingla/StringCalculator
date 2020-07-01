package Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void returnZeroOnEmpty() {
		assertEquals(0, StringCalculator.Add(""));
	}
	
	@Test
	void returnOnOneNumber() {
		assertEquals(10, StringCalculator.Add("10"));
	}
	
	@Test
	void returnOnTwoNumber() {
		assertEquals(20, StringCalculator.Add("10,10"));
	}
	
	@Test
	void returnOnUnlimitedNumbers() {
		assertEquals(6, StringCalculator.Add("1,2,3"));
	}
	
	@Test
	void returnOnNewLine() {
		assertEquals(6, StringCalculator.Add("1,2\n3"));
	}
	
	@Test
	void returnOnCustomDelimeter() {
		assertEquals(3, StringCalculator.Add("//;\n1;2"));
	}
	
	@Test
	void returnOnCustomDelimeter1() {
		assertEquals(3, StringCalculator.Add("//*\n1*2"));
	}
	
	@Test
	void negativeNumber() {
		try{
			StringCalculator.Add("-1,2,3");
			fail("“negatives not allowed" );
		}
		catch(RuntimeException ex){
		}
	}
	
	@Test
	void negativeNumberPresent() {
		try{
			StringCalculator.Add("-1,2,3");
			fail("“negatives not allowed" );
		}
		catch(RuntimeException ex){
			assertEquals("negatives not allowed: [-1]",ex.getMessage() );
		}
	}
	
	@Test
	void negativeNumberPresent1() {
		try{
			StringCalculator.Add("-1,-2,3");
			fail("“negatives not allowed" );
		}
		catch(RuntimeException ex){
			assertEquals("negatives not allowed: [-1, -2]",ex.getMessage() );
		}
	}
	
	@Test
	void returnOnGetCalledCount() {
		int getCalledCount=StringCalculator.GetCalledCount();
		assertEquals(getCalledCount, StringCalculator.GetCalledCount());
	}
	
	@Test
	void returnOnLargeNumber() {
		assertEquals(2, StringCalculator.Add("1001,2"));
	}
	
	@Test
	void returnOnDelimeterAnyLength() {
		assertEquals(6, StringCalculator.Add("//[***]\\n1***2***3"));
	}
	
	@Test
	void returnOnMultipleDelimeter() {
		assertEquals(6, StringCalculator.Add("//[*][%]\\n1*2%3"));
	}
	
	@Test
	void returnMultipleDelimterAnyLength() {
		assertEquals(6, StringCalculator.Add("//[**][%%]\\n1**2%%3"));
	}

}

package com.tdd.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTests {

	DemoApplication demoApplication= new DemoApplication();

	@Test
	void contextLoads() {
	}

	@Test
	void  emptyString(){
		assertEquals(0, demoApplication.add(""));
	}

	@Test
	public void singleNumber() {
		assertEquals(1, demoApplication.add("1"));
	}

	@Test
	public void twoNumbers(){
		assertEquals(3, demoApplication.add("1,2"));
	}

	@Test
	public void threeNumbers(){
		assertEquals(6, demoApplication.add("1,2,3"));
	}

	@Test
	public void newLine(){
		assertEquals(12, demoApplication.add("3\n4,5"));
	}

	@Test
	public void greaterThanThousand(){
		assertEquals(1, demoApplication.add("1001,1"));
	}

	@Test
	public void negativeNumber(){
		try {
			demoApplication.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			demoApplication.add("2,-10,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -10,-5");
		}
	}

	@Test
	public void OtherDelimiter(){
		assertEquals(3, demoApplication.add("//;\n1;2"));
	}

	@Test
	public void repetingDelimiter(){
		assertEquals(8, demoApplication.add("//[%%%%]\n1%%%%2%%%%5"));
	}

	@Test
	public void multipleDelimiter(){
		assertEquals(10, demoApplication.add("//[%%%%][;;;]\n1%%%%2%%%%5;;;2"));
	}




}

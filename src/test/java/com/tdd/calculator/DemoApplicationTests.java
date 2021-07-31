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



}

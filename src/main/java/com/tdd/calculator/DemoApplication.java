package com.tdd.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class DemoApplication {

	public static void main(String[] args) {
		DemoApplication demoApplication =new DemoApplication();
		System.out.println(demoApplication.add(""));
	}

	public  int add(String numbers){

		if(numbers.isEmpty()||numbers==null){
			return 0;
		}
		else {
			String delimiter=",";

			String []digits= numbers.split(delimiter);
			int result= sum(digits);
			return result;
		}
	}

	public static int sum(String [] digits) {

		int total = 0;
		for (String num : digits) {
			int temp = Integer.parseInt(num);
			total = total + temp;
		}
		return total;
	}
}

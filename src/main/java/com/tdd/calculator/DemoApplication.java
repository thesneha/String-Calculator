package com.tdd.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class DemoApplication {

	public static void main(String[] args) {
		DemoApplication demoApplication =new DemoApplication();
		System.out.println(demoApplication.add("//;\n1;2"));
	}

	public  int add(String numbers){

		if(numbers.isEmpty()||numbers==null){
			return 0;
		}
		else {
			String delimiter=",";
			if(numbers.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(numbers.charAt(2));
				numbers= numbers.substring(4);
			}

			delimiter=delimiter+ "|\n";
			String []digits= numbers.split(delimiter);
			int result= sum(digits);
			return result;
		}
	}

	public static int sum(String [] digits) {

		int total = 0;
		String exception="";
		for (String num : digits) {
			int temp = Integer.parseInt(num);

			if (temp>1000){
				continue;
			}
			else {
				total=total+temp;
			}
			if(temp<0){
				if (exception.isEmpty()){
					exception=num;
				}
				else {
					exception=exception+","+num;
				}
			}
		}
		if(!exception.isEmpty()){
			throw new IllegalArgumentException("Negatives not allowed: " + exception);
		}
		return total;
	}
}

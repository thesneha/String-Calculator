package com.tdd.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class DemoApplication {

	public static void main(String[] args) {

		// Sample Inputs
		// ""
		//"1"
		//"1,2"
		//"1,2,3,4"
		//"3\n4,5"
		//"1001,1"
		//"//;\n1;2"
		//"//[%%%%]\n1%%%%2%%%%5"
		//"//[%%%%][;;;]\n1%%%%2%%%%5;;;2"
		DemoApplication demoApplication =new DemoApplication();
		System.out.println(demoApplication.add("//[%%%%][;;;]\n1%%%%2%%%%5;;;2"));
	}

	public  int add(String numbers){

		if(numbers.isEmpty()||numbers==null){
			return 0;
		}
		else {
			String delimiter=",";

			if (numbers.contains("[")){
				delimiter=delimiter(numbers);
				numbers=numbers.split("\n")[1];
			}
			else if(numbers.matches("//(.*)\n(.*)")){
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

	public static String delimiter(String numbers){
		Set<String> s= new HashSet<String>();
		Stack<Character> stack = new Stack<Character>();
		String del="";
		for(char c : numbers.toCharArray()){
			if (c=='['){
				stack.push(c);
			}

			else if(stack.contains('[')&&c!=']'){
				stack.push(c);
			}
			if (c==']'){
				while (stack.size()>1){
					del=del+stack.pop();

				}
				s.add(del);
				stack.pop();
				del="";
			}
		}

		return s.stream().collect(Collectors.joining("|"));
	}
}

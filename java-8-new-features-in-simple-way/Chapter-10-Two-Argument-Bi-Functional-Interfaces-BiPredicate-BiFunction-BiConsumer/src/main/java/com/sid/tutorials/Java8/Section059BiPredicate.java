/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.function.BiPredicate;

/**
 * @author Lenovo
 *
 */
public class Section059BiPredicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiPredicate<Integer, Integer> biPredicate = (Integer o1, Integer o2) -> {
			return (o1 + o2) % 2 == 0;
		};
		System.out.println(biPredicate.test(20, 10));

		BiPredicate<String, String> validation = (String userName, String password) -> {
			return userName.equals("Sid") && password.equals("sahu");
		};

		System.out.println("Validation : " + validation.test("Sid", "sahu"));
	}

}

/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.function.BiFunction;

import com.sid.tutorials.Java8.data.User;

/**
 * @author Lenovo
 *
 */
public class Section060BiFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> biFunction = (Integer o1, Integer o2) -> {
			Integer returnValue = o1 + o2;
			return returnValue;
		};
		System.out.println(biFunction.apply(10, 20));

		BiFunction<String, String, User> function = (String name, String password) -> {
			return new User(name, password);
		};
		System.out.println(function.apply("Siddhant", "Sahu"));
	}

}

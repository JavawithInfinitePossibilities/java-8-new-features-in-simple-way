/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.function.BiConsumer;

/**
 * @author Lenovo
 *
 */
public class Section063BiConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiConsumer<String, String> biConsumer = (String name, String lastName) -> {
			System.out.println(name +" "+ lastName);
		};
		biConsumer.accept("Siddhant", "Sahu");
	}

}

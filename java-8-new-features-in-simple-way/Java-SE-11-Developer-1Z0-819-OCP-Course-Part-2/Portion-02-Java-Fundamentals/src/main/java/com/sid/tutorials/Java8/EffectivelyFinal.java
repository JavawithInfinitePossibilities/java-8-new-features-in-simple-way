/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class EffectivelyFinal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a local variable and assign it a value
		final int efinal = 1;

		// Local Class created with a single method that
		// uses the efinal local variable just created
		class LocalClass {
			public void printValue() {
				System.out.println("efinal = " + efinal);
			}
		}

		// Execute method on the local class
		new LocalClass().printValue();
	}

}

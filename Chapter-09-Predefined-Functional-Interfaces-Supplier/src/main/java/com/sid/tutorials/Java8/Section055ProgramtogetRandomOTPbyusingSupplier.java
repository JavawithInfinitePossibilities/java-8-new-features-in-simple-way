/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Lenovo <br/>
 *         Generate a random number using custom logic
 *
 */
public class Section055ProgramtogetRandomOTPbyusingSupplier {
	public static Integer random = 1;
	public static Map<Integer, Integer> randomIndicator = new LinkedHashMap<Integer, Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Predicate<Integer> predicate = (Integer i) -> {
			return i < 10;
		};
		Supplier<Integer> supplier = () -> {
			int returnValue = 0;
			do {
				if (predicate.test(random)) {
					returnValue = random << 2;
					if (randomIndicator.containsKey(returnValue)) {
						random++;
						returnValue = random << 2;
					}
					//System.out.println("returnValue : " + returnValue);
					if (returnValue > 10) {
						returnValue = random & returnValue;
						//System.out.println("returnValue & random : " + returnValue);
						if (returnValue <= 0) {
							returnValue = random | returnValue;
							//System.out.println("returnValue | random : " + returnValue);
						}
					}
				} else {
					random = random >> 4;
					returnValue = random;
				}
				random++;
			} while (randomIndicator.containsKey(returnValue));
			if (randomIndicator.containsKey(returnValue)) {
				randomIndicator.put(returnValue, randomIndicator.get(returnValue) + 1);
			} else {
				randomIndicator.put(returnValue, 1);
			}
			return returnValue;
		};

		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(randomIndicator);
	}

}

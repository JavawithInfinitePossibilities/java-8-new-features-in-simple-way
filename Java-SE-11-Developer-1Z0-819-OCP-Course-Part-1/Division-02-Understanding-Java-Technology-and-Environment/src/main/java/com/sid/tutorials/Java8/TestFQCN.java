/**
 * 
 */
package com.sid.tutorials.Java8;

import com.sid.tutorials.Java8.garden.*;
/*import com.sid.tutorials.Java8.nursery.VineVegetable;*/
import com.sid.tutorials.Java8.nursery.*;

/**
 * @author Lenovo
 *
 */
public class TestFQCN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.lang.String str = "I am in the Java training";
		System.out.println(str);
		VineVegetable vine = new VineVegetable();
		vine.main(args);
		com.sid.tutorials.Java8.nursery.VineVegetable.main(args);
		com.sid.tutorials.Java8.garden.VineVegetable.main(args);
	}

}

class VineVegetable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("I am a Local vegetable that grows on a vine.");
	}

}
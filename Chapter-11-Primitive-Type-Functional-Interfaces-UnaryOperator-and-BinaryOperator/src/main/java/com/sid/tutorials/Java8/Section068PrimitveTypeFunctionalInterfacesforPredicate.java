/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import com.sid.tutorials.Java8.data.DummyDataTable;

/**
 * @author Lenovo
 *
 */
public class Section068PrimitveTypeFunctionalInterfacesforPredicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntPredicate predicate = (int i) -> {
			return i % 2 == 0;
		};
		int[] intArrayData = DummyDataTable.intArrayData();

		for (int j : intArrayData) {
			if (predicate.test(j)) {
				System.out.println(j + " is an even number.");
			}
		}

		/**
		 * To convert an array to a list. <br/>
		 * If we try to use Arrays.asList(int[]) it will return an List<int[]> type object which will
		 * contain a single object of an array. <br/>
		 * The type of array must be a Wrapper Class(Integer,FLoat, etc) in case of primitive data
		 * types(int,float,etc) , i.e you can’t pass int a[] but you can pass Integer a[]. <br/>
		 * If you pass int a[],this function will return a List <int a[]> and not List <Integer> , as
		 * “autoboxing” doesn’t happens in this case and int a[] is itself identified as an object and a
		 * List of int array is returned, instead of list of integers , which will give error in various
		 * Collection functions . <br/>
		 * https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
		 * 
		 */
		List<int[]> asList = Arrays.asList(intArrayData);
		List<Integer> collect = Arrays.stream(intArrayData).boxed().collect(Collectors.toList());
		collect.stream().forEach((Integer i) -> {
			if (predicate.test(i)) {
				System.out.println(i + " is an even number.");
			}
		});
	}

}

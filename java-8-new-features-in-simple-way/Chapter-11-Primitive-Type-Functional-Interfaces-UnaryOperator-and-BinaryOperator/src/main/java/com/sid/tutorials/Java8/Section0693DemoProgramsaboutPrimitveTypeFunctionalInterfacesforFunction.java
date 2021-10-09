/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;

import com.sid.tutorials.Java8.data.DummyDataTable;

/**
 * @author Lenovo
 *
 */
public class Section0693DemoProgramsaboutPrimitveTypeFunctionalInterfacesforFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArrayData = DummyDataTable.intArrayData();
		IntFunction<Double> intFunction = (int i) -> {
			return Double.valueOf(i * i);
		};
		for (int j : intArrayData) {
			System.out.println(intFunction.apply(j));
		}
		IntToDoubleFunction intToDoubleFunction = (int i) -> {
			return i * i;
		};
		for (int j : intArrayData) {
			System.out.println(intToDoubleFunction.applyAsDouble(j));
		}
	}

}

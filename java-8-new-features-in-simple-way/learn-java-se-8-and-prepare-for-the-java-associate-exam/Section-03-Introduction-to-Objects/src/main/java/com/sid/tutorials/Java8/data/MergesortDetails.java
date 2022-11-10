/**
 * 
 */
package com.sid.tutorials.Java8.data;

import java.util.Arrays;

/**
 * @author Lenovo
 *
 */
public class MergesortDetails {

	public static void mergeSort(int[] arrayValues) {
		mergeSort(arrayValues, new int[arrayValues.length], 0, arrayValues.length - 1);
	}

	private static void mergeSort(int[] arrayValues, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;
		mergeSort(arrayValues, temp, leftStart, middle);
		mergeSort(arrayValues, temp, middle + 1, rightEnd);
		mergeHalves(arrayValues, temp, leftStart, rightEnd);
	}

	private static void mergeHalves(int[] arrayValues, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = (rightEnd - leftStart) + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while ((left <= leftEnd) && (right <= rightEnd)) {
			if (arrayValues[left] < arrayValues[right]) {
				temp[index] = arrayValues[left];
				left++;
			} else {
				temp[index] = arrayValues[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arrayValues, left, temp, index, (leftEnd - left) + 1);
		System.arraycopy(arrayValues, right, temp, index, (rightEnd - right) + 1);
		System.arraycopy(temp, leftStart, arrayValues, leftStart, size);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrayValue = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Before : " + Arrays.toString(arrayValue));
		mergeSort(arrayValue);
		System.out.println("After : " + Arrays.toString(arrayValue));
	}

}

/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 *
 */
public class Chapter03LambdaExpressionswithCollections {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> rawMap = new HashMap<String, String>();
		rawMap.put("EDI234IFD", ",526,32,63,");
		rawMap.put("ETI274IGS", ",,1,,");
		rawMap.put("ETI277IGS", ",,58,,");
		rawMap.put("EVI534IFR", ",5,532,8,");
		rawMap.put("EAI234EFT", "");
		rawMap.put("EFI134ICG", "");
		rawMap.put("EJH234IED", ",985,52,98,");
		System.out.println(rawMap);
		Map<String, String> resultMap = sortMapByValue(rawMap);
		System.out.println(resultMap);
	}

	private static Map<String, String> sortMapByValue(Map<String, String> rawMap) {
		List<Entry<String, String>> rawArraylist = new ArrayList<Map.Entry<String, String>>(rawMap.entrySet());
		Collections.sort(rawArraylist, (Entry<String, String> obj1, Entry<String, String> obj2) -> {
			String[] arr1Split = Arrays.stream(obj1.getValue().split(",")).map(value -> {
				if (value == null || value.isEmpty()) {
					return "0";
				} else {
					return value;
				}
			}).toArray(String[]::new);
			String[] arr2Split = Arrays.stream(obj2.getValue().split(",")).map(value -> {
				if (value == null || value.isEmpty()) {
					return "0";
				} else {
					return value;
				}
			}).toArray(String[]::new);
			/**
			 * this will make the small array equal to large array
			 */
			if (arr1Split.length > arr2Split.length) {
				arr2Split = arrayOneCopyToArrayTwo(arr1Split, arr2Split);
			} else {
				arr1Split = arrayOneCopyToArrayTwo(arr2Split, arr1Split);
			}
			/**
			 * Do the comparision
			 */
			int tempLength = arr1Split.length;
			for (int i = 0; i < tempLength; i++) {
				if (Integer.parseInt(arr1Split[i]) == Integer.parseInt(arr2Split[i])) {
					continue;
				} else {
					return (Integer.parseInt(arr1Split[i]) > Integer.parseInt(arr2Split[i])) ? -1 : 1;
				}
			}
			return 0;
		});
		Map<String, String> resultMap = rawArraylist.stream().collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));
		return resultMap;
	}

	private static String[] arrayOneCopyToArrayTwo(String[] arr1Split, String[] arr2Split) {
		int tempLengthSmall = arr2Split.length;
		int templengthBig = arr1Split.length;
		String[] tempString = new String[templengthBig];
		System.arraycopy(arr2Split, 0, tempString, 0, tempLengthSmall);
		for (int i = tempLengthSmall; i < templengthBig; i++) {
			tempString[i] = "0";
		}
		arr2Split = new String[templengthBig];
		arr2Split = tempString;
		return arr2Split;
	}

}

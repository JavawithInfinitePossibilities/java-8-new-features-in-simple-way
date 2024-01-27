package com.sid.tutorials.Java8.parallelstream;

import static com.sid.tutorials.Java8.util.CommonUtil.*;

import java.util.List;
import java.util.stream.Collectors;

import com.sid.tutorials.Java8.domain.DataDemo;
import com.sid.tutorials.Java8.util.LoggerUtil;

public class StringTransforExample {

	public static void main(String[] args) {
		stopWatch.start();
		List<String> namesList = DataDemo.builder().build().getNameList();
		System.out.println("namesList : " + namesList);
		List<String> namesListUpperCase = namesList.stream()
				.map((name) -> DataDemo.builder().build().addNameLengthTransform(name))
				.collect(Collectors.toList());
		stopWatch.stop();
		LoggerUtil.log("Time taken : " + stopWatch.getTime());
		LoggerUtil.log("namesListUpperCase : " + namesListUpperCase);
	}
}

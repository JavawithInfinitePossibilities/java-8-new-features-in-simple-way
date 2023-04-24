package com.sid.tutorials.Java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sid.tutorials.Java8.services.ParallelStreamPerformance;
import com.sid.tutorials.Java8.util.DataSet;

class ParallelStreamPerformanceTest {

	ParallelStreamPerformance intStreamExample = new ParallelStreamPerformance();

	@ParameterizedTest
	@ValueSource(booleans = { false, true })
	void sum_using_intstream(boolean value) {
		// given
		// when
		int sum = intStreamExample.sum_using_intstream(1000000, value);
		System.out.println("sum : " + sum);
		// then
		assertEquals(1784293664, sum);
	}

	@ParameterizedTest
	@ValueSource(booleans = { false, true })
	void sum_using_iterate(boolean value) {
		// given
		// when
		int sum = intStreamExample.sum_using_iterate(1000000, value);
		System.out.println("sum : " + sum);
		// then
		assertEquals(1784293664, sum);
	}

	@ParameterizedTest
	@ValueSource(booleans = { false, true })
	void sum_using_list(boolean value) {
		// given
		int size = 1000000;
		ArrayList<Integer> inputList = DataSet.generateArrayList(size);
		// when
		int sum = intStreamExample.sum_using_list(inputList, value);
		System.out.println("sum : " + sum);
		// then
		assertEquals(1784293664, sum);
	}

}
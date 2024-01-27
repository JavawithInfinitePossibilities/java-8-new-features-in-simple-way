package com.sid.tutorials.Java8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Section05GettingstartedwithParallelStreamsTest {

	@Test
	public void testParallelStreamtest() {
		/* boolean isParallel = false; */
		GettingStartedWithParallelStreams.builder().build().parallelStreamName();
	}

	@ParameterizedTest
	@ValueSource(booleans = { false, true })
	public void testParalleltest(boolean isParallel) {
		/* boolean isParallel = false; */
		GettingStartedWithParallelStreams.builder().build().parallelAndSequential(isParallel);
	}

	@Test
	public void testParallelStreamNameLowerCaseAssignment() {
		/* boolean isParallel = false; */
		GettingStartedWithParallelStreams.builder().build().parallelStreamNameLowerCaseAssignment();
	}

}

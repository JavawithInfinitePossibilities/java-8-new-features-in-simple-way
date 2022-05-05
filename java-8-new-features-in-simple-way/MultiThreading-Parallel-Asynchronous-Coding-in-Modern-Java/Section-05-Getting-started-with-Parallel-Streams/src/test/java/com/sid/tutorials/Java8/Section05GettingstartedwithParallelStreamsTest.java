package com.sid.tutorials.Java8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Section05GettingstartedwithParallelStreamsTest {

	@ParameterizedTest
	@ValueSource(booleans = { true, false })
	@Test
	public void testParalleltest(boolean isParallel) {
		/*boolean isParallel = false;*/
		GettingStartedWithParallelStreams.builder().build().parallelAndSequential(isParallel);
	}

}

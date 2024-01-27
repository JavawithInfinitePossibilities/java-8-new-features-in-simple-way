package com.sid.tutorials.Java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.sid.tutorials.Java8.completablefuture.CompletableFutureHelloWorld;
import com.sid.tutorials.Java8.services.HelloWorldService;

import static com.sid.tutorials.Java8.util.CommonUtil.*;
import static com.sid.tutorials.Java8.util.LoggerUtil.log;

class Section12ExploringCompletableFutureFunctionTest {

	HelloWorldService hws = new HelloWorldService();
	CompletableFutureHelloWorld cfhw = new CompletableFutureHelloWorld(hws);

	@Disabled
	@Test
	void helloWorld() {
		// when
		CompletableFuture<String> completableFuture = cfhw.helloWorld();
		// then
		completableFuture.thenAccept(s -> {
			assertEquals("HELLO WORLD", s);
		}).join();
		log("Done!");
	}

	@Disabled
	@Test
	void helloworld_muliple_async_calls() {
		// when
		String helloWorld = cfhw.helloworld_muliple_async_calls();
		// then
		assertEquals("HELLO WORLD!", helloWorld);
	}

	@Disabled
	@Test
	void helloworld_3_async_calls() {
		// when
		String helloWorld = cfhw.helloworld_3_async_calls();
		// then
		assertEquals("HELLO WORLD!HI COMPLETABLEFUTURE", helloWorld);
	}

	@Test
	void helloWorld_thenCompose() {
		// given
		startTime();
		// when
		CompletableFuture<String> completableFuture = cfhw.helloWorld_thenCompose();
		// then
		completableFuture.thenAccept(s -> {
			assertEquals("HELLO WORLD!", s);
		}).join();
		timeTaken();
	}

}

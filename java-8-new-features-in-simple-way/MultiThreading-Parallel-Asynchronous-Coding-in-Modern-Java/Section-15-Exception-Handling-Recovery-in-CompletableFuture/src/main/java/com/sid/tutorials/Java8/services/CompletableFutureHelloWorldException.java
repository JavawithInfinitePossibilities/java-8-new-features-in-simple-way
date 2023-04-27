package com.sid.tutorials.Java8.services;

import java.util.concurrent.CompletableFuture;

import lombok.AllArgsConstructor;

import static com.sid.tutorials.Java8.util.LoggerUtil.*;
import static com.sid.tutorials.Java8.util.CommonUtil.*;

@AllArgsConstructor
public class CompletableFutureHelloWorldException {

	private HelloWorldService hws;

	public String helloworld_3_async_calls_handle() {
		startTime(true);
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> hws.hello());
		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> hws.world());
		CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
			delay(1000);
			return " Hi CompletableFuture!";
		});
		String hw = hello.handle((res, e) -> {
			log("Exception is :" + e.getMessage());
			return "";
		}).thenCombine(world, (helloresult, worldresult) -> helloresult + worldresult) // " world!"
				.thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
				// " world! Hi CompletableFuture!"
				.thenApply(String::toUpperCase) // " WORLD! HI COMPLETABLEFUTURE!"
				.join(); // " WORLD! HI COMPLETABLEFUTURE!"

		timeTaken();
		return hw;
	}

	public String helloworld_3_async_calls_2handle() {
		startTime(true);
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> hws.hello());
		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> hws.world());
		CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
			delay(1000);
			return " Hi CompletableFuture!";
		});

		String hw = hello.handle((res, e) -> {
			if (e != null) {
				log("Exception is :" + e.getMessage());
				return "";
			} else {
				return res;
			}
		}).thenCombine(world, (helloresult, worldresult) -> helloresult + worldresult) // " world!"
				.handle((res, e) -> {
					if (e != null) {
						log("Exception after world is :" + e.getMessage());
						return "";
					} else {
						return res;
					}
				}).thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
				// " Hi CompletableFuture!"
				.thenApply(String::toUpperCase) // " HI COMPLETABLEFUTURE!"
				.join(); // " HI COMPLETABLEFUTURE!"

		timeTaken();
		return hw;
	}

	public String helloworld_3_async_calls_exceptionally() {
		startTime(true);
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> hws.hello());
		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> hws.world());
		CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
			delay(1000);
			return " Hi CompletableFuture!";
		});
		String hw = hello // hello
				.exceptionally((e) -> {
					log("Exception is :" + e.getMessage());
					return "";
				}).thenCombine(world, (helloresult, worldresult) -> helloresult + worldresult) // "h-> ""
				.exceptionally((e) -> {
					log("Exception after world is :" + e.getMessage());
					return "";
				}).thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
				// " Hi CompletableFuture!"
				.thenApply(String::toUpperCase) // " HI COMPLETABLEFUTURE!"
				.join(); // " HI COMPLETABLEFUTURE!"

		timeTaken();
		return hw;
	}

	public String helloworld_3_async_calls_whenhandle() {
		startTime(true);
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> hws.hello());
		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> hws.world());
		CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
			delay(1000);
			return " Hi CompletableFuture!";
		});
		String hw = hello // hello
				.whenComplete((res, e) -> {
					log("res is :" + res);
					if (e != null) {
						log("Exception is :" + e.getMessage());
					}
				}).thenCombine(world, (helloresult, worldresult) -> helloresult + worldresult) // "hello world!"
				.whenComplete((res, e) -> {
					log("res is :" + res);
					if (e != null) {
						log("Exception after world is :" + e.getMessage());
					}
				}).exceptionally((e) -> {
					log("Exception after thenCombine is :" + e.getMessage());
					return "";
				}).thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
				// " Hi CompletableFuture!"
				.thenApply(String::toUpperCase) // " HI COMPLETABLEFUTURE!"
				.join(); // " HI COMPLETABLEFUTURE!"

		timeTaken();
		return hw;
	}
}

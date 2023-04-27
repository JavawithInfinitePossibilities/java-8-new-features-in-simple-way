package com.sid.tutorials.Java8.completablefuture;

import static com.sid.tutorials.Java8.util.CommonUtil.*;
import static com.sid.tutorials.Java8.util.LoggerUtil.log;

import java.util.concurrent.CompletableFuture;

import com.sid.tutorials.Java8.services.HelloWorldService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CompletableFutureHelloWorld {
	private HelloWorldService hws;

	public CompletableFuture<String> helloWorld() {
		CompletableFuture<String> resultValue = CompletableFuture.supplyAsync(() -> {
			return hws.helloWorld();
		}).thenApply((result) -> {
			return result.toUpperCase();
		});
		delay(2000);
		return resultValue;
	}

	public String helloWorld_approach1() {
		String hello = hws.hello();
		String world = hws.world();
		return hello + world;
	}

	public String helloworld_muliple_async_calls() {
		startTime(true);
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> hws.hello());
		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> hws.world());
		String helloWorld = hello.thenCombine(world, (helloResult, worldResult) -> {
			// first, second
			return helloResult + worldResult;
		}).thenApply(String::toUpperCase).join();
		timeTaken();
		return helloWorld;
	}

	public String helloworld_3_async_calls() {
		startTime(true);
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			return hws.hello();
		});
		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			return hws.world();
		});
		CompletableFuture<String> hiComFuture = CompletableFuture.supplyAsync(() -> {
			delay(1000);
			return "Hi CompletableFuture";
		});
		String helloWorld3HiComfuture = hello.thenCombine(world, (helloResult, worldResult) -> {
			return helloResult + worldResult;
		}).thenCombine(hiComFuture, (helloWorldResult, hiComFutureResult) -> {
			return helloWorldResult + hiComFutureResult;
		}).thenApply(String::toUpperCase).join();
		timeTaken();
		return helloWorld3HiComfuture;
	}

	public CompletableFuture<String> helloWorld_thenCompose() {
		return CompletableFuture.supplyAsync(() -> hws.hello()).thenCompose((previous) -> hws.worldFuture(previous))
				.thenApply(String::toUpperCase);
	}

	public static void main(String[] args) {
		HelloWorldService hws = new HelloWorldService();
		CompletableFuture.supplyAsync(hws::helloWorld).thenApply(String::toUpperCase).thenAccept((result) -> {
			log("Result is : " + result);
		}).join();
		log("Done!");
		// delay(2000);
	}
}

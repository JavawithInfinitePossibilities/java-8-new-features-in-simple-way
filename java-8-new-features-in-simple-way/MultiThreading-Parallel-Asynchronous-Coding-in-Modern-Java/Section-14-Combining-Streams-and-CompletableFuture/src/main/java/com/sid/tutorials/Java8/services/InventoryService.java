package com.sid.tutorials.Java8.services;

import static com.sid.tutorials.Java8.util.CommonUtil.delay;

import java.util.concurrent.CompletableFuture;

import com.sid.tutorials.Java8.domain.Inventory;
import com.sid.tutorials.Java8.domain.ProductOption;

public class InventoryService {
	public Inventory addInventory(ProductOption productOption) {
		delay(500);
		return Inventory.builder().count(2).build();

	}

	public CompletableFuture<Inventory> addInventory_CF(ProductOption productOption) {
		return CompletableFuture.supplyAsync(() -> {
			delay(500);
			return Inventory.builder().count(2).build();
		});

	}

	public Inventory retrieveInventory(ProductOption productOption) {
		delay(500);
		return Inventory.builder().count(2).build();

	}
}

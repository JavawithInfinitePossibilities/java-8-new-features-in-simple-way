package com.sid.tutorials.Java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sid.tutorials.Java8.domain.Cart;
import com.sid.tutorials.Java8.domain.CheckoutResponse;
import com.sid.tutorials.Java8.domain.CheckoutStatus;
import com.sid.tutorials.Java8.services.CheckoutService;
import com.sid.tutorials.Java8.services.PriceValidatorService;
import com.sid.tutorials.Java8.util.DataSet;

class Section06BuildRetailCheckoutApplicationTest {

	@Disabled
	@Test
	void no_Of_cores() {
		// given

		// when
		System.out.println("no of cores :" + Runtime.getRuntime().availableProcessors());

		// then
	}

	@ParameterizedTest
	@ValueSource(ints = { 4, 6, 8, 12, 16, 20 })
	void checkoutitems(int noOfCartItem) {
		System.out.println("no of cores :" + Runtime.getRuntime().availableProcessors());
		PriceValidatorService priceValidatorService = new PriceValidatorService();
		CheckoutService checkoutService = CheckoutService.builder().priceValidatorService(priceValidatorService)
				.build();
		boolean isParallel = true;
		System.out.println("No of cart :" + noOfCartItem + " isParallel:" + isParallel);
		Cart cart = DataSet.createCart(noOfCartItem);
		// when
		CheckoutResponse checkoutResponse = checkoutService.checkout(cart, isParallel);
		// then
		if (noOfCartItem == 6 || noOfCartItem == 4) {
			assertEquals(CheckoutStatus.SUCCESS, checkoutResponse.getCheckoutStatus());
		} else if (noOfCartItem == 12) {
			assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
		}
	}

}

package com.sid.tutorials.Java8.services;

import static com.sid.tutorials.Java8.util.CommonUtil.startTime;
import static com.sid.tutorials.Java8.util.CommonUtil.timeTaken;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sid.tutorials.Java8.domain.Cart;
import com.sid.tutorials.Java8.domain.CartItem;
import com.sid.tutorials.Java8.domain.CheckoutResponse;
import com.sid.tutorials.Java8.domain.CheckoutStatus;

import lombok.Builder;

public class CheckoutService {

	private PriceValidatorService priceValidatorService;

	@Builder
	public CheckoutService(PriceValidatorService priceValidatorService) {
		this.priceValidatorService = priceValidatorService;
	}

	public CheckoutResponse checkout(Cart cart, boolean isParallel) {
		startTime(true);
		Stream<CartItem> cartStream = cart.getCartItemList().stream();
		if (isParallel) {
			cartStream = cartStream.parallel();
		}
		List<CartItem> priceValidationList = cartStream.map(cartItem -> {
			boolean isPriceInvalid = priceValidatorService.isCartItemInvalid(cartItem);
			cartItem.setExpired(isPriceInvalid);
			return cartItem;
		}).filter(CartItem::isExpired).collect(Collectors.toList());

		timeTaken();
		if (priceValidationList.size() > 0) {
			return new CheckoutResponse(CheckoutStatus.FAILURE, priceValidationList);
		}
		return new CheckoutResponse(CheckoutStatus.SUCCESS);
	}

}

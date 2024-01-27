package com.sid.tutorials.Java8.thread;

import com.sid.tutorials.Java8.domain.Product;
import com.sid.tutorials.Java8.domain.ProductInfo;
import com.sid.tutorials.Java8.domain.Review;
import com.sid.tutorials.Java8.services.ProductInfoService;
import com.sid.tutorials.Java8.services.ReviewService;
import static com.sid.tutorials.Java8.util.CommonUtil.stopWatch;
import static com.sid.tutorials.Java8.util.LoggerUtil.log;

import lombok.Getter;

public class ProductServiceUsingThread {
	private ProductInfoService productInfoService;
	private ReviewService reviewService;

	public ProductServiceUsingThread(ProductInfoService productInfoService, ReviewService reviewService) {
		this.productInfoService = productInfoService;
		this.reviewService = reviewService;
	}

	public Product retrieveProductDetails(String productId) throws InterruptedException {
		stopWatch.start();
		ProductInfoRunnable productInfoRunnable = new ProductInfoRunnable(productId);
		Thread productInfoThread = new Thread(productInfoRunnable);

		ReviewRunable reviewRunnable = new ReviewRunable(productId);
		Thread reviewThread = new Thread(reviewRunnable);

		productInfoThread.start();
		reviewThread.start();

		productInfoThread.join();
		reviewThread.join();

		ProductInfo productInfo = productInfoRunnable.getProductInfo();
		Review review = reviewRunnable.getReview();

		stopWatch.stop();
		log("Total Time Taken : " + stopWatch.getTime());
		return new Product(productId, productInfo, review);
	}

	public static void main(String[] args) throws InterruptedException {
		ProductInfoService productInfoService = new ProductInfoService();
		ReviewService reviewService = new ReviewService();
		ProductServiceUsingThread productService = new ProductServiceUsingThread(productInfoService, reviewService);
		String productId = "ABC123";
		Product product = productService.retrieveProductDetails(productId);
		log("Product is " + product);
	}

	private class ProductInfoRunnable implements Runnable {
		private String productId;
		@Getter
		private ProductInfo productInfo;

		public ProductInfoRunnable(String productId) {
			this.productId = productId;
		}

		@Override
		public void run() {
			productInfo = productInfoService.retrieveProductInfo(productId);
		}
	}

	private class ReviewRunable implements Runnable {
		private String productId;
		@Getter
		private Review review;

		public ReviewRunable(String productId) {
			this.productId = productId;
		}

		@Override
		public void run() {
			review = reviewService.retrieveReviews(productId);
		}
	}
}

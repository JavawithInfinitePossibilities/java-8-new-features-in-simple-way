/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class Section06JavaConventionsandPrimitivesApp {
	/**
	 * weight conversion rates
	 */
	// conversion rate for 1 kilogram to pounds
	public static double kilogramToPounds = 2.2046;
	// conversion rate for 1 kilogram to grams
	public static int kilogramToGrams = 1000;
	// conversion rate for 1 kilogram to weight ounces
	public static double kilogramToOunces = 35.274d;
	/**
	 * volume conversion rates
	 */
	// conversion rate for 1 liter to fluid ounces
	public static float literToFluidOunce = 33.814f;
	// conversion rate for 1 liter to gallons
	public static float literToGallon = 0.2642f;
	// conversion rate for 1 liter to pints
	public static float literToPints = 2.1134f;
	// conversion rate for 1 liter to milliliters
	public static short litertoMilliliters = 1_000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ConversionService.fluidOunces(1.1f));
		System.out.println(ConversionService.gallons(2.2f));
		System.out.println(ConversionService.grams(30));
		System.out.println(ConversionService.milliliters(40));
		System.out.println(ConversionService.ounces(50));
		System.out.println(ConversionService.pints(6.6f));
		System.out.println(ConversionService.pounds(7.7));
		// can you figure out why these do not compile
		ConversionService.fluidOunces((float) 1.1);
		ConversionService.grams((int) 30L);
		ConversionService.milliliters((int) 4.0);
		short grams = (short) ConversionService.grams(30);
		byte byteGrams = (byte) ConversionService.grams(30);
		// why do these still work even though the types are different
		// System.out.println("------------------------------------");
		double ounces = ConversionService.fluidOunces(1.1f);
		System.out.println(ounces);
		long milliliters = ConversionService.milliliters(40);
		System.out.println(milliliters);
		double decimalMilliliters = ConversionService.milliliters(40);
		System.out.println(decimalMilliliters);
		short s = 30;
		System.out.println(ConversionService.grams(s));
		byte b = 4;
		System.out.println(ConversionService.milliliters(b));
		char z = 'z';
		System.out.println(ConversionService.milliliters(z));
		System.out.println(ConversionService.gallons(200));
		System.out.println(ConversionService.ounces(50.5f));
		System.out.println(ConversionService.pints(6L));
		System.out.println(ConversionService.pounds(7L));
		// compare these results. Can you tell why they are different?
		System.out.println("------------------------------------");
		float bigGallons = ConversionService.gallons(123456789123456789L);
		System.out.println(bigGallons);
		double bigGallons2 = 123456789123456789L * 0.2642;
		System.out.println(bigGallons2);
		System.out.println("------------------------------------");
		int bigGrams = ConversionService.grams(1234567890);
		System.out.println(bigGrams);
		long bigGrams2 = 1234567890L * 1000L;
		System.out.println(bigGrams2);
	}

}

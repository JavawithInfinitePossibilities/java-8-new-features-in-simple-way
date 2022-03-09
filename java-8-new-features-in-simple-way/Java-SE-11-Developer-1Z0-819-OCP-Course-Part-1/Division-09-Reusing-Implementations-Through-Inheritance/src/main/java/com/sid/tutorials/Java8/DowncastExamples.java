/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class DowncastExamples {

	public static void main(String[] args) {
		DowncastExamples dex = new DowncastExamples();

		// We create instances of Dog and Cat but assign them to
		// variables of type Animal
		AnimalInheritances genericDog = new DogInheritances();
		AnimalInheritances genericCat = new Cat();

		// We cast now:
		dex.testDog((DogInheritances) genericDog);
		dex.testCat((Cat) genericCat);

		// Try the overloaded methods with
		// specifically typed variables.
		dex.testAnimal((DogInheritances) genericDog);
		dex.testAnimal((Cat) genericCat);

		// Try the overloaded methods with
		// generically typed variables.
		dex.testAnimal(genericDog);
		dex.testAnimal(genericCat);
	}

	// Three Overloaded methods
	public void testAnimal(AnimalInheritances animal) {
		System.out.println("Executing testAnimal with Animal type");
		animal.printAnimal();
	}

	public void testAnimal(Cat cat) {
		System.out.println("Executing testAnimal with Cat type");
		cat.printAnimal();
	}

	public void testAnimal(DogInheritances dog) {
		System.out.println("Executing testAnimal with Dog type");
		dog.printAnimal();
	}

	// Specifically Typed method calls
	public void testDog(DogInheritances dog) {
		dog.printDog();
	}

	public void testCat(Cat cat) {
		cat.printCat();
	}
}

//Animal is our base class
class AnimalInheritances {
	public void printAnimal() {
		System.out.println("I am an animal");
	}
}

//Dog is a subclass of Animal
class DogInheritances extends AnimalInheritances {
	public void printDog() {
		System.out.println("I am a dog");
	}
}

//Cat is also a subclass of Animal
class Cat extends AnimalInheritances {
	public void printCat() {
		System.out.println("I am a cat");
	}
}
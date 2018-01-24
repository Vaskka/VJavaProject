/*
javac com/vaskka/learn/grammar/inherit/inherit.java
java com/vaskka/learn/grammar/inherit/Program

继承

*/

package com.vaskka.learn.grammar.inherit;



class Animal {
	protected int age;


	public Animal(String s) {
		System.out.println("this animal is created");
	}

	protected void move() {
		System.out.println("this animal is moving");
	}

	public void breathe() {
		System.out.println("this animal is breathe");
	}

}

class Dog extends Animal {

	public Dog() {
		super(null);
		System.out.println("this dog is created");
		this.age = 2;
	}

	@Override
	public void breathe() {
		System.out.println("the dog is breahting");
	}

	public void showAge() {
		this.age += 17;
		System.out.println("this dog's age is " + String.valueOf(super.age));
	}

	public void howl() {
		System.out.println("the dog is howling");
	}

}

class Cat extends Animal {
	public Cat() {
		super(null);
	}

	public void maimeng() {
		System.out.println("the cat is maimeng");
	}
}


class Program{
	public static void main(String[] argc){
		Animal oneAnimal = new Animal("");
		Dog oneDog = new Dog();
		Cat oneCat = new Cat();

		oneAnimal.move();
		oneAnimal.breathe();

		oneDog.move();
		oneDog.breathe();
		oneDog.howl();
		oneDog.showAge();
		oneCat.move();
		oneCat.breathe();
		oneCat.maimeng();

	}
}

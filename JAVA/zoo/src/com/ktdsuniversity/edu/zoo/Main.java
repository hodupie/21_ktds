package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Animal;
import com.ktdsuniversity.edu.zoo.inf.Crawlable;
import com.ktdsuniversity.edu.zoo.inf.Flyable;
import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Main {
	
	public static void move(Animal animal) {
		animal.eat();
		animal.bark();
		//만약 animal이 Walkbale의 객체라면
		if (animal instanceof Walkable) {
			((Walkable) animal).walk();
		}
		if (animal instanceof Runable) {
			((Runable) animal).run();
		}
		if (animal instanceof Flyable) {
			((Flyable) animal).fly();
		}
		if (animal instanceof Swimable) {
			((Swimable) animal).swim();
		}
		if (animal instanceof Crawlable) {
			((Crawlable) animal).crawl();
		}
	}
	
	public static void main(String[] args) {
		Animal lion = new Lion("메리");
		Animal duck = new Duck("꽉꽉이");
		Animal penguin = new Penguin("상큼이");
		
		move(lion);
		move(duck);
		move(penguin);
		
	}
}

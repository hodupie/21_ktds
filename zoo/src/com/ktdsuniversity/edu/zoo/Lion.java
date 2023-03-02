package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Lion implements Runable, Walkable, Swimable {

	private String name;
	
	public Lion(String name) {
		this.name = name;
	}
	
	@Override
	public void eat() {
		System.out.println(name + "는 사자. 사자는 사람을 찢어");		
	}

	@Override
	public void bark() {
		System.out.println(name + "는 사자. 사자는 어흥");
	}

	@Override
	public void swim() {
		System.out.println("사자가 수영을 잘하나?");
		
	}

	@Override
	public void walk() {
		System.out.println("사자 걷는다");
		
	}

	@Override
	public void run() {
		System.out.println("사자 뛴다");
	}

}

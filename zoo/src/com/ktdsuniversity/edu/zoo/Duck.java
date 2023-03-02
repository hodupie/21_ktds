package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Duck implements Walkable, Swimable{
	
	private String name;
	
	public Duck (String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(name + "는 오리. 오리는 사료를 먹지만 사람은 오리고기를 먹지");
	}

	@Override
	public void bark() {
		System.out.println(name + "는 오리. 오리는 꽥꽥");
	}

	@Override
	public void swim() {
		System.out.println("오리는 오리발");
	}

	@Override
	public void walk() {
		System.out.println("오리는 뒤뚱뒤뜅");
	}
	
	

}

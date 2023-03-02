package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Flyable;
import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Penguin implements Flyable, Runable, Swimable, Walkable{
	
	private String name;
	
	public Penguin (String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(name + "는 펭귄. 펭귄은 물고기를 먹나");
	}

	@Override
	public void bark() {
		System.out.println(name + "는 퓅귄. 펭귄도 꽥꽥 울던가");
	}

	@Override
	public void walk() {
		System.out.println("펭귄 걷는거 귀여움");
	}

	@Override
	public void swim() {
		System.out.println("펭귄 수영 천재");
	}

	@Override
	public void run() {
		System.out.println(name + "는 펭귄. 펭귄도 급하면 뛴다");
	}

	@Override
	public void fly() {
		System.out.println("펭귄의 꿈");
	}
	
	

}

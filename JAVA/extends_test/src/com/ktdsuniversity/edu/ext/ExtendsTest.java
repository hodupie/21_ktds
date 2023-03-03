package com.ktdsuniversity.edu.ext;

public class ExtendsTest {
	
	public static void print(Address address) {
		System.out.println(address.getName());
		System.out.println(address.getPhoneNumber());
		System.out.println(address.getAddress());
		
		if (address instanceof Friends) {
			//type casting
			Friends friend = (Friends) address;
			System.out.println(friend.getBirthday());
		}
	}
	
	public static void main(String[] args) {
		
		Friends friend = new Friends();
		friend.setName("호두파이");
		friend.setBirthday("2020-05-23");
		print(friend);
	}

}

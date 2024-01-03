package com.qa.adminTest;

import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int number = rnd.nextInt(999999);
		String manufacture="test_"+new Random().nextInt(999999);
		System.out.println(manufacture);

	}

}

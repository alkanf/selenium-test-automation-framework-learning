package day4.pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {

	@Test
	void abc () {
		System.out.println("This is abc from c1");
	}
	
	@BeforeTest
	void beforeTest() {
		System.out.println("This beforeTest method from C1");
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("This aftereTest method from C1");
	}
}

package day4.pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	@BeforeSuite
	void beforeSuite() {
		System.out.println("This is before suit method from c3");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("This is after suit method from c3");
	}
	@Test(priority=3)
	void test() {
		System.out.println("This is 123 from C3");
	}

}

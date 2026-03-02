package day3;

import org.testng.annotations.Test;

/*
 * Open
 * Login
 * Logout
 */
public class FirstTestCase {

	@Test(priority=1)
	void open() {
		System.out.println("Software is opened");
	}
	
	@Test(priority=2)
	void login() {
		System.out.println("User is logged in");
	}
	
	@Test(priority=3)
	void logout() {
		System.out.println("User is logged out");
	}
	
	
	
	
	
	
	
	
	
}

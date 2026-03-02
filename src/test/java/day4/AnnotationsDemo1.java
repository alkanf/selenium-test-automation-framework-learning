package day4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1)Login --@BeforeMethod
 * 2)Search -- @Test
 * 3)Logout --@AfterMethod
 * 4)Login
 * 5)Advanced Search -- @Test
 * 6)Logout
 */
public class AnnotationsDemo1 {

@BeforeMethod
void login() {
	System.out.println("User login");
}

@AfterMethod
void logout() {
	System.out.println("User logout");
}

@Test(priority=1)
void search () {
	System.out.println("User is searching");
}

@Test(priority=2)
void advancedSearch() {
	System.out.println("User is advanced searching");
}




}

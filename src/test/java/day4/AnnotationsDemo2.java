package day4;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1)Login --@BeforeClass
 * 2)Search -- @Test
 * 5)Advanced Search -- @Test
 * 6)Logout --@AfterClass
 */
public class AnnotationsDemo2 {

@BeforeClass
void login() {
	System.out.println("User login");
}

@AfterClass
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

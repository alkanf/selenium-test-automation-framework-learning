package day5;

import org.testng.annotations.Test;

public class LoginTest {

@Test(groups="sanity")
void loginWithEmail() {
	System.out.println("Logged in with e-mail");
}

@Test(groups="sanity")
void loginWithNumber() {
	System.out.println("Logged in with number");
}

@Test(groups="sanity")
void loginWithUsername() {
	System.out.println("Logged in with username");
}

}

package day5;

import org.testng.annotations.Test;

public class SignupTest {

@Test(groups="regression")
void signupWithEmail() {
	System.out.println("Sign up with e-mail");
}

@Test(groups="regression")
void signupWithNumber() {
	System.out.println("Sign up with number");
}

@Test(groups="regression")
void signupWithUsername() {
	System.out.println("Sign up with username");
}

}

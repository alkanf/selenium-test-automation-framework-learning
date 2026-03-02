package day5;

import org.testng.annotations.Test;

public class PaymentTest {

@Test(groups={"regression","sanity","reg+san"})
void payWithCard() {
	System.out.println("Sign up with e-mail");
}

@Test(groups={"regression","sanity","reg+san"})
void payWithNumber() {
	System.out.println("Sign up with number");
}


}

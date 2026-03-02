package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {


		@Test
		void hardAssertion() {
		System.out.println("Testing");
		System.out.println("Testing");
		
		Assert.assertEquals(1, 2);//If the assertion would fail rest of code wont work
		
		System.out.println("After Validation");
		System.out.println("After Validation");
		}

		@Test
		void softAssertion() {
		System.out.println("Testing");
		System.out.println("Testing");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);//If the assertion would fail rest of code wont work
		
		System.out.println("After Validation");
		System.out.println("After Validation");
		sa.assertAll();
		
		}
	}



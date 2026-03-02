package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
void AssertMethod() {

        String expTitle = "Opencart";
        String actTitle = "Cart";
/*
        if (expTitle.equals(actTitle)) {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
        } else {
            System.out.println("Test Failed");
            Assert.assertTrue(false);

        }
        */
        Assert.assertEquals(expTitle, actTitle);

}
}
    

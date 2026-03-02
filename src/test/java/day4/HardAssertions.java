package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
public class HardAssertions {
    @Test
	void test() {
	Assert.assertEquals("xyz", "xyzl");
	//Assert.assertNotEquals(123, 123); it will fail
	//Assert.assertTrue(true) //pass
	}
	
	
	
	
	
	
	
}

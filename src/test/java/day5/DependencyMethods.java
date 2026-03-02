package day5;

import org.testng.annotations.Test;
import org.testng.Assert;

public class DependencyMethods {

@Test
void openApp() {
	Assert.assertTrue(true);
}
@Test(dependsOnMethods= {"openApp"})
void loginApp() {
	Assert.assertTrue(false);
}
@Test(dependsOnMethods= {"loginApp"})
void logoutApp() {
	Assert.assertTrue(true);
}

}

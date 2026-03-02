package day8;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {
	
WebDriver driver;
@BeforeClass
void setup() {
driver = new ChromeDriver();
driver.get("https://practicetestautomation.com/practice-test-login/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
void login() {
LoginPagePOM login = new LoginPagePOM(driver);
login.setUserName("student");
login.setPassword("Password123");
login.clickSubmit();
String title = driver.getTitle();
Assert.assertEquals(title, "Logged In Successfully | Practice Test Automation");
}
@AfterClass
void exit() {
	driver.close();
}





}

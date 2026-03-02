package day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	@DataProvider(name="login")
	public Object[][] data() {

	    Object[][] data = {
	        {"standard_us4er", "secret_sauce"},
	        {"djshfs", "secret_sauce"},
	        {"problem_use4r", "secret_sauce"},
	        {"standard_user", "secret_sauce"}
	    };

	    return data;
	}

	@BeforeClass
	void setup() {
	driver = new EdgeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(dataProvider="login")
	void login(String user, String pass) {
	driver.findElement(By.id("user-name")).clear();
	driver.findElement(By.id("user-name")).sendKeys(user);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(pass);
	driver.findElement(By.id("login-button")).click();
	if(driver.findElement(By.xpath("//span[text()='Products']")).getText().equals("Products")) {
	    Assert.assertTrue(true); }
	else {
	    Assert.assertTrue(false);
	}

	}
    @AfterClass
	void quit() {
	driver.quit();

	}

}

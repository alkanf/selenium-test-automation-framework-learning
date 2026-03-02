package day7;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListenerTestDemo {
	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento2-demo.magebit.com/");
	}

	@Test(priority = 1)
	void testTitle() {
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "Magento 2 Commerce (Enterprise) Demo - Magebit");
	}

	@Test(priority = 2)
	void testURL() {
		String url = driver.getCurrentUrl();
		AssertJUnit.assertEquals(url, "https://magento2-demo.magebit.com/");

	}

	@Test(priority = 3)
	void testLogo() {
		boolean logo = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).isDisplayed();
		AssertJUnit.assertEquals(true, logo);
	}

	@AfterClass
	void exit() {
		driver.quit();
	}

}

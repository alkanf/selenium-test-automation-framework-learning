package day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParamTest {
WebDriver driver;
@BeforeClass
@Parameters({"browser"})
void setup(String br) {
switch(br.toLowerCase())
{
case "chrome" : driver=new ChromeDriver(); break;
case "edge" : driver=new EdgeDriver(); break;
case "firefox" : driver=new FirefoxDriver(); break;
default: System.out.println("Invalid Browser"); return;
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://magento2-demo.magebit.com/")
;
}

@Test(priority=1)
void testTitle() {
String title = driver.getTitle();
Assert.assertEquals(title, "Magento 2 Commerce (Enterprise) Demo - Magebit");
}
@Test(priority=2)
void testURL() {
String url = driver.getCurrentUrl();
Assert.assertEquals(url, "https://magento2-demo.magebit.com/");

	
}
	
@Test(priority=3)
void testLogo() {
boolean logo = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).isDisplayed();
Assert.assertEquals(true, logo);
}
	
@AfterClass
void exit() {
driver.quit();
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

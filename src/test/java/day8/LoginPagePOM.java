package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePOM {
//Driver
WebDriver driver;
//1) Constructor
LoginPagePOM(WebDriver driver) {
	this.driver = driver;
}
//2) Locators
By txt_username_loc = By.xpath("//*[@id=\"username\"]");
By txt_password_loc = By.xpath("//*[@id=\"password\"]");
By btn_submit_loc = By.xpath("//*[@id=\"submit\"]");


//3) Actions
void setUserName(String username) {
	driver.findElement(txt_username_loc).sendKeys(username);
}
void setPassword(String password) {
	driver.findElement(txt_password_loc).sendKeys(password);
}
void clickSubmit() {
	driver.findElement(btn_submit_loc).click();
}




}

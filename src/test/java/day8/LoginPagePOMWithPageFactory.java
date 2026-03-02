package day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOMWithPageFactory {
//Driver
	WebDriver driver;

//1) Constructor
	LoginPagePOMWithPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//2) Locators and finding elements
@FindBy(xpath="//*[@id=\"username\"]") WebElement txt_username_loc;
@FindBy(xpath="//*[@id=\"password\"]") WebElement txt_password_loc;
@FindBy(xpath="//*[@id=\"submit\"]") WebElement btn_submit_loc;

//3) Actions
	void setUserName(String username) {
		txt_username_loc.sendKeys(username);
	}

	void setPassword(String password) {
		txt_password_loc.sendKeys(password);
	}

	void clickSubmit() {
		btn_submit_loc.click();
	}

}

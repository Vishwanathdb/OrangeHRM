package VishLimited.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "txtUsername")
	WebElement userName;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(xpath =  "//button[@type='submit']")
	WebElement loginButton;
	
	@Test()
	public HRAdminPage loginToSite(String userName, String password) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		loginButton.click();
		
		HRAdminPage hrObject = new HRAdminPage(driver);
		return hrObject;
	}
	
}

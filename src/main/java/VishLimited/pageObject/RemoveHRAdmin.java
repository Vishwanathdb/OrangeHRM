package VishLimited.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RemoveHRAdmin {

	WebDriver driver;

	public RemoveHRAdmin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//tbody //tr[1] //td[1]")
	WebElement selectEmployee;
	
	@FindBy(css = ".material-icons.icons-color.orange-text")
	WebElement options;
	
	@FindBy(xpath = "//a[text()='Delete Selected']")
	WebElement deleteButton;
	
	@FindBy(id = "save-button")
	WebElement saveButton;
	
	public void deleteHRAdimn() throws InterruptedException {
		
		Thread.sleep(3000);
		// Remove the Employee
		selectEmployee.click();
		options.click();
		deleteButton.click();
		Thread.sleep(3000);
		saveButton.click();

		Thread.sleep(2000);
		// Get Toast Message
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		Assert.assertEquals(toastMessage, "Successfully Deleted");
		System.out.println(toastMessage);
		
		// driver.quit();

	}
}

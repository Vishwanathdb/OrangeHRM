package VishLimited.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditHRAdmin {
	
	WebDriver driver;
	
	public EditHRAdmin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
//	@FindBy(xpath = "//tbody //tr[1] //td[8]")
//	WebElement editButton;
	
	@FindBy(id = "user_name")
	WebElement userName;
	
	@FindBy(id = "modal-save-button")
	WebElement saveButton;
	
	public RemoveHRAdmin updateHRAdmin(String newUserName) throws InterruptedException
	{
		Thread.sleep(3000);
		// Click on Edit Button
//		editButton.click();

		List<WebElement> usernames = driver.findElements(By.xpath("//div[@id='systemUserDiv'] //tr"));
		
		
		for(int i=0; i<usernames.size(); i++)
		{
//			System.out.println(i+ " "+usernames.get(i));
			WebElement user = usernames.get(i).findElement(By.xpath("//td[2]"));
//			System.out.println(user.getText());
			if(user.getText().contains("Tabby"))
			{
				// Update User Name
				
				WebElement editButton = usernames.get(i).findElement(By.xpath("//td[8]"));
				editButton.click();
				userName.click();
				userName.sendKeys(Keys.CONTROL + "a");
				userName.sendKeys(newUserName);
		
				Thread.sleep(3000);
				// Update the Employee in HR Administration
				saveButton.click();
				System.out.println("Inside If");
				break;
			}
		}

		Thread.sleep(2000);
		// Get Toast Message
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		Assert.assertEquals(toastMessage, "Successfully Updated");
		System.out.println(toastMessage);
		
		RemoveHRAdmin remove = new RemoveHRAdmin(driver);
		return remove;
	}
	
	
}

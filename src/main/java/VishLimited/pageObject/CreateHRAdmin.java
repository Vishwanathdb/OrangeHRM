package VishLimited.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateHRAdmin {

	WebDriver driver;

	public CreateHRAdmin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//i[text()='add']")
	WebElement addButton;

	@FindBy(id = "selectedEmployee_value")
	WebElement employeeNameField;

	@FindBy(css = ".angucomplete-wrapper .angucomplete-row")
	List<WebElement> employeeNameList;

	@FindBy(id = "user_name")
	WebElement userName;

	@FindBy(xpath = "//label[text()='ESS Role']/following-sibling::div //div[@class='filter-option-inner-inner']")
	WebElement essRole;

	@FindBy(xpath = "//span[text()='Default ESS']")
	WebElement defaultESS;

	@FindBy(xpath = "//label[text()='Supervisor Role']/following-sibling::div //div[@class='filter-option-inner-inner']")
	WebElement supervisorRole;

	@FindBy(xpath = "//span[text()='Default Supervisor']")
	WebElement defaultSupervisor;

	@FindBy(xpath = "//label[text()='Admin Role']/following-sibling::div //div[@class='filter-option-inner-inner']")
	WebElement adminRole;

	@FindBy(xpath = "//span[text()='Regional HR Admin']")
	WebElement regionalHRAdmin;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirmpassword")
	WebElement confirmpassword;

	@FindBy(id = "modal-save-button")
	WebElement saveButton;

	public EditHRAdmin addUserToHRAdmin(String employeeToAdd) throws InterruptedException {

		// Adding an Employee to HR Administration
		addButton.click();

		Thread.sleep(5000);
		// Select Employee Name
		employeeNameField.sendKeys("aa");

		Thread.sleep(5000);

		for (int i = 0; i < employeeNameList.size(); i++) {
			// System.out.println(employeeName.get(i).getText());
			if (employeeNameList.get(i).getText().contains(employeeToAdd))
				employeeNameList.get(i).click();
		}

		// Add User Name
		userName.sendKeys("Aaron");

		// Select ESS Role
		essRole.click();
		Thread.sleep(3000);
		defaultESS.click();

		// Select Supervisor Role
		supervisorRole.click();
		Thread.sleep(3000);
		defaultSupervisor.click();

		// Select Admin Role
		adminRole.click();
		Thread.sleep(3000);
		regionalHRAdmin.click();

		// Enter Password and Confirm it
		password.sendKeys("Password@123");
		confirmpassword.sendKeys("Password@123");

		Thread.sleep(3000);
		// Save the Employee in HR Administration
		saveButton.click();

		Thread.sleep(3000);
		// Close the pop up
		saveButton.click();

		Thread.sleep(2000);
		// Get Toast Message
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		Assert.assertEquals(toastMessage, "Successfully Saved");
		System.out.println(toastMessage);
		
		EditHRAdmin edit = new EditHRAdmin(driver);
		return edit;

	}

}

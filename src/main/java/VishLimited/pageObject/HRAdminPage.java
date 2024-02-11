package VishLimited.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRAdminPage {

	WebDriver driver;

	public HRAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[@id='menu-content'] //span[text()='HR Administration']")
	WebElement hrModule;

	@FindBy(xpath = "//tbody //tr //td[4]")
	List<WebElement> userList;

	@FindBy(xpath = "//ul[@class='pagination '] //input[@class='select-dropdown']")
	WebElement paginationDropDown;

	@FindBy(xpath = "//div[@class='select-wrapper'] //li //span[1]")
	WebElement newPagination;

	public CreateHRAdmin mainHRAdminPage() throws InterruptedException {
		// Select HR Module
		hrModule.click();

		Thread.sleep(9000);

		// Fetch Username and Print atleast 10 Username
		System.out.println(userList.size());

		for (int i = 0; i < 10 && i < userList.size(); i++)
			System.out.println(userList.get(i).getText());

		// Update Pagination
		paginationDropDown.click();
		newPagination.click();

		// Updated Pagination
		System.out.println(paginationDropDown.getAttribute("value"));

		CreateHRAdmin create = new CreateHRAdmin(driver);

		return create;

	}

}

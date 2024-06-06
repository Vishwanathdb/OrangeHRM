package VishLimited.orangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HRAdministrationStandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		String url = "https://vishwanathdb-trials711.orangehrmlive.com/";
		String url = "https://vishdb-trials712.orangehrmlive.com";

//		String userName = "Admin", password = "OYs6MbnC2@";
		String userName = "Admin", password = "iVLq@23JjQ";

		String employeeToAdd = "Tabby";
		String toastMessage = "";

		// Creating WebDriver Object
		WebDriver driver = new ChromeDriver();

		// Set Implicit Wait of 3 Sec and Maximize Window Size
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		// Launching OrangeHRM Site
		driver.get(url);

		// Login
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Select HR Module
		driver.findElement(By.xpath("//div[@id='menu-content'] //span[text()='HR Administration']")).click();

		Thread.sleep(9000);

		// Fetch Username and Print atleast 10 Username
		List<WebElement> userList = driver.findElements(By.xpath("//tbody //tr //td[4]"));
		System.out.println(userList.size());

		for (int i = 0; i < 10 && i < userList.size(); i++)
			System.out.println(userList.get(i).getText());

		// Fetch Admin Name
//		System.out.println(driver.findElement
//				(By.xpath("//tbody //tr[3] //td[4] //span")).getText());
//		
//		// Current Pagination
//		System.out.println(driver.findElement
//				(By.xpath("//ul[@class='pagination '] //input[@class='select-dropdown']")).getAttribute("value"));

		// Update Pagination
		driver.findElement(By.xpath("//ul[@class='pagination '] //input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//div[@class='select-wrapper'] //li //span[1]")).click();

		// Updated Pagination
		System.out.println(driver.findElement(By.xpath("//ul[@class='pagination '] //input[@class='select-dropdown']"))
				.getAttribute("value"));

		// Adding an Employee to HR Administration
		driver.findElement(By.xpath("//i[text()='add']")).click();

		Thread.sleep(5000);
		// Select Employee Name
		driver.findElement(By.id("selectedEmployee_value")).sendKeys("bb");
		Thread.sleep(5000);
		List<WebElement> employeeName = driver.findElements(By.cssSelector(".angucomplete-wrapper .angucomplete-row"));
		for (int i = 0; i < employeeName.size(); i++) {
//			System.out.println(employeeName.get(i).getText());
			if (employeeName.get(i).getText().contains(employeeToAdd))
				employeeName.get(i).click();
		}

		// Add User Name
		driver.findElement(By.id("user_name")).sendKeys("Tabby");

		// Select ESS Role
		WebElement essRole = driver.findElement(By
				.xpath("//label[text()='ESS Role']/following-sibling::div //div[@class='filter-option-inner-inner']"));
		essRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Default ESS']")).click();

		// Select Supervisor Role
		WebElement supervisorRole = driver.findElement(By.xpath(
				"//label[text()='Supervisor Role']/following-sibling::div //div[@class='filter-option-inner-inner']"));
		supervisorRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Default Supervisor']")).click();

		// Select Admin Role
		WebElement adminRole = driver.findElement(By.xpath(
				"//label[text()='Admin Role']/following-sibling::div //div[@class='filter-option-inner-inner']"));
		adminRole.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Regional HR Admin']")).click();

		// Enter Password and Confirm it
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Password@123");

		Thread.sleep(3000);
		// Save the Employee in HR Administration
		driver.findElement(By.id("modal-save-button")).click();

		Thread.sleep(3000);
		// Close the pop up
		driver.findElement(By.id("modal-save-button")).click();

		Thread.sleep(2000);
		// Get Toast Message
		toastMessage = driver.findElement(By.className("toast-message")).getText();
		Assert.assertEquals(toastMessage, "Successfully Saved");
		System.out.println(toastMessage);

		Thread.sleep(3000);
//		// Click on Edit Button
//		driver.findElement(By.xpath("//tbody //tr[1] //td[8]")).click();
//
//		// Update User Name
//		driver.findElement(By.id("user_name")).click();
//		driver.findElement(By.id("user_name")).sendKeys(Keys.CONTROL + "a");
//		driver.findElement(By.id("user_name")).sendKeys("Aaron Updated");
//
//		Thread.sleep(3000);
//		// Update the Employee in HR Administration
//		driver.findElement(By.id("modal-save-button")).click();

		List<WebElement> usernames = driver.findElements(By.xpath("//div[@id='systemUserDiv'] //tr"));

		for (int i = 0; i < usernames.size(); i++) {
//			System.out.println(i+ " "+usernames.get(i));
			WebElement user = usernames.get(i).findElement(By.xpath("//td[2]"));
//			System.out.println(user.getText());
			if (user.getText().contains("Tabby")) {
				// Update User Name

				WebElement editButton = usernames.get(i).findElement(By.xpath("//td[8]"));
				editButton.click();
				driver.findElement(By.id("user_name")).click();
				driver.findElement(By.id("user_name")).sendKeys(Keys.CONTROL + "a");
				driver.findElement(By.id("user_name")).sendKeys("Tabby Updated");

				Thread.sleep(3000);
				// Update the Employee in HR Administration
				driver.findElement(By.id("modal-save-button")).click();
				System.out.println("Inside If");
				break;
			}
		}

		Thread.sleep(2000);
		// Get Toast Message
		toastMessage = driver.findElement(By.className("toast-message")).getText();
		Assert.assertEquals(toastMessage, "Successfully Updated");
		System.out.println(toastMessage);

		Thread.sleep(3000);
		// Remove the Employee
		driver.findElement(By.xpath("//tbody //tr[1] //td[1]")).click();
		driver.findElement(By.cssSelector(".material-icons.icons-color.orange-text")).click();
		driver.findElement(By.xpath("//a[text()='Delete Selected']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("save-button")).click();

		Thread.sleep(2000);
		// Get Toast Message
		toastMessage = driver.findElement(By.className("toast-message")).getText();
		Assert.assertEquals(toastMessage, "Successfully Deleted");
		System.out.println(toastMessage);

		// driver.quit();

	}

}

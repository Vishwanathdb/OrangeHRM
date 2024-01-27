package VishLimited.OrangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String url = "https://vishwanathdb-trials711.orangehrmlive.com/";
		String userName = "Admin", password = "OYs6MbnC2@";

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
		driver.findElement
		(By.xpath("//div[@id='menu-content'] //span[text()='HR Administration']")
				).click();
		
		Thread.sleep(9000);
		
		// Fetch Username and Print atleast 10 Username
		List<WebElement> userList = driver.findElements(By.xpath("//tbody //tr //td[4]"));
		System.out.println(userList.size());
		
		for(int i=0; i<10 && i<userList.size(); i++)
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
		System.out.println(driver.findElement
				(By.xpath("//ul[@class='pagination '] //input[@class='select-dropdown']")).getAttribute("value"));
	
		
		
		
	}

}

package VishLimited.testComponent;

import org.testng.annotations.BeforeMethod;


import VishLimited.pageObject.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	WebDriver driver;
	protected Login login;

	void initializer() throws IOException {
		
		String url = "https://vishwanathdb-trials711.orangehrmlive.com/";

//		Check the browser assigned in GolbalData.properties files
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\VishLimited\\resources\\GlobalData.properties");

		properties.load(fis);

//		String browser = System.getProperty("browser")!=null? System.getProperty("browser"): properties.getProperty("browser");

		String browser = properties.getProperty("browser") != null ? properties.getProperty("browser") : "chrome";

		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new FirefoxDriver();

// 		Set Implicit Wait of 3 Sec and Maximize Window Size
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

//		Launching OrangeHRM Site
		driver.get(url);

	}

	@BeforeMethod(alwaysRun = true)
	public void launchApp() throws IOException {
		initializer();
		login = new Login(driver);
	}
	
	public String getScreenShot(String methodName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\reports\\"+methodName);
		FileUtils.copyFile(file, Dest);
		
		return System.getProperty("user.dir") + "\\reports\\"+methodName;
	}
}

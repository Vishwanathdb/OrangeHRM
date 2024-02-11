package VishLimited.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitForElements(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void waitTillElementAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitTillElementAppear(WebElement findBy) {
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitTillElementDisappear(WebElement findBy) {
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}

	public void waitTillElementDisappear(By findBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public void waitTillElementClickable(WebElement findBy) {
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
}

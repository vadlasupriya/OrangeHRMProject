package Project.Human_Resource_Management.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
public static WebDriver driver;
	
	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By login = By.xpath("//button[@type='submit']");
	private By userImg = By.xpath("//div[@class='oxd-topbar-header-userarea']//li[@class='oxd-userdropdown']//img");
	private By logOut = By.xpath("//ul[@class='oxd-dropdown-menu']/li/a[normalize-space()='Logout']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
	}

	public void enterusername(String name) {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(name);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	
	public void clickLogin() {
		driver.findElement(login).click();
		
		
	}
	
	public void logOut() {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userImg));
		driver.findElement(userImg).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(logOut));
		driver.findElement(logOut).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(login));
	}

}

package Project.Human_Resource_Management.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	public static WebDriver driver;
	
	private By options_List = By.xpath("//ul[@class='oxd-main-menu']/li/a");
	private By admin = By.xpath("//ul[@class='oxd-main-menu']/li/a[normalize-space()='Admin']");
	private By adminHeader =By.xpath("//div[@class='oxd-topbar-header']//h6[normalize-space()='Admin']");
	private By username = By.xpath("//label[@class='oxd-label' and normalize-space()='Username']/../following-sibling::div/input");
	private By searchBtn =By.xpath("//button[normalize-space()='Search']");
	private By rows = By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']");
	private By roleDropDown = By.xpath("//label[normalize-space()='User Role']/../following-sibling::div//div[contains(text(),'Select')]");
	private String roleOption = "//div[normalize-space()='User Role']/following-sibling::div//div[@role='listbox']//div[@role='option' and normalize-space()='%s']";
	private By statusDropDown = By.xpath("//label[normalize-space()='Status']/../following-sibling::div//div[contains(text(),'Select')]");
	private String statusOption = "//div[normalize-space()='Status']/following-sibling::div//div[@role='listbox']//div[@role='option' and normalize-space()='%s']";
	
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminPage() {
		// TODO Auto-generated constructor stub
	}
	
	public int countOptions() {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(options_List));
		return driver.findElements(options_List).size();
	}
	
	public void clickAdmin() {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(admin));
		driver.findElement(admin).click();
	}
	
	public boolean verifyAdminHeader() {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(adminHeader));
		
		return driver.findElements(adminHeader).size()>0;
	}
	
	public void enterUsername(String user) {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(user);		
	}
	
	public void clickSearchBtn() {
		driver.findElement(searchBtn).click();
	}
	
	public int getSearchedRecords() {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(rows));
		return driver.findElements(rows).size();
	}

	
	public void selectRole(String role) {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(roleDropDown));
		driver.findElement(roleDropDown).click();
		WebElement option = driver.findElement(By.xpath(String.format(roleOption, role)));
		wait.until(ExpectedConditions.visibilityOf(option));
		option.click();
		
	}
	
public void selectStatus(String status) {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropDown));
		driver.findElement(statusDropDown).click();
		WebElement option = driver.findElement(By.xpath(String.format(statusOption, status)));
		wait.until(ExpectedConditions.visibilityOf(option));
		option.click();
		
	}
	
	
}

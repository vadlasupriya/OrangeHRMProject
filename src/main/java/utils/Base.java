package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import Project.Human_Resource_Management.Pages.LoginPage;


public class Base {
	
	public static WebDriver driver;
	
	
	@BeforeTest
	public static WebDriver getDriver() throws InterruptedException, FileNotFoundException, IOException {
		
		String path= System.getProperty("user.dir") + "\\src\\main\\java\\Library\\chromedriver-win64\\chromedriver.exe";
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Data\\env.properties"));
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		return driver;
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}

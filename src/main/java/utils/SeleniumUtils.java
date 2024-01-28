package utils;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils extends Base {
	
	public void refresh() {
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}

}

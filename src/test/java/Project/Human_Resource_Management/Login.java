package Project.Human_Resource_Management;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import Project.Human_Resource_Management.Pages.LoginPage;
import utils.Base;

@Listeners(utils.Listners.class)
public class Login extends Base {
	
	public static LoginPage lp;
	public static String valid;
	
	@DataProvider
	public Object[][] data() throws FilloException{
		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\LoginData.xlsx");
		String query = "select * from Data";
		Recordset result= con.executeQuery(query);
		System.out.println(result.getCount());
		int rows = result.getCount();
		Object[][] data = new Object[result.getCount()][result.getFieldNames().size()];
        int row = 0;

        while (result.next()) {
            for (int col = 0; col < result.getFieldNames().size(); col++) {
                data[row][col] = result.getField(result.getFieldNames().get(col));
            }
            row++;
        }

        return data;
	}
	
	@Test(dataProvider = "data")
	public static void loginTest(String userName, String password, String valid) {
		Login.valid = valid;
		try {
			driver = getDriver();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		lp = new LoginPage(driver);
		lp.enterusername(userName);
		lp.enterPassword(password);
		lp.clickLogin();
		System.out.println("Login Executed");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
//	@AfterMethod
//	public static void logoutTest() {
//		if(valid.equalsIgnoreCase("Y")) {
//			lp.logOut();
//		}
//	}
//	
	
//	@Test(dependsOnGroups = {"a"})
//	public static void logoutTest() {
//		if(valid.equalsIgnoreCase("Y")) {
//			lp.logOut();
//		}
//	}
	
	@Test(priority= 2, dependsOnMethods = {"loginTest"})
	public static void logoutTest() {
		if(valid.equalsIgnoreCase("Y")) {
			lp.logOut();
			System.out.println("Logout Executed");
		}
	}
	
	
	

}



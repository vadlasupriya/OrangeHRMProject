package Project.Human_Resource_Management;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Project.Human_Resource_Management.Pages.AdminPage;
import Project.Human_Resource_Management.Pages.LoginPage;
import utils.Base;
import utils.SeleniumUtils;



public class AdminSearchFeature extends Base{
	
	public static LoginPage lp;
	public static AdminPage ap;
	public static SeleniumUtils seleniumUtils = new SeleniumUtils();
	
	@BeforeClass
	public void login() {
		lp = new LoginPage(driver);
		lp.enterusername("Admin");
		lp.enterPassword("admin123");
		lp.clickLogin();
	}
	
  @Test
  public void ReadOptionsfromleftView() {
	  ap = new AdminPage(driver);
	  int count = ap.countOptions();
	  System.out.println("Total Options are " + count);
	  Assert.assertTrue(count==12, "Expected 12 options but found " + count);	 
	  ap.clickAdmin();
	  Assert.assertTrue(ap.verifyAdminHeader());
  }
  
  @Test
  public void searchByUserName() {
	  ap = new AdminPage(driver);
	  ap.clickAdmin();
	  ap.enterUsername("Admin");
	  ap.clickSearchBtn();
	  System.out.println("Total recored displayed are: " + ap.getSearchedRecords());
	  seleniumUtils.refresh();
	  
  }
  
  @Test
  public void searchByUserRole() {
	  ap = new AdminPage(driver);
	  ap.clickAdmin();
	  //ap.enterUsername("Admin");
	  ap.selectRole("Admin");
	  ap.clickSearchBtn();
	  System.out.println("Total recored displayed are: " + ap.getSearchedRecords());
	  seleniumUtils.refresh();
	  
  }
  
  @Test
  public void searchByUserStatus() {
	  ap = new AdminPage(driver);
	  ap.clickAdmin();
	  ap.selectStatus("Enabled");
	  ap.clickSearchBtn();
	  System.out.println("Total recored displayed are: " + ap.getSearchedRecords());
	  seleniumUtils.refresh();
	  
  }
}

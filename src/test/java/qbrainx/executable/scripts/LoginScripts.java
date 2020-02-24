package qbrainx.executable.scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qbrainx.locators.LoginPage;
import qbrainx.utility.methods.UtilityClass;

public class LoginScripts extends UtilityClass {
LoginPage page;
	
	@BeforeClass
	private void beforeExecution() {
		launchBrowser("https://www.facebook.com/");
		captureScreenshot(driver, "Browser launch");
	}
	

	@Test (dataProvider = "testdatas") 
	private void testCase1(String username, String password) {
		page = new LoginPage();
	fill(page.getUsername(), username);
	captureScreenshot(driver, "username");
	captureScreenshot(driver, "password");
	fill(page.getPassword(), password);
	btnclk(page.getLoginbtn());
	captureScreenshot(driver, " login ");
	}
	
	@Test 
	private void testCase2() {
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Hai"), " Home page of FB ");

	}
	
	
	@DataProvider (name = "testdatas")
	private Object[][] datas() {
		return new Object[][] {{"bbcbdc", "usbchsbcu"},{"chvhdsv", "bcudsbcub"}};
	}
	
	
	
}

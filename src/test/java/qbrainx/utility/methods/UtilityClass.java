package qbrainx.utility.methods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UtilityClass {

	public static WebDriver driver;
	public static String value = null;
	
	public static String captureScreenshot(WebDriver driver, String ScreenshotName) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis();
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken successfully");
		} catch (IOException e) {
			System.out.println("capture failed" + e.getMessage());
		}
		return path;	
	}
	
	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "F:\\Gowtham\\Oxygen workspaces\\TestNGDemo\\Drivers\\chromedriver.exe");
		ChromeOptions c = new ChromeOptions();
		ChromeOptions d = c.addArguments("--disable-notification");
		driver = new ChromeDriver(d);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	public void fill(WebElement location, String text) {
		System.out.println("Yes the field is enabled "+location.isEnabled());
		location.sendKeys(text);
	}

	public void btnclk(WebElement location) {
		System.out.println("Yes the button is enebled "+location.isEnabled());
		location.click();
	}

	
	
}

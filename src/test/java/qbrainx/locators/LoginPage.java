package qbrainx.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qbrainx.utility.methods.UtilityClass;

public class LoginPage extends UtilityClass {
public LoginPage() {
PageFactory.initElements(driver, this);
}

@FindBy (id = "email")
private WebElement username;

@FindBy (id = "pass")
private WebElement password;

@FindBy (id = "loginbutton")
private WebElement loginbtn;

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLoginbtn() {
	return loginbtn;
}

}

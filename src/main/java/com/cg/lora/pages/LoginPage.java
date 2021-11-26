package com.cg.lora.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.cg.lora.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "email")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(xpath = "//a[@class='password-link']")
	private WebElement forgotPWD;

	@FindBy(xpath = "//input[@value='Me connecter']")
	private WebElement loginSubmitBtn;

	@FindBy(xpath = "//a[text()= 'Je m’inscris']")
	private WebElement signUpBtn;
	
	@FindBy (xpath = "//div[@class= 'error-text']")
	private WebElement invalidCredErrorMsg;
	
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	Verify user login into app using valid credentials.
	public String validLogin() {
		username.sendKeys(prop.getProperty("ValidUsername"));
		pwd.sendKeys(prop.getProperty("ValidPassword"));
		loginSubmitBtn.click();
		String url = driver.getCurrentUrl();
		return url; // url: Landing and Profile Page:
					// https://www.loreal-paris.fr/compte/accountdetails
	}
	

//	Verify user is redirected to forgot pwd page upon clicking forgot pwd link.
	public String clickOnResetPWDLink() {
		forgotPWD.click();
		String url = driver.getCurrentUrl();
		return url;
	}

//	Verify user can login using invalid credentials.
//	public String inValidCredentailsLogin() {
//		username.sendKeys(prop.getProperty("InValidUsername"));
//		pwd.sendKeys(prop.getProperty("Pass123$$"));
//		loginSubmitBtn.click();
//	}

	// use data driven testing for testing login
}

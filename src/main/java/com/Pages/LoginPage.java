package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By emialId = By.id("email");
	private By password = By.id("passwd");
	private By signinbutton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// Constructor of the page class
	public LoginPage(WebDriver driver) {
		   this.driver = driver;
		   
	   }
	
	//page actions : feature(behavior) of the page in the form of methods
	public String getLoginPageTilte() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emialId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnlogin() {
		driver.findElement(signinbutton).click();
	}
	
	public AccountPage doLogin(String un, String pwd){
		System.out.println("Login with "+un+"and "+pwd);
		driver.findElement(emialId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signinbutton).click();
		//If any method going nevigating from one page to another page then its method's 
	    //responsiblity to return next page object:here next page is Account page.
		return new AccountPage(driver);
	}
}

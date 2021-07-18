package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	private By accountsections  = By.cssSelector("div#center_column span");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public int getAccountsSectionCount(){
		return driver.findElements(accountsections).size();
	}
	
	public String getAccountspageTitle(){
		return driver.getTitle();
	}
	
	
	public  List<String> getAccountSectionList() {
		List<String> accountsSectionList = new ArrayList<>();
		List<WebElement> accountHeaderList = driver.findElements(accountsections);
		for(WebElement e: accountHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsSectionList.add(text);
		}
		
		return accountsSectionList;
	}

}

package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
/**
 * This method is used to initalize the thread local driver on the basis of given browser
 * @param browser
 * @return
 */
	public WebDriver init_driver(String browser) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());

		} else {
			System.out.println("Please enter valid browser" + browser);
		}
		
		getWebdrive().manage().deleteAllCookies();
		getWebdrive().manage().window().maximize();
		
		return getWebdrive();
	}
	
	/**
	 * This is used to get the driver with thread local
	 * @return
	 */
	public static synchronized WebDriver getWebdrive() {
		return tlDriver.get();
	}

}

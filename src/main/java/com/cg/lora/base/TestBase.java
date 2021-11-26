package com.cg.lora.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cg.lora.util.GenericUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static void getPropertyFile() {
		String propFilePath = "D:\\SeleniumProjectsWorkSpace\\Loreal\\Loreal\\src\\main\\java\\com\\cg\\lora\\config\\config.properties";

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		/*
		 * we can't use property file attribute to define timeouts as pageLoadTimeout
		 * and implicitlyWait methods expect long and TimeUnit variables only as
		 * arguments
		 */
		driver.manage().timeouts().pageLoadTimeout(GenericUtilities.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(GenericUtilities.implicitlyWait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("HomePageUrl"));

	}
}

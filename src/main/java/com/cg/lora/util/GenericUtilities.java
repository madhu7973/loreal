package com.cg.lora.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.lora.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericUtilities extends TestBase {

	public static long pageLoadTimeOut = 30;
	public static long implicitlyWait = 30;

	public static String excel_path = "D:\\SeleniumProjectsWorkSpace\\Loreal\\Loreal\\src\\main\\java\\com\\cg\\lora\\testData\\LorealTestData.xlsx";

	public static void loginUtil() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("LoginPageUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));

		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath("//input[@value='Me connecter']")).click();
	}

	public static Object[][] testDataUtil(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(excel_path);

		Workbook book = WorkbookFactory.create(file);

		Sheet sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++)
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
		}
		return data;
	}

}

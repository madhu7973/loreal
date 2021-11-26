package com.cg.lora.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cg.lora.base.TestBase;
import com.cg.lora.pages.Header;

public class HeaderTest extends TestBase {

	Header header;

	@BeforeMethod
	public void setUp() {
		TestBase.getPropertyFile();
		TestBase.initialization();
		header = new Header();
	}

	@Test
	public void brandLogoDisplayTest() {
		boolean b = header.brandLogoDisplay();
		Assert.assertEquals(b, true);
	}

	@Test
	public void brandLogoRederictTest() {
		String s = header.brandLogoRederict();
		Assert.assertEquals(s, "https://www.loreal-paris.fr/");
	}

	@Test
	public void prodSearchTest() {
		String s = header.productSearch("Coloration");
		if (s.contains("Coloration"))
			Assert.assertTrue(true);
		else
			Assert.fail();
	}

	@Test
	public void searchSuggestionsFlyoutDisplayTest() {
		boolean b = header.searchSuggestionsFlyoutDisplay("shampoo");
		Assert.assertEquals(b, true);
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

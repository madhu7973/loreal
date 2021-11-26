package com.cg.lora.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cg.lora.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "(//div[@class=\"slick-list draggable\"])[1]")
	private WebElement Banner1;

	@FindBy(xpath = "(//section[@class=\"section section-full\"])[1]")
	private WebElement Banner2;

	@FindBy(xpath = "(//section[@class=\"section section-full\"])[2]")
	private WebElement Banner3;

	@FindBy(xpath = "(//section[@class=\"section section-full\"])[3]")
	private WebElement Banner4;

	@FindBy(xpath = "(//section[@class=\"section section-full\"])[4]")
	private WebElement Banner5;

	@FindBy(xpath = "(//div[@class=\"infobox\"])[1]")
	private WebElement slider1;

	@FindBy(xpath = "(//div[@class=\"infobox\"])[2]")
	private WebElement slider2;

	@FindBy(xpath = "(//div[@class=\"infobox\"])[3]")
	private WebElement slider3;

	@FindBy(xpath = "(//div[@class=\"infobox\"])[4]")
	private WebElement slider4;

	@FindBy(xpath = "(//div[@class=\"infobox\"])[5]")
	private WebElement slider5;

	@FindBy(xpath = "(//div[@class=\"infobox\"])[6]")
	private WebElement slider6;

}

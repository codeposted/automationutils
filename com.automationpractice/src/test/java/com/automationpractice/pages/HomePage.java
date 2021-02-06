package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.testBase.Driver;

public class HomePage {
	@FindBy(id="search_query_top")
	public WebElement searchQueryTop;
	
	@FindBy(name="submit_search")
	public WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}

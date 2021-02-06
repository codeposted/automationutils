package com.automationpractice.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.testBase.Driver;

public class ResultPage {
//	* used for all results
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[*]/img")
	public List<WebElement> searchResults;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[2]/div/div/div/div/iframe")
	public WebElement frame;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
	public WebElement addTocardBtnOnFrame;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	public WebElement proceedCheckoutBtn;
	
	
	public ResultPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}

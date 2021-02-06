package com.automationpractice.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ResultPage;
import com.automationpractice.testBase.Driver;
import com.automationpractice.utils.ConfigurationReader;



public class ClickCheckoutBtn {
//	test case 1
//	Navegate to website
//	Type in search box
//	Click Seach Button
//	"Click on Faded Short
//	 Sleeve T-shirts"
//	Click on "Add to cart" Button
//	"Click on ""Proceed to 
//	Checkout"" Green Button"
	
//	test case 2
//	Navegate to website
//	Type in seach box
//	Click on Seach Button
//	"Click on Faded Short Sleeve
//	T-Shirt"
//	"Click on ""Send to a Friend"" 
//	Button"
//	Enter name of your friend
//	"Enter email address of your
//	friend"
//	Click on "Send" Button
//	"If message ""Your e-mail has
//	been sent successfully"" 
//	appears click ""OK"" button
	
	Actions actions = new Actions(Driver.getDriver());
	HomePage homePage = new HomePage();
	ResultPage resultPage = new ResultPage();
	
	
	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(description= "test case 1")
	public void test1() {
		homePage.searchQueryTop.sendKeys(ConfigurationReader.getProperty("searchTxt"));
		homePage.searchBtn.click();
		
		((JavascriptExecutor) Driver.getDriver()).executeScript("scrollBy(0, 300)");
		
		for (WebElement at : resultPage.searchResults) {
			if (at.getAttribute("title").equals(ConfigurationReader.getProperty("searchTxt"))) {
				at.click();
			}
		}
		
//		frame only appears when we click quick view button
		String x =resultPage.frame.getAttribute("id");
		Driver.getDriver().switchTo().frame(x);
		
		resultPage.addTocardBtnOnFrame.click();
		
		Driver.getDriver().switchTo().defaultContent();
		resultPage.proceedCheckoutBtn.click();
	}
}

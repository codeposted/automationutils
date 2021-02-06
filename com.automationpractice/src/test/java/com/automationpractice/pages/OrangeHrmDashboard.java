package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.testBase.Driver;

public class OrangeHrmDashboard {
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement viewPimModuleBtn;
	
	@FindBy(id="btnAdd")
	public WebElement viewPimModuleAddBtn;
	
	public OrangeHrmDashboard() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}

package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.testBase.Driver;

public class OrangeHrmPersonalDetailsPage {
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement txtEmpFirstName;
	
	@FindBy(id="personal_txtEmpLastName")
	public WebElement txtEmpLastName;
	
	public OrangeHrmPersonalDetailsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}

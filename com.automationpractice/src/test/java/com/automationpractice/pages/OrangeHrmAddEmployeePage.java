package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.testBase.Driver;

public class OrangeHrmAddEmployeePage {
	@FindBy(id="firstName")
	public WebElement firstNameInput;
	
	@FindBy(id="lastName")
	public WebElement lastNameInput;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	public OrangeHrmAddEmployeePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}

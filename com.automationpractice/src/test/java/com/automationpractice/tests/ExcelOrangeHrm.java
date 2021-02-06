package com.automationpractice.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.pages.OrangeHrmAddEmployeePage;
import com.automationpractice.pages.OrangeHrmDashboard;
import com.automationpractice.pages.OrangeHrmLoginPage;
import com.automationpractice.pages.OrangeHrmPersonalDetailsPage;
import com.automationpractice.testBase.Driver;
import com.automationpractice.utils.ConfigurationReader;

public class ExcelOrangeHrm {
	OrangeHrmLoginPage orangeHrmLoginPage = new OrangeHrmLoginPage();
	OrangeHrmDashboard orangeHrmDashboard = new OrangeHrmDashboard();
	OrangeHrmAddEmployeePage orangeHrmAddEmployeePage = new OrangeHrmAddEmployeePage();
	OrangeHrmPersonalDetailsPage orangeHrmPersonalDetailsPage = new OrangeHrmPersonalDetailsPage();
	
	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver().get(ConfigurationReader.getProperty("urlForOrangeHrm"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() throws IOException {
		FileInputStream fs = new FileInputStream("exceltest.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		Cell userName = sheet.getRow(1).getCell(0);
	    String orderID1=userName.toString();
	    orangeHrmLoginPage.username.sendKeys(orderID1);
	    
	    Cell password = sheet.getRow(1).getCell(1);
	    String orderID2=password.toString();
	    orangeHrmLoginPage.password.sendKeys(orderID2);
	    
	    orangeHrmLoginPage.loginBtn.click();
	    
	    orangeHrmDashboard.viewPimModuleBtn.click();
	    orangeHrmDashboard.viewPimModuleAddBtn.click();
	    
	    Cell firstName = sheet.getRow(1).getCell(2);
	    String orderID3=firstName.toString();
	    orangeHrmAddEmployeePage.firstNameInput.sendKeys(orderID3);
	    
	    Cell lastName = sheet.getRow(1).getCell(3);
	    String orderID4=lastName.toString();
	    orangeHrmAddEmployeePage.lastNameInput.sendKeys(orderID4);
	    
	    orangeHrmAddEmployeePage.saveBtn.click();
	    
//	    System.out.println(orangeHrmPersonalDetailsPage.txtEmpFirstName.getAttribute("value"));
	    Assert.assertEquals(orangeHrmPersonalDetailsPage.txtEmpFirstName.getAttribute("value"), orderID3);
	    Assert.assertEquals(orangeHrmPersonalDetailsPage.txtEmpLastName.getAttribute("value"), orderID4);
	    
	}
}

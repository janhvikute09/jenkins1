package POM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class OrganizationsinformationPage {
	
	public WebDriver driver;
	
	WebDriverUtil wutil=new WebDriverUtil();
	
	@FindBy(name="accountname")
	private WebElement organizationnametf;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;

	public OrganizationsinformationPage(WebDriver driver) {
		//to initialize the webelement
		PageFactory.initElements(driver, this);
	}
	
	//create a method
	public HomePage Organizationsinformation(String orgname,String dropdownelement) {
		//enter intel in organization name tf
		organizationnametf.sendKeys(orgname);
		//click on group radio button
		groupbtn.click();
		//handle dropdowm and select support group
		wutil.handledropdown(dropdown, dropdownelement);
		//click on save button
		savebtn.click();
		return new HomePage(driver);
		
	}

	public WebElement getOrganizationnametf() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getGroupbtn() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getSavebtn() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getDropdown() {
		// TODO Auto-generated method stub
		return null;
	}

}


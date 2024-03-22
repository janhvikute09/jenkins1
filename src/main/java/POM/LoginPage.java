package POM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement usernamef;
	
	@FindBy(name="user_password")
	private WebElement passwordf;
	
	@FindBy(name="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernamef() {
		// TODO Auto-generated method stub
		return usernamef;
	}

	public WebElement getPasswordf() {
		// TODO Auto-generated method stub
		return passwordf;
	}

	public Object getLoginbtn() {
		// TODO Auto-generated method stub
		return loginbtn;
	} 
	
	//create a constructor
	public LoginPage(WebDriver driver) {
		//to initilize the webelement
		PageFactory.initElements(driver, this);
	}
	
	//create a method
	public HomePage Login(String usernamedata,String passworddata) {
		
		usernamef.sendKeys(usernamedata);
		passwordf.sendKeys(passworddata);
		loginbtn.click();
		return new HomePage(driver);
	}

}

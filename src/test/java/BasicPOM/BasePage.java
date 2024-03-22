package BasicPOM;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import CommonUtils.JavaUtil;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationsPage;
import POM.OrganizationsinformationPage;

public class BasePage {
	JavaUtil jutil =new JavaUtil();
	public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888/");
			
			LoginPage lp = new LoginPage(driver);
			//To initialize the webelement
			PageFactory.initElements(driver, lp);
			//Enter admin in username tf
			lp.getUsernamef().sendKeys("admin");
			//Enter admin in password tf
			lp.getPasswordf().sendKeys("admin");
			//Click on Login button
		    lp.getLoginbtn().click();
			
			HomePage hp = new HomePage(driver);
			//To initialize the webelement
			PageFactory.initElements(driver, hp);
			//Click on Organizations
			hp.getOrganizations().click();
			
			OrganizationsPage op = new OrganizationsPage(driver);
			//To initialize the webelement
			PageFactory.initElements(driver, op);
			//Click on Create Organization..(+)
			op.getCreateorganizations().click();
			
	OrganizationsinformationPage oip = new OrganizationsinformationPage(driver);
	PageFactory.initElements(driver, oip);
	//Enter Intel in Organization name tf
	oip.getOrganizationnametf().sendKeys("Intel88");		
	//Click on group radio button
	oip.getGroupbtn().click();	
	//Handle dropdown and select support group
	Select s = new Select(oip.getDropdown());
	s.selectByVisibleText("Support Group");		
	//Click on save button
	oip.getSavebtn().click();
			
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(hp.getImage()).perform();
			hp.getSignoutbtn().click();
		
	}

}

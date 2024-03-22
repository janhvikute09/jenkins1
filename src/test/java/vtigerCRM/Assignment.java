package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Assignment {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//create object of propertyFileUtil class
		PropertyFileUtil p=new PropertyFileUtil();
		WebDriverUtil wutil=new WebDriverUtil();
		ExcelUtil ex=new ExcelUtil();
		JavaUtil jutil=new JavaUtil();
		
		String BROWSER = p.getDataFromPropertyFile("browser");
		String URL = p.getDataFromPropertyFile("url");
		String USERNAME = p.getDataFromPropertyFile("username");
		String PASSWORD = p.getDataFromPropertyFile("password");
		
		//To open the browser
		if(BROWSER.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver= new FirefoxDriver();
		}
		
		//To maximize the window
		wutil.maximize(driver);
		
		//To apply implecite wait
		wutil.impleciteWait(driver);
		
		//To launch the application
		driver.get(URL);
		
		//To find WE and pass value in it
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);;
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//To click on contacts
		driver.findElement(By.xpath("(//a[text()='Contacts'])")).click();
		//To click on gender dropdown
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//to click on gender dropdown
		WebElement DROPDOWN = driver.findElement(By.name("salutationtype"));
		String GENDER=ex.getDataFromExcelFile("Contacts", 4, 1);
		wutil.handledropdown(DROPDOWN, GENDER);
		//to enter the first name
		String FIRSTNAME=p.getDataFromPropertyFile("Firstname");
		String LASTNAME=p.getDataFromPropertyFile("Lastname");
		
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//to click on enter organization name + icon
		driver.findElement(By.xpath("(img[alt='Select'])[1]")).click();
		
		//transfer control from parent to child window
		wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//To click on radio button
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
		//To select dropdown
		WebElement TargetedWE = driver.findElement(By.name("assigned_group_id"));
		String DROPDOWNTEXT = ex.getDataFromExcelFile("Contacts", 1, 1);
		wutil.handledropdown(TargetedWE,DROPDOWNTEXT );
		
		//To mouse hover on an image
		Thread.sleep(4000);
		WebElement img= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wutil.mousehover(driver, img);
		
		//To click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//to close the window
		driver.quit();
		

	}

}

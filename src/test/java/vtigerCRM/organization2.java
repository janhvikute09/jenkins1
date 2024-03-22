package vtigerCRM;

import java.io.IOException;

import java.time.Duration;

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

public class organization2 {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException,InterruptedException {
		// TODO Auto-generated method stub

				//create object of propertyFileUtil class
				PropertyFileUtil p=new PropertyFileUtil();
				WebDriverUtil wutil=new WebDriverUtil();
				ExcelUtil ex=new ExcelUtil();
				JavaUtil jutil=new JavaUtil();
				
				String BROWSER = p.getDataFromPropertyFile("Browser");
				String URL = p.getDataFromPropertyFile("Url");
				String USERNAME = p.getDataFromPropertyFile("Username");
				String PASSWORD = p.getDataFromPropertyFile("Password");
				
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
				
				//To find Organizations WE and click on it
				driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				//To find Plus icon WE and click on it
				driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
				
				//To find WE and pass data from excel file
				String data = ex.getDataFromExcelFile("Organizations", 0, 1);
				driver.findElement(By.name("accountname")).sendKeys(data+jutil.getRandomNumber());
				
				//To click on radio button
				driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
				
				//To select dropdown
				WebElement TargetedWE = driver.findElement(By.name("assigned_group_id"));
				String DROPDOWNTEXT = ex.getDataFromExcelFile("Organizations", 1, 1);
				wutil.handledropdown(TargetedWE,DROPDOWNTEXT );
				
				//To click on save button
				driver.findElement(By.name("button")).click();
				
				//To mouse hover on an image
				Thread.sleep(4000);
				WebElement img= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
				wutil.mousehover(driver, img);
				
				//To click on sign out
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			}


	}



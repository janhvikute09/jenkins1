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

public class Leads {
	   public static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {
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
					
					//To find WE Leads and click on it
					driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
					
					//To click on create new Lead---  + icon
					driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
					
					//To click on first name TF and send data
					driver.findElement(By.name("firstname")).sendKeys("Janhvi");
					//To click on last name TF and send data
					driver.findElement(By.name("lastname")).sendKeys("Kute");
					//To click on company name TF and send data
					driver.findElement(By.name("company")).sendKeys("TATA");
					
					//To select grouped radio button
					driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
					
					//To handle dropdown and select value
					WebElement LEADDROPDOWN = driver.findElement(By.name("assigned_group_id"));
					wutil.handledropdown(LEADDROPDOWN, "Team Selling");
					
					//To mouse hover on an image and click on sign out
					Thread.sleep(4000);
					WebElement LEADIMAGE = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wutil.mousehover(driver, LEADIMAGE);
					driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
					driver.quit();
		}


}

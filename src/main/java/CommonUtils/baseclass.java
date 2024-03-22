package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseclass {
	
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	PropertyFileUtil p=new PropertyFileUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	
	@BeforeSuite
	public void BS() {
		System.out.println("connect to data base");
	}
	@BeforeClass
	public void BC() throws IOException{
		//to read the data from propertyfile
		String BROWSER = p.getDataFromPropertyFile("Browser");
		String URL = p.getDataFromPropertyFile("Url");
		
		//To launch the browser
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
		
		sdriver=driver;
		
		//To maximize the window
		wutil.maximize(driver);
		
		//To apply implecite wait
		wutil.impleciteWait(driver);
		
		//To launch the application
		driver.get(URL);
		
	}
	@BeforeMethod
	public void BM() throws IOException {
		
	    //TO READ DATA FROM PROPERTY FILE
		String USERNAME = p.getDataFromPropertyFile("Username");
		String PASSWORD = p.getDataFromPropertyFile("Password");
		//LOGIN TO APPLICATION
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);;
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
	@AfterMethod
	public void AM() throws InterruptedException {
		Thread.sleep(4000);
		//mouse hover on imaage
		WebElement img= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wutil.mousehover(driver, img);
		
		//To click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	@AfterClass
	public void AC() {
		driver.quit();
	}
	@AfterSuite
	public void AS() {
	  
		System.out.println("disconnect from database");
	}
}



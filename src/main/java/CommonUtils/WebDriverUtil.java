package CommonUtils;

import java.io.File;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	 
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void impleciteWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void handledropdown(WebElement targeteddropdown,String targetedoption)
	{
		Select s=new Select(targeteddropdown);
		s.selectByVisibleText(targetedoption);
	}
	
	public void mousehover(WebDriver driver,WebElement targeted)
	{
		Actions a=new Actions(driver);
		a.moveToElement(targeted);
		a.perform();
	}
	public void switchwindow(WebDriver driver,String expectedurl) {
		
		//check how many window are present
		Set<String> ids=driver.getWindowHandles();
		
		//to trasfer the control from one windowto another window
		for(String allwindow:ids) {
			String actualurl=driver.switchTo().window(allwindow).getCurrentUrl();
			
			if(actualurl.contains(expectedurl)) {
				break;
			}
		}
	}
	public String Screenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempfile=ts.getScreenshotAs(OutputType.FILE);
		File destinationfile= new File("./Screenshot/image"+);
		FileUtils.copyFile(tempfile, destinationfile);
		return destinationfile.getAbsolutePath();
		
		
	}

}


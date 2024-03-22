package basictestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test3 {
	
	public void Ajio() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.ajio.com");
		
		/*String actualtitle=d.getTitle();
		
		System.out.println(actualtitle);
		
		String expectedtitle="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
		System.out.println("good morning");*/
		
		WebElement searchf =driver.findElement(By.name("searchVal")); 
		
		//truecondition the output will passed
		//falsecondition the output will failed
	    
		//Assert.assertTrue(searchf.isEnabled);//truecondition
		
		//Assert.assertTrue(searchf.isSelected());//falsecondition
		//System.out.println("good morning");
		
		//truecondition the o/p will fail---searchf is enable 
		//Falsecondition the o/p will pass---searchf is selected
		//Assert.assertFalse(searchf.isEnabled());//true condition
		Assert.assertFalse(searchf.isSelected());//false condition
		System.out.println("good morning");
	
		
		
		
	}

}

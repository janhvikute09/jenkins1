package basictestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test4 {
	
	@Test
	public void Ajio() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		
		String actualtitle=driver.getTitle();
		
		System.out.println(actualtitle);
		
		String expectedtitle="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualtitle, expectedtitle);
		System.out.println("good morning");
		s.assertAll();
		
		
	}

}

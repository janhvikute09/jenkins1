package basictestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test2 {
	
	public void Ajio() {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.ajio.com");
		
		String actualurl =d.getCurrentUrl();
		
		System.out.println(actualurl);
		
		/*if(url.equals("https://www.ajio.com")){
			System.out.println("url is matching");
		}else {
			System.out.println("url is matching");
		}
		System.out.println("good morning");*/
		
		String expecturl ="https://www.ajio.com";
		
		Assert.assertEquals(actualurl, expecturl);
		
		System.out.println("good morning");
		
	}

}

package basictestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test5 {
	@Test
	public void SignUp() {
		System.out.println("Signup");
	}
	@Test
	 public void SignIn() {
		System.out.println("SignIn");
		Assert.assertEquals("pune", "deccan");
	 }
	 @Test(dependsOnMethods="SignIn")
	 public void SignOut() {
		 System.out.println("SignOut");
	 }

}

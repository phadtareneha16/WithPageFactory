package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

	@Test
	public void verifyValidLogin() {
		LoginPage login = new LoginPage(driver);
		ProductsPage products=login.loginValid
				("standard_user","secret_sauce");
		
		Assert.assertEquals(products.getTitle(),"Products",
				"Login Failed for title mismatch!");
		
	}

}

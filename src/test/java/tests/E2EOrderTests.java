package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;


@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class E2EOrderTests extends BaseTest {
	

	@Test
	public void placeOrderForBackpack() {
		LoginPage login = new LoginPage(driver);
		ProductsPage products = login.loginValid("standard_user", "secret_sauce");

		Assert.assertEquals(products.getTitle(), "Products");

		products.addBackpackToCart();
		CartPage cart = products.openCart();

		Assert.assertEquals(cart.getTitle(), "Your Cart");

		CheckoutInfoPage info = cart.clickCheckout();

		CheckoutOverviewPage overview = info.fillInfoandContinue("Neha", "Phadtare", "416001");

		CheckoutCompletePage complete = overview.finishOrder();
		Assert.assertTrue(complete.getSuccessMessage().toUpperCase().contains("THANK YOU FOR YOUR ORDER"));

	}

}

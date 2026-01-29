package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class CheckoutInfoPage {
	private WebDriver driver;
	private WaitUtils wait;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(id = "postal-code")
	private WebElement postalCode;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public CheckoutOverviewPage fillInfoandContinue(String fn, String ln, String zip) {
		wait.typeWhenVisible(firstName, fn);
		wait.typeWhenVisible(lastName, ln);
		wait.typeWhenVisible(postalCode, zip);
		wait.clickWhenReady(continueBtn);
		return new CheckoutOverviewPage(driver);

	}

}

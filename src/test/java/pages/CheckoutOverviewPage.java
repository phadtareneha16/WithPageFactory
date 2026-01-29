package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class CheckoutOverviewPage {
	private WebDriver driver;
	private WaitUtils wait;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public CheckoutCompletePage finishOrder() {
		wait.clickWhenReady(finishBtn);
		return new CheckoutCompletePage(driver);
	}

}

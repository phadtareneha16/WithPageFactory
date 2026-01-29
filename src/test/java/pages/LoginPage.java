package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class LoginPage {

	private WebDriver driver;
	private WaitUtils wait;

	@FindBy(id = "user-name")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public ProductsPage loginValid(String user, String pass) {
		wait.typeWhenVisible(username, user);
		wait.typeWhenVisible(password, pass);
		wait.clickWhenReady(loginBtn);
		return new ProductsPage(driver);

	}

	public String getErrorMessage() {
		try {
			return wait.getTextWhenVisible(errorMsg);
		} catch (Exception e) {
			return "";

		}
	}
}

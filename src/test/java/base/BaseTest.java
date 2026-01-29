package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.AllureAttachments;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = DriverFactory.createChrome();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.saucedemo.com/");

	}

	@AfterMethod
	public void teardown() {
		try {
			// Attach screenshot to allure at end
			// This will be called from AllureAttachments Class from utils package
			AllureAttachments.attachScreenshot(driver, "Final Screenshot");
			AllureAttachments.attachPageSource(driver);
			AllureAttachments.attachCurrentUrl(driver);

		} catch (Exception igonred) {

		} finally {
			if (driver != null) {
				driver.quit();

			}
		}
	}

}

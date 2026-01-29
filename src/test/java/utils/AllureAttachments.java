package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

//Central Place to attach more information in Allure report 
//Mostly used when test cases fail,when screenshots,url,html etc is required
public class AllureAttachments {

	// @Attachment ---Allure annotation
	// value = "{name}" ---Attachment name is dynamic
	// type = "image/png"---Screenshot format
	// Method returns byte[]-required by allure for image attachments
	// static ---can be called without creating object
	@Attachment(value = "{name}", type = "image/png")
	public static byte[] attachScreenshot(WebDriver driver, String name) {

		// Prevent NullPointerException
		// Returns empty byte array if driver is not intialized
		if (driver == null)
			return new byte[0];

		// Cast WebDriver to TakesScreenshot
		// capture screenshot
		// store it in byte array
		// allure report attaches it automatically
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	}

	// Attaches full HTML source of the page
	// Used DOM issues,Element not found,Dynamic loading problems etc
	@Attachment(value = "PageSource", type = "text/html")
	public static String attachPageSource(WebDriver driver) {

		// Safety check for driver
		// fetches current page HTML
		// Attached as HTML File in Allure report
		if (driver == null)
			return "";
		return driver.getPageSource();
	}

	// Attaches the current page url
	// Format ----Plain text
	// Preevnts null issues
	// Prevents navigation or redirection problems
	@Attachment(value = "CurrentURL", type = "text/plain")
	public static String attachCurrentUrl(WebDriver driver) {
		if (driver == null)
			return "";
		return driver.getCurrentUrl();
	}

}

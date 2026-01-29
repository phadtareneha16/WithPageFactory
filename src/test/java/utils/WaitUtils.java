package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickWhenReady(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void typeWhenVisible(WebElement element, String text) {
        waitVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getTextWhenVisible(WebElement element) {
        waitVisible(element);
        return element.getText().trim();
    }

    public void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});", element);
    }

    // Most reliable click for SauceDemo
    public void safeClick(WebElement element) {
        try {
            scrollIntoView(element);
            clickWhenReady(element);
        } catch (TimeoutException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}

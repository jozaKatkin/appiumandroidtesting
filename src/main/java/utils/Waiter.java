package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private final AppiumDriver driver;

    public Waiter(AppiumDriver driver) {
        this.driver = driver;
    }

    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public WebElement waitForElementToBeVisible(WebElement element, int timeInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeInMillis));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element, int timeInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeInMillis));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ILogger;
import utils.Waiter;

public class Alert implements ILogger {
    private final AppiumDriver driver;
    private final Waiter waiter;

    public Alert(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.waiter = new Waiter(driver);
    }

    //    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"OK\"]")
    private WebElement okButton;

    //    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Allow\"]")
    private WebElement allowButton;

    //
    ////android.widget.LinearLayout[@resource-id="com.android.permissioncontroller:id/grant_dialog"]

    public void clickOkButton() {
        waiter.waitForElementToBeClickable300Millis(okButton)
                .click();
        log().info("Clicked Alert OK button");
    }

    public void clickAllowButton() {
        waiter.waitForElementToBeClickable300Millis(allowButton)
                .click();
        log().info("Clicked Alert Allow button");
    }

    public void clickOkButtonIfPresent() {
        if (okButton.isDisplayed()) {
            waiter.waitForElementToBeClickable(okButton, 1000)
                    .click();
            log().info("Clicked Alert OK button");
        } else {
            log().info("Alert OK button is not displayed");
        }
    }

    public void clickAllowButtonIfPresent() {
        if (allowButton.isDisplayed()) {
            waiter.waitForElementToBeClickable(allowButton, 1000)
                    .click();
            log().info("Clicked Alert Allow button");
        } else {
            log().info("Alert Allow button is not displayed");
        }
    }
}

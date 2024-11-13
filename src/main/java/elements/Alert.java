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

    public void clickOkButton() {
        waiter.waitForElementToBeClickable300Millis(okButton)
                .click();
        log().info("Clicked Alert OK button");
    }

}

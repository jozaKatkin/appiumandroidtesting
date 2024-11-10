package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RandomNumberGenerator;

import java.util.List;

public class MainScreen extends BaseScreen {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.joom:id/root\"]")
    private WebElement logo;

    @FindBy(xpath = "//android.widget.GridView/android.view.ViewGroup")
    private List<WebElement> productsList;

    public MainScreen(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainScreen clickOnLogo() {
        waiter.waitForElementToBeVisible(logo, 500)
                .click();
        return this;
    }

    public MainScreen clickOnRandomProduct() {
        int lastElementIndex = productsList.size() - 1;
        WebElement productToClick = productsList.get(RandomNumberGenerator.getRandomIntInRange(0, lastElementIndex));
        waiter.waitForElementToBeClickable(productToClick, 500)
                .click();
        return this;
    }

}

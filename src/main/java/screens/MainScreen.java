package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RandomNumberGenerator;

import java.util.List;

public class MainScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.joom:id/root\"]")
    private WebElement logo;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.GridView/android.view.ViewGroup")
    private List<WebElement> productsList;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "")
    private WebElement productName;

    public MainScreen(AppiumDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
        /*ToDo могу ли перенести в Base Page
         */
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MainScreen clickOnLogo() {
        waiter.waitForElementToBeVisible(logo, 500)
                .click();
        return this;
    }

    public int clickOnRandomProduct() {
        int lastElementIndex = productsList.size() - 1 - 2;
        int indexOfProductToClick = RandomNumberGenerator.getRandomIntInRange(2, lastElementIndex);
        WebElement productToClick = productsList.get(indexOfProductToClick);
        waiter.waitForElementToBeClickable(productToClick, 500)
                .click();
        return indexOfProductToClick;
    }

    public MainScreen clickOnProductByIndex(int index) {
        WebElement productToClick = productsList.get(index);
        waiter.waitForElementToBeClickable(productToClick, 500)
                .click();
        return this;
    }

}

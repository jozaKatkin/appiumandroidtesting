package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.RandomNumberGenerator;

import java.util.List;

public class MainScreen extends BaseScreen {

//    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.joom:id/root\"]")
    private WebElement logo;

//    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.GridView/android.view.ViewGroup")
    private List<WebElement> productsList;

//    @iOSXCUITFindBy(xpath = "")
//    @AndroidFindBy(xpath = "")
//    private WebElement productName;

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public MainScreen clickOnLogo() {
        waiter.waitForElementToBeVisible(logo, 500)
                .click();
        return this;
    }

    public String clickOnRandomProductAndReturnName() {
        WebElement productToClick = findRandomProduct();
        waiter.waitForElementToBeVisible(productToClick, 300);
        String productName = productToClick.getText();
        log().info("Product name: {productName}");

        waiter.waitForElementToBeClickable300Millis(productToClick, 300)
                .click();
        return productName;
    }

    private WebElement findRandomProduct() {
        int lastElementIndex = productsList.size() - 1 - 2;
        int indexOfProductToClick = RandomNumberGenerator.getRandomIntInRange(2, lastElementIndex);
        return productsList.get(indexOfProductToClick);
    }


}

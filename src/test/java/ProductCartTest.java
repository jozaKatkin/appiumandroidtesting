import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import elements.MainScreen;
import elements.ProductScreen;
import utils.ILogger;
import utils.RandomNumberGenerator;

@Disabled
public class ProductCartTest extends BaseTest implements ILogger {

    @BeforeAll
    public static void doPreconditions() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.clickOnLogo();
    }



    @Test
    public void addRandomProductToCart() {
        MainScreen mainScreen = new MainScreen(driver);
        ProductScreen productScreen = new ProductScreen(driver);
        mainScreen.scrollUp(RandomNumberGenerator.getRandomIntInRange(0, 2));

        String productNameFromMainScreen = mainScreen.clickOnRandomProductAndReturnName();
        Assert.assertEquals(productNameFromMainScreen, productScreen.getProductName());

        productScreen.clickOnButtonBuyProduct();

    }


    @Test
    public void deleteFromCart() {
        MainScreen mainScreen = new MainScreen(driver);
        ProductScreen productScreen = new ProductScreen(driver);

//        productScreen.clickOnBuyProduct();
//        Assert.assertTrue();

    }

    @Test
    public void pinchTest() {
        MainScreen mainScreen = new MainScreen(driver);
        ProductScreen productScreen = new ProductScreen(driver);
        mainScreen.scrollUp(RandomNumberGenerator.getRandomIntInRange(0, 2));
        String productNameFromMainScreen = mainScreen.clickOnRandomProductAndReturnName();
        Assert.assertEquals(productNameFromMainScreen, productScreen.getProductName());

    }
}

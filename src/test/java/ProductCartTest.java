import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import screens.MainScreen;
import screens.ProductScreen;
import utils.ILogger;
import utils.RandomNumberGenerator;

public class ProductCartTest extends BaseTest implements ILogger {

    @Test
    public void addRandomProductToCart() {
        log().info("App is successfully started");
        MainScreen mainScreen = new MainScreen(driver);
        ProductScreen productScreen = new ProductScreen(driver);

        mainScreen.clickOnLogo();

        mainScreen.scrollUp(RandomNumberGenerator.getRandomIntInRange(0, 2));
        int indexOfProductToChoose = mainScreen.clickOnRandomProduct();


    }


//    @Test
//    public void deleteFromCart() {
//        MainScreen mainScreen = new MainScreen(driver);
//        ProductScreen productScreen = new ProductScreen(driver);
//        mainScreen.clickOnLogo()
//                .clickOnRandomProduct();
//        productScreen.clickOnBuyProduct();
//        Assert.assertTrue();
//
//    }
}

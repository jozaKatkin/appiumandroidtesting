import org.junit.jupiter.api.Test;
import screens.MainScreen;
import utils.ILogger;

public class FirstTest extends BaseTest implements ILogger {

    @Test
    public void addRandomProductToCart() {
        MainScreen mainScreen = new MainScreen(driver);
        log().info("App is successfully started");
        mainScreen.clickOnLogo()
                .clickOnRandomProduct();
    }


}

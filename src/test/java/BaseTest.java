import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.ScreenshotListener;


@ExtendWith({ScreenshotListener.class})
public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

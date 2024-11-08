import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static AndroidDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}

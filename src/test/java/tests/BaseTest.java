package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

public abstract class BaseTest {
    protected final String URL = "https://www.wikipedia.org/";
    protected final int MAX_WAIT = 10;
    protected final String DOWNLOAD_DIRECTORY = System.getProperty("user.dir") + File.separator + "downloads";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOAD_DIRECTORY);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

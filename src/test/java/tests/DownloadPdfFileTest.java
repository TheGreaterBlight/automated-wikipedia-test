package tests;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DownloadPdfFileTest extends BaseTest {
    private final By UNIQUE_ELEMENT = By.xpath("//div[contains(@class,'central-textlogo')]");
    private final String INPUT_TEXT = "Albert Einstein";
    private final By TEXT_FIELD = By.xpath("//input[@id='searchInput']");
    private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private final By DOWNLD_TOOLBAR = By.xpath("//input[@id='vector-page-tools-dropdown-checkbox']");
    private final By DOWNLD_TOOLBAR_BUTTON = By.xpath("//li[@id='coll-download-as-rl']");
    private final By PDF_NAME_EXTRACTOR = By.xpath("//div[contains(@class,'mw-electronpdfservice-selection-label-desc')]");
    private final By DOWNLD_BUTTON = By.xpath("//button[starts-with(@class,'oo-ui-inputWidget-input')]");

    @Test
    public void pdfTestDownload() {
        Assert.assertTrue(driver.findElement(UNIQUE_ELEMENT).isDisplayed(), "Page is not open");
        driver.findElement(TEXT_FIELD).sendKeys(INPUT_TEXT);
        driver.findElement(SEARCH_BUTTON).click();
        driver.findElement(DOWNLD_TOOLBAR).click();
        driver.findElement(DOWNLD_TOOLBAR_BUTTON).click();
        String fileName = driver.findElement(PDF_NAME_EXTRACTOR).getText();
        driver.findElement(DOWNLD_BUTTON).click();
        String filePath = DOWNLOAD_DIRECTORY + File.separator + fileName;
        File downloadedFile = new File(filePath);
        Assert.assertTrue(ifFileExists(downloadedFile), "FILE DO NOT EXISTS WITHIN THE FOLDER");
    }

    private boolean ifFileExists(File file) {
        try {
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception) {
            return false;
        }
        return true;
    }
}

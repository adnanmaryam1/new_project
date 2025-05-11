package TESTS;

import PAGE_OBJECTS.SearchPageObject;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class BBCNews {
    DriverManager driverManager = new DriverManager();
    private SearchPageObject searchPage = new SearchPageObject();
    private String searchTerm = "BBC news";

    @BeforeTest
    public void driverSetup() {
        driverManager.setupDriver();
    }

    @AfterTest
    public void tearDown() {
        driverManager.closeDriver();
    }

    @Test
    public void googleSearch() throws InterruptedException {
        searchPage.acceptCookiePrompt().typeSearchTerm(searchTerm).clickGoogleSearchButton();
        By firstSearchResult = By.xpath("(//*[@id='rso']//a[@class='zReHs'])[1]");
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchResult));
        driverManager.getDriver().findElement(firstSearchResult).click();
        Thread.sleep(2000);
        String currentURL = driverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.bbc.co.uk/news");
    }

    @Test
    public void googleIFeelLucky() throws InterruptedException {
        searchPage.acceptCookiePrompt().typeSearchTerm(searchTerm).clickIFeelLucky();
        String currentURL = driverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.bbc.co.uk/news");
    }
}

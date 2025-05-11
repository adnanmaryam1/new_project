package PAGE_OBJECTS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPageObject {
    private driver.DriverManager driverManager = new driver.DriverManager();
    private By acceptAll = By.cssSelector("#L2AGLb");
    private By searchBar = By.cssSelector("#APjFqb");
    private By googleSearchButton = By.cssSelector(".FPdoLc.lJ9FBc .gNO89b");
    private By iFeelLucky = By.cssSelector("#gbqfbb");

    private WebDriverWait getWait() {
        return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));
    }

    public SearchPageObject acceptCookiePrompt() {
        getWait().until(ExpectedConditions.elementToBeClickable(acceptAll));
        driverManager.getDriver().findElement(acceptAll).click();
        return this;
    }

    public SearchPageObject typeSearchTerm(String searchTerm) throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(searchBar));
        driverManager.getDriver().findElement(searchBar).sendKeys(searchTerm);
        Thread.sleep(2000);
        driverManager.getDriver().findElement(searchBar).sendKeys(Keys.ESCAPE);
        return this;
    }

    public void clickGoogleSearchButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(googleSearchButton));
        driverManager.getDriver().findElement(googleSearchButton).click();
    }

    public void clickIFeelLucky() {
        getWait().until(ExpectedConditions.elementToBeClickable(iFeelLucky));
        driverManager.getDriver().findElement(iFeelLucky).click();
    }

    public void searchAndSelectResult(String searchTerm) throws InterruptedException {
        acceptCookiePrompt().typeSearchTerm(searchTerm).clickGoogleSearchButton();
    }

}

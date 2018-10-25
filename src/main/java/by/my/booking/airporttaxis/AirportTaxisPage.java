package by.my.booking.airporttaxis;

import by.my.booking.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirportTaxisPage extends BasePage {
    public AirportTaxisPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='pickupLocation']")
    private WebElement pickUpLocation;

    @FindBy(xpath = "//input[@id='dropoffLocation']")
    private WebElement dropOffLocation;

    @FindBy(xpath = "//span[@class='rw-search__date-link']")
    private WebElement calendar;

    @FindBy(xpath = "//ul[@id='pickupLocation-items']//li[2]//a[1]//div[1]")
    private WebElement addressFrom;

    @FindBy(xpath = "//ul[@id='dropoffLocation-items']//li[3]//a[1]//div[1]")
    private WebElement addressTo;

    @FindBy(xpath = "//table[@class='date-picker__calendar']//tbody[1]//tr[5]//td[3]//a[1]")
    private WebElement date;

    @FindBy(xpath = "//button[@name='searchButton']")
    private WebElement searchButton;

    public SearchTaxisPage searchTaxis() {
        pickUpLocation.click();
        pickUpLocation.sendKeys("Minsk");
        addressFrom.click();
        dropOffLocation.click();
        dropOffLocation.sendKeys("Minsk");
        addressTo.click();
        calendar.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", date);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", searchButton);

        return new SearchTaxisPage(driver);
    }
}

package by.my.booking.aviaticket;

import by.my.booking.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AviaTicketPage extends BasePage {

    public AviaTicketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inputWrapper']/input[1]")
    private WebElement originField;

    @FindBy(xpath = "//div[@class='fieldBlock airportBlock destinationBlock']/input[1]")
    private WebElement destinationField;

    @FindBy(xpath = "//div[contains(text(),'Moscow, Russia')]")
    private WebElement selectionAirport;

    @FindBy(xpath = "//div[@class='keel-grid dateRangeGrid']//div[1]//div[1]")
    private WebElement calendar;

    @FindBy(xpath = "//div[@class='default-view']//div[4]//div[1]//div[3]//div[1]//div[3]//div[4]//div[3]//div[1]")
    private WebElement depart;

    @FindBy(xpath = "//div[@class='default-view']//div[4]//div[1]//div[3]//div[1]//div[3]//div[4]//div[4]//div[1]")
    private WebElement returnBack;

    @FindBy(xpath = "//div[@class='fieldBlock buttonBlock']//button")
    private WebElement searchButton;

    public SearchTicketPage checkSearchTicket() {
        originField.click();
        originField.sendKeys("Minsk");
        destinationField.click();
        destinationField.sendKeys("Moscow");
        selectionAirport.click();
        calendar.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", depart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", returnBack);
        searchButton.submit();

        return new SearchTicketPage(driver);
    }
}

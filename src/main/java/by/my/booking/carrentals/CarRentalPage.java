package by.my.booking.carrentals;

import by.my.booking.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRentalPage extends BasePage {

    public CarRentalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='pu-country']")
    private WebElement checkCountry;

    @FindBy(xpath = "//select[@id='pu-country']//option[@value='Беларусь']")
    private WebElement checkBelarus;

    @FindBy(xpath = "//select[@id='pu-city']")
    private WebElement checkCity;

   @FindBy(xpath = "//select[@id='pu-city']//option[@value='Минск']")
    private WebElement checkBrest;

   @FindBy(xpath = "//select[@id='pu-location']")
    private WebElement checkLocation;

   @FindBy(xpath = "//select[@id='pu-location']//option[@value='-1']")
    private WebElement allLocation;


    @FindBy(xpath = "//input[@id='formsubmit']")
    private WebElement searchButton;

    public void checkAvailabilityCars() {
        checkCountry.click();
        checkBelarus.click();
        checkCity.click();
        checkBrest.click();
        checkLocation.click();
        allLocation.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", searchButton);
    }

}

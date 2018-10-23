package by.my.booking.searchroom;

import by.my.booking.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPageBooking extends BasePage {
    public static final String URL = "https://www.booking.com";

    public MainPageBooking(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchField;

    @FindBy(xpath = "//span[contains(text(),'Проверить цены')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'xp__dates-inner xp__dates__checkin')]//button[@type='button']")
    private WebElement dates;

    @FindBy(xpath = "//div[@class='bui-calendar__content']//div[1]//table[1]//tbody[1]//tr[5]//td[6]")
    private WebElement moveIn;

    @FindBy(xpath = "//div[@class='bui-calendar__content']//div[1]//table[1]//tbody[1]//tr[5]//td[7]")
    private WebElement moveOut;

    @FindBy(xpath = "//label[@id='xp__guests__toggle']")
    private WebElement searchOptions;

    @FindBy(xpath = "//select[@id='no_rooms']")
    private WebElement rooms;

    @FindBy(xpath = "//select[@id='no_rooms']//option[@value='3']")
    private WebElement choice3Rooms;

    @FindBy(xpath = "//select[@id='group_adults']")
    private WebElement adults;

    @FindBy(xpath = "//select[@id='group_adults']//option[@value='6']")
    private WebElement choice6Adults;

    public SearchDoubleRoom searchRooms() {
        searchField.sendKeys("Минск");
        dates.click();
        moveIn.click();
        moveOut.click();
        searchOptions.click();
        rooms.click();
        choice3Rooms.click();
        adults.click();
        choice6Adults.click();
        searchButton.submit();

        return new SearchDoubleRoom(driver);
    }


}

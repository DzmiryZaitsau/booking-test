package by.my.booking.airporttaxis;

import by.my.booking.BaseTest;
import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//check searching taxi from airport of Minsk to Minsk.
public class CheckBookTaxiTest extends BaseTest {

    @BeforeTest
    public WebDriver startBrowser() {
        startChrom();
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        mainPageBooking.openAirportTaxis();
        switchWindow();
        return driver;
    }

    @Test
    public void checkTaxis() {
        SearchTaxisPage searchTaxisPage;
        AirportTaxisPage airportTaxisPage = new AirportTaxisPage(driver);
        searchTaxisPage = airportTaxisPage.searchTaxis();
        Assert.assertTrue(searchTaxisPage.checkAvailableTaxis()>=1);
    }

    @AfterTest
    public void closeBrowser() {
        closeChrom();
    }
}

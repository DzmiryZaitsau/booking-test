package by.my.booking.carrentals;

import by.my.booking.BaseTest;
import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//check searching available rental cars
public class CheckCarRentalsTest extends BaseTest {

    @BeforeTest
    public WebDriver startBrowser() {
        startChrom();
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        mainPageBooking.openCarRentalPage();
        switchWindow();
        return driver;
    }

    @Test
    public void checkCarRentals() {
        CarRentalPage carRentalPage = new CarRentalPage(driver);
        carRentalPage.checkAvailabilityCars();
        SearchCarsPage searchCarsPage = new SearchCarsPage(driver);
        Assert.assertTrue(searchCarsPage.checkCars()>=1);
    }
    @AfterTest
    public void closeBrowser() {
        closeChrom();

    }
}

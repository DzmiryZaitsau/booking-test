package by.my.booking.carrentals;

import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//check searching available rental cars
public class CheckCarRentalsTest {
    private WebDriver driver;

    @BeforeTest
    public WebDriver startBrowser() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com");
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        mainPageBooking.openCarRentalPage();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
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
    public void closeChrom() {
        if (driver != null) {
            driver.quit();
        }

    }
}

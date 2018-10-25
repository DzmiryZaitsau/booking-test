package by.my.booking.accomodation;

import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//check for three available double rooms for the coming weekend on booking.com
public class SearchRoomsTest {

    private WebDriver driver;

    @BeforeTest
    public WebDriver startBrowser() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com");
        return driver;
    }

    @Test
    public void searchRooms() {
        SearchRoomPage searchDoubleRoom;
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        searchDoubleRoom = mainPageBooking.searchRooms();
        Assert.assertTrue(searchDoubleRoom.checkDoubleRooms() >= 1);

    }

    @AfterTest
    public void closeChrom() {
        if (driver != null) {
            driver.quit();
        }

    }
}

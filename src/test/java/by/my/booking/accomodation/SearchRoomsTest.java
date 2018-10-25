package by.my.booking.accomodation;

import by.my.booking.BaseTest;
import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//check for three available double rooms for the coming weekend on booking.com
public class SearchRoomsTest extends BaseTest {

    @BeforeTest
    public WebDriver startBrowser() {
        return startChrom();
    }

    @Test
    public void searchRooms() {
        SearchRoomPage searchDoubleRoom;
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        searchDoubleRoom = mainPageBooking.searchRooms();
        Assert.assertTrue(searchDoubleRoom.checkDoubleRooms() >= 1);

    }

    @AfterTest
    public void closeBrowser() {
        closeChrom();
    }
}

package by.my.booking.aviaticket;

import by.my.booking.BaseTest;
import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//check searching available flights from Minsk to Moscow. Test does not work because of captcha
public class SearchTicketTest extends BaseTest {

    @BeforeTest
    public WebDriver startBrowser() {
        startChrom();
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        mainPageBooking.openAviaTicket();
        switchWindow();
        return driver;
    }

    @Test
    public void searchTickets() {
        SearchTicketPage searchTicketPage;
        AviaTicketPage aviaTicketPage = new AviaTicketPage(driver);
        searchTicketPage = aviaTicketPage.checkSearchTicket();
        Assert.assertTrue(searchTicketPage.checkTickets() >= 1);

    }

    @AfterTest
    public void closeBrowser() {
        closeChrom();
    }
}

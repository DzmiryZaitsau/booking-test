package by.my.booking.aviaticket;

import by.my.booking.MainPageBooking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//check searching available flights from Minsk to Moscow. Test does not work because of captcha
public class SearchTicketTest {
    private WebDriver driver;

    @BeforeTest
    public WebDriver startBrowser() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://booking.com/");
        MainPageBooking mainPageBooking = new MainPageBooking(driver);
        mainPageBooking.openAviaTicket();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return driver;
    }

    @Test
    public void searchTickets() {
        SearchTicketPage searchTicketPage;
        AviaTicketPage aviaTicketPage = new AviaTicketPage(driver);
        searchTicketPage = aviaTicketPage.checkSearchTicket();
        Assert.assertTrue(searchTicketPage.checkTickets() >= 1);

    }
}

package by.my.booking.aviaticket;

import by.my.booking.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTicketPage extends BasePage {

    public SearchTicketPage(WebDriver driver) {
        super(driver);
    }

    public int checkTickets() {
        List<WebElement> tickets = driver.findElements(By.xpath("//div[@class='Flights-Results-ResultInfo multiple-legs']"));
        return tickets.size();
    }
}

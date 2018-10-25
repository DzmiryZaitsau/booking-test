package by.my.booking.accomodation;

import by.my.booking.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchRoomPage extends BasePage {

    public SearchRoomPage(WebDriver driver) {
        super(driver);
    }


    public int checkDoubleRooms() {
        List<WebElement> doubleRooms = driver.findElements(By.xpath("//span[contains(text(),'Двухместный номер с 1 кроватью')]"));
        return doubleRooms.size();
    }
}

package by.my.booking.carrentals;

import by.my.booking.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchCarsPage extends BasePage {
    public SearchCarsPage(WebDriver driver) {
        super(driver);
    }
    public int checkCars() {
        List<WebElement> cars = driver.findElements(By.xpath("//div[@class='address-wrap']"));
        return cars.size();
    }
}

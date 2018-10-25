package by.my.booking.airporttaxis;

import by.my.booking.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTaxisPage extends BasePage {
    public SearchTaxisPage(WebDriver driver) {
        super(driver);
    }

    public int checkAvailableTaxis() {
        List<WebElement> taxis = driver.findElements(By.xpath("//div[@class='rw-search-result']"));
        return taxis.size();
    }
}

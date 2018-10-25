package by.my.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    public WebDriver startChrom() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com");
        return driver;
    }

    public WebDriver switchWindow() {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return driver;
    }

    public void closeChrom() {
        if (driver != null) {
            driver.quit();
        }
    }
}
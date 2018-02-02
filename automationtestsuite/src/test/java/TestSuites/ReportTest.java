package TestSuites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.tagName;

public class ReportTest {

    static WebDriver driver;
    String line = ("*****************************************************************");


    @Before

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        //WebDriver driver = new SafariDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.dailymail.co.uk/sport/index.html");

    }

    @Test
    public void socialIcons() {
        if (driver.findElement(By.xpath("//ul[@class='dms-puff']")).isDisplayed()) {
            System.out.println(" All social share icons are present");
        } else {
            System.out.println("No social share icons are present");
        }

        List<WebElement> socialIcons = driver.findElement(By.xpath("")).

    }

}


@After
    public void teardown() {
        driver.quit();
}
        }
package TestSuites;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class CrossBrowser {

    @Test
    @Parameters("Browser")
    public void verifyBrowser(String browser) {

        if (browser.equalsIgnoreCase("FF")) {
            System.setProperty("webdriver.gecko.driver", "/Users/ker/Desktop/Webdrivers/gecko/geckodriver");

            WebDriver driver = new FirefoxDriver();

            driver.manage().window().maximize();

            driver.get("http://www.dailymail.co.uk/home/index.html");

            driver.quit();

        } else if (browser.equalsIgnoreCase("CH")) {

            System.setProperty("webdriver.chrome.driver", "/Users/ker/Desktop/Webdrivers/chrome/chromedriver");

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("http://www.dailymail.co.uk/home/index.html");

            driver.quit();
        }

    }

}

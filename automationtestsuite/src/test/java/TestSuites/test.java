package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {
WebDriver driver;
String line="*************************************************";


@Before
    public void setup() {
    System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://www.dailymail.co.uk");

}

@Test
    public void login() throws InterruptedException{
    List<WebElement> element = driver.findElement(By.cssSelector(".listHolder-3b2tc")).findElements(By.tagName("a"));
    Thread.sleep(1800);
    for (int i = 0; i < element.size(); i++) {
        System.out.println(element.get(i).getText());

    }
    System.out.println(line);
}

}

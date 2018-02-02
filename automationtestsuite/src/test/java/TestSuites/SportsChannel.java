package TestSuites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.tagName;

public class SportsChannel {
    WebDriver driver;
    String line = ("=============================");


    @Before

    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.dailymail.co.uk/sport/index.html");
    }

@Test
public void hoverAndClick() {
    //club-badges club-badges-big club-badges-2013-big cleared
    List<WebElement> teamPages = driver.findElement(By.cssSelector(".club-badges.club-badges-big.club-badges-2013-big.cleared")).findElements(By.tagName("li"));
    for (int i = 0; i < teamPages.size(); i++) {
        System.out.println(teamPages.get(i).findElement(By.tagName("a")).getAttribute("href"));
        teamPages.get(i).findElement(By.tagName("a")).click();
        driver.get("http://www.dailymail.co.uk/sport/index.html");
        teamPages = driver.findElement(By.cssSelector(".club-badges.club-badges-big.club-badges-2013-big.cleared")).findElements(By.tagName("li"));
    }
}
@Test
public void footballNavigationTab() {
    if (driver.findElement(By.id("football-navigation")).isDisplayed()) {
        System.out.println("Football Nsvigation Tabs are present");
    } else{
        System.out.println("No Football Navigation Tab is present");
    }

    List<WebElement> footballFixtures = driver.findElement(By.id("football-navigation")).findElements(By.tagName("li"));
    for (int i=0; i<footballFixtures.size(); i++) {
        System.out.println(footballFixtures.get(i).findElement(By.tagName("a")).getAttribute("href"));
        footballFixtures.get(i).findElement(By.tagName("a")).click();
        // driver.get("http://www.dailymail.co.uk/sport/index.html");
        footballFixtures = driver.findElement(By.id("football-navigation")).findElements(By.tagName("li"));
    }
    System.out.println(line);

}



@After
    public void teardown() {

        driver.quit();
    }


}
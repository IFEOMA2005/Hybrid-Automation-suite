package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.tagName;

public class SuiteRoom {

WebDriver driver;



    @Before
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        driver.get("http://www.dailymail.co.uk/sport/index.html");
    }




    @Test
    public void hoverAndClick() {
        //club-badges club-badges-big club-badges-2013-big cleared
        List<WebElement> teamPages = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div[2]/ul")).findElements(By.tagName("li"));
        System.out.println(teamPages.size());
        for(int i=0; i<teamPages.size(); i++) {
            System.out.println(teamPages.get(i).findElement(By.tagName("a")).getAttribute("href"));
            teamPages.get(i).findElement(By.tagName("a")).click();
            driver.get("http://www.dailymail.co.uk/sport/index.html");
            teamPages = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div[2]/ul")).findElements(By.tagName("li"));
        }



    }






   /* @Test
    public void navJump() throws InterruptedException {
        List<WebElement> primary = driver.findElements(By.cssSelector(".nav-primary.cleared.bdrgr3.cnr5")).get(0).findElements(By.tagName("li"));
        List<WebElement> second = driver.findElements(By.cssSelector(".float-l")).get(0).findElements(By.tagName("li"));

        for(int i=0; i<primary.size(); i++){

            for(int j=0; j<second.size(); j++) {
                primary = driver.findElements(By.cssSelector(".nav-primary.cleared.bdrgr3.cnr5")).get(0).findElements(By.tagName("li"));
                primary.get(i).click();
                Thread.sleep(700);
                second = driver.findElements(By.cssSelector(".float-l")).get(0).findElements(By.tagName("li"));
                second.get(j).click();
                System.out.println(i+ " "+j);
                Thread.sleep(700);

            }
*/


        }










   /* @Test
    public void navJump() throws InterruptedException {
        //driver.get("http://www.dailymail.co.uk");
        List<WebElement> primary = driver.findElements(By.cssSelector(".nav-primary.cleared.bdrgr3.cnr5")).get(0).findElements(By.tagName("li"));
        List<WebElement> second = driver.findElements(By.cssSelector(".float-l")).get(0).findElements(By.tagName("li"));

        for (int i = 0; i < primary.size(); i++) {

            for (int j = 0; j < second.size(); j++) {
                primary = driver.findElements(By.cssSelector(".nav-primary.cleared.bdrgr3.cnr5")).get(0).findElements(By.tagName("li"));
                primary.get(i).click();
                Thread.sleep(700);
                second = driver.findElements(By.cssSelector(".float-l")).get(0).findElements(By.tagName("li"));
                second.get(j).click();
                System.out.println(i + " " + j);
                Thread.sleep(700);

            }

        }
*/




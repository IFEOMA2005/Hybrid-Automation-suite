package TestSuites;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScienceChannel {


    WebDriver driver;
    String line = ("====================================");

    @BeforeTest

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        //driver.navigate().refresh();
        driver.get("http://www.dailymail.co.uk");
        driver.findElement(By.xpath("//*[@id='page-container']/div[2]/ul/li[9]/span/a")).click();

    }


    @Test
    public void weather() {
        if (driver.findElement(By.id("weather-wrapper")).isDisplayed()) {
            System.out.println("Weather icon is visible");
        } else {
            System.out.println("Weather icon failed");


        }
    }
    // This is for the Sub-Channel
    @Test
    public void subChannel() {
        if (driver.findElement(By.xpath("//*[@id='page-container']/div[2]/div[2]/div/ul[1]/li/a")).isDisplayed()) {

            System.out.println("The Sub-Channel is visible");
        } else {
            System.out.println("Sub-Channel is not visible");
        }

        driver.findElement(By.linkText("Science")).click();
        List<WebElement> totalLinks = driver.findElements(By.cssSelector(".nav-secondary ul:first-child li a"));
        int s = totalLinks.size();
        System.out.println(s);

        for (int t=1; t<s;t++){

        }
    }

    @Test
    public void backToTop() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", " ");

        driver.findElement(By.xpath("//*[@id='ext-gen104']")).click();

        jse.executeScript("window.scrollBy(0,-250)", "");

        if (driver.findElement(By.xpath("//*[@id='ext-gen104")).isDisplayed()) {
            System.out.println("Back To Top is displayered");
        } else {
            System.out.println("Back to top is not displayed");
        }
    }

    @Test
    public void billBoardContainer() {

        if (driver.findElement(By.cssSelector("#billBoard")).isDisplayed()) {
            System.out.println("Billbord is present");
        } else {
            System.out.println("Billbord is NOT PRESENT");
        }
        try {
            if (driver.findElement(By.cssSelector("#billBoard")) != null) {
                System.out.println("Billbord Ad is present");
            } else {
                System.out.println("Billbord Ad is NOT PRESENT");
            }
            System.out.println(line);
        } catch (Exception e) {
        }

        System.out.println(line);
    }

    @Test
    public void AllImagesAndLinks() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> wele = driver.findElements(By.tagName("a"));
        int we = wele.size();
        System.out.println("Total Number of Links" + we);

        List<WebElement> weleim = driver.findElements(By.tagName("img"));
        int img = weleim.size();
        System.out.println("Total Number of Links" + img);


    }
    @Test
    public void AdsaboveSocialShare() throws Exception {
        if (driver.findElement(By.id("mpu_top")).isDisplayed()) {
            System.out.println("Ad wrapper is present");
        } else {
            System.out.println("Ad wrapper is NOT PRESENT");

            System.out.println(line);
        }

    }


    public void rssFeeder() throws Exception {
        driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div[2]/div[5]/div")).getText();
    }

    public void todayheadline() throws InterruptedException{
        //driver.findElement(By.xpath(""))
        driver.findElement(By.xpath("//*[@id='p-249']/div/div")).getText();
    }
}

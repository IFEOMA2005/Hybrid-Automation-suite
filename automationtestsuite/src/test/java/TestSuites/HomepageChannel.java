package TestSuites;

//import org.junit.Before;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomepageChannel {
   static WebDriver driver;
    String line = ("****************************************************************************************");

  @BeforeTest
  public static void setup() {
      System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
      driver = new ChromeDriver();
      //WebDriver driver = new SafariDriver();
      //driver.manage().window().fullscreen();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://www.dailymail.co.uk/home/index.html");

  }
    public void highLight(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("console.log(arguments[0].style.border='thick solid red')",
                    element);
        }
    }


    public void goTO(String URL) {
        driver.get(URL);
    }


    public void moveToLocation(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);

        action.perform();
    }

    public List<WebElement> getElements(String className) {

        List<WebElement> elements = driver.findElements(By.cssSelector((className)));
        return elements;

    }

    public List<WebElement> getPuffListItems(List<WebElement> webElement, int puffListNumber) {
        return webElement.get(puffListNumber).findElements(By.tagName("li"));
    }

    public void printElementsAndMove(List<WebElement> list, int number) throws InterruptedException {
        for (int i = 0; i < number; i++) {
            System.out.println(list.get(i).getText());
            Thread.sleep(1700);
            moveToLocation(list.get(i));
        }
    }

// ExtentReports Description
    // ** ExtentTestManager.getTest().setDescription("Homepage Channel testing.");
    @Test
    public void countPuffsTest() throws InterruptedException {

        //driver.get("http://www.dailymail.co.uk");
        List<WebElement> elements = driver.findElements(By.cssSelector((".link-bogr2.linkro-wocc")));
        WebElement puffList = elements.get(0);
        List<WebElement> puffListItems = puffList.findElements(By.tagName("li"));
        int numberToCount = puffListItems.size();
        Actions action = new Actions(driver);
        for (int i = 0; i < numberToCount; i++) {
            System.out.println(puffListItems.get(i).getText());
            action.moveToElement(puffListItems.get(i));
            if (driver instanceof JavascriptExecutor) {

                ((JavascriptExecutor) driver).executeScript("console.log(arguments[0].style.border='thick solid red')",
                        puffListItems.get(i));
                if (i > 0) {
                    ((JavascriptExecutor) driver).executeScript("console.log(arguments[0].style.border='none')",
                            puffListItems.get(i - 1));
                }
            }
            action.perform();
            Thread.sleep(1300);
        }

        System.out.println(line);
    }


    @Test
    public void mostSharedNewsTest() throws InterruptedException {
        // driver.get("http://www.dailymail.co.uk/home/index.html");
        List<WebElement> element = driver.findElement(By.cssSelector(".listHolder-3b2tc")).findElements(By.tagName("a"));
        Thread.sleep(1800);
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    @Test
    public void searchField() {
        if (driver.findElement(By.xpath("//*[@id='content']/div[2]/div[4]/div[2]/div[2]/ul/li[1]/a")).isDisplayed()) {
            System.out.println("Facebook Icon is displayed");
        } else {
            System.out.println("Facebook icon is not displayed");
        }

        if (driver.findElement(By.xpath("//*[@id='content']/div[2]/div[4]/div[2]/div[2]/ul/li[2]/a")).isDisplayed()) {
            System.out.println("Twitter Icon is displayed");
        } else {
            System.out.println("Twitter Icon is not displayed");
        }
        System.out.println(line);
    }

    // Header icon facebook icon and weather

    @Test
    public void topIcons() {


        if (driver.findElement(By.xpath(".//*[@id='page-container']/div[2]/div[3]/div[1]/div[2]/img")).isDisplayed()) {
            System.out.println("Facebook Top Icon is displayed");
        } else {
            System.out.println("Facebook Icon is not visible");
        }
        driver.findElement(By.cssSelector("#weather-wrapper>a")).getAttribute("value");
        if (driver.findElement(By.cssSelector("#weather-wrapper>a")).isDisplayed()) {
            System.out.println("Weather icon is displayed");
        } else {
            System.out.println("There are no weather icon displayed");
        }
        System.out.println(line);
    }
    // WATCH: TODAY'S TOP VIDEO

    @Test
    public void todayTopVideo() throws Exception {
        String HVC = driver.findElement(By.cssSelector(".video_carousel_title.bdrcc")).getText();

        if (HVC.contains("WATCH: TODAY'S TOP VIDEOS")) {
            System.out.println("Today's Video is in display");
        } else {
            System.out.println(" Top Video is not active");
        }
        List<WebElement> element = driver.findElements(By.xpath("//*[@class='rotator link-wocc linkro-womlcc']/ul/li/a"));
        Thread.sleep(1300);
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    //   Ads Sky Auto Refresh
    @Test
    public void autoSkyRefresh() {
        if (driver.findElement(By.xpath("//*[@id='js-sky-left']")).isDisplayed()) {
            System.out.println("Left Sky Auto Refresh is active");
        } else {
            System.out.println("No Left Sky Auto Refresh ");
        }
        if (driver.findElement(By.xpath("//*[@id='js-sky-right']")).isDisplayed()) {
            System.out.println("Right Sky Auto Refresh is Active");
        } else {
            System.out.println("No Right Sky Auto Refresh is Active");
        }
    }

    // In Femail Today
    @Test
    public void inFemailToday() throws Exception {
        String FFF = driver.findElement(By.cssSelector(".fff-hottest-header")).getText();
        if (FFF.contains("Today's hottest fashion finds")) {
            System.out.println("Fashion Finder is displayed");
        } else {
            System.out.println("Fashion Finder is down");
        }
        List<WebElement> element = driver.findElements(By.xpath("//*[@class='fff-hottest-list']/ul/li"));
        Thread.sleep(1300);
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }

        System.out.println(line);
    }

    // WATCH: TODAY'S TOP SHOWBIZ VIDEOS
    @Test
    public void todayTopShowbizVideo() throws Exception {

        if (driver.findElement(By.xpath("//div[@data-track-module='sm-723^video_carousel_module']/div[2]/div[2]/ul/li")).isDisplayed())
        {
            System.out.println("Showbiz Video is Displayed");
        }

        List<WebElement> element = driver.findElements(By.xpath("//div[@data-track-module='sm-723^video_carousel_module']/div[2]/div[2]/ul/li"));
        Thread.sleep(1300);
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    // showbiz extra puff

    @Test
    public void showbizExtraPuff() {
        if (driver.findElement(By.xpath("//*[@data-track-module='llg-1001134^puff']/ul/li/a")).isDisplayed())
        {
            System.out.println("Showbiz Extra Puff is displayed");
        } else {
            System.out.println("Showbiz Extra Puff is not Listed");
        }
        List<WebElement> element = driver.findElements(By.xpath("//*[@data-track-module='llg-1001134^puff']/ul/li/a"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }
    // TOP SPORTS STORIES
    @Test
    public void topSportsStories() {
        if (driver.findElement(By.xpath("//*[@data-track-module='llg-1000118^puff']/ul/li/a")).isDisplayed())
        {
            System.out.println("Top Sport Stories is Displayed");
        } else {
            System.out.println("Top Sport Stories is not in View");
        }
        List<WebElement> element = driver.findElements(By.xpath("//*[@data-track-module='llg-1000118^puff']/ul/li/a"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    // WATCH: EDITTOR'S TOP PICKS.....
    @Test
    public void editorsTopPicks() {
        if (driver.findElement(By.xpath("//div[@data-track-module='llg-62027998^video_mosaic']/div[2]/div[2]/ul/li")).isDisplayed()) {
            System.out.println("Editors Top Video is Active");
        } else {
            System.out.println("Editors Video not Active");
        }
        List<WebElement> element = driver.findElements(By.xpath("//div[@data-track-module='llg-62027998^video_mosaic']/div[2]/div[2]/ul/li"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }


    // Voucher Buttons
    @Test
    public void voucherButtons() {
        if (driver.findElement(By.xpath("//div[contains(@class,'gamma')]")).isDisplayed()) {
            System.out.println("Vouchers visible");
        } else {
            System.out.println("There are no voucher buttons");
        }
    }

    // Bottom Navigation Tab
    @Test
    public void navigationTabs() {
        if (driver.findElement(By.xpath("//ul[@class='nav-primary cleared bdrgr3']")).isDisplayed())
        {  System.out.println("All the Footer buttons are displayed");
        } else

        {
            System.out.println("No Footer buttons are displayed");
        }
        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='nav-primary cleared bdrgr3']/li"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    // The Footer List
    @Test
    public void footerLists() {
        if (driver.findElement(By.xpath("//div[contains(@class,'page-footer')]")).isDisplayed()) {
            System.out.println("All the footer hyper-Linked text are Present");
        } else {
            System.out.println("No footer is present");
        }
        List<WebElement> element = driver.findElements(By.xpath("//div[contains(@class,'page-footer')]/a"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    @Test
    public void pageFooter() {
        if (driver.findElement(By.xpath("//div[contains(@data-track-module,'nav-and_footer^and_footer')]")).isDisplayed())
        { System.out.println("PageFooter is displayed correctly");
        } else{
            System.out.println("No PageFooter is displayed ");
        }
        List<WebElement> element = driver.findElements(By.xpath("//div[contains(@data-track-module,'nav-and_footer^and_footer')]/a"));
        for (int i = 0; i < element.size(); i++) {
            System.out.println(element.get(i).getText());
            highLight(element.get(i));
            moveToLocation(element.get(i));
        }
        System.out.println(line);
    }

    // Tracking BackTo Top Button
    @Test
    public void backtoTop() {
        if (driver.findElement(By.xpath("//a[contains(.,'Back to top')]")).isDisplayed()) {
            System.out.println("Back to Top");
        } else {
            System.out.println("There's no Back to top");
        }
    }

    // MPU Slots
    @Test
    public void mpuSlots() {

    }
    @AfterTest
    public void teardown() {
        driver.quit();
    }


}

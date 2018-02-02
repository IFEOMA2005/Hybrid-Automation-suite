package TestSuites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestStudio {

    WebDriver driver;

    @BeforeTest
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        driver.get("http://www.dailymail.co.uk/home/index.html");
    }
    public void highLight(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("console.log(arguments[0].style.border='thick solid red')",
                    element);
        }
    }

@Test
    public void getAllArticles() throws InterruptedException{
        //.article.article-small
        //.article.article-large cleared
        //.article.article-tri-headline
        //setup();
        //river.get("http://www.dailymail.co.uk");
        List<WebElement> small = driver.findElements(By.cssSelector(".article.article-small"));
        List<WebElement> side = driver.findElements(By.cssSelector(".article.article-large.cleared"));
        List<WebElement> doubles = driver.findElements(By.cssSelector(".article.article-tri-headline"));
        List<WebElement> allArticles = new ArrayList<WebElement>();
        for(int i=0; i<small.size(); i++){
            allArticles.add(small.get(i));
            System.out.println("small articles found");
        }
        for(int i=0; i<side.size(); i++){
            allArticles.add(side.get(i));
            System.out.println("side articles found");
        }
        for(int i=0; i<doubles.size(); i++){
            allArticles.add(doubles.get(i));
            System.out.println("normal/triple articles found");
        }
        for(int i=0; i<allArticles.size(); i++){
            Thread.sleep(700);
            moveToLocation(allArticles.get(i));
            highLight(allArticles.get(i));
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
            Thread.sleep(700);
            moveToLocation(list.get(i));
        }
    }
    @AfterTest
    public void teardown()
    {

        driver.quit();
    }
}

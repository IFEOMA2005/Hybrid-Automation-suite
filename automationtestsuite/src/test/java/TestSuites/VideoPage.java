package TestSuites;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class VideoPage {

    WebDriver driver;


    @Before

    public void setupChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test
    public void videoAdTest() {
        driver.get("http://www.dailymail.co.uk/news/article-5023837/Shocking-video-shows-man-hurl-rival-bus-Alloa.html");
        driver.findElement(By.cssSelector(".vjs-big-play-button")).click();
        WebElement ads = driver.findElement(By.cssSelector(".ima-control.ima-countdown-div"));
        Actions action = new Actions(driver);
        action.moveToElement(ads);
        action.perform();
        System.out.println(ads.isDisplayed());
        assertTrue("ad is present", ads.isDisplayed());
        Assert.assertTrue(true);

    }


    @AfterTest
    public void tearDown() {

        driver.quit();
    }

}

//Open the page containing video component.
      /*  driver.get("http://html5video.org/wiki/JW_HTML5_Video_Player");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//If video is placed in embed tag or iframe, navigate to the source.
//However, we can even switch to frame. [Else, skip this step]
        WebElement elm = driver.findElement(By.id("video_iframe"));
        String urlStr = elm.getAttribute("src");
        System.out.println("Video Url : " + urlStr);
        driver.navigate().to(urlStr);
        cdrv.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
//Click on play button
        jse.executeScript("jwplayer().play();");
        Thread.sleep(2000);
//Pause
        jse.executeScript("jwplayer().pause()");
        Thread.sleep(2000);
//Play
        jse.executeScript("jwplayer().play();");
        Thread.sleep(2000);
// Set Volume
        Thread.sleep(2000);
        jse.executeScript("jwplayer().setVolume(50);");
        Thread.sleep(2000);
//Mute Player
        jse.executeScript("jwplayer().setMute(true);");
        Thread.sleep(2000);
//UnMute Player
        jse.executeScript("jwplayer().setMute(false);");
        Thread.sleep(2000);
//Stop the player
        jse.executeScript("jwplayer().stop()");
        Thread.sleep(2000);
        driver.quit();*/
//https://advancedtestautomation.blogspot.co.uk/2016/07/test-video-using-selenium-webdriver.html?m=1
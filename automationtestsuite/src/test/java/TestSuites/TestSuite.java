package TestSuites;

import gherkin.lexer.It;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestSuite {

    public WebDriver driver;
    WebElement element;

    private String url = "http://www.dailymail.co.uk";

    //Current Directory
    private String currentDir = System.getProperty("user.dir");

    //GetScreenShot Method Directory and Image File
    private File getSreenShotMethodImageFile = new File (currentDir +
            "/ScreenShots/GetScreenShotMethod/amazonscreenshot.png");

    //Element Screenshot Directory and Image File
    private File webElementImageFile = new File(currentDir +
            "/ScreenShots/WebElement/logo.png");

    //Entirepage ScreenShot Directory and Image File
    private File entirePageImageFile = new File(currentDir +
            "/ScreenShots/EntirePage/entirepage.png");


    //Setup Driver
    @BeforeTest
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.navigate().to(url);

    }

    @Test
    public void screenshotGetScreenShotAs() throws IOException {
        //Take Screenshot of viewable area
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Write Screenshot to a file
        FileUtils.copyFile(scrFile, getSreenShotMethodImageFile);
    }

    /*@Test
    public void screenshotWebElementAshot() throws IOException {
        WebElement logo = driver.findElement(By.cssSelector(".nav-logo-link .nav-logo-base"));
        //Take Screenshot
        Screenshot elementScreenShot = new AShot().takeScreenshot(driver, logo);
        //Write Screenshot to a file
        ImageIO.write(elementScreenShot.getImage(),"PNG", webElementImageFile);
    }*/


    /*screenshotGetScreenShotAs: It takes viewable screen’s screenshot. Like a print screen operation.
            screenshotWebElementAshot: It takes an element’s screenshot by using AShot. But it is not working after new upgrades so I commented out this method. Before it was working flawlessly.
            screenshotWebElement2: It takes an element screenshot by cropping element size from an entire viewable area’s screenshot.
    screenshotEntirePageAshot: It takes all (entire) screenshot of a website from top to bottom.*/

    @Test
    public void screenshotWebElement2() throws IOException {
        //Find the element
        WebElement logo = driver.findElement(By.cssSelector(".nav-logo-link .nav-logo-base"));

        // Get viewable area's screenshot
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        Point point = logo.getLocation();

        // Get width and height of the element
        int eleWidth = logo.getSize().getWidth();
        int eleHeight = logo.getSize().getHeight();

        // Crop element from viewable area's screenshot to get element's screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        //Write Screenshot to a file
        FileUtils.copyFile(screenshot, webElementImageFile);
    }


    @Test
    public void screenshotEntirePageAshot() throws IOException {
        //Take Screenshot of entire page by AShot
        Screenshot entirePageScreenShot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        //Write Screenshot to a file
        ImageIO.write(entirePageScreenShot.getImage(),"PNG", entirePageImageFile);
    }

    //Close Driver
    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}

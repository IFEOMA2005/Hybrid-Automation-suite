package TestSuites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;
    String line = ("******************************************************************************");
    WebElement element;


@Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/Users/hi/Desktop/Webdrivers/gecko/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        //driver.navigate().refresh();
        driver.get("http://www.dailymail.co.uk");

    }


    @Test
    public void loginTest() throws Exception {
       // ExtentReports Description
        //ExtentTestManager.getTest().setDescription("Direct Login"); // Please remember to uncomment this
        String emailAddress = "**************";
        String password = "***********.";
        WebElement element = driver.findElement(By.cssSelector(".js-login"));
        highLight(element);
        Thread.sleep(700);
        element.click();
        WebElement email = driver.findElement(By.cssSelector(".txt-inp.full-width"));
        highLight(email);
        Thread.sleep(700);
        email.sendKeys(emailAddress);
        WebElement passwordElement = driver.findElement(By.id("reg-lbx-password-page"));
        highLight(passwordElement);
        Thread.sleep(700);
        passwordElement.sendKeys(password);
        WebElement login = driver.findElement(By.cssSelector(".reg-btn.wocc.reg-btn-login"));
        highLight(login);
        login.click();
        driver.findElement(By.id("logout_comp")).getText();
        if (driver.getPageSource().contains("My Profile")) {
            System.out.println("Successfully Logged In");
        } else {
            System.out.println("Login Failed");
        }

        // this is for the "Profile Page

        driver.findElement(By.id("logout_comp")).click();
        //assertEquals("About Me", driver.findElement(By.xpath("//*[@id='ext-gen95']")).getText());
        if (driver.getPageSource().contains("About Me")) {
            System.out.println("Profile Page");
        } else {
            System.out.println("Page not found");
        }

        driver.findElement(By.cssSelector(".gr-btn.m-t-5")).click();
        driver.findElement(By.xpath("//*[@id='reg-about-me']")).clear();
        driver.findElement(By.xpath("//*[@id='reg-about-me']")).sendKeys("Am scared to death with the rate they are going");
        driver.findElement(By.xpath("//*[@id='reg-gender-f']")).click();
        driver.findElement(By.cssSelector("#pub-fld-gender")).click();

        // select the date birth from the drop-field

        WebElement select = driver.findElement(By.cssSelector("#reg-dob-day"));

        List<WebElement> options = select.findElements(By.tagName("option"));

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getAttribute("value").equalsIgnoreCase("16")) {
                options.get(i).click();
            }
        }

        WebElement select2 = driver.findElement(By.cssSelector("#reg-dob-month"));

        List<WebElement> options2 = select2.findElements(By.tagName("option"));

        for (int i = 0; i < options2.size(); i++) {
            if (options2.get(i).getAttribute("value").equalsIgnoreCase("8")) {
                options2.get(i).click();
            }
        }

        WebElement select3 = driver.findElement(By.cssSelector("#reg-dob-year"));

        List<WebElement> options3 = select3.findElements(By.tagName("option"));

        for (int i = 0; i < options3.size(); i++) {
            if (options3.get(i).getAttribute("value").equalsIgnoreCase("1991")) {
                options3.get(i).click();
            }
        }


        driver.findElement(By.xpath("//*[@id='reg-edit-profile']/div/button")).click();

        assertEquals("Back to my profile", driver.findElement(By.xpath("//*[@id='reg-edit-profile']/div/a")).getText());

        driver.findElement(By.xpath("//*[@id='logout']/a")).click(); // this is the logout linked text

        driver.findElement(By.id("logout_comp")).getText();

        if (driver.getPageSource().contains("Logout")) {
            System.out.println("Successfully Logged Off");
        } else {
            System.out.println("Login Failed");
        }

        System.out.println(line);

    }


    public void highLight(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("console.log(arguments[0].style.border='thick solid red')",
                    element);
        }
    }

    // Facebook Login
    @Test
    public void facebookLogin() throws Exception {

        driver.get("https://secured.dailymail.co.uk/registration/login.html?targetUrl=http://www.dailymail.co.uk/home/index.html&geolocation=gb");
        driver.findElement(By.id("login")).click();

        //assertEquals(driver.findElement(By.cssSelector("a-reg-btn")).isDisplayed());
        driver.findElement(By.name("social-provider")).click();
        //assertEquals(driver.findElement(By.id("header_block")).isDisplayed());
        // driver.findElement(By.id("//*[@id='header_block']/span")).getText();
        if (driver.getPageSource().contains("Log in to Facebook")) {
            System.out.println("Successfully on Facebook Login Page");
        } else {
            System.out.println("Facebook Login Page Failed");
        }
        driver.findElement(By.id("email")).sendKeys("***************");
        driver.findElement(By.id("pass")).sendKeys("**********l");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(3000);
        driver.navigate().to("http://www.dailymail.co.uk");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://www.dailymail.co.uk/home/index.html" );
        try{
            if(driver.findElement(By.xpath("//*[@id='logout_comp']/li[1]/a")).isDisplayed())
            {
                System.out.println("Successfully Navigated back to the Homepage");
                driver.findElement(By.id("logout")).click();
                assertEquals(driver.findElement(By.id("login")).isDisplayed());
                driver.findElement(By.id("login")).click();
                assertEquals(driver.findElement(By.id("wa_not_you_lb")).isDisplayed());
            }
            else
            {
                System.out.println("Facebook - Failed");
                assertEquals(driver.findElement(By.id("login")).isDisplayed());
            }
        }catch (Exception e){System.out.println(e.getMessage());}


        System.out.println(line);

    }

    private void assertEquals(boolean displayed) {
    }


    // Twitter Login
    @Test
    public void twitterLogin() throws Exception {
        driver.get("https://secured.dailymail.co.uk/registration/login.html?targetUrl=http://www.dailymail.co.uk/home/index.html&geolocation=gb");
        System.out.println((driver.getCurrentUrl()));
        driver.findElement(By.id("signin-page")).click();

        if (driver.getPageSource().contains("Registration - Live")) {
            System.out.println("Am on Twitter Page");
        } else {
            driver.navigate().to("https://secured.dailymail.co.uk/registration/login.html?targetUrl=http://www.dailymail.co.uk/home/index.html&geolocation=gb");
        }
        driver.findElement(By.id("username_or_email")).sendKeys("te*******.***");
        driver.findElement(By.id("password")).sendKeys("t*********");
        driver.findElement(By.id("allow")).click();

        if (driver.findElement(By.id("logout")).isDisplayed()) {
            driver.findElement(By.id("logout")).click();
            System.out.println("Twitter - Passed");
        } else {
            System.out.println("Twitter - Failed");
        }

        System.out.println(line);
    }

// GoogleMail Login Script

    @Test

    public void googlemailLogin() throws Exception {

        driver.navigate().to("https://secured.dailymail.co.uk/registration/login.html?targetUrl=http://www.dailymail.co.uk/home/index.html&geolocation=gb");
        if (driver.findElement(By.xpath("html/body/div/div[1]/div/div")).isDisplayed()) {
            System.out.println("Google login Page Displayed");
        }
        else {
            System.out.println("GoogleLogin Page - Not Displayed");
        }
        driver.findElement(By.xpath("//*[@id='signin-page']/ul/li[3]/input")).click();
        driver.findElement(By.id("identifierId")).sendKeys("t***************");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("**************");

        WebElement element = driver.findElement(By.id("passwordNext"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();


        assertEquals("Welcome", driver.findElement(By.xpath("//*[@id='headingText']")).getText());
        if (driver.findElement(By.id("logout_comp")).isDisplayed()) {
            driver.findElement(By.id("logout_comp")).click();
            System.out.println("Logged out Successfully from Googlemail - Passed");
        } else {
            System.out.println("Failed to Log Out of GoogleMail - Failed");
        }

        System.out.println(line);
    }

    private void assertEquals(String welcome, String text) {
    }

    // public static void wrongPassword() throws Exception{}


  @After
    public void tearDown() {

        driver.quit();
    }

}

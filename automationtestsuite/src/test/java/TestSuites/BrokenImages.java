package TestSuites;

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

public class BrokenImages {

    WebDriver driver;
    String line = ("***************************************************************************************");

    @Before

    public void setup () {
        System.setProperty("webdriver.chrome.driver", "/Users/?????/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test

    public void setupLinks() throws InterruptedException{

        driver.get("https://www.dailymail.co.uk/home/index.html");

        //Find total No of images on page and print In console.
        List<WebElement> total_images = driver.findElements(By.tagName("img"));
        System.out.println("Total Number of images found on page = " + total_images.size());

        //for loop to open all images one by one to check response code.
        boolean isValid = false;
        for (int i = 0; i < total_images.size(); i++) {
            String url = total_images.get(i).getAttribute("src");

            if (url != null) {

                //Call getResponseCode function for each URL to check response code.
                //isValid = getResponseCode(url);

                //Print message based on value of isValid which Is returned by getResponseCode function.
                if (isValid) {
                    System.out.println("Valid image:" + url);
                    System.out.println("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
                    System.out.println();
                } else {
                    System.out.println("Broken image ------> " + url);
                    System.out.println("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
                    System.out.println();
                }
            } else {
                //If <a> tag do not contain href attribute and value then print this message
                System.out.println("String null");
                System.out.println("----------XXXX-----------XXXX----------XXXX-----------XXXX----------");
                System.out.println();
                continue;
            }
        }

        System.out.println(line);
    }


    @AfterTest
    public void teardown(){

        driver.quit();
    }

}



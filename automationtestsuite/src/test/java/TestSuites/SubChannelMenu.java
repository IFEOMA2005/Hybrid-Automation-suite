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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubChannelMenu {

    WebDriver driver;
    String line = ("******************************************");

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/alihawker/Desktop/Webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.dailymail.co.uk");

    }


    @Test

    public void test() throws InterruptedException {
        for (int m=1;m<=13;m++){

            String expectedh1=driver.findElement(By.xpath("//*[@id='page-container']/div[2]/ul/li["+m+"]/span/a")).getText();

            driver.findElement(By.xpath("//*[@id='page-container']/div[2]/ul/li["+m+"]/span/a")).click();

            String actualh1= driver.findElement(By.cssSelector(".h1-page-last-updated>h1")).getText();

            try{actualh1.contains(expectedh1);System.out.println("H1 is Present for "+expectedh1+ "channel");}

            catch(Exception e){System.out.println("***** H1 is NOT Present for "+expectedh1+ "channel ****");
                System.out.println(e.getMessage());
            }

            //Count list of elements in sub-channel

            List<WebElement> totalLinks = driver.findElements(By.cssSelector(".nav-secondary ul:first-child li a"));

            int s = totalLinks.size();

            System.out.println(s);

            for(int i=0;i<=s;i++){

                WebElement ele=totalLinks.get(i);
                String name=ele.getText();
                System.out.println(name);
            }



            for(int j=1;j<s;j++){

                String parent = driver.getWindowHandle();
                String expected= driver.findElement(By.xpath("//*[@id='page-container']/div[2]/div[2]/div/ul[1]/li["+j+"]/a")).getAttribute("href");
                String NewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);

                driver.findElement(By.xpath("//*[@id='page-container']/div[2]/div[2]/div/ul[1]/li["+j+"]/a")).sendKeys(NewTab);

                Thread.sleep(3000);
                ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(child.get(1));
                Thread.sleep(1000);
                System.out.println("Test pass for "+ expected);
                System.out.println(driver.getCurrentUrl());



                driver.close();driver.switchTo().window(parent);

            }
        }



    }
    @AfterTest

    public void after(){

        driver.quit();
    }

}





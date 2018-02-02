package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks {
    static WebDriver driver;
    String line = ("*****************************************************************");

    @Before

    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/Users/alihawker/Desktop/Webdrivers/gecko/geckodriver");
        driver = new FirefoxDriver();
        //WebDriver driver = new SafariDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.dailymail.co.uk/home/index.html");

    }

    @Test
    public  void main() throws InterruptedException {
        //driver.get("http://www.dailymail.co.uk/home/index.html");
        Thread.sleep(5000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        //To print the total number of links
        System.out.println("Total links are "+links.size());
        //used for loop to
        for(int i=0; i<links.size(); i++) {
            WebElement element = links.get(i);
            //By using "href" attribute, we could get the url of the requried link
            String url=element.getAttribute("href");
            verifyLink(url);
        }
    }

    public  void verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter
            URL link = new URL(urlLink);
            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            //Set the timeout for 2 seconds
            httpConn.setConnectTimeout(2000);
            //connect using connect method
            httpConn.connect();
            //use getResponseCode() to get the response code.
            if(httpConn.getResponseCode()== 200) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(httpConn.getResponseCode()== 400) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(httpConn.getResponseCode()== 404) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(httpConn.getResponseCode()== 500) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage());
            }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server.
        catch (Exception e) {
            //e.printStackTrace();

        }
        System.out.println(line);
    }


    @AfterTest
    public void teardown(){

        driver.quit();
    }
}



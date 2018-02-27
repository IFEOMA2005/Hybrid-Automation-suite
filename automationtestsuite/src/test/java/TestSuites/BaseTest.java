package TestSuites;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

public WebDriver driver;

    

@Before

        public void BeforeMethod(){
            System.out.println("I am in Before Method! Test is starting!");
        }

@After

 public void AfterMethod(){
            System.out.println("I am in After Method! Test is ending!");

        }

    public WebDriver getDriver() {
        return driver;
    }
}


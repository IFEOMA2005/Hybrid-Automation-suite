/*
package TestSuites;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NetworkTraffic {

    @Test

    public static void  Exception(){

        final BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar("dailymail.co.uk");

        final FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.http","localhost");
        profile.setPreference("network.proxy.http_port",proxy.getPort());
// profile.setPreference("network.proxy.ssl", "localhost");
// profile.setPreference("network.proxy.ssl_port", proxy.getPort());
        profile.setPreference("network.proxy.type",1);

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxDriver.PROFILE,profile);

        System.setProperty("webdriver.gecko.driver", "/Users/alihawker/Desktop/Webdrivers/firefox/geckdriver");
        final WebDriver driver = new FirefoxDriver(new FirefoxOptions(capabilities));


        driver.get("http://www.dailymail.co.uk/home/index.html");

        for(
                final HarEntry harEntry :proxy.getHar().

                getLog().

                getEntries())

        {
            System.out.println(harEntry.getRequest().getUrl());
        }
        boolean rtaFound = false;
        for (final HarEntry harEntry : proxy.getHar().getLog().getEntries()) {
            if (harEntry.getRequest().getUrl().toLowerCase().contains("rta.dailymail.co.uk")) {
                rtaFound = true;
            }

        }



        driver.quit();

    }






}
*/

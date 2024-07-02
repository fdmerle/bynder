package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settingsObj.Settings;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Driver {
    RemoteWebDriver remoteWebDriver;
    static Logger logger = Logger.getLogger(Driver.class.getName());

    public Driver() {
        try {
            URL url = new URL("http://localhost:4444/wd/hub");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("–ignore-ssl-errors=yes");
                    chromeOptions.addArguments("–ignore-certificate-errors");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    Map prefs = new HashMap();
                    prefs.put("profile.default_content_settings.cookies", 2);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    remoteWebDriver = new RemoteWebDriver(url, chromeOptions);
        } catch (MalformedURLException e) {
            throw new NoSuchElementException("incorrect URL");
        }
    }

    public boolean waitElementToBeVisible(String webElementXpath, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOut));
        for (int i = 0; i < timeOut * 2; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(webElementXpath))));
                return true;
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new NoSuchElementException("No such element: " + webElementXpath);
                }

            }
        }
        return false;
    }

    public void waitToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebDriver getWebDriver() {
        return remoteWebDriver;
    }

    public void cleanWebDriver() {
        remoteWebDriver.quit();

    }

    public void waitElementToBeVisible(By byObject) {
        logger.setLevel(Level.FINE);
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(Settings.loadingTime));
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(byObject)));
        } catch (Exception e) {
            logger.log(Level.WARNING, "Element not present");
        }
    }
}

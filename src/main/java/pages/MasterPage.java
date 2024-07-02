package pages;

import settingsObj.Settings;
import wrappers.Driver;
import wrappers.WebObject;

import java.util.Objects;


public class MasterPage {
    private Driver webDriver;

    public void setWebDriver(Driver driver) {
        this.webDriver = driver;
    }

    public Driver getWebDriver() {
        return webDriver;
    }

    public void doClick(Driver driver, WebObject webObject) {
        driver.waitToBeClickable(webObject.byObject, Settings.loadingTime);
        driver.getWebDriver().findElement(webObject.byObject).click();
    }


    public void enterText(Driver driver, WebObject webObject, String textToEnter) {
        driver.waitElementToBeVisible(webObject.byObject);
        if (textToEnter == null) {
            textToEnter = "";
        }
        driver.getWebDriver().findElement(webObject.byObject).sendKeys(textToEnter);

    }

    public boolean driverExist(Driver driver) {
        return Objects.isNull(driver);
    }


}

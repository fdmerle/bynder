package pages;

import wrappers.Driver;
import wrappers.WebObject;


public class MainPage extends MasterPage {
	Driver driver;
	public MainPage(Driver driver){
		setWebDriver(driver);
	}
	WebObject signUpSuccessful = new WebObject("xpath", ".//a[@title='%s']");
	public boolean containsTitle(String loginText) {
		boolean result = getWebDriver().waitElementToBeVisible(signUpSuccessful.addStringToXpath(loginText).objectValue, 10);
		getWebDriver().cleanWebDriver();
		 return result;
	}
}

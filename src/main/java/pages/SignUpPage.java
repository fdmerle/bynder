package pages;

import wrappers.Driver;
import wrappers.WebObject;


public class SignUpPage extends MasterPage {
	private Driver webDriver;
	private final String url = "https://wave-trial.getbynder.com/login/";
	WebObject signUpName = new WebObject("id", "inputEmail");
	WebObject signUpPassword = new WebObject("id", "inputPassword");
	String xpathType = "xpath";
	WebObject signUpSubmit = new WebObject(xpathType, ".//button[@type='submit']");
	WebObject cancelCookies = new WebObject(xpathType,".//div[@role='dialog']//button[text()='Reject All']");
	WebObject signUpUnSuccessful = new WebObject(xpathType, ".//a[@title='Bynder']");


	public SignUpPage() {
		if (driverExist(webDriver)) {
			webDriver = new Driver();
			webDriver.getWebDriver().get(url);
		}
	}
	public void fillSignUpForm(String login, String password) {
		enterText(webDriver, signUpName, login);
		enterText(webDriver, signUpPassword, password);

	}

	public void submitSignUp() {
		doClick(webDriver, signUpSubmit);
		setWebDriver(webDriver);
	}

	public void setCancelCookies(){
		doClick(webDriver,cancelCookies);
	}


	public boolean doNotContainTitle() {
		boolean result = webDriver.waitElementToBeVisible(signUpUnSuccessful.objectValue, 10);
		getWebDriver().cleanWebDriver();
		return result;
	}
}



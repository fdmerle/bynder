package suites;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MainPage;
import pages.SignUpPage;

import java.util.NoSuchElementException;
class PositiveScenarioTests {
	@ParameterizedTest
	@Category(suites.PositiveScenarioTests.class)
	@CsvFileSource(resources = "/signup.csv", numLinesToSkip = 1)  void positiveE2E(
			String login, String password, String loginText,
			String status) {
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.fillSignUpForm(login, password);
		signUpPage.setCancelCookies();
		signUpPage.submitSignUp();
		if (status.contains("passed")){
			MainPage mainPage= new MainPage(signUpPage.getWebDriver());
			Assertions.assertTrue(mainPage.containsTitle(loginText));
		} else if (status.contains("failed")) {
			Assertions.assertTrue(signUpPage.doNotContainTitle());

		}else {
			throw new NoSuchElementException("Please correct test run status: "+status);
		}
	}

}

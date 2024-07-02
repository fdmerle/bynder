package suites;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.util.NoSuchElementException;

import static io.restassured.RestAssured.given;

class TestApi {


    @ParameterizedTest
    @Category(suites.PositiveScenarioTests.class)
    @CsvFileSource(resources = "/apiparam.csv", numLinesToSkip = 1)
    void positiveAPI(String testName, String url, String auth, String ratingToSet, String filmId, String respondCode) {
        String authName = "Authorization";
        String acceptType = "application/json";
        int returnCode = 0;
        if (testName.contains("top_rated")) {
            returnCode=given().baseUri(url)
                    .header(authName, auth)
                    .accept(acceptType)
                    .when().get().statusCode();
        } else if (testName.contains("set_rating")) {
            String contentType = "application/json;charset=utf-8";
            String bodyForRatingPost = String.format("\"value\":%s}", ratingToSet);
            returnCode=given().baseUri(String.format(url, filmId))
                    .contentType(contentType)
                    .accept(acceptType)
                    .header(authName, auth)
                    .body("{" + bodyForRatingPost)
                    .when()
                    .post().statusCode();
        } else{
            throw new NoSuchElementException("Please correct test run name: "+testName);
        }
        Assertions.assertEquals(returnCode, Integer.parseInt(respondCode));
    }

}

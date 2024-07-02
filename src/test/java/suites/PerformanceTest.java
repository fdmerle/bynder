package suites;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class PerformanceTest {
    @ParameterizedTest
    @Category(suites.PositiveScenarioTests.class)
    @CsvFileSource(resources = "/perfparam.csv", numLinesToSkip = 1)    void testPerformance(String testName, String url, String auth, String ratingToSet, String filmId, String respondCode) {
        long startTime = System.nanoTime()/1000;
        TestApi testApi = new TestApi();
        for (int i = 0; i < 1000; i++) {
            testApi.positiveAPI(testName,url,auth,ratingToSet,filmId,respondCode);
        }

        long endTime = System.nanoTime()/1000;
        long duration = endTime - startTime;
        long timeToCompare=1000000000;

        System.out.println("Duration: " + duration + " nanoseconds");
        Assertions.assertTrue(duration < timeToCompare);
    }
}

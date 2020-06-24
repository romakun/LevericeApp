package tests.creationTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateDirectChannelByOptionTest extends BaseTest {

    @Test
    public void createDirectChannelByOptionTest() {
        setSteps
                .openSettingsByContext("direct")
                .clickByOption("New Direct");
        modalSteps
                .fillInNewDirectModal("First User")
                .clickAccept();
        wsElementsSteps
                .clickByMenuItem("First User")
                .checkChannelOpened("First User");
    }
}

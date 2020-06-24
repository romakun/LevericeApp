package tests.creation_tests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateDirectChannelByCommandLinkTest extends BaseTest {

    @Test
    public void createDirectChannelByCommandLinkTest() {
        setSteps
                .openSettingsByContext("direct")
                .clickByOption("Expand");
        wsElementsSteps.clickByMenuItem("Create new Direct Channel");
        modalSteps
                .fillInNewDirectModal("First User")
                .clickAccept();
        wsElementsSteps
                .clickByMenuItem("First User")
                .checkChannelOpened("First User");
    }
}

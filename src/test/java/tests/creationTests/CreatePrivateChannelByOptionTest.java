package tests.creationTests;

import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreatePrivateChannelByOptionTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String channelName = randomData.generateRandomChannel();

    @Test
    public void createPrivateChannelByOptionTest() {
        authorizeInLeverice();
        setSteps
                .openSettingsByIcon("MyTestWorkSpace")
                .clickByOption("New")
                .clickByOption("Private");
        wsElementsSteps.checkModalHeader("Creating Private Channel");
        modalSteps
                .typeName(channelName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(channelName);
    }
}

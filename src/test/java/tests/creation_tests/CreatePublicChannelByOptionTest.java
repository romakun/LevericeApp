package tests.creation_tests;

import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreatePublicChannelByOptionTest extends BaseTest {


    GenerateData randomData = new GenerateData();
    String channelName = randomData.generateRandomChannel();

    @Test
    public void createPublicChannelByOptionTest(){
        setSteps
                .openSettingsByIcon("MyTestWorkSpace")
                .clickByOption("New")
                .clickByOption("Public");
        wsElementsSteps.checkModalHeader("Creating Public Channel");
        modalSteps
                .typeName(channelName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(channelName);
    }
}

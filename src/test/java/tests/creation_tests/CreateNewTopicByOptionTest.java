package tests.creation_tests;

import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateNewTopicByOptionTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String topicName = randomData.generateRandomTopic();

    @Test
    public void createNewTopicByOptionTest(){
        setSteps
                .openSettingsByContext("direct")
                .clickByOption("Expand")
                .openSettingsByIcon("First User")
                .clickByOption("New Topic");
        wsElementsSteps.checkModalHeader("Creating Topic Channel");
        modalSteps
                .typeName(topicName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(topicName);
    }
}

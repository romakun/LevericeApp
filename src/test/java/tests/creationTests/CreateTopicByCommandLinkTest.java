package tests.creationTests;

import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateTopicByCommandLinkTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String topicName = randomData.generateRandomTopic();

    @Test
    public void createTopicByCommandLinkTest() {
        setSteps
                .openSettingsByContext("direct")
                .clickByOption("Expand");
        wsElementsSteps.clickByMenuItem("Add new Topic");
        modalSteps
                .fillInNewDirectModal("First User")
                .clickAccept()
                .typeName(topicName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(topicName);
    }
}

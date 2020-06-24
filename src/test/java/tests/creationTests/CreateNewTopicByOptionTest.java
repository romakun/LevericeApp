package tests.creationTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateNewTopicByOptionTest extends BaseTest {

    @Test
    public void createNewTopicByOptionTest(){
        setSteps
                .openSettingsByContext("direct")
                .clickByOption("Expand")
                .openSettingsByIcon("First User")
                .clickByOption("New Topic");
        wsElementsSteps.checkModalHeader("Creating Topic Channel");
        modalSteps
                .typeName("New Topic3")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened("New Topic3");
    }
}

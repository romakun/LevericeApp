package tests.creationTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreatePublicChannelByOptionTest extends BaseTest {

    @Test
    public void createPublicChannelByOptionTest(){
        setSteps
                .openSettingsByIcon("MyTestWorkSpace")
                .clickByOption("New")
                .clickByOption("Public");
        wsElementsSteps.checkModalHeader("Creating Public Channel");
        modalSteps
                .typeName("New")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkCreationAndOpen("New");
    }
}

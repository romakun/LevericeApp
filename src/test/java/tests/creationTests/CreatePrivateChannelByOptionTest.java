package tests.creationTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreatePrivateChannelByOptionTest extends BaseTest {

    @Test
    public void createPrivateChannelByOptionTest() {
        setSteps
                .openSettingsByIcon("MyTestWorkSpace")
                .clickByOption("New")
                .clickByOption("Private");
        wsElementsSteps.checkModalHeader("Creating Private Channel");
        modalSteps
                .typeName("NewPrivateChannel")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkCreationAndOpen("NewPrivateChannel");
    }
}

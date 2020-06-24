package tests.creationTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreatePublicChannelByCommandLinkTest extends BaseTest {

    @BeforeMethod
    public void createFolderByCommandLinkTest(){
        wsElementsSteps
                .clickByMenuItem("Create new Folder")
                .checkModalHeader("Creating Folder");
        modalSteps
                .typeName("NewFolderrr")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps
                .checkCreationAndOpen("NewFolderrr")
                .openElementTree("NewFolderrr");
    }

    @Test
    public void createPublicChannelByCommandLinkTest(){
        wsElementsSteps
                .clickByMenuItem("Create new Channel")
                .checkModalHeader("Creating Public Channel");
        modalSteps
                .typeName("NewChannel")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkCreationAndOpen("NewChannel");
    }
}

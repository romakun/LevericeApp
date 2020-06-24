package tests.creationTests;

import models.GenerateData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreatePublicChannelByCommandLinkTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String channelName = randomData.generateRandomChannel();
    String folderName = randomData.generateRandomFolder();

    @BeforeMethod
    public void createFolderByCommandLinkTest(){
        wsElementsSteps
                .clickByMenuItem("Create new Folder")
                .checkModalHeader("Creating Folder");
        modalSteps
                .typeName(folderName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps
                .checkChannelOpened(folderName)
                .openElementTree(folderName);
    }

    @Test
    public void createPublicChannelByCommandLinkTest(){
        wsElementsSteps
                .clickByMenuItem("Create new Channel")
                .checkModalHeader("Creating Public Channel");
        modalSteps
                .typeName(channelName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(channelName);
    }
}

package tests.creationTests;

import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateFolderByCommandLinkTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String folderName = randomData.generateRandomFolder();

    @Test
    public void createFolderByCommandLinkTest(){
        authorizeInLeverice();
        wsElementsSteps
                .clickByMenuItem("Create new Folder")
                .checkModalHeader("Creating Folder");
        modalSteps
                .typeName(folderName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(folderName);
    }
}

package tests.creationTests;

import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateFolderByOptionTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String folderName = randomData.generateRandomFolder();

    @Test
    public void createFolderByOptionTest(){
        authorizeInLeverice();
        setSteps
                .openSettingsByIcon("MyTestWorkSpace")
                .clickByOption("New")
                .clickByOption("Folder");
        wsElementsSteps.checkModalHeader("Creating Folder");
        modalSteps
                .typeName(folderName)
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened(folderName);
    }
}

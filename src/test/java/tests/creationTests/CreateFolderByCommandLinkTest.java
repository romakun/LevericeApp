package tests.creationTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateFolderByCommandLinkTest extends BaseTest {

    @Test
    public void createFolderByCommandLinkTest(){
        wsElementsSteps
                .clickByMenuItem("Create new Folder")
                .checkModalHeader("Creating Folder");
        modalSteps
                .typeName("NewFolder2")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkChannelOpened("NewFolder2");
    }
}

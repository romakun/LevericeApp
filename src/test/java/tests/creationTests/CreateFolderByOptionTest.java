package tests.creationTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CreateFolderByOptionTest extends BaseTest {

    @Test
    public void createFolderByOptionTest(){
        setSteps
                .openSettingsByIcon("MyTestWorkSpace")
                .clickByOption("New")
                .clickByOption("Folder");
        wsElementsSteps.checkModalHeader("Creating Folder");
        modalSteps
                .typeName("NewFolder4")
                .typeDescription("Bla Bla Bla")
                .clickAccept();
        wsElementsSteps.checkCreationAndOpen("NewFolder4");
    }
}

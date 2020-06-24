package steps;

import io.qameta.allure.Step;
import pages.creatingModalPages.CreatingModalPage;

public class CreateModalSteps {

    CreatingModalPage modalPage;

    public CreateModalSteps(){
        modalPage = new CreatingModalPage();
    }

    @Step
    public CreateModalSteps typeName(String folderName){
        modalPage
                .isPageOpened()
                .fillInName(folderName);
        return this;
    }

    @Step
    public CreateModalSteps typeDescription(String folderDescription){
        modalPage
                .openOptions()
                .fillInDescription(folderDescription);
        return this;
    }

    @Step
    public CreateModalSteps clickAccept(){
        modalPage.clickAcceptButton();
        return this;
    }
}

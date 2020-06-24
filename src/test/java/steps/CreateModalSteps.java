package steps;

import io.qameta.allure.Step;
import pages.creating_modal_pages.CreatingModalPage;

public class CreateModalSteps {

    CreatingModalPage modalPage;

    public CreateModalSteps(){
        modalPage = new CreatingModalPage();
    }

    @Step("Вводим название папки - {folderName}")
    public CreateModalSteps typeName(String folderName){
        modalPage
                .isPageOpened()
                .fillInName(folderName);
        return this;
    }

    @Step("Вводим описание - {folderDescription}")
    public CreateModalSteps typeDescription(String folderDescription){
        modalPage
                .openOptions()
                .fillInDescription(folderDescription);
        return this;
    }

    @Step("Сохраняем изменения")
    public CreateModalSteps clickAccept(){
        modalPage.clickAcceptButton();
        return this;
    }

    @Step
    public CreateModalSteps fillInNewDirectModal(String userName){
        modalPage
                .clickByRequiredInput()
                .chooseUserForNewDirect(userName)
                .checkUserAddedToInput(userName);
        return this;
    }
}

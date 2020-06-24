package steps;

import io.qameta.allure.Step;
import pages.WorkSpaceChatElementsPage;

public class WorkSpaceElementsSteps {

    WorkSpaceChatElementsPage wsElementsPage;

    public WorkSpaceElementsSteps() {
        wsElementsPage = new WorkSpaceChatElementsPage();
    }

    @Step
    public WorkSpaceElementsSteps clickByMenuItem(String itemName) {
        wsElementsPage
                .isPageOpened()
                .clickByMenuItem(itemName);
        return this;
    }

    @Step
    public WorkSpaceElementsSteps checkModalHeader(String header) {
        wsElementsPage.creatingPopupOpened(header);
        return this;
    }

    @Step
    public WorkSpaceElementsSteps checkCreationAndOpen(String itemName) {
        wsElementsPage
                .isPageOpened()
                .channelOpened(itemName);
        return this;
    }

    @Step
    public WorkSpaceElementsSteps openElementTree(String itemName) {
        wsElementsPage.openElementTree(itemName);
        return this;
    }
}

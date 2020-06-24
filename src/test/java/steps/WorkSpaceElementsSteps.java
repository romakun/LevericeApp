package steps;

import io.qameta.allure.Step;
import pages.WorkSpaceChatElementsPage;

public class WorkSpaceElementsSteps {

    WorkSpaceChatElementsPage wsElementsPage;

    public WorkSpaceElementsSteps() {
        wsElementsPage = new WorkSpaceChatElementsPage();
    }

    @Step("Выбираем айтем {itemName}")
    public WorkSpaceElementsSteps clickByMenuItem(String itemName) {
        wsElementsPage
                .isPageOpened()
                .clickByMenuItem(itemName);
        return this;
    }

    @Step("Проверяем заголовок на наличие {header}")
    public WorkSpaceElementsSteps checkModalHeader(String header) {
        wsElementsPage.creatingPopupOpened(header);
        return this;
    }

    @Step("Проверяем создание")
    public WorkSpaceElementsSteps checkCreationAndOpen(String itemName) {
        wsElementsPage
                .isPageOpened()
                .channelOpened(itemName);
        return this;
    }

    @Step("Кликаем collapse или expand с использованием стрелки возле названия канала")
    public WorkSpaceElementsSteps openElementTree(String itemName) {
        wsElementsPage.openElementTree(itemName);
        return this;
    }
}

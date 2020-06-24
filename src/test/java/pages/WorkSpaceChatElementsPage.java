package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import elements.WorkSpaceChatElements;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class WorkSpaceChatElementsPage extends BasePage{

    private static final String CONNECTION_INDICATOR_CSS = ".connection-indicator.green";
    private static final By TUTORIAL_QUICK_GUIDE_HEADER_LOCATOR = xpath("//div[contains(@class,'hints-panel__title')]/div[text()='Quick Guide']");
    private static final By INVITE_USERS_POPUP_HEADER_LOCATOR = xpath("//div[contains(@class,'heading') and contains(text(),'Invite other users')]");
    private static final String POPUP_HEADER = "//div[contains(@class,'window-caption-label') and contains(text(),'%s')]";
    private static final String CHANNEL_NAME = "//div[contains(@class,'channel-name') and contains(text(),'%s')]";

    WorkSpaceChatElements wsElement = new WorkSpaceChatElements();

    @Override
    public WorkSpaceChatElementsPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public WorkSpaceChatElementsPage isPageOpened() {
        try {
            $(CONNECTION_INDICATOR_CSS).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
        }
        return this;
    }

    public WorkSpaceChatElementsPage clickByMenuItem(String itemName){
        wsElement.clickByElement(itemName);
        return this;
    }

    public void invitePopupOpened(){
        $(INVITE_USERS_POPUP_HEADER_LOCATOR).shouldBe(Condition.visible);
    }

    public void creatingPopupOpened(String popupHeader){
        By POPUP_HEADER_LOCATOR = xpath(String.format(POPUP_HEADER, popupHeader));
        try {
            $(POPUP_HEADER_LOCATOR).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Заголовок не соответствует ожидаемому");
        }
    }

    public void tutorialOpened(){
        $(TUTORIAL_QUICK_GUIDE_HEADER_LOCATOR).shouldBe(Condition.visible);
    }

    public void channelOpened(String channelName){
        By CHANNEL_NAME_LOCATOR = xpath(String.format(CHANNEL_NAME, channelName));
        $(CHANNEL_NAME_LOCATOR).shouldBe(Condition.visible);
    }

    public boolean checkMutedChannel(String channel) {
        return  wsElement.findElementMutedIcon(channel);
    }

    public WorkSpaceChatElementsPage openElementTree(String channel){
        wsElement.toggleElement(channel);
        return this;
    }
}

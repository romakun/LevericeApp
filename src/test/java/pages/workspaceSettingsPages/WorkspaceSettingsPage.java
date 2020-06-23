package pages.workspaceSettingsPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.BasePage;

import static org.testng.Assert.assertFalse;

public class WorkspaceSettingsPage extends BasePage {

    private static final By WORKSPACE_NAME = By.xpath("//span[contains(text(),'MyTestWorkSpace')]");
    private static final By SETTINGS_POPUP = By.className("channel-settings-icon");
    private static final By NEW = By.xpath("//label[contains(text(),'New')]");
    private static final By NEW_CHANNEL_NAME_FIELD = By.xpath("//textarea[@placeholder='Add a channel name']");
    private static final By CREATE_CHANNEL_BUTTON = By.xpath("//label[contains(text(),'Create')]");
    private static final By MUTE = By.xpath("//label[contains(text(),'Mute')]");
    private static final By UNMUTE = By.xpath("//label[contains(text(),'Unmute')]");
    private static final By MUTE_ICON = By.className("muted-project-icon");
    private static final By SETTINGS = By.xpath("//label[contains(text(),'Settings')]");
    private static final By EDIT_NAME_FIELD = By.className("textarea__inner");
    private static final By SAVE_NEW_NAME = By.xpath("//label[contains(text(),'Save')]");
    private static final By COLLAPSE = By.xpath("//label[contains(text(),'Collapse')]");
    private static final By EXPAND = By.xpath("//label[contains(text(),'Expand')]");

    @Override
    public WorkspaceSettingsPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public WorkspaceSettingsPage isPageOpened() {
        $(WORKSPACE_NAME).shouldBe(Condition.visible);
        return this;
    }

    public WorkspaceSettingsPage openPopupSettings () {
        $(WORKSPACE_NAME).hover();
        $(SETTINGS_POPUP).click();
        return this;
    }

    public WorkspaceSettingsPage addNewSubChannel (String newChannel) {
        $(NEW).hover();
        $(By.xpath("//label[contains(text(),'Public')]")).click();
        $(NEW_CHANNEL_NAME_FIELD).setValue(newChannel);
        $(CREATE_CHANNEL_BUTTON).click();
        //$(By.className("channel-name")).shouldBe(Condition.visible);
        $(By.className("channel-name")).shouldHave(Condition.text(newChannel));
        return this;
    }

    public WorkspaceSettingsPage mute (boolean isMuted) {
        if (isMuted) {
            $(UNMUTE).click();
            $(MUTE_ICON).shouldNotBe(Condition.visible);
        } else {
            $(MUTE).click();
            $(MUTE_ICON).shouldBe(Condition.visible);
        }
        return this;
    }

    public WorkspaceSettingsPage editName (String newName) {
        $(SETTINGS).click();
        $(By.className("project-name-settings__button")).click();
        $(EDIT_NAME_FIELD).setValue(newName);
        $(SAVE_NEW_NAME).click();
        assertFalse($(WORKSPACE_NAME).exists(), "The name hasn't changed");
        return this;
    }

    public WorkspaceSettingsPage collapseOrExpand (boolean toExpand) {
        if (toExpand) {
            $(EXPAND).click();
            $(By.className("command-link")).shouldBe(Condition.visible);
        } else {
            $(COLLAPSE).click();
            $(By.className("command-link")).shouldNotBe(Condition.visible);
        }
        return this;
    }

}

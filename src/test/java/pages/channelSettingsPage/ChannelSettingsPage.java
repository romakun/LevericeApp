package pages.channelSettingsPage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.BasePage;

public class ChannelSettingsPage extends BasePage {

    private static final By CHANNEL_NAME = By.xpath("//span[contains(text(),'Channel')]");

    private static final By NEW_CHANNEL = By.xpath("//label[contains(text(),'New')]");
    private static final By NEW_CHANNEL_FIELD_NAME = By.xpath("//textarea[@placeholder='Add a channel name']");
    private static final By CREATE_CHANNEL_BUTTON = By.xpath("//label[contains(text(),'Create')]");

    private static final By RENAME = By.xpath("//label[contains(text(),'Rename')]");
    private static final By RENAME_INPUT = By.className("rename__input-field");
    private static final By RENAME_CHANNEL_BUTTON = By.xpath("//label[contains(text(),'Rename')]");

    private static final By CHANNEL_SETTINGS = By.xpath("//label[contains(text(),'Channel settings')]");
    private static final By DESCRIPTION_FIELD_INPUT = By.xpath("//textarea[@placeholder='Add a channel description (Optional)']");
    private static final By CHANNEL_DESCRIPTION = By.className("channel-description");
    private static final By UPDATE_CHANNEL_BUTTON = By.xpath("//label[contains(text(),'Update')]");
    private static final By REMOVE_CHANNEL_BUTTON = By.xpath("//label[contains(text(),'Remove channel')]");

    private static final By MUTE = By.xpath("//label[contains(text(),'Mute')]");
    private static final By UNMUTE = By.xpath("//label[contains(text(),'Unmute')]");
    private static final By MUTE_ICON = By.className("muted-channel-icon");

    private static final By FAVORITE = By.xpath("//label[contains(text(),'Mark As Favorite')]");
    private static final By FAV_MARK = By.className("svg-mark-favorite");

    @Override
    public ChannelSettingsPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public ChannelSettingsPage isPageOpened() {
        $(By.xpath("//span[contains(text(),'MyTestWorkSpace')]")).shouldBe(Condition.visible);
        return this;
    }

    public ChannelSettingsPage openPopUpSettings () {
        $(CHANNEL_NAME).click();
        $$(".channel-settings-icon").filterBy(Condition.visible).get(0).click();
        return this;
    }

    public ChannelSettingsPage addNew (String newChannelName) {
        $(NEW_CHANNEL).hover();
        $(By.xpath("//label[contains(text(),'Public')]")).click();
        $(NEW_CHANNEL_FIELD_NAME).setValue(newChannelName);
        $(CREATE_CHANNEL_BUTTON).click();
        $(By.className("channel-name")).shouldHave(Condition.text(newChannelName));
        return this;
    }

    public ChannelSettingsPage rename (String name) {
        $(RENAME).click();
        $(RENAME_INPUT).setValue(name);
        $(RENAME_CHANNEL_BUTTON).click();
        $(By.className("channel-name")).shouldHave(Condition.text(name));
        return this;
    }

    public ChannelSettingsPage openSettings () {
        $(CHANNEL_SETTINGS).click();
        return this;
    }

    public ChannelSettingsPage addDescription (String description) {
        $(DESCRIPTION_FIELD_INPUT).setValue(description);
        $(UPDATE_CHANNEL_BUTTON).click();
        $(CHANNEL_DESCRIPTION).shouldHave(Condition.text(description));
        return this;
    }

    public ChannelSettingsPage deleteChannel () {
        $(REMOVE_CHANNEL_BUTTON).click();
        $$(".button").get(1).click();
        $(CHANNEL_NAME).shouldNot(Condition.visible);
        return this;
    } // not ready yet

    public ChannelSettingsPage mute (boolean isMuted) {
        if (isMuted) {
            $(UNMUTE).click();
            $(MUTE_ICON).shouldNotBe(Condition.visible);
        } else {
            $(MUTE).click();
            $(MUTE_ICON).shouldBe(Condition.visible);
        }
        return this;
    }

    public ChannelSettingsPage markAsFavorite () {
        $(FAVORITE).click();
        $(FAV_MARK).shouldBe(Condition.visible);
        return this;
    }
}

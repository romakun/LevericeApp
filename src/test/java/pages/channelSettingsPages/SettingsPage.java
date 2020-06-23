package pages.channelSettingsPages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.OptionElements;
import pages.BasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SettingsPage extends BasePage {

    private static final String CHANNEL_ELEMENT_LOCATOR = ".channel-node";
    private static final String CONNECTION_INDICATOR_CSS = ".connection-indicator.green";
    private static final String MUTED_CHANNEL_ICON = ".muted-channel-icon";

    OptionElements optionElement = new OptionElements();

    @Override
    public SettingsPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public SettingsPage isPageOpened() {
        $(CONNECTION_INDICATOR_CSS).shouldBe(Condition.visible);
        return this;
    }

    public SettingsPage clickByElementSettingsButton(SelenideElement channel) {
        channel.hover();
        channel.find(".channel-settings-icon").click();
        return this;
    }

    public SettingsPage clickByOption(String optionName) {
        optionElement.clickByOption(optionName);
        return this;
    }

    public boolean checkMutedChannel(SelenideElement channel) {
        return channel.find(MUTED_CHANNEL_ICON).isDisplayed();
    }

    public SelenideElement findChannelElement(String elementName) {
        SelenideElement channel = null;
        List<SelenideElement> channels = $$(CHANNEL_ELEMENT_LOCATOR).shouldBe(CollectionCondition.sizeGreaterThan(0));
        for (int i = 0; i < channels.size(); ) {
            if (channels.get(i).find("span").getText().equals(elementName)) {
                channel = channels.get(i);
            } else {
                i++;
            }
        }
        return channel;
    }
}

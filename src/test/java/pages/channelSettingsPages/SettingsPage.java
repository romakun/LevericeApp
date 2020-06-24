package pages.channelSettingsPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import elements.OptionElements;
import elements.WorkSpaceChatElements;
import org.testng.Assert;
import pages.BasePage;


import static com.codeborne.selenide.Selenide.$;


public class SettingsPage extends BasePage {

    private static final String CONNECTION_INDICATOR_CSS = ".connection-indicator.green";

    WorkSpaceChatElements wsElement = new WorkSpaceChatElements();
    OptionElements optionElement = new OptionElements();

    @Override
    public SettingsPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public SettingsPage isPageOpened() {
        try {
            $(CONNECTION_INDICATOR_CSS).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
        }
        return this;
    }

    public SettingsPage openElementSettingsByContext(String channel) {
        wsElement.clickByElement(channel);
        wsElement.rightClickByElement(channel);
        return this;
    }

    public SettingsPage openElementSettingsByIcon(String channel) {
        wsElement.clickByElement(channel);
        wsElement.openElementSettingsIcon(channel);
        return this;
    }

    public SettingsPage clickByOption(String optionName) {
        optionElement.clickByOption(optionName);
        return this;
    }
}

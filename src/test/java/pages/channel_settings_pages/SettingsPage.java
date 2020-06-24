package pages.channel_settings_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import elements.OptionElements;
import elements.WorkSpaceChatElements;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import pages.BasePage;


import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class SettingsPage extends BasePage {

    private static final String CONNECTION_INDICATOR_CSS = ".connection-indicator.green";

    WorkSpaceChatElements wsElement = new WorkSpaceChatElements();
    OptionElements optionElement = new OptionElements();

    @Override
    public SettingsPage openPage() {
        log.info("Открываем настройки");
        isPageOpened();
        return this;
    }

    @Override
    public SettingsPage isPageOpened() {
        log.info("Загрузилась ли страница");
        try {
            $(CONNECTION_INDICATOR_CSS).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
        }
        return this;
    }

    public SettingsPage openElementSettingsByContext(String channel) {
        log.info("Открываем настройки контекстно");
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
        log.info("Выбираем опцию " + optionName);
        optionElement.clickByOption(optionName);
        return this;
    }
}

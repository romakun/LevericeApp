package steps;

import io.qameta.allure.Step;
import pages.channel_settings_pages.SettingsPage;

public class SettingSteps {

    SettingsPage setPage;

    public SettingSteps(){
        setPage = new SettingsPage();
    }

    @Step("Открываем настройки контекстно")
    public SettingSteps openSettingsByContext(String itemName){
        setPage
                .isPageOpened()
                .openElementSettingsByContext(itemName);
        return this;
    }

    @Step("Открываем настройки нажатием по иконке")
    public SettingSteps openSettingsByIcon(String itemName){
        setPage
                .isPageOpened()
                .openElementSettingsByContext(itemName);
        return this;
    }

    @Step("Кликаем по опции {optionName}")
    public SettingSteps clickByOption(String optionName){
        setPage.clickByOption(optionName);
        return this;
    }
}

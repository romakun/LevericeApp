package steps;

import io.qameta.allure.Step;
import pages.channelSettingsPages.SettingsPage;

public class SettingSteps {

    SettingsPage setPage;

    public SettingSteps(){
        setPage = new SettingsPage();
    }

    @Step
    public SettingSteps openSettingsByContext(String itemName){
        setPage
                .isPageOpened()
                .openElementSettingsByContext(itemName);
        return this;
    }

    @Step
    public SettingSteps openSettingsByIcon(String itemName){
        setPage
                .isPageOpened()
                .openElementSettingsByContext(itemName);
        return this;
    }

    @Step
    public SettingSteps clickByOption(String optionName){
        setPage.clickByOption(optionName);
        return this;
    }
}

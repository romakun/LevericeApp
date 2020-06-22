package pages.creatingModalPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CreatingModalPage extends BasePage {

    private static final String WINDOW_HEADER_ICON_CSS = ".window__header-icon";
    private static final String POSITION_INPUT_CSS = ".smart-bar-text";
    private static final String CLEAR_POSITION_ICON = ".smartbar-clear-input";
    private static final String GO_TO_DEFAULT_WORKSPACE_DIRECTORY_ICON = ".btn-workspace";
    private static final By ADD_A_NAME_TEXTAREA_XPATH = xpath("//textarea[contains(@placeholder,'name')]");
    private static final By ADD_DESCRIPTION_TEXTAREA_XPATH = xpath("//textarea[contains(@placeholder,'description')]");
    private static final String OPTION_BUTTON_CSS = ".option-button";
    private static final String CLOSE_WINDOW_ICON_CSS = ".close-window-icon .close-window-icon";
    private static final String CANCEL_BUTTON_CSS = ".button-cancel";
    private static final String ACCEPT_BUTTON_CSS = ".button-accept";
    private static final String SORT_SUBCHANNELS_DROPDOWN_CSS = ".dropdown-list";
    private static final String WINDOW_HEADER_CSS = ".window-caption-label";
    private static final String MAKE_FOLDER_PRIVATE_TOGGLE_CSS = ".toggle";

    private String Creating_Public_Channel = "Creating Public Channel";
    private String Creating_Private_Channel = "Creating Private Channel";
    private String Creating_Folder = "Creating Folder";
    private String Creating_Direct_Channel = "Creating Direct Channel";
    private String Creating_Topic_Channel = "Creating Topic Channel";

    @Override
    public CreatingModalPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public CreatingModalPage isPageOpened() {
        try {
            $(WINDOW_HEADER_ICON_CSS).shouldBe(Condition.visible);
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public CreatingModalPage fillInName(String name) {
        $(ADD_A_NAME_TEXTAREA_XPATH).setValue(name);
        return this;
    }

    public CreatingModalPage fillInDescription(String description) {
        $(ADD_DESCRIPTION_TEXTAREA_XPATH).setValue(description);
        return this;
    }

    public CreatingModalPage choosePosition() {
        return this;
    }

    public CreatingModalPage clearPositionInput() {
        $(CLEAR_POSITION_ICON).click();
        return this;
    }

    public CreatingModalPage goToDefaultPosition() {
        $(GO_TO_DEFAULT_WORKSPACE_DIRECTORY_ICON).click();
        return this;
    }

    public CreatingModalPage openOptions() {
        if ($(OPTION_BUTTON_CSS).find("div").shouldHave(cssClass("open")).isDisplayed()) {
            $(OPTION_BUTTON_CSS).click();
        }
        return this;
    }

    public CreatingModalPage closeOptions() {
        if ($(OPTION_BUTTON_CSS).find("div").shouldHave(cssClass("close")).isDisplayed()) {
            $(OPTION_BUTTON_CSS).click();
        }
        return this;
    }

    public CreatingModalPage closeWindowByIcon() {
        $(CLOSE_WINDOW_ICON_CSS).click();
        $(WINDOW_HEADER_ICON_CSS).shouldNot(Condition.visible);
        return this;
    }

    public CreatingModalPage closeWindowByCancel() {
        $(CANCEL_BUTTON_CSS).click();
        $(WINDOW_HEADER_ICON_CSS).shouldNot(Condition.visible);
        return this;
    }

    public CreatingModalPage clickAcceptButton() {
        return this;
    }

    public CreatingModalPage makeFolderPrivate() {
        return this;
    }

    public CreatingModalPage makeFolderPublic() {
        return this;
    }

    public CreatingModalPage chooseSortSubChannels() {
        return this;
    }
}

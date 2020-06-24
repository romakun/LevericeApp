package pages.accountSettings;

import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AccountSettingsPage extends BasePage {
    private static final String DEFAULT_BACKGROUND_CSS = ".default-background";
    private static final String CLOSE_WINDOW = ".close-window-icon";
    private static final String NAME = ".__vuescroll";
    private static final By UPLOAD_AN_IMAGE = xpath("//*[contains(text(),'Upload an Image')]");
    private static final String CANCEL = ".button-cancel";
    private static final String ACCEPT = ".button-accept";
    private static final String SELECT_FILES = ".highlighter";
    private static final String BUTTON_SAVE = ".modal__save";

    @Override
    public AccountSettingsPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public AccountSettingsPage isPageOpened() {
        return null;
    }

    public AccountSettingsPage clickAvatar() {
        $(DEFAULT_BACKGROUND_CSS).click();
        return this;
    }

    public AccountSettingsPage changeName(String firstName) {
        $(NAME).click();
        $(NAME).clear();
        $(NAME).sendKeys(firstName);
        return this;
    }

    public AccountSettingsPage fileUpload() {
        $(UPLOAD_AN_IMAGE).click();
        return this;
    }

    public AccountSettingsPage selectFileToUpload(String url) {
        $(SELECT_FILES).sendKeys(System.getProperty("user.dir") + url);
        $(BUTTON_SAVE).click();
        return this;
    }

    public AccountSettingsPage clickCancel() {
        $(CANCEL).click();
        return this;
    }

    public AccountSettingsPage clickAccept() {
        $(ACCEPT).click();
        return this;
    }

    public AccountSettingsPage closeWindow() {
        $(CLOSE_WINDOW).click();
        return this;
    }
}

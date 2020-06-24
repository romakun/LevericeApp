package pages.authorizationPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class AuthorizationPage extends BasePage {

    private static final String URL = "https://autotest.leverice.net/public/client";
    private static final String TUTORIAL_IMAGE_CSS = ".tutorial-img__content";
    private static final By EMAIL_INPUT = name("email");
    private static final By BUTTON_SIGN_IN_XPATH = xpath("//div[@class='button']//label[text()='Sign in']");
    private static final String ACTIVE_BUTTON_NEXT_STEP = ".action-button.button-accept.active";
    private static final String INPUT_VALIDATION_CODE = "[inputmode='numeric']";
    private static final By FIRST_NAME_INPUT = name("fname");
    private static final By LAST_NAME_INPUT = name("lname");
    private static final String INPUT_WORKSPACE_NAME_CSS = ".textarea__inner.in-workspace-wizard";
    private static final String CREATE_NEW_WORKSPACE_LINK_TEXT = "Create a new workspace";
    private static final String JOIN_WORKSPACE_INVITATION_LINK_TEXT = "Join workspace using invitation code";
    private static final String PAGE_HEADER_CSS = ".heading";
    private static final String CONNECTION_INDICATOR_CSS = ".additional-icon";

    @Override
    public AuthorizationPage openPage() {
        log.info("Открываем " + URL);
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public AuthorizationPage isPageOpened() {
        log.info("Загрузилась ли " + URL);
        try {
            $(TUTORIAL_IMAGE_CSS).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
        }
        return this;
    }

    public AuthorizationPage clickSignIn() {
        log.info("Кликаем по входу");
        $(BUTTON_SIGN_IN_XPATH).shouldBe(Condition.visible);
        $(BUTTON_SIGN_IN_XPATH).click();
        return this;
    }

    public AuthorizationPage enterEmail(String email) {
        log.info("Вводим email " + email);
        $(EMAIL_INPUT).shouldBe(Condition.visible);
        $(EMAIL_INPUT).setValue(email);
        return this;
    }

    public AuthorizationPage clickButton() {
        log.info("Кликаем на следующий шаг");
        $(ACTIVE_BUTTON_NEXT_STEP).shouldBe(Condition.visible);
        $(ACTIVE_BUTTON_NEXT_STEP).click();
        return this;
    }

    public AuthorizationPage enterCode(String code) {
        log.info("Вводим код " + code);
        $(INPUT_VALIDATION_CODE).shouldBe(Condition.visible);
        $(INPUT_VALIDATION_CODE).setValue(code);
        return this;
    }

    public AuthorizationPage fillInUserNames(String fname, String lname) {
        log.info("Вводим имя и фамилию " + fname + " и " + lname);
        $(FIRST_NAME_INPUT).shouldBe(Condition.visible);
        $(FIRST_NAME_INPUT).setValue(fname);
        $(LAST_NAME_INPUT).shouldBe(Condition.visible);
        $(LAST_NAME_INPUT).setValue(lname);
        return this;
    }

    public AuthorizationPage fillInWorkspaceName(String workName) {
        log.info("Вводим имя воркспейса " + workName);
        $(INPUT_WORKSPACE_NAME_CSS).shouldBe(Condition.visible);
        $(INPUT_WORKSPACE_NAME_CSS).setValue(workName);
        return this;
    }

    public AuthorizationPage clickCreateNewWorkspace() {
        log.info("Создаём воркспейс");
        $(withText(CREATE_NEW_WORKSPACE_LINK_TEXT)).shouldBe(Condition.visible);
        $(withText(CREATE_NEW_WORKSPACE_LINK_TEXT)).click();
        return this;
    }

    public AuthorizationPage enterInMyWorkSpace(String workSpaceName) {
        log.info("Входим в воркспейс");
        $(withText(workSpaceName)).shouldBe(Condition.visible);
        $(withText(workSpaceName)).click();
        return this;
    }

    public AuthorizationPage clickJoinWorkspaceByInvitationCode() {
        $(withText(JOIN_WORKSPACE_INVITATION_LINK_TEXT)).shouldBe(Condition.visible);
        $(withText(JOIN_WORKSPACE_INVITATION_LINK_TEXT)).click();
        return this;
    }

    public boolean checkPage() {
        log.info("Загрузилась ли страница");
        $(PAGE_HEADER_CSS).shouldBe(Condition.visible);
        return $(PAGE_HEADER_CSS).getText().equals("Introduce yourself");
    }

    public AuthorizationPage checkAuthorization() {
        try {
            $(CONNECTION_INDICATOR_CSS).shouldBe(Condition.visible);
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public AuthorizationPage openInvitationLink(){
        log.info("Открываем ссыщку на приглашение");
        open(onPaste());
        return this;
    }

    private String onPaste(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();

        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e){
            Assert.fail("Ничего не скопировали");
            return null;
        }
    }
}
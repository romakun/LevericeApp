package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class InviteModalPage extends BasePage{

    private static final By MODAL_HEADER = xpath("//div[contains(@class,'heading') and contains(text(),'Invite other users to Workspace')]");
    private static final By EMAIL_INPUT = xpath("//textarea[contains(@placeholder,'Enter email')]");
    private static final String ACTIVE_ACCEPT_BUTTON_CSS = ".wizard-modal__inner .action-button.active";
    private static final String COPY_LINK_BUTTON_CSS = ".apply-button";
    private static final String INVITE_WINDOW_SCC = ".wizard-modal__inner";

    @Override
    public InviteModalPage openPage() {
        log.info("Открываем окно с приглашением");
        isPageOpened();
        return this;
    }

    @Override
    public InviteModalPage isPageOpened() {
        log.info("Открылось ли окно с инвайтом");
        try {
            $(MODAL_HEADER).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
        }
        return this;
    }

    public InviteModalPage fillInEmail(String email){
        log.info("Вводим email " + email);
        $(EMAIL_INPUT).shouldBe(Condition.visible);
        $(EMAIL_INPUT).setValue(email);
        return this;
    }

    public InviteModalPage clickInviteButton(){
        log.info("Кликаем на инвайт");
        $(ACTIVE_ACCEPT_BUTTON_CSS).find(withText("Invite")).shouldBe(Condition.visible);
        $(ACTIVE_ACCEPT_BUTTON_CSS).click();
        $(INVITE_WINDOW_SCC).shouldNot(Condition.visible);
        return this;
    }

    public InviteModalPage clickCopyLinkButton(){
        log.info("Копируем ссылку");
        $(COPY_LINK_BUTTON_CSS).shouldBe(Condition.visible);
        $(COPY_LINK_BUTTON_CSS).click();
        clearCache();
        return this;
    }

}

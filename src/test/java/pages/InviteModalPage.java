package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class InviteModalPage extends BasePage{

    private static final By MODAL_HEADER = xpath("//div[contains(@class,'heading') and contains(text(),'Invite other users to Workspace')]");
    private static final By EMAIL_INPUT = xpath("//textarea[contains(@placeholder,'Enter email')]");
    private static final String ACTIVE_ACCEPT_BUTTON_CSS = ".wizard-modal__inner .action-button.active";
    private static final String COPY_LINK_BUTTON_CSS = ".apply-button";

    @Override
    public InviteModalPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public InviteModalPage isPageOpened() {
        try {
            $(MODAL_HEADER).shouldBe(Condition.visible);
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
        }
        return this;
    }

    public InviteModalPage fillInEmail(String email){
        $(EMAIL_INPUT).shouldBe(Condition.visible);
        $(EMAIL_INPUT).setValue(email);
        return this;
    }

    public InviteModalPage clickInviteButton(){
        $(ACTIVE_ACCEPT_BUTTON_CSS).find(withText("Invite")).shouldBe(Condition.visible);
        $(ACTIVE_ACCEPT_BUTTON_CSS).click();
        return this;
    }

    public InviteModalPage clickCopyLinkButton(){
        $(COPY_LINK_BUTTON_CSS).shouldBe(Condition.visible);
        $(COPY_LINK_BUTTON_CSS).click();
        clearCache();
        return this;
    }
}

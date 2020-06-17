package pages.authorizationPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selectors.withText;
import static org.openqa.selenium.By.name;

public class EnterEmailPage extends BasePage {

    private static final String PAGE_HEADER_TEXT = "Enter your email";
    private static final By EMAIL_INPUT = name("email");
    private static final String ACTIVE_BUTTON_CONTINUE = ".action-button.button-accept.active";

    @Override
    public EnterEmailPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public EnterEmailPage isPageOpened() {
        try {
            $(withText(PAGE_HEADER_TEXT), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public EnterEmailPage enterEmail(String email){
        $(EMAIL_INPUT, "Вводим Email " + email).setValue(email);
        return this;
    }

    public void clickContinueButton(){
        $(ACTIVE_BUTTON_CONTINUE).click();
    }
}

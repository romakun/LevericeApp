package pages.authorizationPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;

import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationPage extends BasePage {

    private static final String URL = "https://autotest.leverice.net/public/client";
    private static final String TEXT_BUTTON_SIGN_IN = "Sign in";

    @Override
    public AuthorizationPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public AuthorizationPage isPageOpened() {
        try {
            $(byText(TEXT_BUTTON_SIGN_IN), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public AuthorizationPage clickSignIn() {
        $(byText(TEXT_BUTTON_SIGN_IN)).click();
        return this;
    }
}
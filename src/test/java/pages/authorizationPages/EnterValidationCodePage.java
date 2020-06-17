package pages.authorizationPages;

import com.codeborne.selenide.ex.ElementShould;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selectors.withText;


public class EnterValidationCodePage extends BasePage{

    private static final String PAGE_HEADER_TEXT = "Verification of your email";
    private static final String INPUT_VALIDATION_CODE = "[inputmode='numeric']";

    @Override
    public EnterValidationCodePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public EnterValidationCodePage isPageOpened() {
        try {
            $(withText(PAGE_HEADER_TEXT), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public void enterCode(String code){
        $(INPUT_VALIDATION_CODE).setValue(code);
    }
}

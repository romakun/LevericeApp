package pages.authorizationPages;

import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selectors.withText;
import static org.openqa.selenium.By.name;

public class IntroduceYourselfPage extends BasePage {

    private static final String PAGE_HEADER_TEXT = "Introduce yourself";
    private static final By FIRST_NAME_INPUT = name("fname");
    private static final By LAST_NAME_INPUT = name("lname");
    private static final String ACTIVE_BUTTON_CONTINUE = ".action-button.button-accept.active";

    @Override
    public IntroduceYourselfPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public IntroduceYourselfPage isPageOpened() {
        try {
            $(withText(PAGE_HEADER_TEXT), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public IntroduceYourselfPage fillInUserNames(String fname, String lname){
        $(FIRST_NAME_INPUT).setValue(fname);
        $(LAST_NAME_INPUT).setValue(lname);
        return this;
    }

    public void clickContinueButton(){
        $(ACTIVE_BUTTON_CONTINUE).click();
    }
}

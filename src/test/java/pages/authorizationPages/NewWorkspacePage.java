package pages.authorizationPages;

import com.codeborne.selenide.ex.ElementShould;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selectors.withText;

public class NewWorkspacePage extends BasePage {

    private static final String PAGE_HEADER_TEXT = "Create a new workspace";
    private static final String INPUT_WORKSPACE_NAME_CSS = ".textarea__inner.in-workspace-wizard";
    private static final String ACTIVE_BUTTON_CONTINUE = ".action-button.button-accept.active";

    @Override
    public NewWorkspacePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public NewWorkspacePage isPageOpened() {
        try {
            $(withText(PAGE_HEADER_TEXT), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public NewWorkspacePage fillInWorkspaceName(String workName){
        $(INPUT_WORKSPACE_NAME_CSS).setValue(workName);
        return this;
    }

    public void clickCreateButton(){
        $(ACTIVE_BUTTON_CONTINUE).click();
    }
}

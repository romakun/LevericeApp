package pages.authorizationPages;

import com.codeborne.selenide.ex.ElementShould;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selectors.withText;

public class WorkspacePage extends BasePage {

    private static final String PAGE_HEADER_TEXT = "Open an existing workspace";
    private static final String CREATE_NEW_WORKSPACE_LINK_TEXT = "Create a new workspace";
    private static final String JOIN_WORKSPACE_INVITATION_LINK_TEXT = "Join workspace using invitation code";

    @Override
    public WorkspacePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public WorkspacePage isPageOpened() {
        try {
            $(withText(PAGE_HEADER_TEXT), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public WorkspacePage clickCreateNewWorkspace(){
        $(withText(CREATE_NEW_WORKSPACE_LINK_TEXT)).click();
        return this;
    }

    public WorkspacePage enterInMyWorkSpace(String workSpaceName){
        $(withText(workSpaceName)).click();
        return this;
    }

    public void clickJoinWorkspaceByInvitationCode(){
        $(withText(JOIN_WORKSPACE_INVITATION_LINK_TEXT)).click();
    }
}

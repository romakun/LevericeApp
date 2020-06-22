package steps;

import io.qameta.allure.Step;
import pages.authorizationPages.*;
import pages.mailHogPages.MailHogPage;

public class AuthorizationSteps {

    AuthorizationPage authPage;
    MailHogPage mailHog;

    public AuthorizationSteps() {
        authPage = new AuthorizationPage();
        mailHog = new MailHogPage();

    }

    @Step("Open Leverice and sign in with Email='{email}'")
    public AuthorizationSteps signIn(String email) {
        authPage
                .openPage()
                .clickSignIn()
                .enterEmail(email)
                .clickButton();
        return this;
    }

    @Step
    public AuthorizationSteps getEmailCodeOutOfMailHog(String userEmail) {
        mailHog
                .openPage()
                .findEmail(userEmail)
                .getValidationCode()
                .closeMailHogTab();
        return this;
    }

    @Step
    public AuthorizationSteps enterCode(String code) {
        authPage.enterCode(code);
        return this;
    }

    @Step
    public AuthorizationSteps fillInUserNames(String fname, String lname) {
        authPage
                .fillInUserNames(fname, lname)
                .clickButton();
        return this;
    }

    @Step
    public AuthorizationSteps clickCreateWorkspace() {
        authPage.clickCreateNewWorkspace();
        return this;
    }

    @Step
    public AuthorizationSteps fillInWorkSpaceName(String workName) {
        authPage
                .fillInWorkspaceName(workName)
                .clickButton();
        return this;
    }

    @Step
    public AuthorizationSteps enterInMySpace(String workSpaceName) {
        authPage.enterInMyWorkSpace(workSpaceName);
        return this;
    }

    @Step
    public boolean checkPage() {
        return authPage.checkPage();
    }
}

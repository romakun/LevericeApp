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

    @Step("Open Leverice and sign in")
    public AuthorizationSteps signIn() {
        authPage
                .openPage()
                .clickSignIn();
        return this;
    }

    @Step("Type Email='{email}'")
    public AuthorizationSteps typEmail(String email) {
        authPage
                .enterEmail(email)
                .clickButton();
        return this;
    }

    @Step
    public AuthorizationSteps openMailHog() {
        mailHog.openPage();
        return this;
    }

    @Step
    public AuthorizationSteps findMail(String userEmail) {
        mailHog.findEmail(userEmail);
        return this;
    }

    @Step
    public AuthorizationSteps getEmailCodeOutOfMailHog() {
        mailHog
                .switchToMailFrame()
                .getValidationCode();
        return this;
    }

    @Step
    public AuthorizationSteps goToInvitationUrl() {
        mailHog
                .switchToMailFrame()
                .goToInvitationUrl();
        return this;
    }

    @Step
    public AuthorizationSteps closeMailHog() {
        mailHog.closeMailHogTab();
        return this;
    }

    @Step
    public AuthorizationSteps enterCode(String code) {
        authPage.enterCode(code);
        return this;
    }

    @Step
    public AuthorizationSteps fillInUserName(String fname, String lname) {
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

    @Step
    public void checkAuthorizationInLeverice() {
        authPage.checkAuthorization();
    }

    @Step
    public AuthorizationSteps openNewWindow() {
        mailHog.openNewWindow();
        return this;
    }

    @Step
    public AuthorizationSteps openInvitationLink(){
        authPage.openInvitationLink();
        return this;
    }

}

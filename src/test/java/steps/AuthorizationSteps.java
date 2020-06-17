package steps;

import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.authorizationPages.*;
import pages.mailHogPages.MailHogPage;

public class AuthorizationSteps {

    AuthorizationPage authPage;
    EnterEmailPage emailPage;
    MailHogPage mailHog;
    EnterValidationCodePage codePage;
    IntroduceYourselfPage namesPage;
    WorkspacePage workPage;
    NewWorkspacePage newWorkPage;

    public AuthorizationSteps() {
        authPage = new AuthorizationPage();
        emailPage = new EnterEmailPage();
        mailHog = new MailHogPage();
        codePage = new EnterValidationCodePage();
        namesPage = new IntroduceYourselfPage();
        newWorkPage = new NewWorkspacePage();
        workPage = new WorkspacePage();
    }

    @Step("Open Leverice and sign in with Email='{email}'")
    public AuthorizationSteps signIn(String email){
        authPage
                .openPage()
                .clickSignIn();
        emailPage
                .openPage()
                .enterEmail(email)
                .clickContinueButton();
        return this;
    }

    @Step
    public AuthorizationSteps getEmailCodeOutOfMailHog(){
        mailHog
                .openPage()
                .findEmail()
                .getValidationCode()
                .closeMailHogTab();
     return this;
    }

    @Step
    public AuthorizationSteps enterCode(String code){
        codePage
                .openPage()
                .enterCode(code);
        return this;
    }

    @Step
    public AuthorizationSteps fillInUserNames(String fname, String lname){
        namesPage
                .openPage()
                .fillInUserNames(fname, lname)
                .clickContinueButton();
        return this;
    }

    @Step
    public AuthorizationSteps clickCreateWorkspace(){
        workPage
                .openPage()
                .clickCreateNewWorkspace();
        return this;
    }

    @Step
    public AuthorizationSteps fillInWorkSpaceName(String workName){
        newWorkPage
                .openPage()
                .fillInWorkspaceName(workName)
                .clickCreateButton();
        return this;
    }

    @Step
    public AuthorizationSteps enterInMySpace(String workSpaceName){
        workPage
                .openPage()
                .enterInMyWorkSpace(workSpaceName);
        return this;
    }
}

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

    @Step("Открываем mailHog")
    public AuthorizationSteps openMailHog(){
        mailHog.openPage();
        return this;
    }

    @Step("Находим наш email")
    public AuthorizationSteps findMail(String userEmail){
        mailHog.findEmail(userEmail);
        return this;
    }

    @Step("Получаем код")
    public AuthorizationSteps getEmailCodeOutOfMailHog() {
        mailHog
                .switchToMailFrame()
                .getValidationCode();
        return this;
    }

    @Step("Переходим по ссылке на инвайт")
    public AuthorizationSteps goToInvitationUrl() {
        mailHog
                .switchToMailFrame()
                .goToInvitationUrl();
        return this;
    }

    @Step("Закрываем mailHog")
    public AuthorizationSteps closeMailHog(){
        mailHog.closeMailHogTab();
        return this;
    }

    @Step("Вводим код")
    public AuthorizationSteps enterCode(String code) {
        authPage.enterCode(code);
        return this;
    }

    @Step("Вводим имя {fname} и фамилию {lname}")
    public AuthorizationSteps fillInUserName(String fname, String lname) {
        authPage
                .fillInUserNames(fname, lname)
                .clickButton();
        return this;
    }

    @Step("Создаём workspace")
    public AuthorizationSteps clickCreateWorkspace() {
        authPage.clickCreateNewWorkspace();
        return this;
    }

    @Step("Вводим имя workspace - {workName}")
    public AuthorizationSteps fillInWorkSpaceName(String workName) {
        authPage
                .fillInWorkspaceName(workName)
                .clickButton();
        return this;
    }

    @Step("Входим в {workSpaceName}")
    public AuthorizationSteps enterInMySpace(String workSpaceName) {
        authPage.enterInMyWorkSpace(workSpaceName);
        return this;
    }

    @Step("Проверяем текст на странице")
    public boolean checkPage() {
        return authPage.checkPage();
    }

    @Step("Проверяем авторизацию")
    public void checkAuthorizationInLeverice() {
        authPage.checkAuthorization();
    }

    @Step("Открываем новое окно")
    public AuthorizationSteps openNewWindow(){
        mailHog.openNewWindow();
        return this;
    }

    @Step
    public AuthorizationSteps openInvitationLink(){
        authPage.openInvitationLink();
        return this;
    }
}
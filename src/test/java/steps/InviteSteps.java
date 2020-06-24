package steps;

import io.qameta.allure.Step;
import pages.InviteModalPage;
import pages.chatPages.DirectPage;

public class InviteSteps {

    InviteModalPage invPage;
    DirectPage dirPage;

    public InviteSteps(){
        invPage = new InviteModalPage();
        dirPage = new DirectPage();
    }

    @Step
    public InviteSteps typeEmailInInput(String email){
        invPage
                .isPageOpened()
                .fillInEmail(email);
        return this;
    }

    @Step
    public InviteSteps clickInviteButton(){
        invPage
                .clickInviteButton();
        return this;
    }

    @Step
    public InviteSteps checkUserInvited(String userEmail){
        dirPage.checkInviteUser(userEmail);
        return this;
    }

    @Step
    public InviteSteps clickCopyLinkButton(){
        invPage.clickCopyLinkButton();
        return this;
    }
}

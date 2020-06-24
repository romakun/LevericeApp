package steps;

import io.qameta.allure.Step;
import pages.InviteModalPage;

public class InviteSteps {

    InviteModalPage invPage;

    public InviteSteps(){
        invPage = new InviteModalPage();
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
}

package steps;

import io.qameta.allure.Step;
import pages.InviteModalPage;

public class InviteSteps {

    InviteModalPage invPage;

    public InviteSteps(){
        invPage = new InviteModalPage();
    }

    @Step("Вводим email {email}")
    public InviteSteps typeEmailInInput(String email){
        invPage
                .isPageOpened()
                .fillInEmail(email);
        return this;
    }

    @Step("Кликаем по кнопке приглашения")
    public InviteSteps clickInviteButton(){
        invPage
                .clickInviteButton();
        return this;
    }
}

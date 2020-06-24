package tests.inviteTests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import tests.BaseTest;

public class InviteByEmailTest extends BaseTest {

    @Test
    public void inviteByEmailTest(){
        wsElementsSteps
                .clickByMenuItem("Invite Users");
        invSteps
                .typeEmailInInput("stttttt@mailinator.com")
                .clickInviteButton();
        Selenide.closeWebDriver();
        authSteps
                .openNewWindow()
                .findMail("stttttt@mailinator.com")
                .goToInvitationUrl()
                .closeMailHog()
                .fillInUserName("Param2", "PamPam2")
                .checkAuthorizationInLeverice();
    }
}

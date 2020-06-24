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
                .typeEmailInInput("buba@mailinator.com")
                .clickInviteButton();
        wsElementsSteps
                .clickByMenuItem("direct")
                .checkChannelOpened("direct");
        invSteps
                .checkUserInvited("buba@mailinator.com");
        Selenide.closeWebDriver();
        authSteps
                .openNewWindow()
                .findMail("buba@mailinator.com")
                .goToInvitationUrl()
                .closeMailHog()
                .fillInUserName("Param22", "PamPam22")
                .checkAuthorizationInLeverice();
    }
}

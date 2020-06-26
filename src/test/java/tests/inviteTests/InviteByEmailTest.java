package tests.inviteTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import models.GenerateData;
import org.testng.annotations.Test;
import tests.BaseTest;

public class InviteByEmailTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String randomEmail = randomData.generateRandomEmail();
    String fName = randomData.generateRandomUserFirstName();
    String lName = randomData.generateRandomUserLastName();

    @Test
    public void inviteByEmailTest(){
        authorizeInLeverice();
        wsElementsSteps
                .clickByMenuItem("Invite Users");
        invSteps
                .typeEmailInInput(randomEmail)
                .clickInviteButton();
        wsElementsSteps
                .clickByMenuItem("direct")
                .checkChannelOpened("direct");
        invSteps
                .checkUserInvited(randomEmail);
        Selenide.clearBrowserLocalStorage();
        authSteps
                .openNewWindow()
                .findMail(randomEmail)
                .goToInvitationUrl()
                .closeMailHog()
                .fillInUserName(fName, lName)
                .checkAuthorizationInLeverice();
    }
}

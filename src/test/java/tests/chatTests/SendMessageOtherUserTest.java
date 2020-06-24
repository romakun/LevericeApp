package tests.chatTests;

import com.codeborne.selenide.Selenide;
import models.GenerateData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SendMessageOtherUserTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String randomEmail = randomData.generateRandomEmail();
    String fName = randomData.generateRandomUserFirstName();
    String lName = randomData.generateRandomUserLastName();

    @BeforeMethod
    public void inviteByEmail(){
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
    }

    @Test
    public void sendMessageOtherUserTest(){
        setSteps
                .openSettingsByIcon("direct")
                .clickByOption("Expand");
        wsElementsSteps.clickByMenuItem("Create new Direct Channel");
        modalSteps
                .fillInNewDirectModal(randomEmail)
                .clickAccept();
        wsElementsSteps
                .clickByMenuItem(randomEmail)
                .checkChannelOpened(randomEmail);
        chatSteps.sendMessage("Hello bro!");
        Selenide.closeWebDriver();
        authSteps
                .openNewWindow()
                .findMail(randomEmail)
                .goToInvitationUrl()
                .closeMailHog()
                .fillInUserName(fName, lName)
                .checkAuthorizationInLeverice();
        wsElementsSteps
                .openElementTree("direct")
                .clickByMenuItem("First User");
        chatSteps.checkIncomeMessage("Hello bro!");
    }
}

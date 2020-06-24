package tests.inviteTests;

import models.GenerateData;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class InviteByLInkTest extends BaseTest {

    GenerateData randomData = new GenerateData();
    String randomEmail = randomData.generateRandomEmail();
    String fName = randomData.generateRandomUserFirstName();
    String lName = randomData.generateRandomUserLastName();

    Properties codeProp = new Properties();
    Path codeFile = Paths.get("src/test/resources/userValidationCode.xml");

    @Test
    public void inviteByLInkTest(){
        authorizeInLeverice();
        wsElementsSteps
                .clickByMenuItem("Invite Users");
        invSteps.clickCopyLinkButton();
        authSteps
                .openInvitationLink()
                .typEmail(randomEmail)
                .openMailHog()
                .findMail(randomEmail)
                .getEmailCodeOutOfMailHog()
                .closeMailHog();
        try {
            codeProp.loadFromXML(Files.newInputStream(codeFile));
        } catch (Exception e) {
            Assert.fail("Не удалось загрузить файл с валидационным кодом");
        }
        authSteps
                .enterCode(codeProp.getProperty("validationCode"))
                .fillInUserName(fName, lName)
                .checkAuthorizationInLeverice();
    }
}

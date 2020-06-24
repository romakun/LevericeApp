package tests.inviteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class InviteByLInkTest extends BaseTest {

    Properties codeProp = new Properties();
    Path codeFile = Paths.get("src/test/resources/userValidationCode.xml");

    @Test
    public void inviteByLInkTest(){
        wsElementsSteps
                .clickByMenuItem("Invite Users");
        invSteps.clickCopyLinkButton();
        authSteps
                .openInvitationLink()
                .typEmail("shakalaka@mailinator.com")
                .openMailHog()
                .findMail("shakalaka@mailinator.com")
                .getEmailCodeOutOfMailHog()
                .closeMailHog();
        try {
            codeProp.loadFromXML(Files.newInputStream(codeFile));
        } catch (Exception e) {
            Assert.fail("Не удалось загрузить файл с валидационным кодом");
        }
        authSteps
                .enterCode(codeProp.getProperty("validationCode"))
                .fillInUserName("SHABA", "LABA")
                .checkAuthorizationInLeverice();
    }
}

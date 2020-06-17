package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class AuthorizationTest extends BaseTest{


    @Test
    public void authorize() throws IOException {
        String workSpaceName = "MyTestWorkSpace";

        properties.loadFromXML(Files.newInputStream(emailFile));
        authSteps
                .signIn(properties.getProperty("userEmail"))
                .getEmailCodeOutOfMailHog();
        properties.loadFromXML(Files.newInputStream(codeFile));
        authSteps
                .enterCode(properties.getProperty("validationCode"))
                .enterInMySpace(workSpaceName)
                .fillInWorkSpaceName("TestSpace");
    }
}

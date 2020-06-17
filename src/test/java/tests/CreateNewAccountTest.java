package tests;

import models.GenerateEmail;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class CreateNewAccountTest extends BaseTest{

    @BeforeTest
    public void generateNewUserData() throws IOException {
        GenerateEmail userEmail = new GenerateEmail();

        properties.setProperty("userEmail", userEmail.generateRandomEmail());
        properties.storeToXML(Files.newOutputStream(emailFile), "File with user email");

    }

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
                .fillInUserNames("Roma", "Kun")
                .clickCreateWorkspace()
                .fillInWorkSpaceName(workSpaceName);
    }
}

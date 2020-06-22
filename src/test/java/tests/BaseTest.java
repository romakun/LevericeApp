package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.AuthorizationSteps;
import tests.base.TestListener;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Listeners(TestListener.class)
public class BaseTest {

    AuthorizationSteps authSteps;

    Properties userProp = new Properties();
    Properties codeProp = new Properties();
    Path userFile = Paths.get("src/test/resources/userData.xml");
    Path codeFile = Paths.get("src/test/resources/userValidationCode.xml");

    @BeforeClass
    public void setupDriver() {
        userProp.setProperty("userEmail", "4ilibumba@mailinator.com");
        userProp.setProperty("workSpaceName", "MyTestWorkSpace");
        try {
            userProp.storeToXML(Files.newOutputStream(userFile), "File with user email");
        } catch (Exception e) {
            Assert.fail("Не удалось сохранить в файл данные пользователя");
        }

        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 600000000;
        authSteps = new AuthorizationSteps();
    }

    @BeforeMethod(description = "Precondition - Авторизация в Leverice")
    public void authorizeInLeverice() {
        try {
            userProp.loadFromXML(Files.newInputStream(userFile));
        } catch (Exception e) {
            Assert.fail("Не удалось загрузить файл с данными пользователя");
        }
        authSteps
                .signIn(userProp.getProperty("userEmail"))
                .getEmailCodeOutOfMailHog(userProp.getProperty("userEmail"));
        try {
            codeProp.loadFromXML(Files.newInputStream(codeFile));
        } catch (Exception e) {
            Assert.fail("Не удалось загрузить файл с валидационным кодом");
        }
        authSteps.enterCode(codeProp.getProperty("validationCode"));
        if (authSteps.checkPage()) {
            authSteps
                    .fillInUserNames("First", "User")
                    .clickCreateWorkspace()
                    .fillInWorkSpaceName(userProp.getProperty("workSpaceName"));
        } else {
            authSteps
                    .enterInMySpace(userProp.getProperty("workSpaceName"));
        }
    }

    @AfterClass
    public void clearCash() {
        Selenide.closeWebDriver();
    }
}



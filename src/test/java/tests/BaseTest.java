package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.*;
import tests.base.TestListener;
import utils.Highlighter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.addListener;

@Listeners(TestListener.class)
public class BaseTest {

    public AuthorizationSteps authSteps;
    public WorkSpaceElementsSteps wsElementsSteps;
    public CreateModalSteps modalSteps;
    public SettingSteps setSteps;
    public InviteSteps invSteps;
    public ChatSteps chatSteps;

    Properties userProp = new Properties();
    Properties codeProp = new Properties();
    Path userFile = Paths.get("src/test/resources/userData.xml");
    Path codeFile = Paths.get("src/test/resources/userValidationCode.xml");

    @BeforeClass()
    public void setupDriver() {
        userProp.setProperty("userEmail", "4ilibumba@mailinator.com");
        userProp.setProperty("workSpaceName", "MyTestWorkSpace");
        try {
            userProp.storeToXML(Files.newOutputStream(userFile), "File with user email");
        } catch (Exception e) {
            Assert.fail("Не удалось сохранить в файл данные пользователя");
        }

        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 6000;
        addListener(new Highlighter());
        authSteps = new AuthorizationSteps();
        wsElementsSteps = new WorkSpaceElementsSteps();
        modalSteps = new CreateModalSteps();
        setSteps = new SettingSteps();
        invSteps = new InviteSteps();
        chatSteps = new ChatSteps();

    }

    public void authorizeInLeverice() {
        try {
            userProp.loadFromXML(Files.newInputStream(userFile));
        } catch (Exception e) {
            Assert.fail("Не удалось загрузить файл с данными пользователя");
        }
        authSteps
                .signIn()
                .typEmail(userProp.getProperty("userEmail"))
                .openMailHog()
                .findMail(userProp.getProperty("userEmail"))
                .getEmailCodeOutOfMailHog()
                .closeMailHog();
        try {
            codeProp.loadFromXML(Files.newInputStream(codeFile));
        } catch (Exception e) {
            Assert.fail("Не удалось загрузить файл с валидационным кодом");
        }
        authSteps.enterCode(codeProp.getProperty("validationCode"));
        if (authSteps.checkPage()) {
            authSteps
                    .fillInUserName("First", "User")
                    .clickCreateWorkspace()
                    .fillInWorkSpaceName(userProp.getProperty("workSpaceName"))
                    .checkAuthorizationInLeverice();
        } else {
            authSteps
                    .enterInMySpace(userProp.getProperty("workSpaceName"))
                    .checkAuthorizationInLeverice();
        }
    }

    @AfterClass
    public void clearCash() {
        Selenide.closeWebDriver();
    }
}



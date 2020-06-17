package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.AuthorizationSteps;
import tests.base.TestListener;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Listeners(TestListener.class)
public class BaseTest {

    AuthorizationSteps authSteps;

    Properties properties = new Properties();
    Path emailFile = Paths.get("src/test/resources/userEmail.xml");
    Path codeFile = Paths.get("src/test/resources/userValidationCode.xml");

    @BeforeClass
    public void setupDriver() {

        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 6000;

        authSteps = new AuthorizationSteps();
    }

    @AfterClass
    public void clearCash() {
        WebDriverRunner.closeWebDriver();
    }
}



package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import tests.base.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeClass
    public void setupDriver() {

        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 6000;
}

    @AfterClass
    public void clearCash() {
        WebDriverRunner.closeWebDriver();
    }
}



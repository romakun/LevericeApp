package pages.mailHogPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;


public class MailHogPage extends BasePage {

    private static final String URL = "https://autotest.leverice.net/email/#";
    private static final String DISCONNECT_BUTTON_TEXT = "Disconnected";
    private static final String EMAILS_CSS = ".msglist-message";
    private static final String VALIDATION_CODE_CSS = ".validation-code";
    private static final By MAIL_IFRAME_ID = id("preview-html");


    Properties properties = new Properties();
    Path path = Paths.get("src/test/resources/userValidationCode.xml");

    @Override
    public MailHogPage openPage() {
        Selenide.executeJavaScript("window.open();");
        switchTo().window(1);
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public MailHogPage isPageOpened() {
        try {
            $(byText(DISCONNECT_BUTTON_TEXT), "Ждем, пока страница загрузится");
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public MailHogPage findEmail() {
        List<SelenideElement> emailList = $$(EMAILS_CSS, "");
        emailList.get(0).click();
        return this;
    }

    public MailHogPage getValidationCode() {
        switchTo().frame($(MAIL_IFRAME_ID));

        try {

            properties.setProperty("validationCode", $(VALIDATION_CODE_CSS).getText());
            properties.storeToXML(Files.newOutputStream(path), "File with user email && code");

        } catch (IOException io) {
            io.printStackTrace();
        }
        return this;
    }

    public void closeMailHogTab(){
        Selenide.executeJavaScript( "window.close()");
        switchTo().window(0);
    }
}

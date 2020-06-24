package pages.mailHogPages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementShould;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class MailHogPage extends BasePage {

    private static final String URL = "https://autotest.leverice.net/email/#";
    private static final String DISCONNECT_BUTTON_TEXT = "Disconnected";
    private static final String EMAILS_CSS = ".msglist-message";
    private static final String VALIDATION_CODE_CSS = ".validation-code";
    private static final By MAIL_IFRAME_ID = id("preview-html");
    private static final By INVITE_URL_LOCATOR = xpath("//a[@data-url='invite' and contains(text(),'Join')]");


    Properties properties = new Properties();
    Path path = Paths.get("src/test/resources/userValidationCode.xml");

    @Override
    public MailHogPage openPage() {
        log.info("Открываем mailHog");
       Selenide.executeJavaScript("window.open();");
        switchTo().window(1);
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public MailHogPage isPageOpened() {
        log.info("Открылся ли mailHog");
        try {
            $(byText(DISCONNECT_BUTTON_TEXT)).shouldBe(Condition.visible);
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public MailHogPage findEmail(String userEmail) {
        log.info("Находим email " + userEmail);
        List<SelenideElement> emailList = $$(EMAILS_CSS).shouldBe(CollectionCondition.sizeGreaterThan(0));
        for(int i = 0; i < emailList.size(); i++){
           if (emailList.get(i).find(".ng-binding.ng-scope").getText().equals(userEmail)){
               emailList.get(i).click();
               i = emailList.size();
           }
        }
        return this;
    }

    public MailHogPage getValidationCode() {
        log.info("Получаем код");
        try {
            properties.setProperty("validationCode", $(VALIDATION_CODE_CSS).getText());
            properties.storeToXML(Files.newOutputStream(path), "File with user email && code");
        } catch (Exception e) {
            Assert.fail("Не удалось сохранить validation code в файл");
        }
        return this;
    }

    public MailHogPage switchToMailFrame(){
        switchTo().frame($(MAIL_IFRAME_ID));
        return this;
    }

    public void closeMailHogTab() {
        log.info("Закрываем mailHog");
        Selenide.closeWindow();
        switchTo().window(0);
    }

    public MailHogPage openNewWindow() {
        log.info("Открываем " + URL);
        open(URL);
        isPageOpened();
        return this;
    }

    public MailHogPage goToInvitationUrl(){
        log.info("Переходим по ссылке инвайта");
        $(INVITE_URL_LOCATOR).click();
        return this;
    }

}

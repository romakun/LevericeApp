package pages.chatPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;

@Log4j2
public class ChatPage extends BasePage {

    private static final By MESSAGE_SENT = By.cssSelector(".message-render");
    private static final By INPUT_MESSAGE_FIELD = By.id("input-message");
    private static final By EMOJI = xpath("//div[@class='clickable']");
    private static final By SEND_MESSAGE_BUTTON = xpath("//div[@class='send-button active']");
    private static final By DELETE_MESSAGE = xpath("//div[@data-original-title='Delete Post']");
    private static final By EDIT_MESSAGE = xpath("//div[@data-original-title='Edit Post']");
    private static final By QUOTE_MESSAGE = xpath("//div[@data-original-title='Quote Post']");
    private static final String SENDER_NAME_LOCATOR = "//div[@class='sender-name' and contains(text(),'First User')]";
    String SENDER_MESSAGE_LOCATOR = "/../../..//p[contains(text(),'%s')]";

    @Step("Открываем чат")
    @Override
    public ChatPage openPage() {
        log.info("Открываем чат");
        isPageOpened();
        return this;
    }

    @Step("Открылся ли чат")
    @Override
    public ChatPage isPageOpened() {
        log.info("Открылся ли чат");
        $(By.className("channel-name")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Отправляем сообщение {message}")
    public ChatPage sendMessage (String message) {
        log.info("Отправляем сообщение " + message);
        $(INPUT_MESSAGE_FIELD).setValue(message);
        $(SEND_MESSAGE_BUTTON).click();
        log.info("Отправилось ли сообщение");
        assertTrue($(MESSAGE_SENT).isDisplayed(), "The message wasn't sent");
        return this;
    }

    @Step("Отправляем эмоджи")
    public ChatPage sendEmoji () {
        log.info("Отправляем эмоджи");
        $(EMOJI).hover().click();

        $(By.xpath("//span[@data-title='grinning']")).hover().click();
        $(SEND_MESSAGE_BUTTON).hover().click();
        log.info("Отправилось ли эмоджи");
        assertTrue($(MESSAGE_SENT).isDisplayed(), "The emoji wasn't sent");
        return this;
    }

    @Step("Редактируем сообщение добавлением {newMessage}")
    public ChatPage editMessage (String newMessage) {
        $(MESSAGE_SENT).hover();
        $(EDIT_MESSAGE).hover().click();
        log.info("Редактируем сообщение");
        $(INPUT_MESSAGE_FIELD).sendKeys(newMessage);
        $(SEND_MESSAGE_BUTTON).click();
        log.info("Проверяем отредактировано ли сообщение");
        $(MESSAGE_SENT).should(Condition.matchText(newMessage));
        return this;
    }

    @Step("Цитируем сообщение")
    public ChatPage quoteMessage () {
        log.info("Делаем quote на сообщении");
        $(MESSAGE_SENT).hover();
        $(QUOTE_MESSAGE).click();
        $(SEND_MESSAGE_BUTTON).click();
        log.info("Было ли выполнено quote");
        $(By.tagName("blockquote")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Удаляем сообщение")
    public ChatPage deleteMessage () {
        log.info("Удаляем сообщение");
        $(MESSAGE_SENT).hover();
        $(DELETE_MESSAGE).hover().click();
        log.info("Проверяем удалилось ли сообщение");
        $(MESSAGE_SENT).shouldNot(Condition.exist);
        return this;
    }

    @Step("Проверяем что от другого пользоваетля пришло сообщение")
    public ChatPage checkUserMessage(String message){
        log.info("Проверяем что сообщение пришло от другого пользователя");
        By incomeMessage = xpath(SENDER_NAME_LOCATOR + String.format(SENDER_MESSAGE_LOCATOR, message));
        $(incomeMessage).shouldBe(Condition.visible);
        return this;
    }

    public ChatPage clearChat () {
        log.info("Чистим чат");
        $(MESSAGE_SENT).hover();
        $(DELETE_MESSAGE).hover().click();
        sleep(3000);
        $(MESSAGE_SENT).hover();
        $(DELETE_MESSAGE).hover().click();
        log.info("Проверяем удалились ли сообщение");
        $(MESSAGE_SENT).shouldNot(Condition.exist);
        return this;
    }

}

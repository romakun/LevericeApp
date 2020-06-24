package pages.chatPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {

    private static final By MESSAGE_SENT = By.cssSelector(".message-render");
    private static final By INPUT_MESSAGE_FIELD = By.id("input-message");
    private static final By ATTACH = By.id("file-input");
    private static final By EMOJI = By.xpath("//div[@class='clickable']");
    private static final By SEND_MESSAGE_BUTTON = By.xpath("//div[@class='send-button active']");
    private static final By DELETE_MESSAGE = By.xpath("//div[@data-original-title='Delete Post']");
    private static final By EDIT_MESSAGE = By.xpath("//div[@data-original-title='Edit Post']");
    private static final By QUOTE_MESSAGE = By.xpath("//div[@data-original-title='Quote Post']");

    @Step("Открываем чат")
    @Override
    public ChatPage openPage() {
        isPageOpened();
        return null;
    }

    @Step("Открылся ли чат")
    @Override
    public ChatPage isPageOpened() {
        $(By.className("channel-name")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Отправляем сообщение {message}")
    public ChatPage sendMessage (String message) {
        $(INPUT_MESSAGE_FIELD).setValue(message);
        $(SEND_MESSAGE_BUTTON).click();
        assertTrue($(MESSAGE_SENT).isDisplayed(), "The message wasn't sent");
        return this;
    }

    @Step("Отправляем эмоджи")
    public ChatPage sendEmoji () {
        $(EMOJI).hover().click();
        $(By.xpath("//span[@data-title='grinning']")).hover().click();
        $(SEND_MESSAGE_BUTTON).click();
        assertTrue($(MESSAGE_SENT).isDisplayed(), "The emoji wasn't sent");
        return this;
    }

    @Step("Редактируем сообщение добавлением {newMessage}")
    public ChatPage editMessage (String newMessage) {
        $(MESSAGE_SENT).hover();
        $(EDIT_MESSAGE).hover().click();
        $(INPUT_MESSAGE_FIELD).sendKeys(newMessage);
        $(SEND_MESSAGE_BUTTON).click();
        $(MESSAGE_SENT).should(Condition.matchText(newMessage));
        return this;
    }

    @Step("Цитируем сообщение")
    public ChatPage quoteMessage () {
        $(MESSAGE_SENT).hover();
        $(QUOTE_MESSAGE).click();
        $(SEND_MESSAGE_BUTTON).click();
        $(By.tagName("blockquote")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Удаляем сообщение")
    public ChatPage deleteMessage () {
        $(MESSAGE_SENT).hover();
        $(DELETE_MESSAGE).hover().click();
        $(MESSAGE_SENT).shouldNot(Condition.exist);
        return this;
    }

    @Step("Прикрепляем файл с путём {filePath}")
    public ChatPage attachFile (String filePath) {
        $(ATTACH).sendKeys(filePath);
        $(By.className("attachments")).shouldBe(Condition.visible);
        $(SEND_MESSAGE_BUTTON).click();
        assertTrue($(MESSAGE_SENT).isDisplayed(), "The attached file wasn't sent");
        return this;
    } //не могу разобраться как сделать этот метод

}

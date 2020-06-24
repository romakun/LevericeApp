package tests.chatTests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class ChatTest extends BaseTest {

    @Test (description = "Тест на отправку сообщения", priority = 1)
    public void sendMessage () {
        chatSteps.sendMessage("Hello");
    }

    @Test (description = "Тест на редактирование сообщения", priority = 2)
    public void editMessage () {
        chatSteps.editMessage(" my friend");
    }

    @Test (description = "Тест на удаление сообщения", priority = 3)
    public void deleteMessage () {
        chatSteps.deleteMessage();
    }

    @Test (description = "Тест на отправку эмоджи", priority = 4)
    public void sendEmoji () {
        chatSteps.sendEmoji();
    }

    @Test (description = "Тест на цитирование другого сообщения", priority = 5)
    public void quoteMessage () {
        chatSteps.quoteMessage();
    }
}
